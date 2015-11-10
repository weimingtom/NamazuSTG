package basic;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Bullet01 {
	double x = Enemy01.getX();
	double y = Enemy01.getY();
	int r = 0;
	double speed =0;
	double angle = Enemy01.getAngle();
	boolean exist = false;
	public Ellipse2D circle = new Ellipse2D.Double();
	public Bullet01(){
		
	}
	public void wake() {
		x = Enemy01.getX();
		y = Enemy01.getY();
		r = 2;
		speed = 3;
		angle = Enemy01.getAngle();
		exist = true;
	}
	public void step() {
		x += speed * Math.cos(Math.toRadians(angle));
		y += speed * Math.sin(Math.toRadians(angle));
		if(y>Main.window.getHeight()){
			exist = false;
			r = 0;
		}
		if(y<0){
			exist = false;
			r = 0;
		}
		if(x>Main.window.getWidth()){
			exist = false;
			r = 0;
		}
		if(x<0){
			exist = false;
			r = 0;
		}
		circle.setFrame(x-r, y-r, r * 2, r * 2);
	}
	public void draw(Graphics2D g) {
		g.setColor(Color.YELLOW);
		int r = this.r+3;
		g.fillOval((int)x-r, (int)y-r, r * 2, r * 2);
	}

}
