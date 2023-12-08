package edu.pr4.util;

import edu.pr4.model.FractalImage;
import edu.pr4.model.ImageFormat;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

public class ImageUtilsTest {

    @Test
    @DisplayName("#save test")
    public void save_shouldSaveImageToDisc(@TempDir Path path) {
        Path savedImg = path.resolve("img.png");
        ImageUtils.save(FractalImage.create(400, 400), path.resolve("img.png"), ImageFormat.PNG);
        Assertions.assertThat(path.resolve("img.png")).exists();
    }
}
