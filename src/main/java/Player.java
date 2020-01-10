import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Player {
    static int numberOfFlags=BombsDistributor.numberOfBombs;
    public static void play(String[][] board, String[][] bombs) {

        while (true) {
            BoardPrinter.printBoard(board);
            System.out.println("Flags: "+ numberOfFlags);
            String coordinates = checkCoOrdinates(board);
            if (coordinates.equals("")) continue;
            int letterIndex = Integer.valueOf(coordinates.substring(0, 1));
            int numberIndex = Integer.valueOf(coordinates.substring(2));
            if (bombs[numberIndex][letterIndex].equals("(*)")) {
                System.out.println();
                System.out.println("         BOOM !!!");
                System.out.println();
                bombs[numberIndex][letterIndex] = "[*]";
                BoardPrinter.printBoard(bombs);
                System.out.println();
                System.out.println("GAME OVER!");
                return;
            } else if (bombs[numberIndex][letterIndex].equals(" 0 ")) {
                lookForAllEmpty(board, bombs, numberIndex, letterIndex);
            } else {
                board[numberIndex][letterIndex] = bombs[numberIndex][letterIndex];
            }
            int numberOfEmptyFields = 0;
            int numberOfBombs = BombsDistributor.numberOfBombs;
            for (int i = 1; i < board.length - 1; i++) {
                for (int j = 1; j < board[0].length - 1; j++) {
                    if (board[i][j].equals(" □ ")) numberOfEmptyFields++;
                    if (numberOfEmptyFields > numberOfBombs) {
                        break;
                    }
                }
            }
            if(numberOfEmptyFields==numberOfBombs){
                BoardPrinter.printBoard(board);
                System.out.println("CONGRATULATIONS!!! MISSION COMPLETED :)");
                return;
            } else{
                numberOfEmptyFields=0;
            }
        } }

    private static void lookForAllEmpty(String[][] board, String[][] bombs, int numberIndex, int letterIndex) {

        board[numberIndex - 1][letterIndex - 1] = bombs[numberIndex - 1][letterIndex - 1];
        board[numberIndex - 1][letterIndex] = bombs[numberIndex - 1][letterIndex];
        if (bombs[numberIndex - 1][letterIndex].equals(" 0 "))
            lookForAllEmpty(board, bombs, numberIndex - 1, letterIndex);
        board[numberIndex - 1][letterIndex + 1] = bombs[numberIndex - 1][letterIndex + 1];
        board[numberIndex][letterIndex - 1] = bombs[numberIndex][letterIndex - 1];
        board[numberIndex][letterIndex] = "   ";
        bombs[numberIndex][letterIndex] = "   ";
        if (bombs[numberIndex][letterIndex - 1].equals(" 0 "))
            lookForAllEmpty(board, bombs, numberIndex, letterIndex - 1);
        board[numberIndex][letterIndex + 1] = bombs[numberIndex][letterIndex + 1];
        if (bombs[numberIndex][letterIndex + 1].equals(" 0 "))
            lookForAllEmpty(board, bombs, numberIndex, letterIndex + 1);
        board[numberIndex + 1][letterIndex - 1] = bombs[numberIndex + 1][letterIndex - 1];
        board[numberIndex + 1][letterIndex] = bombs[numberIndex + 1][letterIndex];
        if (bombs[numberIndex + 1][letterIndex].equals(" 0 "))
            lookForAllEmpty(board, bombs, numberIndex + 1, letterIndex);
        board[numberIndex + 1][letterIndex + 1] = bombs[numberIndex + 1][letterIndex + 1];


    }

    private static String checkCoOrdinates(String[][] board) {
        Set set = new HashSet<String>();
        set.add("0");
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        set.add("6");
        set.add("7");
        set.add("8");
        set.add("9");
        Scanner scanner = new Scanner(System.in);
        String alphabet = " abcdefghijklmnoprstuwxyz";
        int letterIndex = 0;
        int numberIndex = 0;
        while (true) {
            String move = scanner.nextLine();

            if (move.equals("+f") || move.equals("+F") || move.equals("-f") || move.equals("-F")) {
                String toSetFlag = scanner.nextLine();
                try {
                    char letter = toSetFlag.charAt(0);
                    String stringLetter = String.valueOf(letter).toLowerCase();
                    if(set.contains(stringLetter)){
                        System.out.println("Co-ordinates are wrong. Please, try again:");
                        continue;
                    }
                    letterIndex = alphabet.indexOf(stringLetter);
                    numberIndex = Integer.valueOf(toSetFlag.substring(1));
                    if (letterIndex > board[0].length - 2 || numberIndex > board.length - 2) {
                        System.out.println("Co-ordinates are wrong. Please, try again:");
                       continue;
                    }
                    if (board[numberIndex][letterIndex].equals("   ")) {
                        System.out.println("Co-ordinates are wrong. Please, try again:");
                        continue;
                    }

                } catch (Exception exception) {
                    System.out.println("Co-ordinates are wrong. Please, try again:");
                }
                FlagSetter.setFlag(board, letterIndex, numberIndex, move);
                break;

            } else {
                try {
                    char letter = move.charAt(0);
                    String stringLetter = String.valueOf(letter).toLowerCase();
                    if(set.contains(stringLetter)){
                        System.out.println("Co-ordinates are wrong. Please, try again:");
                        continue;
                    }
                    letterIndex = alphabet.indexOf(stringLetter);
                    numberIndex = Integer.valueOf(move.substring(1));
                    if (letterIndex > board[0].length - 2 || numberIndex > board.length - 2) {
                        System.out.println("Co-ordinates are wrong. Please, try again:");
                        continue;
                    }

                } catch (Exception exception) {
                    System.out.println("Co-ordinates are wrong. Please, try again:");
                    continue;
                }

                return letterIndex + " " + numberIndex;
            }
        }
        return "";
    }
}


