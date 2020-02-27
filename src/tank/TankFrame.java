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
//	int x = 200;
//	int y = 200;
//	final int SPEED = 10;
//
//	Dir dir ;
	
	//主战坦克
	Tank myTank = new Tank(200,200,Dir.DOWN);
	

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
		
		myTank.paint(g);
		
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
				myTank.setDir(Dir.LEFT); 
			if (bR)
				myTank.setDir(Dir.RIGHT); 
			if (bU)
				myTank.setDir(Dir.UP); 
			if (bD)
				myTank.setDir(Dir.DOWN); 
		}

	}

}
