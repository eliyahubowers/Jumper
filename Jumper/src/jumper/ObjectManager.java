package jumper;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	
	Frog f;
	
	ArrayList<Logs> logs;
	
	long logSpawnTime = 10; 
	long logTimer = 0;
	
	int score;
	
	ObjectManager(Frog f){
		
		this.f = f;
		logs = new ArrayList<Logs>();		
		score = 0;
		
	}
	
	void draw(Graphics g) {
		for(Logs l : logs) {
			l.draw(g);
		}
		f.draw(g);
	}
	
	void update() {
		f.update();
		for(Logs l : logs) {
			l.update();
		}
	}
	
	void addLogs(Logs l) {
		logs.add(l);
	}
	
	void purgeObjects(){
		for(int i = 0; i < logs.size(); i ++) {
			if(logs.get(i).isAlive == false) {
				logs.remove(i);
			}
		}
	}
	
	void checkCollision() {
		for(Logs l : logs){
	        if(f.collisionBox.intersects(l.collisionBox)){
	                f.againstCurrent = l.getSpeed();
	        }
	}
	}
	
	public void manageLogs(){
        if(System.currentTimeMillis() - logTimer >= logSpawnTime) {
                addLogs(new Logs(500, (new Random().nextInt(25)+3)*25, (new Random().nextInt(2)+3)*25, 25, 1));
                logSpawnTime = new Random().nextInt(200)+100; 
                logTimer = System.currentTimeMillis();
        }
   }
	
}
