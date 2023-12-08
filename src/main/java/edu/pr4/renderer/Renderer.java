package edu.pr4.renderer;

import edu.pr4.model.FractalImage;
import edu.pr4.model.Rect;
import edu.pr4.transformation.Transformation;
import java.util.List;

public interface Renderer {

    FractalImage render(
        FractalImage canvas,
        Rect world,
        List<Transformation> transformations,
        int samples,
        int iterPerSample,
        int symmetry
    );
}
