package org.example;

sealed public interface Vector permits AbstractVector {
    double component(int n);

    double length();

    Vector plus(Vector other);

    Vector sub(Vector other);

    Vector mulOnDigit(double n);

    double dotProduct(Vector other);

    Vector normalize();

    double angleBetweenVector(Vector other);

    boolean isCollinearWith(Vector other);

    boolean isOrthogonalWith(Vector other);

    int bitDepth();

    static Vector of(double... coords) {
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
