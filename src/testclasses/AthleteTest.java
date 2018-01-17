package testclasses;

import objectclasses.Athlete;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AthleteTest {

    public Athlete athlete1;
    public Athlete athlete2;

    public String _name = "john";
    public int _age = 28;
    public int _racerid = 2341;

    public abstract Athlete getAthlete1();
    public abstract Athlete getExpliciteAthlete2();

    public AthleteTest(){
        athlete1 = getAthlete1();
        athlete2 = getExpliciteAthlete2();
    }

    @Before
    public void setUp() throws Exception{

    }

    @After
    public void tearDown() throws Exception{
        athlete1 = null;
        athlete2 = null;
    }

    @Test
    public void testConstructors(){
        Assert.assertNotNull("Default constructor does not created ", athlete1);
        Assert.assertNotNull("Explicite constructor does not created ", athlete2);

        Assert.assertEquals("name does not construct ",
                _name, athlete2.getName());
        Assert.assertEquals("name does not construct ",
                _age, athlete2.getAge());
        Assert.assertEquals("name does not construct ",
                _racerid, athlete2.getRaceId());
    }

    @Test
    public void testGetSetName(){
        athlete1.setName(_name);
        Assert.assertEquals("get set name does not work",
                _name, athlete1.getName());
    }

    @Test
    public void testGetSetAge(){
        athlete1.setAge(_age);
        Assert.assertEquals("get set age does not work",
                _age, athlete1.getAge());
    }

    @Test
    public void testGetSetRacerId(){
        athlete1.setRacerId(_racerid);
        Assert.assertEquals("get set racer id does not work",
                _racerid, athlete1.getRaceId());
    }

    @Test
    public void testToString(){
        athlete1.setName(_name);
        athlete1.setAge(_age);
        athlete1.setRacerId(_racerid);

        String expected = athlete1.toString();

        Assert.assertTrue(expected.contains(_name));
        Assert.assertTrue(expected.contains(String.format("%d", _age)));
        Assert.assertTrue(expected.contains(String.format("%d", _racerid)));
    }

}
