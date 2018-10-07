package jumper;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Jumper {
	JFrame jf;
	
	GamePanel gp;
	
	final int h = 800;
	final int w = 500;
	
	Jumper(){
		jf = new JFrame();
		gp = new GamePanel();		
	}
	
	public static void main(String[] args) {
		new Jumper().setup();
	}
	
	void setup() {
		jf.add(gp);
		jf.addKeyListener(gp);
		jf.setSize(w, h);
		jf.setVisible(true);
		jf.setTitle("Jumper");
		jf.getContentPane().setPreferredSize(new Dimension(w, h));
        jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        gp.StartGame();
	}
	
}
