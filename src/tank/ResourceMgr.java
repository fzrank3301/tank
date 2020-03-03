package tank;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;

import javax.imageio.ImageIO;

public class ResourceMgr {
	public static BufferedImage tankL,tankU,tankR,tankD;
	public static BufferedImage BulletL,BulletR,BulletU,BulletD;
	
	static {
		try {
			tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/tankL.gif"));
			tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/tankU.gif"));
			tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/tankD.gif"));
			tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/tankR.gif"));
			
			BulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bulletL.gif"));
			BulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bulletU.gif"));
			BulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bulletR.gif"));
			BulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bulletD.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
