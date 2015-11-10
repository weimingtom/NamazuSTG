package basic;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Main {

	static JFrame window;
	static BufferStrategy buffer;
	static KeyEvent e;
	static boolean[] keyinfo = new boolean[4];

	public static void main(String[] args) {
		window = new JFrame("title");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(800, 600);
		window.setVisible(true);
		window.addKeyListener(new Key());
		window.createBufferStrategy(2);
		buffer = window.getBufferStrategy();
		Timer t = new Timer();
		t.schedule(new Task(), 0, 20);
	}

	private static class Key extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			Main.e = e;
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				keyinfo[0] = true;
				break;
			case KeyEvent.VK_DOWN:
				keyinfo[1] = true;
				break;
			case KeyEvent.VK_LEFT:
				keyinfo[2] = true;
				break;
			case KeyEvent.VK_RIGHT:
				keyinfo[3] = true;
				break;
			}

			super.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				keyinfo[0] = false;
				break;
			case KeyEvent.VK_DOWN:
				keyinfo[1] = false;
				break;
			case KeyEvent.VK_LEFT:
				keyinfo[2] = false;
				break;
			case KeyEvent.VK_RIGHT:
				keyinfo[3] = false;
				break;
			}

			super.keyReleased(e);
		}
	}

	static class Task extends TimerTask {

		MyShip myship;
		Enemy01 enemy;
		BulletParent01 bulletP;
		int bull = 300;
		static Bullet01[] bullet = new Bullet01[300];

		public Task() {
			myship = new MyShip();
			enemy = new Enemy01();
			bulletP = new BulletParent01();	
		}

		@Override
		public void run() {
			if (buffer.contentsLost() == false) {
				Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
				move(g);
				g.dispose();
				buffer.show();

			} else {
				buffer.getDrawGraphics().dispose();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}

		public void move(Graphics2D g) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, window.getWidth(), window.getHeight());
			myship.draw(g);
			enemy.draw(g);
			for(int i=0;i<bull;i++){
				if(bullet[i].exist == true){
					bullet[i].draw(g);
				}
			}
			if (keyinfo[0] == true) {
				myship.my -= myship.speed;
			}
			if (keyinfo[1] == true) {
				myship.my += myship.speed;
			}
			if (keyinfo[2] == true) {
				myship.mx -= myship.speed;
			}
			if (keyinfo[3] == true) {
				myship.mx += myship.speed;
			}
			if ((keyinfo[0] == true || keyinfo[1] == true)
					&& (keyinfo[2] == true || keyinfo[3] == true)) {
				myship.mx /= Math.sqrt(2);
				myship.my /= Math.sqrt(2);
			}
			myship.step();
			enemy.step();
			bulletP.step();
			for(int i=0;i<bull;i++){
				if(bullet[i].exist == true){
					bullet[i].step();
				}
				
			}
		
			bulletP.delete();
		}
	}
}
