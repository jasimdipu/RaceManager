package testclasses;

import objectclasses.Athlete;
import objectclasses.Swimmer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SwimmerTest extends AthleteTest {

    public Swimmer swimmer;

    @Override
    public Athlete getAthlete1() {
        return new Swimmer();
    }

    @Override
    public Athlete getExpliciteAthlete2() {
        return new Swimmer(_name, _age, _racerid);
    }

    @Before
    public void setUp() throws Exception{

    }

    @After
    public void tearDown() throws Exception{
        swimmer = null;
    }

    @Test
    public void testToString(){

        super.testToString();

    }
}
