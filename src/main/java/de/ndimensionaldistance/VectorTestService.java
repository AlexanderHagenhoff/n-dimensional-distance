package de.ndimensionaldistance;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.String.format;

public class VectorTestService {

    private static final String SUMMARY_MESSAGE = "dimensions: % 6d, avg distance: %s, averageDistance / sqrt(avg distance): %s";

    private static final int VECTOR_COUNT_PER_TEST = 200;

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#0.000");

    private VectorFactory vectorFactory;

    public VectorTestService(VectorFactory vectorFactory) {
        this.vectorFactory = vectorFactory;
    }

    public void testVectors(final int limit) {
        IntStream.iterate(2, i -> i * 2).limit(limit)
                .forEach(this::testVector);
    }

    private void testVector(int dimensionCount) {
        final List<Vector> vectors = vectorFactory.createVectors(VECTOR_COUNT_PER_TEST, dimensionCount);

        final float averageDistance = calculateAverageDistance(vectors);

        final String message = format(
                SUMMARY_MESSAGE,
                dimensionCount,
                DECIMAL_FORMAT.format(averageDistance),
                DECIMAL_FORMAT.format((averageDistance / Math.sqrt(dimensionCount))));

        System.out.println(message);
    }

    private float calculateAverageDistance(List<Vector> vectors) {
        float sumDistance = 0.0f;
        int count = 0;
        for (int position = 0; position < vectors.size() - 1; position++) {
            final Vector vector1 = vectors.get(position);
            for (int i = position + 1; i < vectors.size(); i++) {
                Vector vector2 = vectors.get(i);

                count++;
                sumDistance += vector1.getDistance(vector2);
            }
        }

        return sumDistance / count;
    }
}
