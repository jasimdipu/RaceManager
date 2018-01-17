package objectclasses;

public class Runner extends Athlete {

    private String _shoeBrands;

    public Runner(String _name, int _age, int _racerid, String shoeBrands){
        super(_name, _age, _racerid);
        _shoeBrands = shoeBrands;
    }

    public Runner(){

    }

    public String get_shoeBrands(){
        return _shoeBrands;
    }

    public void set_shoeBrands(String shoeBrands){
        _shoeBrands = shoeBrands;
    }

    @Override
    public String sportsPerformence() {
        return "Running....";
    }
}
