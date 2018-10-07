package jumper;

import java.awt.Graphics;

public class GameObject {
	
	int x;
	int y;
	int width;
	int height;	
	int speed;
	
	int ymomentum;
	int xmomentum;
	
	GameObject(int x, int y, int width, int height, int speed, int xmomentum, int ymomentum){
		this.x = x; 
		this.y =y; 
		this.width = width; 
		this.height = height;
		this.speed = speed;
		this. xmomentum = xmomentum;
		this. ymomentum = ymomentum;
	}
	
	void update() {
		this.x+=(speed*xmomentum);
		this.y+=(speed*ymomentum);
		ymomentum = 0;
		xmomentum = 0;
	}
	
	void draw(Graphics g){
		g.fillRect(this.x, this.y, 100, 100);
	}
	
	void setymomentum(int a) {
		this.ymomentum = a;
	}
	void setxmomentum(int a) {
		this.xmomentum = a;
	}
	
}
