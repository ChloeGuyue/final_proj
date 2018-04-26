
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
        while (!buffer.isEmpty()) {
            buffer.dequeue();
        }

        while (!buffer.isFull()) {
            buffer.enqueue(Math.random() - 0.5);
        }
    }

    public void tic() {
        buffer.enqueue(((buffer.dequeue() + buffer.peek()) / 2.0) * DECAY);
    }

    public double sample() {
        return buffer.peek();
    }

}
