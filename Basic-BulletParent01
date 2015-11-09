package basic;


public class BulletParent01{
	private int count =0;
	public BulletParent01() {
		for(int i=0;i<5;i++){
			Main.Task.bullet[i] = new Bullet01();
		}
	}
	
	public void step() {
		count ++;
		if(count%30 == 0 && count<150){
				Main.Task.bullet[count/30].wake();
		}
	}

	public void delete(){
		for(int i=0; i<5;i++){
			if(Main.Task.bullet[i].exist == false && Main.Task.bullet[i].r != 0){
				Main.Task.bullet[i] = null;
			}
		}
	}

}
