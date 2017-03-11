package de.ndimensionaldistance;

public class Vector extends java.util.Vector<Float> {

    public Vector(int dimensionCount) {
        super(dimensionCount);
    }

    public float getDistance(Vector other) {

        double sum = 0.0d;

        for (int i = 0; i < this.size(); i++) {
            sum += Math.pow(this.get(i) - other.get(i), 2.0d);
        }

        return (float) Math.sqrt(sum);
    }
}
