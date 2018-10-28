package jumper;

import java.awt.Color;
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
	final int INSTRUCTION_STATE = 4;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	
	int currentState = START_STATE;
	
	Font instructFont;
	Font titleFont;
	Font titleFontt;
	Font deathFont;
	
	Timer t; 
	
	GameObject go;
	Frog fu;
	ObjectManager om;
	
	GamePanel(){
		titleFont = new Font("Arial",Font.PLAIN,53);
		titleFontt = new Font("Arial",Font.PLAIN,25);
		instructFont = new Font("Arial",Font.PLAIN,40);
		deathFont = new Font("Arial",Font.PLAIN,53);
		t = new Timer(1000/100,this);
		go = new GameObject(100,100,100,100);
		fu = new Frog(250,700,25,25,25,0,0);
		om = new ObjectManager(fu);
	}
	
	void updateStartState() {
	}	
	void updateInstructionState() {
	}	
	void updateGameState() {
		om.update();
	}	
	void updateEndState() {
	}	
	void drawStartState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 800); 
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		
		g.drawString("Welcome To Jumper", 10, 100);
		
		g.setFont(titleFontt);
		
		g.drawString("Press SPACE for instructions", 85, 400);
		g.drawString("Press ENTER to start", 130, 500);
	}	
	void drawInstructionState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 500, 800); 
		g.setFont(instructFont);
		g.setColor(Color.BLACK);
		
		g.drawString("Press", 200, 100);
		g.drawString("w , s , a , d /", 140, 160);
		g.drawString("up , down , right , left ", 70, 200);
		g.drawString("to Move", 170, 260);
		
		g.drawString("go on the logs and lily pads", 10, 400);
		g.drawString("to cross the river safely", 30, 440);
	}	
	void drawGameState(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, 500, 800); 
		om.draw(g);
	}	
	void drawEndState(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 500, 800); 
		g.setFont(deathFont);
		g.setColor(Color.BLACK);
		
		g.drawString("You Died", 140, 100);
		
		g.setFont(titleFontt);
		
		g.drawString("Press ENTER to try again", 110, 300);
	}	
	void StartGame() {
		t.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		go.update();
		if(currentState == START_STATE) {
			updateStartState();
		}else if(currentState == INSTRUCTION_STATE){
            updateInstructionState();
        }else if(currentState == GAME_STATE){
            updateGameState();
        }else if(currentState == END_STATE){
          	updateEndState();
        }
	}
	@Override

	public void paintComponent(Graphics g){
        go.draw(g);
        if(currentState == START_STATE) {
			drawStartState(g);
		}else if(currentState == INSTRUCTION_STATE){
            drawInstructionState(g);
        }else if(currentState == GAME_STATE){
            drawGameState(g);
        }else if(currentState == END_STATE){
          	drawEndState(g);
        }
    }

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("Typed");	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Pressed");	
		if(e.getKeyCode() == KeyEvent.VK_DOWN||e.getKeyCode() == KeyEvent.VK_S) {
			fu.setymomentum(1);
		}else if(e.getKeyCode() == KeyEvent.VK_UP||e.getKeyCode() == KeyEvent.VK_W) {
			fu.setymomentum(-1);
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT||e.getKeyCode() == KeyEvent.VK_D) {
			fu.setxmomentum(1);
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT||e.getKeyCode() == KeyEvent.VK_A) {
			fu.setxmomentum(-1);
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER  && currentState != INSTRUCTION_STATE){
          currentState++;
		  if(currentState > END_STATE){
	          currentState = START_STATE;
		  }
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(currentState == START_STATE) {
				currentState = INSTRUCTION_STATE;
			}else if(currentState == INSTRUCTION_STATE){
				currentState = START_STATE;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Released");	
	}
	
}
