import edu.princeton.cs.algs4.StdAudio;

/**
 * Application
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHeroLite {
    private static final double CONCERT_A = 440.0;    // base case

    private static final String STRING_KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static final GuitarString[] STRING_LIST = new GuitarString[37];

    /**
     * convert input index into frequency
     */
    public static double frequency(int i) {
        return CONCERT_A * Math.pow(2, (i - 24) / 12.0);
    }

    /**
     * construct the STRING_LIST
     */
    public static void construct() {
        for (int i = 0; i < 37; i++) {
            STRING_LIST[i] = new GuitarString(frequency(i));
        }
    }

    public static void main(String[] args) {
        construct();    // construct the STRING_LIST

        int i = 0;
        while (true) {

            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                i = STRING_KEYBOARD.indexOf(key);
                if (i == -1) {
                    i = 0;
                    continue;
                }
                STRING_LIST[i].pluck();
            }

            double sample = STRING_LIST[i].sample();

            StdAudio.play(sample);

            STRING_LIST[i].tic();

        }
    }
}


