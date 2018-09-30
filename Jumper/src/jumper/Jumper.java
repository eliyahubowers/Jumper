package jumper;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Jumper {
	JFrame jf;
	JPanel jp;
	
	final int h = 800;
	final int w = 500;
	
	public static void main(String[] args) {
		new Jumper().setup();
	}
	
	void setup() {
		jf = new JFrame();
		jp = new JPanel();
		jf.add(jp);
		jf.setSize(w, h);
		jf.setVisible(true);
		jf.setTitle("Jumper");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setPreferredSize(new Dimension(w, h));
        jf.pack();
	}
	
}
