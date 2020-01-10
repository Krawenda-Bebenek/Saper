import java.util.Scanner;

public class DifficultySetter {
    public static double setDifficulty(){
        System.out.println();
        System.out.println("Please, choose difficulty level:");
        System.out.println("");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.println("4. Extreme");
        System.out.println("");
        System.out.println("Select number and press Enter");
        System.out.println("");

        Scanner scanner = new Scanner(System.in);
        int choice;
        while(true){
        String str=scanner.nextLine();
        try {
            choice = Integer.valueOf(str);
            if(choice>4)continue;
            break;
        } catch(NumberFormatException exception){

        }
        }

        switch (choice){
            case 1:
                return 0.15;
            case 2:
                return 0.20;
            case 3:
                return 0.25;
            case 4:
                return 0.3;
        }
        return 0;
    }
}
