public class RingBuffer<T> {
    private static final int MAX_SIZE = 1024;

    private T[] buffer;
    private int head;
    private int tail;
    private int size;

    @SuppressWarnings("unchecked")
    public RingBuffer(int capacity) {
        if (capacity < 0 || capacity > MAX_SIZE) {
            throw new IllegalArgumentException("Размер должен быть в пределах [0, 1024]");
        }

        this.buffer = (T[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public RingBuffer(RingBuffer<T> other) {
        this.buffer = (T[]) new Object[other.buffer.length];
        this.head = 0;
        this.tail = 0;
        this.size = 0;

        for (int i = 0; i < other.size; i++) {
            int index = (other.head + i) % other.buffer.length;
            this.add(other.buffer[index]);
        }
    }

    @SafeVarargs
    public final void add(T... elements) {
        for (T element : elements) {
            buffer[tail] = element;
            tail = (tail + 1) % buffer.length;

            if (size < buffer.length) {
                size++;
            } else {
                head = (head + 1) % buffer.length;
            }
        }
    }

    public T getElement() {
        if (size == 0) {
            throw new IllegalStateException("Вы пытаетесь прочитать пустой буфер");
        }

        T elt = buffer[head];
        buffer[head] = null;
        head = (head + 1) % buffer.length;
        size--;
        return elt;
    }

    @SuppressWarnings("unchecked")
    public T[] export() {
        T[] exportingBuffer = (T[]) new Object[size];

        for (int i = 0; i < size; i++) {
            int index = (head + i) % buffer.length;
            exportingBuffer[i] = buffer[index];
        }

        return exportingBuffer;
    }
}