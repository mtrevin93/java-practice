import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {

    private int numTasks;
    private int taskSpeed;

    private static final int defaultSuSLevel = 15;
    private static final int defaultNumTasks = 6;
    private static final int defaultTaskSpeed = 10;

    public BlueAstronaut(String name) {
        this(name, defaultSuSLevel, defaultNumTasks, defaultTaskSpeed);
    }

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    public void emergencyMeeting() {
        if (isFrozen()) {
            return;
        }
        var playerArray = getPlayers();
        int unfrozenPlayerCount = 0;
        for (Player p : playerArray) {
            if (p.isFrozen()) {
                continue;
            }
            else {
                unfrozenPlayerCount++;
            }
        } 
        Player [] unfrozenPlayerArray = new Player[unfrozenPlayerCount];
        int index = 0;
        for (Player p : playerArray) {
            if (!p.isFrozen()) {
                unfrozenPlayerArray[index] = p;
                index++;
            }
        }

        if(unfrozenPlayerArray.length <= 2) {
            return;
        }

        Arrays.sort(unfrozenPlayerArray);
        Player mostSus = unfrozenPlayerArray[unfrozenPlayerArray.length-1];

        if (this.getSusLevel() == mostSus.getSusLevel()) {
            return;
        }
        if (mostSus.getSusLevel() == unfrozenPlayerArray[unfrozenPlayerArray.length-2].getSusLevel()) {
            return;
        }

        mostSus.setFrozen(true);
        this.gameOver();
    }

    public void completeTask() {
        if (isFrozen() || numTasks == 0) {
            return;
        }
        if (taskSpeed > 20) {
            numTasks -= 2;
        }
        else {
            numTasks -= 1;
        }
        if (numTasks < 0) {
            numTasks = 0;
        }
        if (numTasks == 0) {
            System.out.println("I have completed all my tasks");
            setSusLevel((int)(getSusLevel() * 0.5));
        }
    }

    public boolean equals(Object o) {
        if (o instanceof Player && o instanceof BlueAstronaut) {
            Player player = (Player) o;
            BlueAstronaut blue = (BlueAstronaut) o;
            return this.getName().equals(player.getName()) && this.isFrozen() == player.isFrozen()
                    && this.getSusLevel() == player.getSusLevel() && this.numTasks == blue.numTasks
                    && this.taskSpeed == blue.taskSpeed;
        }
        return false;
    }

    @Override
    public String toString() {
        String string = super.toString() + " I have " + numTasks + " left over";

        if (getSusLevel() > 15) {
            return string.toUpperCase();
        }
        else {
            return string;
        }
    }

    public int getNumTasks() {
        return numTasks;
    }

    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }

    public int getTaskSpeed() {
        return taskSpeed;
    }

    public void setTaskSpeed(int taskSpeed) {
        this.taskSpeed = taskSpeed;
    }

}