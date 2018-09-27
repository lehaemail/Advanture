import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map 
{
    protected static char[][] mapArr;
    protected static int rows, cols;
    protected String[] size = new String[TWO];
    protected int[] mapSize;
    Scanner scanner = null;
    protected static int TWO = 2; // Needed for initial size

    void Map() {
        rows = 0;
        cols = 0;
        size = new String[TWO];
        mapArr = new char[rows][cols];
    }

    public void readMapFile(String fileName) {
        String firstRow = "";

        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, " + fileName + " not found.");
        }

        if (scanner.hasNextLine()) {
            firstRow = scanner.nextLine();
        }
        // Figure map size by the firs row
        size = firstRow.split(" +");
        rows = Integer.parseInt(size[0]);
        cols = Integer.parseInt(size[1]);

        mapSize = new int[TWO];
        mapSize[0] = rows;
        mapSize[1] = cols;

        mapArr = new char[rows][cols];

        // Create map
        for (int i = 0; i < rows; i++) {
            firstRow = scanner.next();
            for (int j = 0; j < cols; j++) {
                mapArr[i][j] = firstRow.charAt(j);
                System.out.print(firstRow.charAt(j));
            }
            System.out.print("\n");
        }
    }

    public char[][] getMap()
    {
        return mapArr;
    }

    public int[] getSize() 
    {
        return mapSize;
    }
}
