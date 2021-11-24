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
        this.skill = skill.toLowerCase();
    }

    public void emergencyMeeting() {
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

    public boolean equals(Object o) {
        if (o instanceof Player && o instanceof RedAstronaut) {
            Player player = (Player) o;
            RedAstronaut red = (RedAstronaut) o;
            return this.getName().equals(player.getName()) && this.isFrozen() == player.isFrozen()
                    && this.getSusLevel() == player.getSusLevel() && this.getSkill() == red.getSkill();
        }
        return false;
    }

    @Override
    public String toString() {
        String string = super.toString() + " I am a " + getSkill() + "player!";

        if (getSusLevel() > 15) {
            return string.toUpperCase();
        }
        else {
            return string;
        }
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        skill = skill.toLowerCase();
    }

}