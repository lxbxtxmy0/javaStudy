package org.example;

sealed abstract public class AbstractVector implements Vector permits Vec2, Vec3, VecN {
    final private double epsilon = 1e-9;

    public double length() {
        int bitDepth = bitDepth();

        double sum = 0;
        for (int i = 0; i < bitDepth; i++) {
            sum += component(i) * component(i);
        }

        return Math.sqrt(sum);
    }


    public Vector plus(Vector other) {
        int bitDepth = bitDepth();
        if (bitDepth != other.bitDepth()) {
            throw new IllegalArgumentException("Нельзя складывать векторы разных разрядностей");
        }


        if (bitDepth == 2) {
            return new Vec2(component(0) + other.component(0),
                            component(1) + other.component(1));
        } else if (bitDepth == 3) {
            return new Vec3(component(0) + other.component(0),
                            component(1) + other.component(1),
                            component(2) + other.component(2));
        } else {
            double[] coords = new double[bitDepth];
            for (int i = 0; i < bitDepth; i++) {
                coords[i] = component(i) + other.component(i);
            }

            return new VecN(coords);
        }
    }

    public Vector sub(Vector other) {
        int bitDepth = bitDepth();

        if (bitDepth != other.bitDepth()) {
            throw new IllegalArgumentException("Нельзя складывать векторы разных разрядностей");
        }


        if (bitDepth == 2) {
            return new Vec2(component(0) - other.component(0),
                    component(1) - other.component(1));
        } else if (bitDepth == 3) {
            return new Vec3(component(0) - other.component(0),
                    component(1) - other.component(1),
                    component(2) - other.component(2));
        } else {
            double[] coords = new double[bitDepth];
            for (int i = 0; i < bitDepth; i++) {
                coords[i] = component(i) - other.component(i);
            }

            return new VecN(coords);
        }
    }

    public Vector mulOnDigit(double n) {
        int bitDepth = bitDepth();
        if (bitDepth == 2) {
            return new Vec2(component(0) * n, component(1) * n);
        } else if (bitDepth == 3) {
            return new Vec3(component(0) * n, component(1) * n, component(2) * n);
        } else {
            double[] coords = new double[bitDepth];
            for (int i = 0; i < bitDepth; i++) {
                coords[i] = component(i) * n;
            }

            return new VecN(coords);
        }
    }

    public double dotProduct(Vector other) {
        int bitDepth = bitDepth();

        if (bitDepth != other.bitDepth()) {
            throw new IllegalArgumentException("Нельзя складывать векторы разных разрядностей");
        }

        double result = 0;
        for (int i = 0; i < bitDepth; i++) {
            result += component(i) * other.component(i);
        }

        return result;
    }

    public Vector normalize() {
        int bitDepth = bitDepth();
        double length = length();

        if (bitDepth == 2) {
            return new Vec2(component(0) / length, component(1) / length);
        } else if (bitDepth == 3) {
            return new Vec3(component(0) / length, component(1) / length, component(2) / length);
        } else {
            double[] coords = new double[bitDepth];
            for (int i = 0; i < bitDepth; i++) {
                coords[i] = component(i) / length;
            }

            return new VecN(coords);
        }
    }

    public double angleBetweenVector(Vector other) {
        double dot = dotProduct(other);
        double thisLength = length();
        double thatLength = other.length();

        double cosBetweenVectors = dot / thisLength / thatLength;

        return Math.toDegrees(Math.acos(cosBetweenVectors));
    }

    public boolean isCollinearWith(Vector other) {
        if (bitDepth() != other.bitDepth()) {
            throw new IllegalArgumentException("Нельзя складывать векторы разных разрядностей");
        }

        double angle = angleBetweenVector(other);

        return Math.abs(angle - 180) < epsilon || Math.abs(angle - 0) < epsilon || Math.abs(angle + 180) < epsilon;
    }

    public boolean isOrthogonalWith(Vector other) {
        if (bitDepth() != other.bitDepth()) {
            throw new IllegalArgumentException("Нельзя складывать векторы разных разрядностей");
        }

        double angle = angleBetweenVector(other);

        return Math.abs(angle - 90) < epsilon;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector that)) return false;
        if (bitDepth() != that.bitDepth()) return false;

        for (int i = 0; i < bitDepth(); i++) {
            if (Math.abs(component(i) - that.component(i)) >= epsilon) return false;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("(");

        for (int i = 0; i < bitDepth(); i++) {
            result.append(component(i) + ", ");
        }

        result.delete(result.length() - 1, result.length());
        result.delete(result.length() - 1, result.length());
        result.append(")");

        return result.toString();
    }
}
