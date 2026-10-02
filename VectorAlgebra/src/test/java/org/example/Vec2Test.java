package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class Vec2Test {
    Vector v1 = new Vec2(1, 2);
    Vector v2 = new VecN(1, 2);


    @Test
    void component() {
        assertEquals(v1.component(0), 1);
        assertEquals(v2.component(0), 1);
        assertEquals(v1.component(1), 2);
        assertEquals(v2.component(1), 2);
    }

    @Test
    void bitDepth() {
        assertEquals(v1.bitDepth(), 2);
        assertEquals(v2.bitDepth(), 2);
    }
}