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

	// 生成可操作的坦克对象
	Tank myTank = new Tank(200, 200, Dir.DOWN);
	Bullet b = new Bullet(300, 300, Dir.RIGHT);


	// 窗口相关设置
	public TankFrame() {
		this.setTitle("Tank War");
		this.setResizable(false);
		this.setSize(800, 600);
		this.setVisible(true);

		// 添加按键监听，传入一个内部类
		this.addKeyListener(new MyKeyListener());

		// 添加窗口监听，传入一个匿名内部类
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}

	// 画图方法，把传入的参数g交给tank类进行处理
	@Override
	public void paint(Graphics g) {
		myTank.paint(g);
		b.paint(g);
	}

	// 内部类
	class MyKeyListener extends KeyAdapter {
		// 初始设置，四个按键都未被按下
		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;

		// 按键被按下
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

		// 按键跳起来
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

		// 通过bool设置坦克方向
		private void setMainTankDir() {

			if (!bD && !bU && !bL && !bR) {
				// 如果四个键都没按，不动
				myTank.setMoving(false);
			} else {
				// 按了，设置坦克方向
				myTank.setMoving(true);

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

}
