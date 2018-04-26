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
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;

        last = (last + 1) % capacity;
        fillCount += 1;
    }

    /**
     * Dequeue oldest item in the ring buffer.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }

        T f = rb[first];
        rb[first] = null;

        first = (first + 1) % capacity;
        fillCount -= 1;

        return f;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");  // messenger subject to change
        }
        return rb[first];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator {
        private int p;
        private boolean front;

        public Iter() {
            p = first;
            front = true;
        }

        public boolean hasNext() {
            if (isEmpty()) {
                return false;
            }
            if (p == first) {
                if (front) {
                    front = false;
                    return true;
                }
                return false;
            } else if (rb[p] != null) {
                return true;
            }
            return false;

        }

        public T next() {
            T nex = rb[p];
            p = (p + 1) % capacity;
            return nex;
        }

        public int p() {
            return p;
        }

    }


}
