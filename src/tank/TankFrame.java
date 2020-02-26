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

		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;
		
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = true;
				x -= 10;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				x += 10;
				break;
			case KeyEvent.VK_UP:
				bU = true;
				y -= 10;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				y += 10;
				break;
			}
			
		}

		// 右 39 左 37 
		
		@Override
		public void keyReleased(KeyEvent e) {

			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = false;
				x -= 10;
				break;
			case KeyEvent.VK_RIGHT:
				bR = false;
				
				x += 10;
				break;
			case KeyEvent.VK_UP:
				bU = false;
				y -= 10;
				break;
			case KeyEvent.VK_DOWN:
				bD = false;
				y += 10;
				break;
			}
			
			
			
		}
		
		
		
	}
	
	
}
