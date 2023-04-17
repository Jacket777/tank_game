package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

class ImageTest {

	@Test
	void test() {
		try {
			
			//BufferedImage image = ImageIO.read(new File("C:\\Users\\n'n\\Desktop\\test2\\tank\\tank\\src\\images\\BadTank1.png"));
			BufferedImage image = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
			
			assertNotNull(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fail("Not yet implemented");
		//assertNotNull("abc");
	}

}
