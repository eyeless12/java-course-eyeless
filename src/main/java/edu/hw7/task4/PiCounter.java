package edu.hw7.task4;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PiCounter {
    private static final Double CIRCLE_X = 0.5;
    private static final Double CIRCLE_Y = 0.5;
    private static final Double CIRCLE_R = 1.0;
    private static final int FOUR = 4;

    public double countPi(int randomPointsCount) {
        var random = new Random();
        var circleCount = 0;
        for (long i = 0; i < randomPointsCount; i++) {
            var x = random.nextDouble() * 2 - 1;
            var y = random.nextDouble() * 2 - 1;
            if (isPointInCircle(x, y)) {
                circleCount++;
            }
        }
        return FOUR * (circleCount / (double) randomPointsCount);
    }

    public double countPiParallel(int randomPointsCount) {
        return FOUR * (getPointsInsideCircle(randomPointsCount) / (double) randomPointsCount);
    }

    private double getPointsInsideCircle(int numPoints) {
        return ThreadLocalRandom.current().ints(numPoints)
            .parallel()
            .mapToObj(i -> {
                double x = ThreadLocalRandom.current().nextDouble() * 2 - 1;
                double y = ThreadLocalRandom.current().nextDouble() * 2 - 1;
                return (x * x + y * y) <= CIRCLE_R ? 1 : 0;
            })
            .reduce(0, Integer::sum);
    }

    private boolean isPointInCircle(double x, double y) {
        return x * x + y * y <= CIRCLE_R;
    }
}
