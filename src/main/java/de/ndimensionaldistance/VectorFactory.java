package de.ndimensionaldistance;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class VectorFactory {

    public List<Vector> createVectors(final int count, final int dimensionCount) {
        return IntStream.rangeClosed(0, count)
                .mapToObj(i -> createVector(dimensionCount))
                .collect(toList());
    }

    private Vector createVector(final int dimensionCount) {
        Vector vector = new Vector(dimensionCount);

        for (int i = 0; i < vector.capacity(); i++) {
            vector.add((float) Math.random());
        }

        return vector;
    }
}
