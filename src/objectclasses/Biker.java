package objectclasses;

public class Biker extends Athlete {

    private boolean USINGCLIPS;
    public Biker(String name, int age, int racerid, boolean usingclips) {
        super(name, age, racerid);
        USINGCLIPS = usingclips;
    }

    public Biker() {
    }

    public boolean isUSINGCLIPS() {
        return USINGCLIPS;
    }

    public void setUSINGCLIPS(boolean USINGCLIPS) {
        this.USINGCLIPS = USINGCLIPS;
    }

    @Override
    public String sportsPerformence() {
        return null;
    }
}
