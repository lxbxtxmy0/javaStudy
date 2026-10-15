package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class VecNTest {
    Vector v1 = new VecN(1, 2);
    Vector v2 = new VecN(1, 2, 3);

    @Test
    void component() {
        assertEquals(v1.component(0), 1);
        assertEquals(v2.component(0), 1);
        assertEquals(v1.component(1), 2);
        assertEquals(v2.component(1), 2);
        assertEquals(v2.component(2), 3);
    }

    @Test
    void bitDepth() {
        assertEquals(v1.bitDepth(), 2);
        assertEquals(v2.bitDepth(), 3);
    }
}