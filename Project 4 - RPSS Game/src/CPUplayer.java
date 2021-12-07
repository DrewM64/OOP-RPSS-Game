import java.util.Random;

public class CPUplayer extends Player {
    private int cpuChoice;
    CPUstats cpuStats = new CPUstats();

    public int getCpuChoice() {
        setCpuChoice();
        return cpuChoice;
    }

    public void setCpuChoice() {
        Random rand = new Random();
        cpuChoice = rand.nextInt(4);
    }
}
