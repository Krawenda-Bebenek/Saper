import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        String[][]board= BoardGenerator.generateBoard();
        double difficulty = DifficultySetter.setDifficulty();
        String[][]boardCopy = BoardCopier.copyBoard(board);
        String[][] bombBoard = BombsDistributor.distributeBombs(boardCopy,difficulty);
       // BoardPrinter.printBoard(bombBoard);
        Player.play(board,boardCopy);
    }
}
