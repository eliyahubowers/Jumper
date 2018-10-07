package jumper;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	final int START_STATE = 0;
	final int MENU_STATE = 1;
	final int GAME_STATE = 2;
	final int END_STATE = 3;
	
	Font instructFont;
	Font titleFont;
	Font deathFont;
	
	Timer t; 
	
	GameObject go;
	
	GamePanel(){
		titleFont = new Font("Arial",Font.PLAIN,53);
		instructFont = new Font("Arial",Font.PLAIN,25);
		deathFont = new Font("Arial",Font.PLAIN,53);
		t = new Timer(1000/100,this);
		go = new GameObject(100,100,100,100,100,0,0);
	}
	
	void updateStartState() {
		
	}
	
	void updateMenuState() {
		
	}
	
	void updateGameState() {
		
	}
	
	void updateEndState() {
		
	}
	
	void StartGame() {
		t.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		go.update();
	}
	@Override

	public void paintComponent(Graphics g){
        go.draw(g);
    }

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("Typed");	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Pressed");	
		if(e.getKeyCode() == KeyEvent.VK_DOWN||e.getKeyCode() == KeyEvent.VK_S) {
			go.setymomentum(1);
		}else if(e.getKeyCode() == KeyEvent.VK_UP||e.getKeyCode() == KeyEvent.VK_W) {
			go.setymomentum(-1);
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN||e.getKeyCode() == KeyEvent.VK_S) {
			go.setymomentum(1);
		}else if(e.getKeyCode() == KeyEvent.VK_UP||e.getKeyCode() == KeyEvent.VK_W) {
			go.setymomentum(-1);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Released");	
	}
	
}
