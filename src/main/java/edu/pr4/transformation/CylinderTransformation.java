package edu.pr4.transformation;

import edu.pr4.model.Point;

public class CylinderTransformation implements Transformation {

    @Override
    public Point apply(Point point) {
        return new Point(Math.sin(point.y()), point.y());
    }
}
