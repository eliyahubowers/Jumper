package jumper;

import java.awt.Color;
import java.awt.Graphics;

public class Frog extends GameObject{
	
	int speed;
	int xmomentum;
	int ymomentum;
	int current;
	int againstCurrent;
	
	int lives;
	
	Color c;
	
	Frog(int x, int y, int width, int height, int speed, int xmomentum, int ymomentum) {
		super(x, y, width, height);
		this.speed = speed;
		this.xmomentum = xmomentum;
		this.ymomentum = ymomentum;
		this.current = 5;
		this.againstCurrent = 0;
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
		    g.fillRect((i*30)+10, 740, width, height);		
		    c = new Color(41,173,56);
		    g.setColor(c);
		    g.fillRect((i*30)+10, 760, width, height-20);
	    }
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
			this.lives -=1;
			if(this.lives >= 0) {
				this.x = 250;
			    this.y = 750;
			}else{
			    this.isAlive = false;
			}
		}
		
	}
	
	void setymomentum(int a) {
		this.ymomentum = a;
	}
	void setxmomentum(int a) {
		this.xmomentum = a;
	}
}
