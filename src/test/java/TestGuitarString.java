/* Since this test is part of a package, we have to import the package version of StdAudio. */
/* Don't worry too much about this, we'll get there in due time. */
import edu.princeton.cs.introcs.StdAudio;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestGuitarString {
    @Test
    public void testInitiation() {
        double concertA = 440.0;
        GuitarString gs = new GuitarString(concertA);
        assertEquals(0.0, gs.sample(), 0.001);
    }

    @Test
    public void testPluck() {
        GuitarString gs = new GuitarString(11025);
        gs.pluck();
    }

    @Test
    public void testTic() {
        GuitarString gs = new GuitarString(11025);
        // initialize
        // capacity of array buffer: 4
        gs.pluck();
        gs.tic();

    }

    @Test
    public void testTicImplementation() {
        GuitarString gs = new GuitarString(11025);
        // initialize
        // capacity of array buffer: 4
        gs.pluck();

        double s1 = gs.sample();
        gs.tic();
        double s2 = gs.sample();
        gs.tic();
        gs.tic();
        gs.tic();

        assertEquals((s2 + s1) / 2.0 * 0.996, gs.sample(), 0.05);
    }

} 
