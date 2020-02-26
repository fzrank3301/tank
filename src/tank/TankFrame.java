package tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.omg.CORBA.ORBPackage.InconsistentTypeCode;

import com.sun.jmx.snmp.tasks.ThreadService;

import sun.net.www.content.audio.x_aiff;

public class TankFrame extends Frame {

	
	int x = 200;
	int y = 200;
	
	public TankFrame() {
		this.setTitle("Tank War");
		this.setResizable(false);
		this.setSize(800,600);
		this.setVisible(true);
		
		this.addKeyListener(new MyKeyListener());
		
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	
	
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.PINK);
		g.fillRect(x, y, 50, 50);
	}
	
	class MyKeyListener extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				x -= 10;
				break;
			case KeyEvent.VK_RIGHT:
				x += 10;
				break;
			case KeyEvent.VK_UP:
				y -= 10;
				break;
			case KeyEvent.VK_DOWN:
				y += 10;
				break;
			}
			
		}

		// 右 39 左 37 
		
		@Override
		public void keyReleased(KeyEvent e) {

			
		}
		
		
		
	}
	
	
}
