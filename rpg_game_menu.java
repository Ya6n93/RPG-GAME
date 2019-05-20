import java.util.*;

public class rpg_game_menu
{

    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();  
    }
    
    public void display_menu()
    {
        clear();
        System.out.println(".----. .----.  .---.     .---.   .--.  .-.   .-..----.");
        System.out.println("| {}  }| {}  }/   __}   /   __} / {} \\ |  `.'  || {_  ");
        System.out.println("| .-. \\| .--' \\  {_ }   \\  {_ }/  /\\  \\| |\\ /| || {__ ");
        System.out.println("`-' `-'`-'     `---'     `---' `-'  `-'`-' ` `-'`----'");
        System.out.println("1) Arcade\n2) Multiplayer\n3) Quit");
        System.out.print("Selection: ");
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

            case "9":
                clear();
                System.out.println ("Please proceed.");
                new rpg_game_menu();
                break;
            default:
                clear();
                System.err.println ( "Unrecognized option" );
                break;
            }
    }

    public rpg_game_menu()
    {
        Scanner in = new Scanner(System.in);
        display_menu();

        switch (in.nextLine())
            {
            case "1":
                clear();
                System.out.println ( "You picked option 1" );
                question();
                break;

            case "2":
                clear();
                System.out.println ( "You picked option 2" );
                question();
                break;

            case "3":
                clear();
                System.out.println ("See you later ! ;)");
                break;
            default:
                clear();
                System.err.println ( "Unrecognized option" );
                break;
            }
    }

    public static void main (String[]args)
    {
        clear();
        new rpg_game_menu();
    }
}
