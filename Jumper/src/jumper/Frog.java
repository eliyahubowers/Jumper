package jumper;

import java.awt.Color;
import java.awt.Graphics;

public class Frog extends GameObject{
	
	int speed;
	double xmomentum;
	int ymomentum;
	final int oldCurrentOne = 5;
	int nowCurrent;
	
	int score;
	
	int lives;

	Color c;
	
	Frog(int x, int y, int width, int height, int speed, int xmomentum, int ymomentum) {
		super(x, y, width, height);
		this.speed = speed;
		this.xmomentum = xmomentum;
		this.ymomentum = ymomentum;
		this.nowCurrent = oldCurrentOne;
		this.lives = 3;
	}
	
	void draw(Graphics g){
	    c = new Color(46,219,66);
	    g.setColor(c);
	    g.fillRect(x, y-5, width, height);		
	    c = new Color(41,173,56);
	    g.setColor(c);
	    g.fillRect(x, y+20, width, height-20);
	    
	    for(int i = 0; i < lives; i ++) {
		    c = new Color(46,219,66);
		    g.setColor(c);
		    g.fillRect((i*30)+10, 735, width, height);		
		    c = new Color(41,173,56);
		    g.setColor(c);
		    g.fillRect((i*30)+10, 760, width, height-20);
	    }
	}
	
	void update() {
		super.update();
		if(this.y < 700 && this.y >= 75) {
			this.x+=nowCurrent;
		}
		this.x+=(speed*xmomentum);
		this.y+=(speed*ymomentum);
		
		ymomentum = 0;
		xmomentum = 0;
		
		if(this.y < 75) {
			this.score ++;
			this.y = 750;
			this.x = 250;
		}
		if(this.y >= 700 || this.y < 75) {
			if(this.x < 0 ) {
				this.x = 0;
			}else if(this.x+this.width > 500) {
				this.x = 500-this.width;
			}
		}if(this.y+this.height-5 > 800) {
			this.y = 800-height;
		}else if(this.y < 0) {
			this.y = 0;
		}
		if(this.x < 0 || this.x+this.width > 500) {
			this.dead();
		}
		
	}
	
	void setymomentum(int a) {
		this.ymomentum = a;
	}
	void setxmomentum(int a) {
		this.xmomentum = a;
	}
	void dead() {
		this.lives -=1;
		if(this.lives >= 0) {
			this.x = 250;
		    this.y = 750;
		}else{
		    this.isAlive = false;
		}
	}
}
