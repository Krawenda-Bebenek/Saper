import java.util.Scanner;

public class BoardGenerator {
    public static String[][] generateBoard(){
        System.out.println("                Welcome to the Saper :)");
        System.out.println("");
        System.out.println("Please, specify the size of Your board:");
        System.out.println("");
        System.out.println("1. 8x8");
        System.out.println("2. 16x16");
        System.out.println("3. 16x30");
        System.out.println("4. create Your own size");
        System.out.println("");
        System.out.println("Select number and press Enter");
        Scanner scanner = new Scanner(System.in);
        int choice;
        while(true) {
            try {
               choice = Integer.valueOf(scanner.nextLine());
               if(choice>4)continue;
                break;
            } catch (NumberFormatException exception) {

            }
        }
        String [][] table=null;
        switch(choice){
            case 1 :
                table =createTable(8,8);
                break;
            case 2 :
                table =createTable(16,16);
                break;
            case 3 :
                table =createTable(16, 30);
                break;
            case 4 :
                int width;
                int height;
                while(true) {
                    try {
                        System.out.println("Enter width (min 8, max 24):");
                        width = Integer.valueOf(scanner.nextLine());
                        if(width>24||width<8) {
                            System.out.println("Wrong value. Please, try again:");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException exception) {

                    }
                }
                System.out.println("Enter height (min 8, max 99):");
                while(true) {
                    try {
                        height= Integer.valueOf(scanner.nextLine());
                        if(height>99||height<8) {
                            System.out.println("Wrong value. Please, try again:");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException exception) {

                    }
                }
                table =createTable(width, height);
                break;
        }


return table;
    }

    private static String[][] createTable(int width, int height){
        String [][] table = new String[height+2][width+2];
        String alphabet="  ABCDEFGHIJKLMNOPRSTUWXYZ";
        table[0][0]="X ";
        for(int i=1; i<=height+1; i++){
            for(int j=1; j<=width+1; j++){
               table [i][j] = " □ ";
               if(i==table.length-1) table[i][j]="  ";
               if(j==table[0].length-1) table[i][j]="  ";
            }
    table[0][table[0].length-1]="  ";
            table[table.length-1][0]="  ";
        }
        for(int i=1; i<=height; i++){
            String str ="";
            if(i<10){
                str=String.valueOf(i)+" ";
            } else{
                str=String.valueOf(i);
            }
            table[i][0]=str;
        }
        for(int i=1; i<=width; i++){
            table[0][i]=" "+String.valueOf(alphabet.charAt(i+1))+" ";
        }

return table;

    }
}
