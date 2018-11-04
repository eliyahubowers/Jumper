package jumper;

import java.awt.Color;
import java.awt.Graphics;

public class Logs extends GameObject{
	
	int speed;
	
	Logs(int x, int y, int width, int height, int speed) {
		super(x, y, width, height);
		this.speed = speed;
	}
	
	void update() {
		this.x -= speed;
		if(this.x < 0-this.width) {
			isAlive = false;
		}
	}
	
	void draw(Graphics g) {
		Color c = new Color(99,71,52);
		g.setColor(c);
		g.fillRect(x, y, width, height);
	}
	
}
