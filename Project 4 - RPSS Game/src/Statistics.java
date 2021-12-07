// Store stats information 
// display display all stats (toString?)
public class Statistics {
	// round Statistics = row 0; [0, 0] = round wins, [0, 1] = round losses, [0, 2] = round ties
	// game statistics = row 1; [1, 0] = game wins, [1, 1] = game losses, [1, 2] = game ties
    private final int[][] statsArray = new int[2][3];

    // for keeping track of current game points
    private int tempPoints;



	// Return cumulative game/round results

    /**
     * Get total game stats
     * @param gameStat 0 for wins, 1 for losses, 2 for ties
     */
    public int getGameStats(int gameStat) {
        return statsArray[1][gameStat];
    }

    public int getTempPoints(){
        return tempPoints;
    }

	// increment cumulative game/round wins, losses, or ties

    /**
     * Increment total round stats
     * @param roundResult 0 for wins +1, 1 for losses +1, 2 for ties +1
     */
    public void incrementRoundStats(int roundResult) {
        statsArray[0][roundResult]++;
    }

    /**
     * Increment total game stats
     * @param gameResult 0 for wins +1, 1 for losses +1, 2 for ties +1
     */
	public void incrementGameStats(int gameResult) {
        statsArray[1][gameResult]++;
    }

    public void incrementTempPoints(){
        tempPoints++;
    }

    public void resetTempPoints(){
        tempPoints = 0;
    }

    //display stats for 1 player
    public void displayStats() {
        System.out.println("Rounds - " + statsArray[0][0] + "W  " + statsArray[0][1] + "L " + statsArray[0][2] + "T || " +
                "Games - " + statsArray[1][0] + "W  " + statsArray[1][1] + "L " + statsArray[1][2] + "T");
    }
	
}
