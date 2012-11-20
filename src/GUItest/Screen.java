package GUItest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Screen extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static int HEIGHT = 200;
	private final static int WIDTH = 300;
	private Color skyColor = Color.CYAN;
	private Color healthColor = Color.RED;
	private Color barColor = Color.WHITE;
	private Color groundColor = Color.GREEN;
	private Color textColor = Color.BLACK;
	private final static int hpperecent = 80;
 	private ArrayList<Pokemon> pokemon;
	
	public Screen() {
		init();
	}
	
	
	private void init() {
		setTitle("Battle");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setVisible(true);
	    setAlwaysOnTop(false);
	    
	    // importera bild
	    //importImages();
	    
	}
	
	/*private void importImages() {
		ImageIcon ii = new ImageIcon(this.getClass().getResource("fence.png"));
		fence = ii.getImage();
	    ImageIcon ii2 = new ImageIcon(this.getClass().getResource("parrot_head idle.png"));
	    happyFace = ii2.getImage();
	    ImageIcon ii3 = new ImageIcon(this.getClass().getResource("notHappyFace.png"));
	    unhappyFace = ii3.getImage();
	}*/
	
	private ArrayList<Image> getImages(Pokemon a, Pokemon b) {
		ArrayList<Image> images = new ArrayList<Image>();
		// body
		ImageIcon ii = new ImageIcon(this.getClass().getResource(a.getPkmnNr() + ".png"));
		images.add(ii.getImage());
		// head
		ImageIcon ii2 = new ImageIcon(this.getClass().getResource(b.getPkmnNr() + ".png"));
		images.add(ii2.getImage());
		
		return images;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(skyColor);
		g2.fillRect(0, 0, WIDTH, HEIGHT/2);
		
		g2.setColor(groundColor);
		g2.fillRect(0, HEIGHT/2, WIDTH, HEIGHT/2);
		
		
		if (pokemon != null) {
			// Draw playerpoke
			int x = 10;
			int y = 110;
			Pokemon a = pokemon.get(0);
			Pokemon b = pokemon.get(1);
			ArrayList<Image> images = getImages(a,b);
			
			g2.drawImage(images.get(0), x, y, this);
			
			Glib.WriteText();
			x = 180;
			y = 130;
			g2.setColor(textColor);
			g2.setFont(new Font("Verdana", Font.PLAIN, 14));
			g2.drawString(a.getName(), x, y);
			
			// Healthbar
			g2.setColor(barColor);
			g2.fillRect(20, 60, 110, 16);
			g2.setColor(healthColor);
			g2.fillRect(20, 63, hpperecent, 10);
			
			// Draw enemy
			x = 180;
			y = 20;
			g2.drawImage(images.get(1), x, y, this);
			xOffset = 20;
			yOffset = 35;
			g2.setColor(textColor);
			g2.setFont(new Font("Verdana", Font.PLAIN, 14));
			g2.drawString(b.getName(), x, y + 20);
			
			// Healthbar
			g2.setColor(barColor);
			g2.fillRect(180, 135, 110, 16);
			g2.setColor(healthColor);
			g2.fillRect(180, 138, hpperecent, 10);
			
			int textX = 200;
			int textY = 40;
			
			/*g2.drawString("Level: " + a.getStats()[0], textX, textY);
			g2.drawString("HP: " + a.getStats()[1], textX, textY + 20);
			g2.drawString("Attack: " + a.getStats()[2], textX, textY + 40);
			g2.drawString("Defence: " + a.getStats()[3], textX, textY + 60);
			g2.drawString("Speed: " + a.getStats()[4], textX, textY + 80);
			g2.drawString("Special: " + a.getStats()[5], textX, textY + 100);*/

			xOffset += images.get(0).getWidth(null);
			yOffset += 80;
		}
	}
	
	public void drawWorld(ArrayList<Pokemon> pokemon) {
		this.pokemon = pokemon;
		drawBackground();
		repaint();
	}
	
	private void drawBackground() {
		boolean isDay = false;
		
		Calendar calendar = new GregorianCalendar();
		
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		
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
		
	}
	
	public static void WriteText(Graphics2D g2, int x, int y, String text)
	{
		private Color textColor = Color.BLACK;
		g2.setColor(textColor);
		g2.setFont(new Font("Verdana", Font.PLAIN, 14));
		g2.drawString(text, x, y);
	}
}
