package jumper;

import java.awt.Color;
import java.awt.Graphics;

public class Frog extends GameObject{
	
	int speed;
	int xmomentum;
	int ymomentum;
	
	Frog(int x, int y, int width, int height, int speed, int xmomentum, int ymomentum) {
		super(x, y, width, height);
		this.speed = speed;
		this.xmomentum = xmomentum;
		this.ymomentum = ymomentum;
	}
	
	void draw(Graphics g){
	        g.setColor(Color.BLUE);
	        g.fillRect(x, y, width, height);		
	}
	
	void update() {
		this.x+=(speed*xmomentum);
		this.y+=(speed*ymomentum);
		ymomentum = 0;
		xmomentum = 0;
	}
	
	void setymomentum(int a) {
		this.ymomentum = a;
	}
	void setxmomentum(int a) {
		this.xmomentum = a;
	}
}
