package de.ndimensionaldistance;

public class Main {

    private final VectorFactory vectorFactory = new VectorFactory();

    public Main() {
        VectorTestService vectorTestService = new VectorTestService(vectorFactory);

        vectorTestService.testVectors(15);
    }

    public static void main(String[] args) {
        new Main();
    }
}
