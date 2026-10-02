package org.example;

final public class VecN extends AbstractVector {
    private final double[] coords;

    public VecN(double... coords) {
        if (coords.length <= 1) throw new IllegalArgumentException("Минимальная разрядность вектора - 2");
        this.coords = coords;
    }

    public double component(int n) {
        return coords[n];
    }

    public int bitDepth() {
        return coords.length;
    }


}
