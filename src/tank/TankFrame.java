package tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;



public class TankFrame extends Frame {

	static final int GAME_WIDTH = 800,GAME_HEIGHT=600;
	
	// 生成可操作的坦克对象
	Tank myTank = new Tank(200, 200, Dir.DOWN,this);
	// 子弹List
	List<Bullet> bullets = new ArrayList<>();
	// 坦克容器
	List<Tank> tanks = new ArrayList<>();

	
	// 窗口相关设置
	public TankFrame() {
		this.setTitle("Tank War");
		this.setResizable(false);
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
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

	
	//双缓冲解决闪烁问题
	java.awt.Image OffScreenImage = null;
	@Override
	public void update(Graphics g) {
		if (OffScreenImage==null) {
			OffScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = OffScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(OffScreenImage,0,0,null);
	}
	
	
	
	
	// 画图方法，把传入的参数g交给tank类进行处理
	@Override
	public void paint(Graphics g) {
		Color gColor = g.getColor();
		g.setColor(Color.white);
		g.drawString("子弹的数量"+bullets.size(), 50, 50);
		g.drawString("敌人的数量"+tanks.size(), 50, 70);
		g.setColor(gColor);
		
		//画出子弹
		myTank.paint(g);
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).paint(g);
		}
		
		//画出坦克
		for (int i = 0; i < tanks.size(); i++) {
			tanks.get(i).paint(g);
		}
		
		for (int i = 0; i < bullets.size(); i++) {
			for (int j = 0; j < tanks.size(); j++) {
				bullets.get(i).collidewith(tanks.get(j));
			}
		}
		
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
			case KeyEvent.VK_Z:
				myTank.fire();
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
