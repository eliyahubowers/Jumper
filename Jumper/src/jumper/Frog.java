package jumper;

import java.awt.Color;
import java.awt.Graphics;

public class Frog extends GameObject{
	
	int speed;
	int xmomentum;
	int ymomentum;
	int current;
	int againstCurrent;
	
	Frog(int x, int y, int width, int height, int speed, int xmomentum, int ymomentum) {
		super(x, y, width, height);
		this.speed = speed;
		this.xmomentum = xmomentum;
		this.ymomentum = ymomentum;
		this.current = 5;
		this.againstCurrent = 0;
	}
	
	void draw(Graphics g){
	        g.setColor(Color.GREEN);
	        g.fillRect(x, y, width, height);		
	}
	
	void update() {
		super.update();
		this.x+=(speed*xmomentum);
		this.y+=(speed*ymomentum);
		if(this.y < 700 && this.y >= 75) {
			if(againstCurrent == 0) {
				this.x+=current;
			}else{
				this.x-=againstCurrent;
			}
		}
		againstCurrent = 0;
		ymomentum = 0;
		xmomentum = 0;
		
		if(this.x < 0 || this.x+this.width > 500) {
			this.isAlive = false;
		}
		
	}
	
	void setymomentum(int a) {
		this.ymomentum = a;
	}
	void setxmomentum(int a) {
		this.xmomentum = a;
	}
}
