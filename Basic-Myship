package basic;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class MyShip {
	public double x, y, speed;
	public int mx,my;
	public int r = 5;
	public Ellipse2D circle = new Ellipse2D.Double();

	public MyShip() {
		x = Main.window.getWidth()/2;
		y = Main.window.getHeight() *4 / 5;
		speed = 3;
		mx = 0;
		my = 0;
	}

	public void step() {
		x += mx;
		y += my;
		circle.setFrame(x-r, y-r, r * 2, r * 2);
		mx = my = 0;
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.WHITE);
		int r = this.r +10;
		g.fillOval((int)x-r, (int)y-r, r * 2, r * 2);
		g.setColor(Color.RED);
		r -= 10;
		g.fillOval((int)x-r, (int)y-r, r * 2, r * 2);
	}
	

}
