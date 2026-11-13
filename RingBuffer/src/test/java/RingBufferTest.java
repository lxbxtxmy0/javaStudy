import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RingBufferTest {
    RingBuffer<Integer> buffer1;
    RingBuffer<Integer> buffer2;

    @BeforeEach
    void setUp() {
        buffer1 = new RingBuffer<>(5);
        buffer1.add(5);
        buffer1.add(6);
        buffer1.add(7);
        buffer1.add(8);
        buffer1.add(9);
        buffer1.add(10);



        buffer2 = new RingBuffer<>(buffer1);
    }

    @Test
    void getElement() {
        assertEquals(buffer1.getElement(), (Integer) 6);
        assertEquals(buffer1.getElement(), (Integer) 7);
    }

    @Test
    void export() {
        assertTrue(Arrays.equals(buffer2.export(), buffer1.export()));
    }
}