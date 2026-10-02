package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class AbstractVectorTest {
    Vector v1;
    Vector v2;
    Vector v3;

    @BeforeEach
    void setUp() {
        v1 = Vector.of(2, 1);
        v2 = Vector.of(1, 2, 3);
        v3 = Vector.of(1, 2, 3, 4, 5);
    }


    @Test
    void of() {
        v1 = Vector.of(2, 1);
        assertTrue(v1 instanceof Vec2);
        v2 = Vector.of(2, 1, 3);
        assertTrue(v2 instanceof Vec3);
        v3 = Vector.of(2, 1, 4, 5);
        assertTrue(v3 instanceof VecN);
        assertThrows(IllegalArgumentException.class, () -> {
            Vector.of(0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Vector.of();
        });
    }


    @Test
    void length() {
        assertEquals(v1.length(), Math.sqrt(2 * 2 + 1));
        assertEquals(v2.length(), Math.sqrt(2 * 2 + 1 + 3 * 3));
        assertEquals(v3.length(), Math.sqrt(2 * 2 + 1 + 3 * 3 + 4 * 4 + 5 * 5));
    }

    @Test
    void plus() {
        assertThrows(IllegalArgumentException.class, () -> {
            v1.plus(v2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            v2.plus(v1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            v3.plus(v1);
        });

        assertEquals(v1.plus(v1), Vector.of(4, 2));
        assertEquals(v2.plus(v2), Vector.of(2, 4, 6));
        assertEquals(v3.plus(v3), Vector.of(2, 4, 6, 8, 10));
    }

    @Test
    void sub() {
        assertThrows(IllegalArgumentException.class, () -> {
            v1.sub(v2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            v2.sub(v1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            v3.sub(v1);
        });

        assertEquals(v1.sub(v1), Vector.of(0, 0));
        assertEquals(v2.sub(v2), Vector.of(0, 0, 0));
        assertEquals(v3.sub(v3), Vector.of(0, 0, 0, 0, 0));
    }

    @Test
    void mulOnDigit() {
        assertEquals(v1.mulOnDigit(2), Vector.of(4, 2));
        assertEquals(v2.mulOnDigit(2), Vector.of(2, 4, 6));
        assertEquals(v3.mulOnDigit(2), Vector.of(2, 4, 6, 8, 10));
    }

    @Test
    void dotProduct() {
        assertThrows(IllegalArgumentException.class, () -> {
            v1.dotProduct(v2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            v2.dotProduct(v1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            v3.dotProduct(v1);
        });

        assertEquals(v1.dotProduct(v1), v1.length() * v1.length(), 1e-9);
        assertEquals(v2.dotProduct(v2), v2.length() * v2.length(), 1e-9);
        assertEquals(v3.dotProduct(v3), v3.length() * v3.length(), 1e-9);
    }

    @Test
    void normalize() {
        assertEquals(v1.normalize().length(), 1, 1e-9);
        assertEquals(v2.normalize().length(), 1, 1e-9);
        assertEquals(v3.normalize().length(), 1, 1e-9);

    }

    @Test
    void angleBetweenVector() {
        assertThrows(IllegalArgumentException.class, () -> {
            v1.angleBetweenVector(v2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            v2.angleBetweenVector(v1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            v3.angleBetweenVector(v2);
        });

        assertEquals(Vector.of(1, 0).angleBetweenVector(Vector.of(0, 1)), 90, 1e-9);
        assertEquals(Vector.of(2, -1, 0).angleBetweenVector(Vector.of(1, 2, 3)), 90, 1e-9);
        assertEquals(Vector.of(1, 1, 1, 1).angleBetweenVector(Vector.of(1, 1, 1, 1)), 0, 1e-9);
    }

    @Test
    void isCollinearWith() {
        assertTrue(Vector.of(2, 4).isCollinearWith(Vector.of(4, 8)));
        assertTrue(Vector.of(1, 2, 3).isCollinearWith(Vector.of(2, 4, 6)));
        assertTrue(Vector.of(1, -1, 2, -2).isCollinearWith(Vector.of(-3, 3, -6, 6)));
    }

    @Test
    void isOrthogonalWith() {
        assertTrue(Vector.of(1, 2).isOrthogonalWith(Vector.of(-2, 1)));
        assertTrue(Vector.of(2, -1, 0).isOrthogonalWith(Vector.of(1, 2, 3)));
        assertTrue(Vector.of(1, 1, 1, 1).isOrthogonalWith(Vector.of(1, -1, 1, -1)));
    }

    @Test
    void testEquals() {
        v1 = Vector.of(1, 2);
        v2 = Vector.of(1, 2);
        v3 = new VecN(1, 2);

        assertTrue(v1.equals(v1));

        assertTrue(v1.equals(v2));
        assertTrue(v2.equals(v1));

        assertTrue(v1.equals(v2));
        assertTrue(v2.equals(v3));
        assertTrue(v1.equals(v3));

        assertFalse(v1.equals(new Object()));
        assertFalse(v1.equals(new VecN(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void testToString() {
        assertEquals(v1.toString(), "(2.0, 1.0)");
        assertEquals(v2.toString(), "(1.0, 2.0, 3.0)");
        assertEquals(v3.toString(), "(1.0, 2.0, 3.0, 4.0, 5.0)");
    }
}