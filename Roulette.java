import java.util.*;
import java.util.Scanner;

public class Roulette {
    public static void launch() {
        Scanner reader = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Enter your Money");
        int money = reader.nextInt();
        int max = money;

        while (money > 0) {
            System.out.println("Enter your bet");
            int bet = reader.nextInt();
            
            if (money < bet) {
                bet = money;
            }

            int spin = r.nextInt(10);


            if (spin != 0 && spin <= 18) {
                money = money + bet;
            } else {
                money = money - bet;
            }

            if (money > max) {
                max = money;
                System.out.println("Your money is :" + max);
                return ;
            }
            System.out.println("betting $" + bet + ", spin is " + spin
                               + ", money now = $" + money);
        }
        System.out.println("max = $" + max);
    }
}
