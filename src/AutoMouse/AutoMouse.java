package AutoMouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AutoMouse extends JFrame{
	AutoMouse(){
		super("AutoMouse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		setLayout(new FlowLayout());
		
		JButton start = new JButton("START");
		start.setSize(100,50);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		c.add(start);
		
		JLabel im = new JLabel("시작 : F7 종료 : F8");
		c.add(im);
		c.addKeyListener(new MyKeyListener());
		
		c.setFocusable(true);
		c.requestFocus();
		setLocation(200,200);
		setSize(300,300);
		setVisible(true);
	}
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_F7) {
				try {
					Robot bot = new Robot();
					int i=0;
					while(i<500) {
						Thread.sleep(10);
						bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
						bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
						requestFocus();
						if(e.getKeyCode()==KeyEvent.VK_F8) break;
						i++;
					}
				} catch (AWTException e1) {} catch (InterruptedException e1) {}
			}
		}
	}
	public static void main(String[] args) {
		new AutoMouse();
	}
}
