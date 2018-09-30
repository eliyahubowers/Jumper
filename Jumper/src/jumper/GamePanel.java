package jumper;

import java.awt.Font;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class GamePanel {
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	
	Font instructFont;
	Font titleFont;
	Font deathFont;
	
	GamePanel(){
		titleFont = new Font("Arial",Font.PLAIN,53);
		instructFont = new Font("Arial",Font.PLAIN,25);
		deathFont = new Font("Arial",Font.PLAIN,53);
	}
	
	void updateGameState() {
		
	}
	
	void updateMenuState() {
		
	}
	
}
