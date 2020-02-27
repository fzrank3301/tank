package tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	private int x, y;
	private Dir dir;
	private static final int SPEED = 5;
	private boolean moving = false;

	public Tank(int x, int y, Dir dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
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
		// TODO Auto-generated method stub

		g.setColor(Color.PINK);
		g.fillRect(x, y, 50, 50);

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

}
