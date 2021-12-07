// Store name
// Store statistics data for player in Statistics object

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Player {
	private String name;
	Statistics stats = new Statistics();
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	// get player's choice of weapon
	public int getChoice(Scanner in) {
		// 0 = Rock, 1 = Paper, 2 = Scissors, 3 = Saw
		ArrayList<Integer> weaponChoices =new ArrayList<>(Arrays.asList(0, 1, 2, 3));

		int choice;
		do {
			System.out.println(name + " select: Rock(0) Paper(1) Scissors(2) Saw(3)");
			while(!in.hasNextInt()) {
				System.out.println("Invalid input. Please try again.");
				in.next();
			}
			choice = in.nextInt();
			if (!weaponChoices.contains(choice)) {
				System.out.println("Invalid choice; please type a number between 0 and 3");
			}
		} while(!weaponChoices.contains(choice));
		return choice;
	}

}
