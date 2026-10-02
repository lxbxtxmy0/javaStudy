package org.example;

final public class Vec3 extends AbstractVector {
    final private double x, y, z;

    public Vec3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double component(int n) {
        switch(n) {
            case 0: return x;
            case 1: return y;
            case 2: return z;
            default: throw new IllegalArgumentException("Такого компонента нет");
        }
    }

    public int bitDepth() {
        return 3;
    }

    public Vec3 vectorProduct(Vec3 other) {
        return new Vec3(component(1) * other.component(2) - component(2) * other.component(1),
                component(2) * other.component(0) - component(0) * other.component(2),
                component(0) * other.component(1) - component(1) * other.component(0));
    }
}
