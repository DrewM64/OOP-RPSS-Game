// Display rules
// Game logic to auto-run 3 rounds, announce winners of rounds and game 

import java.util.Scanner;

public class Game {
	Player player1;
	Player player2;
	CPUplayer computer;
	Scanner input;
	int p1choice;
	int p2choice;
	int cpuChoice;



	public Game(Player p1, Player p2, CPUplayer cpu, Scanner in){
		this.player1 = p1;
		this.player2 = p2;
		this.computer = cpu;
		this.input = in;
	}



	// 0 = tie, -1 = loss, 1 = win
	int[][] outcomes = {
			{0, -1, 1, 1},
			{1, 0, -1, -1},
			{-1, 1, 0, -1},
			{-1, 1, 1, 0}
	};


	public void displayRules() {
		System.out.println("""
				---HOW TO PLAY---
				Make a selection by typing the corresponding menu number and pressing the ENTER key

				---RULES---
				Winner of the round will be determined as follow:
				a.	Rock breaks scissors and Saw therefore rock wins over scissors and saw. Rock loses against paper.
				b.	Scissors cut paper therefore scissors win over paper. Scissors lose against rock and Saw.
				c.	Paper covers rock therefore paper wins over rock. Paper loses against scissors and saw
				e.	If player and computer make the same selection, there is a tie

				Winner of the game against the computer is one who won more rounds.
				Overall human winner is decided by most won games and least games lost against the computer""");
	}

	public String getWeaponName(int choice){
		String[] weapons = {"Rock", "Paper", "Scissors", "Saw"};
		return weapons[choice];
	}

	public int getWinner(int playerChoice, int cpuChoice){
		return outcomes[playerChoice][cpuChoice];
	}

	public void declareRoundWinner(Player player, CPUplayer computer, int playerChoice, int cpuChoice, int playerNum){
		if(getWinner(playerChoice, cpuChoice) == 0){
			System.out.println(player.getName() + " tied with computer!");
			player.stats.incrementRoundStats(2);
		}
		else if(getWinner(playerChoice, cpuChoice) > 0){
			System.out.println(player.getName() + " won!");
			player.stats.incrementRoundStats(0);
			player.stats.incrementTempPoints();
		}
		if(getWinner(playerChoice, cpuChoice) < 0){
			System.out.println(player.getName() + " lost...");
			player.stats.incrementRoundStats(1);
			computer.cpuStats.incrementCpuTemp(playerNum);
		}

//		For testing round points
//		System.out.println("points in method: " + player.stats.getTempPoints());
//		System.out.println("cpu points: " + computer.cpuStats.getCpuTemp(playerNum));
	}

	public void declareGameWinner(Player p, int playerNum){
		int playerTemp = p.stats.getTempPoints();
		int cpuTemp = computer.cpuStats.getCpuTemp(playerNum);
		if(playerTemp > cpuTemp){
			System.out.println(p.getName() + " won the game against CPU!");
			p.stats.incrementGameStats(0);
		}
		else if(playerTemp < cpuTemp){
			System.out.println(p.getName() + " lost the game against CPU...");
			p.stats.incrementGameStats(1);
		}
		else {
			System.out.println(p.getName() + " tied the game against CPU!");
			p.stats.incrementGameStats(2);
		}
	}

	//A round of RPSS
	public void oneRound() {

		p1choice = player1.getChoice(input);
		p2choice = player2.getChoice(input);
		cpuChoice = computer.getCpuChoice();

		System.out.println(player1.getName() + " chose " + getWeaponName(p1choice));
		System.out.println(player2.getName() + " chose " + getWeaponName(p2choice));
		System.out.println("CPU chose " + getWeaponName(cpuChoice));

		declareRoundWinner(player1, computer, p1choice,cpuChoice, 1);
		declareRoundWinner(player2, computer, p2choice,cpuChoice, 2);
	}


	public void playGame() {
		System.out.println("\n-------RPSW game-------");

		for (int i =0; i<3; i++) {
			System.out.println("\n--Round " + (i+1));
			oneRound();
		}

		System.out.println("\n---Game Over---");
		//After game winners declared, reset points
		declareGameWinner(player1, 1);
		declareGameWinner(player2, 2);

		player1.stats.resetTempPoints();
		player2.stats.resetTempPoints();
		computer.cpuStats.resetCpuTemp();
	}


}
