import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// prompt user for 2 player names
// display and select from menu
// Create and initialize Player objects
// Store Player objects in List/ Array
// Create instance and start Game when option is selected

public class GameDriver {
	
	/**
	 * Compares the length of a string to a minimum and maximum value.
	 * @param name The string to be tested
	 * @param min The minimum length
	 * @param max The maximum length
	 * @return true if min <= name length <= max, else returns false with a message
	 */
	static Boolean nameLengthTester(String name, int min, int max) {
		if (name.length() >= min && name.length() <= max)
		{
			return true;
		} 
		else 
		{
			System.out.println("Name must be between " + min + " and " + max + " characters long.");
			return false;
		}
	}
	
	
	/**
	 * Compares two String names (case-sensitive)
	 * @param name1 A String representing the first player's name
	 * @param name2 A String representing the second player's name
	 * @return true if names are different
	 */
	static boolean sameNameTester(String name1, String name2) {
		if (!name1.equals(name2)) {
			return true;
		}
		else {
			System.out.println("Player names cannot be the same. Please try again.");
			return false;
		}
	}
	
	
	/**
	 * The menu function displays the menu and prompts the user to select an option. 
	 * It then calls the corresponding function. 
	 * @param sc A Scanner object for user input
	 */
    static void menu(Scanner sc, Game ng, List<Player> playerList) {
    	int userChoice;
        do {
				System.out.println("\n-------MENU-------");
				System.out.println("1. Play game");
				System.out.println("2. Show game rules");
				System.out.println("3. Show statistics");
				System.out.println("4. Exit");
				System.out.println("Please enter your choice (1, 2, 3, or 4): ");
				while(!sc.hasNextInt()) {
					System.out.println("Invalid input. Please try again.");
					sc.next();
				}
				userChoice = sc.nextInt();
				if (userChoice == 1) {
					ng.playGame();
				} else if (userChoice == 2) {
					ng.displayRules();
				} else if (userChoice == 3) {
					System.out.println("\n-------STATISTICS-------");
					for (Player p : playerList) {
						System.out.print(p.getName() + ": ");
						p.stats.displayStats();
					}
					System.out.print("\tOverall winner: ");
					if (playerList.get(0).stats.getGameStats(0) > playerList.get(1).stats.getGameStats(0)) {
						System.out.println(playerList.get(0).getName());
					} else if (playerList.get(0).stats.getGameStats(0) < playerList.get(1).stats.getGameStats(0)) {
						System.out.println(playerList.get(1).getName());
					} else {
						if (playerList.get(0).stats.getGameStats(1) < playerList.get(1).stats.getGameStats(1)) {
							System.out.println(playerList.get(0).getName());
						} else if (playerList.get(0).stats.getGameStats(1) > playerList.get(1).stats.getGameStats(1)) {
							System.out.println(playerList.get(1).getName());
						} else {
							System.out.println("Players are tied!");
						}
					}
				} else if (userChoice == 4) {
					System.out.println("Goodbye!");
					System.exit(0);
				} else {
					System.out.println("Invalid choice. Please enter again");
				}
        } while (true);
                
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		List<Player> players = new ArrayList<>();

		Player player1 = new Player();
		Player player2 = new Player();
		CPUplayer cpu = new CPUplayer();

		players.add(player1);
		players.add(player2);

		Game newGame = new Game(player1, player2, cpu, input);
		
		String tempName;
		// Prompt for names
		do {
			System.out.println("What is the name of the first player? ");
			tempName = input.nextLine();
		}while (!nameLengthTester(tempName, 5, 20));
		player1.setName(tempName);

		do {
			do {
				System.out.println("\nWhat is the name of the second player? ");
				tempName = input.nextLine();
			} while (!sameNameTester(player1.getName(),tempName));
		}while (!nameLengthTester(tempName,5,20));
		player2.setName(tempName);

// 		Display names for testing.
//		System.out.println("Player names: " + player1.getName() + " and " + player2.getName());


		// display menu
		menu(input, newGame, players);
	}

}
