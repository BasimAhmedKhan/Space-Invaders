package game.pack;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class MainMenu
{

	public static void main(String[] args) throws Exception
	{
		new Menu();
		
	}
	
	public static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) 
	{
		Image img = icon.getImage();  
		Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
		return new ImageIcon(resizedImage);
	}

}

class Menu extends MainMenu 
{
	Menu() throws IOException
	{
		JFrame f = new JFrame();
		f.setContentPane(new JPanel() 
		{			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			BufferedImage image = ImageIO.read(getClass().getResource("images\\menu.jpg"));
	        public void paintComponent(Graphics g) 
	        {
	            super.paintComponent(g);
	            g.drawImage(image, -70, -100, 768, 768, this);
	        }
	    });
		ImageIcon icon = new ImageIcon("src\\game\\pack\\images\\startnewgame.png");
		ImageIcon icon1 = new ImageIcon("src\\game\\pack\\images\\credits1.png");
		ImageIcon icon2 = new ImageIcon("src\\game\\pack\\images\\exit.png");
		
		//Start New Game
		JButton b = new JButton();
    	b.setBounds(145, 380, 350, 60);
    	int offset = b.getInsets().left;
    	b.setIcon(resizeIcon(icon, b.getWidth() - offset, b.getHeight() - offset));
    	b.setBackground(Color.BLACK);
    	b.addActionListener(e -> 
    	{
    	    new SpaceInvaders();
    	    f.dispose();
   
    	});
    	
    	//Credits
    	JButton b1 = new JButton();
    	b1.setBounds(215, 450, 200, 50);
    	int offset1 = b1.getInsets().left;
    	b1.setIcon(resizeIcon(icon1, b1.getWidth() - offset1, b1.getHeight() - offset1));
    	b1.setBackground(Color.BLACK);
    	b1.addActionListener(e -> 
    	{
    		try {
				new Credits();
				f.dispose();
			} catch (IOException e1) {
				System.out.println("Nothing");
				e1.printStackTrace();
			}
    	});
    	
    	//Exit
    	JButton b2 = new JButton();
    	b2.setBounds(265, 510, 100, 50);
    	int offset2 = b2.getInsets().left;
    	b2.setIcon(resizeIcon(icon2, b2.getWidth() - offset2, b2.getHeight() - offset2));
    	b2.setBackground(Color.BLACK);
    	b2.addActionListener(e -> 
    	{
    		f.dispose();
    	});
    	
        f.add(b);
        f.add(b1);
        f.add(b2);
		f.setTitle("SPACE INVADERS"); 
		f.setLayout(null);
		f.setVisible(true);
		f.setResizable(false);
		f.setSize(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}
	
}

class Credits extends MainMenu
{
	Credits() throws IOException
	{
		JFrame f1 = new JFrame();
		ImageIcon icon2 = new ImageIcon("src\\game\\pack\\images\\exit.png");
		f1.setContentPane(new JPanel() 
		{

	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			BufferedImage image = ImageIO.read(getClass().getResource("images\\credits.jpg"));
	        public void paintComponent(Graphics g) 
	        {
	            super.paintComponent(g);
	            g.drawImage(image, 1, 70, 100, 500, this);
	        }
	    });
		
		//Exit
		JButton b3 = new JButton();
		b3.setBounds(265, 570, 100, 50);
    	int offset2 = b3.getInsets().left;
    	b3.setIcon(resizeIcon(icon2, b3.getWidth() - offset2, b3.getHeight() - offset2));
    	b3.setBackground(Color.BLACK);
    	b3.addActionListener(e -> 
    	{
    		try {
				new Menu();
			} catch (IOException e1) 
    		{
				System.out.println("Nothing");
				e1.printStackTrace();
			}
    		f1.dispose();
    	});
		
		
		JLabel l = new JLabel("CREDITS");
		l.setFont(new Font("Century Gothic", Font.BOLD, 50));
		l.setForeground(Color.WHITE);
		l.setBounds(210, -160, 550, 400);
		JLabel l1 = new JLabel("BASIM AHMED KHAN (Developer, Designer)");
		l1.setFont(new Font("Century Gothic", Font.BOLD, 25));
		l1.setForeground(Color.YELLOW);
		l1.setBounds(115, 80, 550, 100);
		JLabel l2 = new JLabel("WARRISHA JABEEN");
		l2.setFont(new Font("Century Gothic", Font.BOLD, 25));
		l2.setForeground(Color.ORANGE);
		l2.setBounds(115, 170, 550, 100);
		JLabel l3 = new JLabel("MARYAM ALAVI");
		l3.setFont(new Font("Century Gothic", Font.BOLD, 25));
		l3.setForeground(Color.MAGENTA);
		l3.setBounds(115, 270, 550, 100);
		JLabel l4 = new JLabel("MOHAMMAD USMAN");
		l4.setFont(new Font("Century Gothic", Font.BOLD, 25));
		l4.setForeground(Color.BLUE);
		l4.setBounds(115, 370, 550, 100);
		JLabel l5 = new JLabel("HAROON FAROOQUI");
		l5.setFont(new Font("Century Gothic", Font.BOLD, 25));
		l5.setForeground(Color.GREEN);
		l5.setBounds(115, 475, 550, 100);
		
		f1.add(b3);
		f1.add(l);
		f1.add(l1);
		f1.add(l2);
		f1.add(l3);
		f1.add(l4);
		f1.add(l5);
		f1.getContentPane().setBackground(Color.BLACK);
		f1.setTitle("SPACE INVADERS"); 
		f1.setLayout(null);
		f1.setVisible(true);
		f1.setResizable(false);
		f1.setSize(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);
		f1.setLocationRelativeTo(null);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}

