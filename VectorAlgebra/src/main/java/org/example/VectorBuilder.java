package org.example;

public class VectorBuilder {
    public static AbstractVector of(double... coords) {
        if (coords.length <= 1) throw new IllegalArgumentException();
        if (coords.length == 2) {
            return new Vec2(coords[0], coords[1]);
        } else if (coords.length == 3) {
            return new Vec3(coords[0], coords[1], coords[2]);
        } else {
            return new VecN(coords);
        }
    }
}
