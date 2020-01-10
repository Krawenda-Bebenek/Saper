public class BoardCopier {
   public static String [][] copyBoard(String [][] toCopy){
       String [][]result = new String [toCopy.length][toCopy[0].length];
       for(int i=0; i<toCopy.length; i++){
           for(int j=0; j<toCopy[0].length; j++){
               result[i][j]=toCopy[i][j];
           }
       }


       return result;
   }
}
