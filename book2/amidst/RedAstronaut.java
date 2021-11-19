import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {

    private String skill;

    private static final int defaultSusLevel = 15;
    private static final String defaultSkill = "experienced";

    public  RedAstronaut(String name) {
        this(name, defaultSusLevel, defaultSkill);
    }

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        skill = skill.toLowerCase();
    }

    public void emergencyMeeting() {
        var playerArray = getPlayers();

        if(playerArray.length <= 2) {
            return;
        }

        Arrays.sort(playerArray);
        Player mostSus = playerArray[playerArray.length-1];

        if (this.getSusLevel() == mostSus.getSusLevel()) {
            return;
        }
        if (mostSus.getSusLevel() == playerArray[playerArray.length-2].getSusLevel()) {
            return;
        }

        mostSus.setFrozen(true);
        this.gameOver();
    }

    public void sabotage(Player p) {
        if (isFrozen() || p.isFrozen()) {
            return;
        }
        if (getSusLevel() < 20) {
            p.setSusLevel((int)(p.getSusLevel()*1.5));
        }
        else {
            p.setSusLevel((int)(p.getSusLevel()*1.25));
        }
    }

    public void freeze(Player p) {
        if (p.isFrozen()) {
            return;
        }
        if (p instanceof Impostor) {
            return;
        }
        if (getSusLevel() < p.getSusLevel()) {
            p.setFrozen(true);
        }
        else {
            setSusLevel(getSusLevel()*2);
        }
        gameOver();
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        skill = skill.toLowerCase();
    }

}