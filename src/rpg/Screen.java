package rpg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;


public class Screen extends JFrame {
	
	public static 	JPanel contentPane;
	public static 	JTextPane textPane1;
	public static 	JButton buttons[] = new JButton[16];
	public final 	JPanel panel = new JPanel();
	
	private static final long serialVersionUID = 1L;
	private final static int HEIGHT = 200;
	private final static int WIDTH = 300;
	private Color skyColor = Color.CYAN;
	private Color healthColor = Color.RED;
	private Color barColor = Color.WHITE;
	private Color groundColor = Color.GREEN;
	private Color textColor = Color.BLACK;
	private final static int hpperecent = 80;
 	//private ArrayList<Pokemon> pokemon;
 	Pokemon a = Main.trainer.get(0).pokemon.get(0);
	Pokemon b = Main.trainer.get(1).pokemon.get(0);
	
	public Screen() {
		
		setVisible(true);
		setTitle("Pokemon Battle");
		setSize(WIDTH,HEIGHT);
		setResizable(false);
		setVisible(true);
	    setAlwaysOnTop(false);
		setLocation(100,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 0, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//workingArea.setBackground(healthColor);
		//workingArea.add(panel, BorderLayout.CENTER);
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		buttons[0] = new JButton("[FIGHT]");
		buttons[1] = new JButton("[ITEM]");
		buttons[2] = new JButton("[PKMN]");
		buttons[3] = new JButton("[RUN]");
		
		panel.add(buttons[0]);
		//buttons[0].addActionListener(new do1());
		panel.add(buttons[1]);
		//buttons[1].addActionListener(new do1());
		panel.add(buttons[2]);
		//buttons[2].addActionListener(new do1());
		panel.add(buttons[3]);
		//buttons[3].addActionListener(new do1());
		*/
	}
	
	private ArrayList<Image> getImages() {
		ArrayList<Image> images = new ArrayList<Image>();
		// body
		ImageIcon ii = new ImageIcon(this.getClass().getResource("images/backsprites/" + a.getPkmnNr() + ".png"));
		images.add(ii.getImage());
		// head
		ImageIcon ii2 = new ImageIcon(this.getClass().getResource("images/frontsprites/" +  b.getPkmnNr() + ".png"));
		images.add(ii2.getImage());
		
		ImageIcon ii3 = new ImageIcon(this.getClass().getResource("images/enemyhpbar.png"));
		images.add(ii3.getImage());
		
		ImageIcon ii4 = new ImageIcon(this.getClass().getResource("images/playerhpbar.png"));
		images.add(ii4.getImage());
		
		return images;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(skyColor);
		g2.fillRect(0, 0, WIDTH, HEIGHT/2);
		
		g2.setColor(groundColor);
		g2.fillRect(0, HEIGHT/2, WIDTH, HEIGHT/2);
		
		// GUI
		//Button button1 = new Button("Button One");
		
		
		if (a != null) {
			// Draw playerpoke
			int x = 10;
			int y = 110;
			ArrayList<Image> images = getImages();
			
			g2.drawImage(images.get(0), x, y, this);
			
			WriteText(g2,180,130,a.getName(),textColor);
			
			// Healthbar
			x = 125;
			y = 130;
			g2.drawImage(images.get(3), x, y, this);
			g2.setColor(barColor);
			g2.fillRect(180, 133, 90, 12);
			g2.setColor(healthColor);
			g2.fillRect(180, 135, hpperecent, 8);
			WriteText(g2,180,160,a.stats[0] + " / " + 100,textColor);
			
			// Draw enemy
			x = 180;
			y = 20;
			g2.drawImage(images.get(1), x, y, this);
			x = 20;
			y = 40;
			g2.setColor(textColor);
			g2.setFont(new Font("Verdana", Font.PLAIN, 14));
			g2.drawString(b.getName(), x, y);

			
			// Healthbar
			x = 5;
			y = 50;
			g2.drawImage(images.get(2), x, y, this);
			g2.setColor(barColor);
			g2.fillRect(45, 55, 90, 8);
			g2.setColor(healthColor);
			g2.fillRect(45, 57, hpperecent, 4);
			
		}
	}
	
	public void drawWorld() {
		//drawBackground();
		repaint();
		//contentPane.revalidate();
	}
	
	/*private void drawBackground() {
		boolean isDay = true;
		//Calendar calendar = new GregorianCalendar();
		
		//int hours = calendar.get(Calendar.HOUR_OF_DAY);
		
		if (hours > 6 && hours < 18) {
			isDay = true;
		}
		
		if (isDay) {
			textColor = Color.BLACK;
			skyColor = Color.CYAN;
			groundColor = Color.GREEN;
		} else {
			textColor = Color.WHITE;
			skyColor = Color.BLACK;
			groundColor = Color.DARK_GRAY;
		}
		
	}*/
	
	public static void WriteText(Graphics2D g2, int x, int y, String text, Color textColor)
	{
		textColor = Color.BLACK;
		g2.setColor(textColor);
		g2.setFont(new Font("Verdana", Font.PLAIN, 14));
		g2.drawString(text, x, y);
	}
}
