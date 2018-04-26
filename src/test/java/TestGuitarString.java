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
} 
