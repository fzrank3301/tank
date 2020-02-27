package tank;

import java.awt.Color;
import java.awt.Graphics;

import com.sun.prism.paint.Paint;

public class Bullet {
	private static final int SPEED = 15;
	private static final int WIDTH = 20, HEIGHT = 20;
	private int x, y;
	private Dir dir;

	public Bullet(int x, int y, Dir dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public void paint(Graphics g) {
		//先取出颜色，事后还回去
		Color color = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, WIDTH, HEIGHT);
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
	}
	
}
