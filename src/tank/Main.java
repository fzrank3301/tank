package tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.sun.media.jfxmedia.events.NewFrameEvent;

public class Main {
	public static void main(String[] args) throws Exception {
		TankFrame tf = new TankFrame();
		
		for (int i = 0; i < 5; i++) {
			tf.tanks.add(new Tank(50 + i*100 , 300, Dir.DOWN, tf));
		}
		
		while (true) {
			Thread.sleep(50);
			tf.repaint();
		}
		
	}
}
