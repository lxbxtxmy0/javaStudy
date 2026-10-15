package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;



class Vec3Test {

    Vector v1 = new Vec3(1, 2, 3);
    Vector v2 = new VecN(1, 2, 4);


    @Test
    void component() {
        assertEquals(v1.component(0), 1);
        assertEquals(v2.component(0), 1);
        assertEquals(v1.component(1), 2);
        assertEquals(v2.component(1), 2);
        assertEquals(v1.component(2), 3);
        assertEquals(v2.component(2), 4);
    }

    @Test
    void bitDepth() {
        assertEquals(v1.bitDepth(), 3);
        assertEquals(v2.bitDepth(), 3);
    }

    @Test
    void vectorProduct() {
        assertEquals(new Vec3(1, 2, -2).vectorProduct(new Vec3(4, -1, 5)), new Vec3(8, -13, -9));
    }
}