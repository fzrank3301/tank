package tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	private int x, y;
	private Dir dir;
	private static final int SPEED = 5;
	private boolean moving = false;

	private TankFrame tf;
	
	public static final int WIDTH = ResourceMgr.tankD.getWidth();
	public static final int HEIGHT = ResourceMgr.tankD.getHeight();
	
	private boolean living = true;
	
	public Tank(int x, int y, Dir dir,TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public static int getSpeed() {
		return SPEED;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	// 画出自己
	public void paint(Graphics g) {
		if (!living) {
			tf.tanks.remove(this);
		}
		
		switch (dir) {
		case LEFT:
			g.drawImage(ResourceMgr.tankL, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.tankR, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.tankU, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.tankD, x, y, null);
			break;
		default:
			break;
		}
		
		move();

	}

	// 移动方法
	private void move() {
		// 控制速度
		if (!moving) {
			return;
		} else {
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

	}

	public void fire() {
		//子弹位置调优
		int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2 ;
		int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
		
		tf.bullets.add(new Bullet(bX, bY, this.dir,this.tf));
		
	}

	//坦克死亡
	public void die() {
		// TODO Auto-generated method stub
		this.living = false;
	}

	

}
