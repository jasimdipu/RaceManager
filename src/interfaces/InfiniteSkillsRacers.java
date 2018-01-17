package interfaces;

import objectclasses.Athlete;

import java.util.ArrayList;
import java.util.Random;

public class InfiniteSkillsRacers implements Racer {

    public ArrayList<Athlete> _racers;
    public int _nextRacersId;
    public String _name;
    public double _distance;
    public String _location;
    public Athlete _winner;

    public InfiniteSkillsRacers(){
        _racers = new ArrayList<>();
        Random random = new Random();
        _nextRacersId = random.nextInt(99999);
    }

    @Override
    public String getname() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;
    }

    @Override
    public double getDistance() {
        return _distance;
    }

    @Override
    public void setDistance(double distance) {
        _distance = distance;
    }

    @Override
    public String getLocation() {
        return _location;
    }

    @Override
    public void setLocation(String location) {
        _location = location;
    }

    @Override
    public Athlete getWinner() {
        calculateWinner();
        return _winner;
    }

    private void calculateWinner(){
        Random random = new Random();
        int winnerIndex = random.nextInt(_racers.size());
        _winner = _racers.get(winnerIndex);
    }

    @Override
    public boolean addRacer(Athlete addAthlete) {
        if(addAthlete == null)
            return false;
        if (addAthlete.getName() == null)
            return false;
        int racerIndex = findRacer(addAthlete.getName());
        if(racerIndex >= 0)
            return false;
        _racers.add(addAthlete);
        addAthlete.setRacerId(_nextRacersId++);
        return true;
    }

    @Override
    public boolean removeRacer(String name) {

        if(name == null)
            return false;
        int racePosition = findRacer(name);
        if(racePosition < 0)
            return false;
        _racers.remove(racePosition);
        return true;
    }

    @Override
    public int getCurrentNumberofRacers() {
        return _racers.size();
    }

    @Override
    public Athlete getAthlete(String name) {

        int index = findRacer(name);
        if(index < 0)
            return null;
        return _racers.get(index);
    }

    private int findRacer(String name){
        if(name == null)
            return -1;
        for(int i=0; i<_racers.size(); i++){
            Athlete athlete = _racers.get(i);
            if(athlete.getName().equalsIgnoreCase(name))
                return i;
        }
        return -1;
    }

    @Override
    public Athlete[] getRacers() {
        if(_racers.size() > 0){
            Athlete[] athletes = new Athlete[_racers.size()];
            for(int i=0; i<_racers.size(); i++)
                athletes[i] = _racers.get(i);
            return athletes;
        }
        return null;
    }
}
