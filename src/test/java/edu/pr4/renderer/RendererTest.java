package edu.pr4.renderer;

import edu.pr4.model.FractalImage;
import edu.pr4.model.Rect;
import edu.pr4.transformation.CylinderTransformation;
import edu.pr4.transformation.DiscTransformation;
import edu.pr4.transformation.ExTransformation;
import edu.pr4.transformation.FisheyeTransformation;
import edu.pr4.transformation.HandkerchiefTransformation;
import edu.pr4.transformation.HeartTransformation;
import edu.pr4.transformation.JuliaTransformation;
import edu.pr4.transformation.PolarTransformation;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RendererTest {

    @Test
    @DisplayName("DefaultRenderer#render test")
    public void defaultRender_shouldNotThrowAnyException_whenEverythingIsCorrect() {
        Assertions.assertDoesNotThrow(() ->
            new DefaultRenderer().render(
                FractalImage.create(400, 400),
                new Rect(-4, -3, 8, 6),
                List.of(
                    new CylinderTransformation(),
                    new DiscTransformation(),
                    new ExTransformation(),
                    new FisheyeTransformation()
                ),
                1000, 1000, 2
            )
        );
    }
    @Test
    @DisplayName("ParralelRenderer#render test")
    public void parallelRender_shouldNotThrowAnyException_whenEverythingIsCorrect() {
        Assertions.assertDoesNotThrow(() ->
            new ParallelRenderer().render(
                FractalImage.create(400, 400),
                new Rect(-4, -3, 8, 6),
                List.of(
                    new HandkerchiefTransformation(),
                    new HeartTransformation(),
                    new JuliaTransformation(),
                    new PolarTransformation()
                ),
                1000, 1000, 2
            )
        );
    }
}
