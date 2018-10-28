package jumper;

import java.awt.Graphics;

public class GameObject {
	
	int x;
	int y;
	int width;
	int height;	
	
	boolean isAlive;
	
	GameObject(int x, int y, int width, int height){
		this.x = x; 
		this.y =y; 
		this.width = width; 
		this.height = height;
		this.isAlive = true;
	}
	
	void update() {

	}
	
	void draw(Graphics g){
		g.fillRect(this.x, this.y, 100, 100);
	}
	
}
