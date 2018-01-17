package interfaces;

import objectclasses.Athlete;

public interface Racer {

    public String getname();

    public void setName(String name);

    public double getDistance();

    public void setDistance(double distance);

    public String getLocation();

    public void setLocation(String location);

    public Athlete getWinner();

    public boolean addRacer(Athlete addAthlete);

    public boolean removeRacer(String name);

    public int getCurrentNumberofRacers();

    public Athlete getAthlete(String name);

    public Athlete[] getRacers();

}
