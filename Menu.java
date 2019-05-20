import java.util.*;

public class Menu
{
    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();  
    }

    public void display_menu()
    {
        clear();
        Art.rpggame();
        System.out.println(ConsoleColors.GREEN + "1) Arcade\n" + ConsoleColors.YELLOW + "2) Multiplayer\n" + ConsoleColors.RED + "3) Quit");
        System.out.print(ConsoleColors.CYAN + "Selection: " + ConsoleColors.RESET);
    }

    public void question()
    {
        clear();
        System.out.println("Would you like to return at the home or quit?");
        System.out.println("To return at the home enter 1.");
        System.out.println("If you wish to quit enter 0.");
        Scanner q = new Scanner(System.in);

        switch (q.nextLine())
            {
            case "0":
                clear();
                System.out.println ("See you later ! ;)");
                break;

            case "1":
                clear();
                System.out.println ("Please proceed.");
                new Menu();
                break;
            default:
                clear();
                System.err.println ( "Unrecognized option" );
                break;
            }
    }

    public Menu()
    {
        Scanner in = new Scanner(System.in);
        display_menu();
        switch (in.nextLine())
            {
            case "1":
                clear();
                Art.arcade();
                System.out.println("");
                StartMap.startMap();
                break;

            case "2":
                clear();
                Art.multiplayer();
                Map m2 = new Map(10,15);
                m2.put(6,7,'P');
                m2.put(7,2,'P');
                m2.display();
                break;

            case "3":
                clear();
                System.out.println (ConsoleColors.GREEN + "See you later ! ;)" + ConsoleColors.RESET);
                System.exit(1);
                return;
            default:
                clear();
                System.err.println ( "Unrecognized option" );
                new Menu();
                break;
            }
    }

    public static void main (String[]args)
    {
        clear();
        new Menu();
    }
    
}
