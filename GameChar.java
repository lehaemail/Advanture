public class GameChar 
{
    protected static int THREE = 3;
    protected static int row;
    protected static int col;
    protected static int areaSize;
    protected static char[][] ladscape;
    protected static Map map = new Map();

    void GameChar() {
        areaSize = THREE;
        row = 0;
        col = 0;
        ladscape = new char[map.rows][map.cols];
        ladscape = map.getMap();
    }

    public static void userGoes(String[] strArray) {
        int[] mapSize = new int[2];
        mapSize[0] = map.rows;
        mapSize[1] = map.cols;
        System.out.print("\n");

        if (strArray.length < 2) {
            System.out.println("Please, tell me a dirrection.");
            return;
        }
        String command = strArray[1].toLowerCase();
        command.toLowerCase();
        if (command.charAt(0) == 'e') {
            if (col + 1 < map.cols) {
                col += 1;
                System.out.println("Moving East...");
            } else {
                System.out.println("You can't go that far East.");
            }
        } else if (command.charAt(0) == 's') {
            if (row + 1 < map.rows) {
                row += 1;
                System.out.println("Moving South...");
            } else {
                System.out.println("You can't go that far South.");
            }
        } else if (command.charAt(0) == 'w') {
            if (col - 1 >= 0) {
                col -= 1;
                System.out.println("Moving West...");
            } else {
                System.out.println("You can't go that far West.");
            }
        } else if (command.charAt(0) == 'n') {
            if (row - 1 >= 0) {
                row -= 1;
                System.out.println("Moving North...");
            } else {
                System.out.println("You can't go that far North.");
            }
        } else {
            System.out.println("You can't go that way.");
        }

        System.out.println("You are at location " + row + "," + col + " in the terrain.");
        ladscape = new char[map.rows][map.cols];
        ladscape = map.getMap();
        char curLocation = ladscape[row][col];
        printLandscape(curLocation);
        printAreaAround(THREE);
    }

    // Output landscape
    public static void printLandscape(char terrainType) {
        System.out.print("The landscape is ");
        char location = ladscape[row][col];
        if (location == '.') {
            System.out.print("plains.\n\n");
        }
        if (location == 'M') {
            System.out.print("mountains.\n\n");
        }
        if (location == '~') {
            System.out.print("water.\n\n");
        }
        if (location == 'f') {
            System.out.print("forest.\n\n");
        }
        if (location == '*') {
            System.out.print("Congrats, you found a suply to pick up!\n\n");
        }
    }

    // Otput 3x3 map piece
    public static void printAreaAround(int areaAround) {
        if (row - 1 >= 0 && col - 1 >= 0) {
            System.out.print(ladscape[row - 1][col - 1]);
        } else {
            System.out.print("X");
        }
        if (row - 1 >= 0 && col >= 0) {
            System.out.print(ladscape[row - 1][col]);
        } else {
            System.out.print("X");
        }
        if (row - 1 >= 0 && col + 1 < (map.cols)) {
            System.out.print(ladscape[row - 1][col + 1]);
        } else {
            System.out.print("X");
        }
        System.out.print("\n");
        if (row >= 0 && col - 1 >= 0) {
            System.out.print(ladscape[row][col - 1]);
        } else {
            System.out.print("X");
        }
        if (row >= 0 && col >= 0) {
            System.out.print(ladscape[row][col]);
        } else {
            System.out.print("X");
        }
        if (row >= 0 && col + 1 < (map.cols)) {
            System.out.print(ladscape[row][col + 1]);
        } else {
            System.out.print("X");
        }
        System.out.print("\n");
        if (row + 1 < (map.rows) && col - 1 >= 0) {
            System.out.print(ladscape[row + 1][col - 1]);
        } else {
            System.out.print("X");
        }
        if (row + 1 < (map.rows) && col >= 0) {
            System.out.print(ladscape[row + 1][col]);
        } else {
            System.out.print("X");
        }
        if (row + 1 < (map.rows) && col + 1 < (map.cols)) {
            System.out.print(ladscape[row + 1][col + 1]);
        } else {
            System.out.print("X");
        }
        System.out.print("\n");

    }
    
    static void Inventory(String[] strArray) {
        // print out the inventory
        System.out.println("You are carrying:\nbrass lantern\nrope\nrations\nstaff");
    }
}
