import java.util.Arrays;

public class CPUstats extends Statistics {
    //[0] points vs p1, [1] points vs p2
    private int[] cpuTemp = new int[2];

    public int getCpuTemp(int playerNum){
        return cpuTemp[playerNum-1];
    }

    public void incrementCpuTemp(int playerNum){
        cpuTemp[playerNum-1]++;
    }

    // reset CPU's round points to 0
    public void resetCpuTemp(){
        Arrays.fill(cpuTemp,0);
    }
}
