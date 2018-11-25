package jumper;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Logs extends GameObject{
	
	int speed;
	Color c;
	
	Logs(int x, int y, int width, int height, int speed) {
		super(x, y, width, height);
		this.speed = speed;
	}
	
	void update() {
		super.update();
		this.x -= speed;
		if(this.x < 0-this.width) {
			isAlive = false;
		}
	}
	
	int getSpeed() {
		return this.speed;
	}
	
	void drawDark(Graphics g) {
		c = new Color(61,41,28);
		g.setColor(c);
		g.fillRect(x,y+25,width, height-20);
	}void drawMain(Graphics g){
		c = new Color(99,71,52);
		g.setColor(c);
		g.fillRect(x, y, width, height);
	}
}
