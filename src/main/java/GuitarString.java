
public class GuitarString {
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    public GuitarString(double frequency) {
        buffer = new ArrayRingBuffer<>((int) Math.round(SR / frequency));

        while (!buffer.isFull()) {
            buffer.enqueue(0.0);
        }
    }

    public void pluck() {

    }

    public void tic() {

    }

    public double sample() {
        return buffer.peek();
    }

}
