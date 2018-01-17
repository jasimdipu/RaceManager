package objectclasses;

public class Swimmer extends Athlete {

    public Swimmer(String _name, int _age, int _racerid){
        super(_name, _age, _racerid);
    }

    public Swimmer(){

    }

    @Override
    public String sportsPerformence() {
        return "Swimming";
    }
}
