package edu.hw7.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PiTimeComparator {
    public record PointResult(double pi, Long oneThreadTime, Long multiThreadTime, int pointCount) { }
    public String compareTime(List<Integer> points) {
        var counter = new PiCounter();
        var results = new ArrayList<PointResult>();
        for (var point : points) {
            var nowTimeOneThread = System.currentTimeMillis();
            var piResult = counter.countPi(point);
            var oneThreadTime = System.currentTimeMillis() - nowTimeOneThread;

            var nowTimeMultiThread = System.currentTimeMillis();
            counter.countPiParallel(point);
            var multiThreadTime = System.currentTimeMillis() - nowTimeMultiThread;

            results.add(new PointResult(piResult, oneThreadTime, multiThreadTime, point));
        }
        return getResults(results);
    }

    private static String getResults(Collection<PointResult> pointResults) {
        var sb = new StringBuilder();
        for (var pointResult : pointResults) {
            sb.append(String.format("Для %d точек ускорение равно %f%%, а погрешность %f%%\n",
                pointResult.pointCount,
                (double)pointResult.oneThreadTime / (double)pointResult.multiThreadTime,
                Math.abs(pointResult.pi - Math.PI) * 100));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new PiTimeComparator().compareTime(Arrays.asList(10000, 100000, 1000000, 10000000)));
    }
}
