package tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.sun.media.jfxmedia.events.NewFrameEvent;

public class TMain {
	public static void main(String[] args) throws Exception {
		TankFrame tankFrame = new TankFrame();
		
		while (true) {
			Thread.sleep(50);
			tankFrame.repaint();
		}
		
	}
}
