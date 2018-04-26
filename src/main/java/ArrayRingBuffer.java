import java.util.Iterator;

/**
 * an array implementation of BoundedQueue
 */
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        //       first, last, and fillCount should all be set to 0.
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;

        fillCount = 0;
        this.capacity = capacity;
    }

    /**
     * Adds x to the end of the ring buffer.
     */
    public void enqueue(T x) {

    }

    /**
     * Dequeue oldest item in the ring buffer.
     */
    public T dequeue() {
        return null;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }


}
