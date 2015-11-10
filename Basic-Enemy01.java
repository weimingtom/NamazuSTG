package basic;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Enemy01 {
	public static double x;
	public static double y;
	public static double speed;
	public static double angle;
	public int r = 1;
	public Ellipse2D circle = new Ellipse2D.Double();

	public Enemy01() {
		x = Main.window.getWidth() / 2;
		y = Main.window.getHeight() *2/ 5;
		angle = 90;
		speed = 4;
	}

	public static double getX() {
		return x;
	}

	public static double getY() {
		return y;
	}

	public static double getAngle() {
		return angle;
	}
	public void step() {
		x += speed * Math.cos(Math.toRadians(angle));
		y += speed * Math.sin(Math.toRadians(angle));
		if(y>Main.window.getHeight()){
			y = 0;
		}
		circle.setFrame(x-r, y-r, r * 2, r * 2);
		angle += 3;
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.BLUE);
		int r = this.r + 10;
		g.fillOval((int)x-r, (int)y-r, r * 2, r * 2);
	}
}
