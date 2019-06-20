import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Colors
        String RESET = "\u001B[0m";
        String RED = "\033[31;1m";
        String YELLOW = "\033[33m";
        String GREEN = "\u001B[32m";
        String BLUE = "\033[34m";

        // Header
        System.out.println(BLUE + "                                      ***********************************" + RESET);
        System.out.println(BLUE + "                                      *********" + RESET + "  Le Juste Prix  " + BLUE + "*********" + RESET);
        System.out.println(BLUE + "                                      ***********************************" + RESET);
        System.out.println("                                                 V: 06182019.1           ");
        System.out.println("                                                 -------------           ");
        System.out.println();
        System.out.println("                                                  Informations           ");
        System.out.println("                                                  ------------           ");
        System.out.println("  - A tout moment de la partie vous pouvez quitter en tapant \".exit\" ou \".quit\".");
        System.out.println("  - Je suis KESYLO.");
        System.out.println("                                      -----------------------------------");

        // Program
        int justPrice = 0;
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers = 0;
        int minPrice = 1;
        int maxPrice = 3;
        String userInput = "";

        boolean isQuitGame = true;
        while (isQuitGame){

            // Make sure number of players is Int else loop
            boolean isNumberOfPlayersInt = true;
            while (isNumberOfPlayersInt){

                System.out.print(YELLOW + "        -> Nombre de joueurs : " + RESET);
                userInput = scanner.nextLine();
                try {
                    numberOfPlayers = Integer.parseInt(userInput);
                    isNumberOfPlayersInt = false;
                }catch ( NumberFormatException e){
                    System.out.println(RED + "                !-> La valeur entrée est incorrecte <-!" + RESET);
                }
            }

            // create game
            Game myGame = new Game(numberOfPlayers, minPrice, maxPrice);

            // Store just price
            justPrice = myGame.getPrice().getPriceValue();

            // Store player's array to set names
            Player players [] = myGame.getPlayers();

            // Set names
            for (int i = 0; i < numberOfPlayers; i++) {
                int playerCount = i + 1;
                System.out.print(YELLOW + "        -> Nom du joueur N° " + playerCount + " : " + RESET);
                userInput = scanner.nextLine();
                players[i] = new Player(userInput);
            }

            // Start game
            System.out.print("\n");
            System.out.print("                           ----------------           \n");
            System.out.print(GREEN + "          !!-> Le juste prix est dans la plage [" + minPrice + ", " + maxPrice + "] <-!! \n" + RESET);
            System.out.print("                           ----------------           \n");
            System.out.print("\n");

            int count = 0;
            int numberOfattempts = 1;
            int maxAttempsPerPlayer = 6;
            int currentTest = 0;

            // Switch between users to get their tries
            while (numberOfattempts < maxAttempsPerPlayer + 1){
                for (int i = 0; i < players.length ; i++) {
                    count = i + 1;

                    // Make sure test is Int else loop
                    boolean isAttemptInt = true;
                    while (isAttemptInt){

                        System.out.print(YELLOW + "        -> Joueur N° " + count + " Estimation de " + players[i].getPlayerName() + " (Tentative N° " + numberOfattempts + "): " + RESET);
                        userInput = scanner.nextLine();
                        try {
                            currentTest = Integer.parseInt(userInput);
                            isAttemptInt = false;
                        }catch ( NumberFormatException e){
                            System.out.println(RED + "                !-> La valeur entrée est incorrecte <-!" + RESET);
                        }

                        // check if won
                        if (currentTest == justPrice){
                            System.out.print("\n");
                            System.out.print(GREEN + "          !!-> Le gagnant est : " + players[i].getPlayerName() + " <-!! \n" + RESET);
                            System.exit(0);
                        } else if (currentTest < justPrice && !isAttemptInt){
                            System.out.print(GREEN + "          !-> Faux, le juste prix est Plus <-!! \n" + RESET);
                        }else if (currentTest > justPrice && !isAttemptInt) {
                            System.out.print(GREEN + "          !-> Faux, le juste prix est Moins <-!! \n" + RESET);
                        }
                    }
                }
                numberOfattempts ++;
            }

            // loop until hit .exit
            isQuitGame = false;
            if (userInput.equals(".exit") || userInput.equals(".quit")){
                System.exit(0);
            }
        }
    }
}