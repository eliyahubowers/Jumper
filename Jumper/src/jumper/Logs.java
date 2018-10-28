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
		
	}
	
	void draw(Graphics g) {
		Color c = new Color(644405);
		g.setColor(c);
	}
	
}
