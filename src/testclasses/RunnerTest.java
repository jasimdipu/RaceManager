package testclasses;

import objectclasses.Athlete;
import objectclasses.Runner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RunnerTest extends AthleteTest {

    public Runner runner;
    public String shoeBarnds = "fastrack";

    @Override
    public Athlete getAthlete1() {
        return new Runner();
    }

    @Override
    public Athlete getExpliciteAthlete2() {
        return new Runner(_name, _age, _racerid, shoeBarnds);
    }

    @Before
    public void setUp() throws Exception{
        runner = new Runner();
    }

    @After
    public void tearDown() throws Exception{
        runner = null;
    }

    @Test
    public void testConstructors(){
        super.testConstructors();
        Runner runner2 = new Runner(_name, _age, _racerid, shoeBarnds);
        Assert.assertEquals("shoe brands does not constructed",
                shoeBarnds, runner2.get_shoeBrands());
    }

    @Test
    public void testShoeBrands(){
        runner.set_shoeBrands(shoeBarnds);
        Assert.assertEquals("shoe brands does not get set expectedly",
                shoeBarnds, runner.get_shoeBrands());
    }

    @Test
    public void testToString(){
        super.testToString();
        }
}
