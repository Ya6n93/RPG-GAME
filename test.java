import java.util.Random;
import java.util.Scanner;

public class test{
    public static void start(){

        Random r = new Random();
        int essai = 0;
        int justprice = r.nextInt(200);
        int price = 0;

        while(justprice != price){
            System.out.println("Enter a number between 0 and 200 :");
            Scanner scan = new Scanner(System.in);

            if(justprice > price){
                System.out.println("Greater !");
            } else {
                System.out.println("Lower !");
            }

            price = scan.nextInt();
            essai++;
        }
        System.out.println("You win, the just price was :" + justprice);
        System.out.println("In " + essai + " try");
    }
}
