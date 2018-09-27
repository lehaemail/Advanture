import java.util.Scanner;
import java.io.PrintStream;

public class Adventure 
{

    static int row = 0;
    static int col = 0;
    static boolean quit = false; //quit flag
    static int[] size;

    
    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("Error! I expected a map file.\nUsage: java Adventure map.txt\n");
            quit = true;
        }
        else {
            Map map = new Map(); // Ceate Map() object
            map.readMapFile(args[0]); //Get and load the map
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nYour adventure has began.\nDare to make your move.\n");
            while (!quit) {
                System.out.print("\nHint:\nTo make a move type go followed by dirrection, north, south, east, or west.\nTo see what do you have in our bag type inventory.\nTo exit the game type quit.\n");
                String input = scanner.nextLine();
                String[] inputArr = input.split(" +");
                if (inputArr[0].length() > 0) {
                    command(inputArr);
                }
            } 
        }
        
    }

    public static void command(String[] strArray) {
        GameChar gmchr = new GameChar();
        String temp = strArray[0].toLowerCase();
        if (temp.charAt(0) == 'q') {
            doQuit(strArray);
        } else if (temp.charAt(0) == 'g') {
            gmchr.userGoes(strArray);
        } else if (temp.charAt(0) == 'i') {
            gmchr.Inventory(strArray);
        } else {
            System.out.println("I didn't get what you mean. Please, try again:\n");
        }
    }

    public static void doQuit(String[] strArray) {
        System.out.println("See you next time.\n");
        quit = true;
    }
}
