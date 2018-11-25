package jumper;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;

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
	
	float delayJump = 0;
	
	Timer t; 
	
	GameObject go;
	Frog fu;
	ObjectManager om;
	
	Color c;
	
	GamePanel(){
		titleFont = new Font("Arial",Font.PLAIN,53);
		titleFontt = new Font("Arial",Font.PLAIN,25);
		instructFont = new Font("Arial",Font.PLAIN,40);
		deathFont = new Font("Arial",Font.PLAIN,53);
		t = new Timer(1000/100,this);
		go = new GameObject(100,100,100,100);
		fu = new Frog(250,750,25,25,25,0,0);
		om = new ObjectManager(fu);
	}
	
	void updateStartState() {
	}	
	void updateInstructionState() {
	}	
	void updateGameState() {
		om.update();
		om.manageLogs();
		om.purgeObjects();
		om.checkCollision();
		if(fu.isAlive == false) {
			currentState = END_STATE;
		}
	}	
	void updateEndState() {
	}	
	void drawStartState(Graphics g) {
		c = new Color(94, 165, 219);
		g.setColor(c);
		g.fillRect(0, 0, 500, 800); 
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		
		g.drawString("Welcome To Jumper", 10, 100);
		
		g.setFont(titleFontt);
		
		g.drawString("Press SPACE for instructions", 85, 400);
		g.drawString("Press ENTER to start", 130, 500);
	}	
	void drawInstructionState(Graphics g) {
		c = new Color(255, 255, 255);
		g.setColor(c);
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
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);
		c = new Color(255,216,76);
		g.setColor(c);
		g.fillRect(0, 0, 500, 75);
		g.fillRect(0,700,500,100);
		c = new Color(206,174,59);
		g.setColor(c);
		g.fillRect(0, 75, 500, 5); 
		om.draw(g);
	}	
	void drawEndState(Graphics g) {
		c = new Color(193, 40, 17);
		g.setColor(c);
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
		if(delayJump <= 0) {
		if(e.getKeyCode() == KeyEvent.VK_DOWN||e.getKeyCode() == KeyEvent.VK_S) {
			fu.setymomentum(1);
			delayJump +=.00025;
		}else if(e.getKeyCode() == KeyEvent.VK_UP||e.getKeyCode() == KeyEvent.VK_W) {
			fu.setymomentum(-1);
			delayJump +=.00025;
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT||e.getKeyCode() == KeyEvent.VK_D) {
			fu.setxmomentum(1);
			delayJump +=.00025;
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT||e.getKeyCode() == KeyEvent.VK_A) {
			fu.setxmomentum(-1);
			delayJump +=.00025;
		}
		}else {
			delayJump-=.001;
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER  && currentState != INSTRUCTION_STATE && currentState != GAME_STATE){
          currentState++;
		  if(currentState > END_STATE){
			  fu = new Frog(250,750,25,25,25,0,0);
			  om = new ObjectManager(fu);
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
