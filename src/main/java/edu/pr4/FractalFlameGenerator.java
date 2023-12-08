package edu.pr4;

import edu.pr4.image_processor.ImageProcessor;
import edu.pr4.model.FractalImage;
import edu.pr4.model.ImageFormat;
import edu.pr4.model.Rect;
import edu.pr4.renderer.Renderer;
import edu.pr4.transformation.Transformation;
import edu.pr4.util.ImageUtils;
import java.nio.file.Path;
import java.util.List;

public final class FractalFlameGenerator {

    private final FractalImage fractalImage;
    private final Renderer renderer;
    private final Rect world;
    private final List<Transformation> transformations;
    private final ImageProcessor processor;

    public FractalFlameGenerator(
        int width,
        int height,
        Renderer renderer,
        Rect world,
        List<Transformation> transformations,
        ImageProcessor processor
    ) {
        this.fractalImage = FractalImage.create(width, height);
        this.renderer = renderer;
        this.world = world;
        this.transformations = transformations;
        this.processor = processor;
    }

    public void generate(int samples, int iterPerSample, int symmetry, Path path, ImageFormat format) {
        renderer.render(fractalImage, world, transformations, samples, iterPerSample, symmetry);
        processor.process(fractalImage);
        ImageUtils.save(fractalImage, path, format);
    }
//    //usage
//    public static void main(String[] args) {
//        FractalFlameGenerator generator = new FractalFlameGenerator(
//            1920,
//            1080,
//            new ParallelRenderer(),
//            new Rect(-8, -6, 16, 12),
//            List.of(
//                new PowerTransformation(),
//                new SinusTransformation(),
//                new SphereTransformation(),
//                new SwirlTransformation(),
//                new TangentTransformation()
//            ),
//            new GammaCorrectionImageProcessor()
//        );
//        generator.generate(1000, 1000, 2, Path.of("img.png"), ImageFormat.PNG);
//    }
}
