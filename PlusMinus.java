import java.util.Random;
import java.util.Scanner;

public class PlusMinus{
    public static void start(){

        Random r = new Random();
        int essai = 0;
        int justprice = r.nextInt(200);
        int price = 0;

        while(justprice != price){
            if (essai == 20) {
                System.out.println("");
                return;
            }
            System.out.println("Enter a number between 0 and 200 (20 try):  ");
            Scanner scan = new Scanner(System.in);
            price = scan.nextInt();
            
            if(justprice > price){
                System.out.println("Greater !");
            } else if (justprice < price) {
                System.out.println("Lower !");
            }
            else {
                System.out.println("GOOD JOB");
            }
            
            essai++;
        }
        System.out.println("You win, the just price was :" + justprice);
        System.out.println("In " + essai + " try");
    }
}
