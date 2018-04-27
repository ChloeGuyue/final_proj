import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHeroLite {
    @Test
    public void testApplication() {
        // instantiate the client, test if array buffer is correct
        // the 24th item should be concert_A, which has a frequency of
        assertEquals(440.0, GuitarHeroLite.frequency(24), 0.05);
    }
}
