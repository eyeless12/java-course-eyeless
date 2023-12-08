package edu.pr4;

import edu.pr4.image_processor.GammaCorrectionImageProcessor;
import edu.pr4.model.ImageFormat;
import edu.pr4.model.Rect;
import edu.pr4.renderer.ParallelRenderer;
import edu.pr4.transformation.PowerTransformation;
import edu.pr4.transformation.SinusTransformation;
import edu.pr4.transformation.SphereTransformation;
import edu.pr4.transformation.SwirlTransformation;
import edu.pr4.transformation.TangentTransformation;
import java.nio.file.Path;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class FractalFlameGeneratorTest {

    @Test
    @DisplayName("#generate test")
    public void generate_shouldGenerateFractalFlameImage(@TempDir Path path) {
        FractalFlameGenerator generator = new FractalFlameGenerator(
            1920,
            1080,
            new ParallelRenderer(),
            new Rect(-4, -3, 8, 6),
            List.of(
                new PowerTransformation(),
                new SinusTransformation(),
                new SphereTransformation(),
                new SwirlTransformation(),
                new TangentTransformation()
            ),
            new GammaCorrectionImageProcessor()
        );
        generator.generate(1000, 1000, 2, path.resolve("img.png"), ImageFormat.PNG);
        Assertions.assertThat(path.resolve("img.png")).exists();
    }
}
