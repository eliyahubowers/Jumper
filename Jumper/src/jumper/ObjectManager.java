package jumper;

import java.awt.Graphics;

public class ObjectManager {
	
	Frog f;
	
	ObjectManager(Frog f){
		
		this.f = f;
		
	}
	
	void draw(Graphics g) {
		f.draw(g);
	}
	
	void update() {
		f.update();
	}
	
}
