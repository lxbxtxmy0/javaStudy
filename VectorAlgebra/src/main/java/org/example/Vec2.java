package org.example;

final public class Vec2 extends AbstractVector {
    final private double x, y;

    public Vec2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double component(int n) {
        switch(n) {
            case 0: return x;
            case 1: return y;
            default: throw new IllegalArgumentException("Такого компонента нет");
        }
    }

    public int bitDepth() {
        return 2;
    }

}
