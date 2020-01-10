import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BombsDistributor {
    static int numberOfBombs;

    public static void setNumberOfBombs(int numberOfBombs) {
        BombsDistributor.numberOfBombs = numberOfBombs;
    }

    public static String[][] distributeBombs(String[][] table, double difficulty) {

        int boardSize = (table[0].length - 2) * (table.length - 2);
        int numberOfBombs = (int)(boardSize * difficulty);
        setNumberOfBombs(numberOfBombs);
        Set set = new HashSet<>();

        Random random = new Random();
        while (set.size() <= numberOfBombs-1) {
            int bombPlace = random.nextInt(boardSize);
            set.add(bombPlace);
        }

        int it = 0;
        for (int i = 1; i < table.length -1; i++) {
            for (int j = 1; j < table[0].length-1; j++) {
                if (set.contains(it)) {
                    table[i][j] = "(*)";
                }
                it++;
            }
        }
        enterNumbersOnBoard(table);
        return table;
    }

    private static void enterNumbersOnBoard(String[][] table) {
        int numberOfBombs=0;
        for (int i = 1; i < table.length - 1; i++) {
            for (int j = 1; j < table[0].length - 1; j++) {
                if(table[i-1][j-1].equals("(*)"))numberOfBombs++;
                if(table[i-1][j].equals("(*)"))numberOfBombs++;
                if(table[i-1][j+1].equals("(*)"))numberOfBombs++;
                if(table[i][j-1].equals("(*)"))numberOfBombs++;
                if(table[i][j+1].equals("(*)"))numberOfBombs++;
                if(table[i+1][j-1].equals("(*)"))numberOfBombs++;
                if(table[i+1][j].equals("(*)"))numberOfBombs++;
                if(table[i+1][j+1].equals("(*)"))numberOfBombs++;
                if(table[i][j].equals(" □ "))table[i][j]= " "+numberOfBombs+" ";
                numberOfBombs=0;
            }
        }
    }
}