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
import com.sun.org.apache.xerces.internal.impl.dv.dtd.IDREFDatatypeValidator;

import sun.net.www.content.audio.x_aiff;

public class TankFrame extends Frame {

	// 设置坦克的初始位置
	int x = 200;
	int y = 200;
	final int SPEED = 10;

	Dir dir ;

	public TankFrame() {
		this.setTitle("Tank War");
		this.setResizable(false);
		this.setSize(800, 600);
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

		//控制速度
		switch (dir) {
		case LEFT:
			x -= SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		case RIGHT:
			x += SPEED;
		default:
			break;
		}
	}
	

	class MyKeyListener extends KeyAdapter {

		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;

		//控制方向
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = true;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				break;
			case KeyEvent.VK_UP:
				bU = true;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				break;
			}

			setMainTankDir();

		}

		// 右 39 左 37

		@Override
		public void keyReleased(KeyEvent e) {

			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = false;
				break;
			case KeyEvent.VK_RIGHT:
				bR = false;
				break;
			case KeyEvent.VK_UP:
				bU = false;
				break;
			case KeyEvent.VK_DOWN:
				bD = false;
				break;
			}

			setMainTankDir();

		}

		private void setMainTankDir() {
			if (bL)
				dir = Dir.LEFT;
			if (bR)
				dir = Dir.RIGHT;
			if (bU)
				dir = Dir.UP;
			if (bD)
				dir = Dir.DOWN;
		}

	}

}
