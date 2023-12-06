package edu.pr4.transformation;

import edu.pr4.model.Point;

public class SphereTransformation implements Transformation {

    @Override
    public Point apply(Point point) {
        double oldX = point.x();
        double oldY = point.y();
        return new Point(oldX / (oldX * oldX + oldY * oldY), oldY / (oldX * oldX + oldY * oldY));
    }
}
