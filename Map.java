import java.util.*;

public class Map{

    private int ligne;
    private int colonne;
    private char[][] map;
    private Player player;
    private int Key = 0;
    private int Weapon = 0;
    private int Kill = 0;
    private int PV = 100;

    public Map(int colonne, int ligne){
        this.ligne = ligne - 1;
        this.colonne = colonne - 1;
        map = new char[this.ligne][this.colonne];
        
        
        for(int i = 0; i < this.ligne; i++){
            for(int j = 0; j < this.colonne; j++){
                map[i][j] = '_';
            }
        }
    }

    public void display(){
        System.out.println("");
        System.out.println(ConsoleColors.GREEN + "|------CAPTION------|" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "|                   |");
        System.out.println(ConsoleColors.GREEN + "|    " + ConsoleColors.PURPLE+"P = Player"+ConsoleColors.GREEN+"     |" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "|    " + ConsoleColors.YELLOW+"1,2,3 = Key"+ConsoleColors.GREEN+"    |" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "|    " + ConsoleColors.RED+"M,D,B = Monster"+ConsoleColors.GREEN+"|" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "|    " + ConsoleColors.CYAN+"W = Weapon"+ConsoleColors.GREEN+"     |" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "|___________________|" + ConsoleColors.RESET);
        System.out.println("");
        for(int i = 0; i < ligne; i++){
            for(int j = 0; j < colonne; j++){
                if(map[i][j] == '_'){
                    System.out.print(ConsoleColors.GREEN + " | "  + map[i][j] + ConsoleColors.RESET);
                }
                else if(map[i][j] == 'P'){
                    System.out.print(ConsoleColors.GREEN + " | " + ConsoleColors.PURPLE + map[i][j] + ConsoleColors.RESET);
                }
                else if(map[i][j] == '1' || map[i][j] == '2' || map[i][j] == '3'){
                    System.out.print(ConsoleColors.GREEN + " | " + ConsoleColors.YELLOW+ map[i][j] + ConsoleColors.RESET);
                }
                else if(map[i][j] == 'M' || map[i][j] == 'D' || map[i][j] == 'B' || map[i][j] == '#'){
                    System.out.print(ConsoleColors.GREEN + " | " + ConsoleColors.RED + map[i][j] + ConsoleColors.RESET);
                }
                else if(map[i][j] == 'W'){
                    System.out.print(ConsoleColors.GREEN + " | " + ConsoleColors.CYAN + map[i][j] + ConsoleColors.RESET);
                }
                else {
                    System.out.print(ConsoleColors.GREEN + " | "  + ConsoleColors.RESET + map[i][j]);
                }
            }
            System.out.println(ConsoleColors.GREEN + " | " + ConsoleColors.RESET);
        }
    }

    public void put(int l, int c, char e){
               
        if(l < 0 || c < 0 || l > ligne || c  > colonne){
            System.out.print("PLACE TOI BIEN FRERO");
            return;
        }

        if(map[l][c] == '_'){
            map[l][c] = e;
            if(e == 'P'){
                this.player = new Player(l,c);
            }
        }

        else{
            System.out.print("OBSTACLEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        }

    }
    
    public void moveUp(){
        
        if (this.player.x - 1 >= 0) {
            if(map[this.player.x - 1][this.player.y] == '_'){
                map[this.player.x][this.player.y] = '_';
                this.player.x = this.player.x - 1;
                map[this.player.x][this.player.y] = 'P';
            }
            if(map[this.player.x - 1][this.player.y] == '1' && Kill == 1){
                map[this.player.x][this.player.y] = '_';
                this.player.x = this.player.x - 1;
                map[this.player.x][this.player.y] = 'P';
                Menu.clear();
                PlusMinus.start();
                Key++;
                Menu.clear();
                put(5,5,'2');
                put(3,7,'D');
                put(2,2,'W');                
            }
            if(map[this.player.x - 1][this.player.y] == '2' && Kill == 2){
                map[this.player.x][this.player.y] = '_';
                this.player.x = this.player.x - 1;
                map[this.player.x][this.player.y] = 'P';
                Menu.clear();
                Quiz.quiz();
                Key++;
                Menu.clear();
                put(7,1,'3');
                put(6,4,'B');
                put(4,6,'W');
            }
            if(map[this.player.x - 1][this.player.y] == '3' && Kill == 3){
                map[this.player.x][this.player.y] = '_';
                this.player.x = this.player.x - 1;
                map[this.player.x][this.player.y] = 'P';
                Key++;
                Roulette.launch();
                Menu.clear();
                Art.end();
            }
            
            if(map[this.player.x - 1][this.player.y] == 'W'){
                map[this.player.x][this.player.y] = '_';
                this.player.x = this.player.x - 1;
                map[this.player.x][this.player.y] = 'P';
                Weapon++;
            }
            if(map[this.player.x - 1][this.player.y] == 'M' && Weapon == 1){
                map[this.player.x][this.player.y] = '_';
                this.player.x = this.player.x - 1;
                map[this.player.x][this.player.y] = 'P';
                PV = 1000;
                Kill++;
            }
            if(map[this.player.x - 1][this.player.y] == 'D' && Weapon == 2){
                map[this.player.x][this.player.y] = '_';
                this.player.x = this.player.x - 1;
                map[this.player.x][this.player.y] = 'P';
                PV = 10000;
                Kill++;
            }
            if(map[this.player.x - 1][this.player.y] == 'B' && Weapon == 3){
                map[this.player.x][this.player.y] = '_';
                this.player.x = this.player.x - 1;
                map[this.player.x][this.player.y] = 'P';
                PV = 100000;
                Kill++;
            }
        }
    }

    public void moveDown(){

        if(this.player.x + 1 < ligne) {
            if(map[this.player.x + 1][this.player.y] == '_'){
                map[this.player.x][this.player.y] = '_';
                this.player.x = this.player.x + 1;
                map[this.player.x][this.player.y] = 'P';
            }
            if(map[this.player.x + 1][this.player.y] == '1' && Kill == 1){
                map[this.player.x][this.player.y] = '_';
                this.player.x = this.player.x + 1;
                map[this.player.x][this.player.y] = 'P';
                Menu.clear();
                PlusMinus.start();
                Key++;
                Menu.clear();
                put(5,5,'2');
                put(3,7,'D');
                put(2,2,'W');
            }
            if(map[this.player.x + 1][this.player.y] == '2' && Kill == 2){
                map[this.player.x][this.player.y] = '_';
                this.player.x = this.player.x + 1;
                map[this.player.x][this.player.y] = 'P';
                Menu.clear();
                Quiz.quiz();
                Key++;
                Menu.clear();
                put(7,1,'3');
                put(6,4,'B');
                put(4,6,'W');
            }
            if(map[this.player.x + 1][this.player.y] == '3' && Kill == 3){
                map[this.player.x][this.player.y] = '_';
                this.player.x = this.player.x + 1;
                map[this.player.x][this.player.y] = 'P';
                Key++;
                Roulette.launch();
                Menu.clear();
                Art.end();
            }
            if(map[this.player.x + 1][this.player.y] == 'W'){
                map[this.player.x][this.player.y] = '_';
                this.player.x = this.player.x + 1;
                map[this.player.x][this.player.y] = 'P';
                Weapon++;
            }
            if(map[this.player.x + 1][this.player.y] == 'M' && Weapon == 1){
                map[this.player.x][this.player.y] = '_';
                this.player.x = this.player.x + 1;
                map[this.player.x][this.player.y] = 'P';
                PV = 1000;
                Kill++;
            }
            if(map[this.player.x + 1][this.player.y] == 'D' && Weapon == 2){
                map[this.player.x][this.player.y] = '_';
                this.player.x = this.player.x + 1;
                map[this.player.x][this.player.y] = 'P';
                PV = 10000;
                Kill++;
            }
            if(map[this.player.x + 1][this.player.y] == 'B' && Weapon == 3){
                map[this.player.x][this.player.y] = '_';
                this.player.x = this.player.x + 1;
                map[this.player.x][this.player.y] = 'P';
                PV = 10000;
                Kill++;
            }
        }
    }

    public void moveLeft(){
        
        if(this.player.y - 1 >= 0){
            if(map[this.player.x][this.player.y - 1] == '_'){
                map[this.player.x][this.player.y] = '_';
                this.player.y = this.player.y - 1;
                map[this.player.x][this.player.y] = 'P';
            }
            if(map[this.player.x][this.player.y - 1] == '1' && Kill == 1){
                map[this.player.x][this.player.y] = '_';
                this.player.y = this.player.y - 1;
                map[this.player.x][this.player.y] = 'P';
                Menu.clear();
                PlusMinus.start();
                Key++;
                Menu.clear();
                put(5,5,'2');
                put(3,7,'D');
                put(2,2,'W');
            }
            if(map[this.player.x][this.player.y - 1] == '2' && Kill == 2){
                map[this.player.x][this.player.y] = '_';
                this.player.y = this.player.y - 1;
                map[this.player.x][this.player.y] = 'P';
                Menu.clear();
                Quiz.quiz();
                Key++;
                Menu.clear();
                put(7,1,'3');
                put(6,4,'B');
                put(4,6,'W');
            }
            if(map[this.player.x][this.player.y - 1] == '3' && Kill == 3){
                map[this.player.x][this.player.y] = '_';
                this.player.y = this.player.y - 1;
                map[this.player.x][this.player.y] = 'P';
                Key++;
                Roulette.launch();
                Menu.clear();
                Art.end();
            }
            if(map[this.player.x][this.player.y - 1] == 'W'){
                map[this.player.x][this.player.y] = '_';
                this.player.y = this.player.y - 1;
                map[this.player.x][this.player.y] = 'P';
                Weapon++;
            }
            if(map[this.player.x][this.player.y - 1] == 'M' && Weapon == 1){
                map[this.player.x][this.player.y] = '_';
                this.player.y = this.player.y - 1;
                map[this.player.x][this.player.y] = 'P';
                PV = 1000;
                Kill++;
            }
            if(map[this.player.x][this.player.y - 1] == 'D' && Weapon == 2){
                map[this.player.x][this.player.y] = '_';
                this.player.y = this.player.y - 1;
                map[this.player.x][this.player.y] = 'P';
                PV = 10000;
                Kill++;
            }
            if(map[this.player.x][this.player.y - 1] == 'B' && Weapon == 3){
                map[this.player.x][this.player.y] = '_';
                this.player.y = this.player.y - 1;
                map[this.player.x][this.player.y] = 'P';
                PV = 100000;
                Kill++;
            }
        }
    }

    public void moveRight(){
        
        if(this.player.y + 1 < colonne){
            if(map[this.player.x][this.player.y + 1] == '_'){
                map[this.player.x][this.player.y] = '_';
                this.player.y = this.player.y + 1;
                map[this.player.x][this.player.y] = 'P';
            }
        }
        if(map[this.player.x][this.player.y + 1] == '1' && Kill == 1){
            map[this.player.x][this.player.y] = '_';
            this.player.y = this.player.y + 1;
            map[this.player.x][this.player.y] = 'P';
            Menu.clear();
            PlusMinus.start();
            Key++;
            Menu.clear();
            put(5,5,'2');
            put(3,7,'D');
            put(2,2,'W');
        }
        if(map[this.player.x][this.player.y + 1] == '2' && Kill == 2){
            map[this.player.x][this.player.y] = '_';
            this.player.y = this.player.y + 1;
            map[this.player.x][this.player.y] = 'P';
            Menu.clear();
            Quiz.quiz();
            Key++;
            Menu.clear();
            put(7,1,'3');
            put(6,4,'B');
            put(4,6,'W');
        }
        if(map[this.player.x][this.player.y + 1] == '3' && Kill == 3){
            map[this.player.x][this.player.y] = '_';
            this.player.y = this.player.y + 1;
            map[this.player.x][this.player.y] = 'P';
            Key++;
            Roulette.launch();
            Menu.clear();
            Art.end();
        }
        if(map[this.player.x][this.player.y + 1] == 'W'){
            map[this.player.x][this.player.y] = '_';
            this.player.y = this.player.y + 1;
            map[this.player.x][this.player.y] = 'P';
            Weapon++;
        }
        if(map[this.player.x][this.player.y + 1] == 'M' && Weapon == 1){
            map[this.player.x][this.player.y] = '_';
            this.player.y = this.player.y + 1;
            map[this.player.x][this.player.y] = 'P';
            PV = 1000;
            Kill++;
        }
        if(map[this.player.x][this.player.y + 1] == 'D' && Weapon == 2){
            map[this.player.x][this.player.y] = '_';
            this.player.y = this.player.y + 1;
            map[this.player.x][this.player.y] = 'P';
            PV = 10000;
            Kill++;
        }
        if(map[this.player.x][this.player.y + 1] == 'B' && Weapon == 1){
            map[this.player.x][this.player.y] = '_';
            this.player.y = this.player.y + 1;
            map[this.player.x][this.player.y] = 'P';
            PV = 100000;
            Kill++;
        }
    }

    public void MOVE(){
        boolean stoparcade = false;
        System.out.println(ConsoleColors.PURPLE + "You have " + PV + " PV");
        System.out.println("");
        System.out.println(ConsoleColors.YELLOW + "You have " + Key + " Key");
        System.out.println("");
        System.out.println(ConsoleColors.CYAN + "You have a Sword level " + Weapon + "." + ConsoleColors.RESET);
        System.out.println("");
        System.out.println(ConsoleColors.RED + "You Kill " + Kill + " monster.");
        System.out.print(ConsoleColors.BLUE + "To move use z,q,s,d and 0 to leave : " + ConsoleColors.RESET);
        
        while(!stoparcade) {
            // System.out.println(ConsoleColors.PURPLE + "You have " + PV + " PV");
            // System.out.println("");
            // System.out.println(ConsoleColors.YELLOW + "You have " + Key + " Key");
            // System.out.println("");
            // System.out.println(ConsoleColors.CYAN + "You have a Sword level " + Weapon + "." + ConsoleColors.RESET);
            // System.out.println("");
            // System.out.println(ConsoleColors.RED + "You Kill " + Kill + " monster.");
            // System.out.print(ConsoleColors.BLUE + "To move use z,q,s,d and 0 to leave : " + ConsoleColors.RESET);
            Scanner sc = new Scanner(System.in);
            String Sens = sc.nextLine();
            switch(Sens){
            case "z" :
                Menu.clear();
                moveUp();
                display();
                break;
            case "s" :
                Menu.clear();
                moveDown();
                display();
                break;
            case "q" :
                Menu.clear();
                moveLeft();
                display();
                break;
            case "d" :
                Menu.clear();
                moveRight();
                display();
                break;
            case "0" :
                new Menu();
                break;
            default :
                Menu.clear();
                System.out.print("PUT A GOOD KEY PLEASE !!!!");
                display();
            }
        }
    }
}
