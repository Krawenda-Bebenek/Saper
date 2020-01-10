public class FlagSetter {
    public static void setFlag(String[][]board, int letterIndex, int numberIndex, String move){
        if(move.equals("+F")||move.equals("+f")){
            board[numberIndex][letterIndex]=" ◙ ";
            Player.numberOfFlags--;
        }
        if(move.equals("-F")||move.equals("-f")){
           if(board[numberIndex][letterIndex]==" ◙ ") {
               board[numberIndex][letterIndex]=" □ ";
               Player.numberOfFlags++;
           }
        }
    }
}
