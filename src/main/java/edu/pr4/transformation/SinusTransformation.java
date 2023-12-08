package edu.pr4.transformation;

import edu.pr4.model.Point;

public class SinusTransformation implements Transformation {

    @Override
    public Point apply(Point point) {
        return new Point(Math.sin(point.x()), Math.sin(point.y()));
    }
}
