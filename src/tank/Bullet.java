package tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import org.junit.experimental.theories.Theories;

import com.sun.prism.paint.Paint;

public class Bullet {
	private static final int SPEED = 15;
	public static final int WIDTH = ResourceMgr.BulletD.getWidth();
	public static final int HEIGHT = ResourceMgr.BulletD.getHeight();
	private int x, y;
	private Dir dir;
	
	public boolean living = true;
	TankFrame tf = null;
	
	public Bullet(int x, int y, Dir dir,TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}

	public void paint(Graphics g) {
		
		if (!living) {
			tf.bullets.remove(this);
		}
		
		//先取出颜色，事后还回去
		Color color = g.getColor();
		
		switch (dir) {
		case LEFT:
			g.drawImage(ResourceMgr.BulletL, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.BulletR, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.BulletD, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.BulletU, x, y, null);
			break;
		default:
			break;
		}
		
		g.setColor(color);
		
		move();
	}

	private void move() {
		// 控制移动
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
		
		System.out.println("x:"+Integer.toString(x)+" y:"+Integer.toString(y)+"是否存活:"+living);
		if (this.x < 0 || this.y < 0 || this.x > TankFrame.GAME_WIDTH || this.y > TankFrame.GAME_HEIGHT) living = false;
			
		
		//  if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.HEIGHT) live = false;
		// FUCKKKKKKK THE TankFrame.HEIGHT !!!!!!!!!!
	}

	public void collidewith(Tank tank) {
		// TODO Auto-generated method stub
		Rectangle rectangle1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
		Rectangle rectangle2 = new Rectangle(tank.getX(), tank.getY(), tank.WIDTH, tank.HEIGHT);
		if (rectangle1.intersects(rectangle2)) {
			tank.die();
			this.die();
		}
	}

	//子弹死亡
	private void die() {
		// TODO Auto-generated method stub
		this.living = false;
	}


	
}
