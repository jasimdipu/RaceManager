package objectclasses;

public abstract class Athlete implements Person{
    private String _name;
    private int _age;
    private int _racerid;

    public Athlete(String name, int age, int racerid){
        _name = name;
        _age = age;
        _racerid = racerid;
    }

    public Athlete(){

    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;
    }

    @Override
    public int getAge() {
        return _age;
    }

    @Override
    public void setAge(int age) {
        _age = age;
    }

    @Override
    public int getRaceId() {
        return _racerid;
    }

    @Override
    public void setRacerId(int raceId) {
        _racerid = raceId;
    }

    public String toString(){
        return String.format("Racer Name : %s || Racer Age : %d || Racer id : %d ",
                getName(), getAge(), getRaceId());
    }

    public abstract String sportsPerformence();
}
