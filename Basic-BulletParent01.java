package basic;

import basic.Bullet01;
import basic.Main;

public class BulletParent01{
	private int count =0;
	private int bul = 300;
	public BulletParent01() {
		for(int i=0;i<bul;i++){
			Main.Task.bullet[i] = new Bullet01();
		}
	}
	public int getBul() {
		return bul;
	}

	public void step() {
		count ++;
		if(count%5 == 0 && count<bul-5){
			for(int i =0;i<5;i++){
				Main.Task.bullet[count+i].wake();
				Main.Task.bullet[count+i].angle += 71*i;
				
			}	
			System.out.println(count);
		}
		if(count == bul-15){
			count = 0;
		}
	}
	public void delete(){
		for(int i=0; i<bul;i++){
			if(Main.Task.bullet[i].exist == false && Main.Task.bullet[i].r != 0){
				Main.Task.bullet[i] = null;
			}
		}
	}
}
