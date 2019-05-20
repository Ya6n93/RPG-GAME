import java.util.*;

public class Quiz {

    public static void quiz() {
        int c = 0;
        Scanner scan = new Scanner ( System.in );
        String in;
        boolean end = false;
        
        while (!end) {
            //--------------------------------------
            System.out.println("What is my name ?");
            System.out.println("1.YASSINE");
            System.out.println("2.LATRAC_Y");
            System.out.println("3.STEAVE");
            System.out.println("4.ELIAS\n");
            
            in = scan.nextLine();
                
            if (in.equals("1"))
                {
                    System.out.println("\nCorrect\n\n");
                    Menu.clear();
                    c++;
                }
            else
                System.out.println("\nWrong\n\n");
            //--------------------------------------
            System.out.println("What is my promo ?");
            System.out.println("1.APAE");
            System.out.println("2.APE");
            System.out.println("3.ZED");
            System.out.println("4.VOODOO GANG");

            in = scan.nextLine();

            if (in.equals("2"))
                {
                    System.out.println("\nCorrect\n\n");
                    Menu.clear();
                    c++;
                }
            else
                System.out.println("\nWrong\n\n");
            //--------------------------------------
            System.out.println("What is this command : :(){ :|:& };: on bash ?");
            System.out.println("1.Spawn a chicken form the sky");
            System.out.println("2.Launch Google Maps in your terminal");
            System.out.println("3.Turn off your computer");
            System.out.println("4.Launch all process of your terminal to crash it");

            in = scan.nextLine();

            if (in.equals("4"))
                {
                    System.out.println("\nCorrect\n\n");
                    Menu.clear();
                    c++;
                }
            else
                System.out.println("\nWrong\n\n");
            //--------------------------------------
            System.out.println("How old am I ?");
            System.out.println("1.18");
            System.out.println("2.19");
            System.out.println("3.17");
            System.out.println("4.20\n");

            in = scan.nextLine();

            if (in.equals("1"))
                {
                    System.out.println("\nCorrect\n\n");
                    Menu.clear();
                    c++;
                    return;
                }
            else
                System.out.println("\nWrong\n\n");
            //--------------------------------------
            
        }
        System.out.println("Sorry you have failed. LOL");
        end = true;
    }
}
