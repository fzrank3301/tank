package tank;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

class imageTest {

	@Test
	void test() {
		try {
			BufferedImage image = ImageIO.read(new File(""));
			assertNotNull(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
