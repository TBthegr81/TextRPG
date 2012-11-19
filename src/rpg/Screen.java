package rpg;
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
	
	private final static int HEIGHT = 200;
	private final static int WIDTH = 300;
	private Color skyColor = Color.CYAN;
	private Color groundColor = Color.GREEN;
	private Color textColor = Color.BLACK;
 	private ArrayList<Pokemon> pokemon;
	private Image fence;
	
	public Screen() {
		init();
	}
	
	private void init() {
		setTitle("Bulbasaur");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setVisible(true);
	    setAlwaysOnTop(true);
	    
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
	
	private ArrayList<Image> getImages(Pokemon a) {
		ArrayList<Image> images = new ArrayList<Image>();
		// body
		ImageIcon ii = new ImageIcon(this.getClass().getResource(a.getPkmnNr() + ".png"));
		images.add(ii.getImage());
		// head
		//ImageIcon ii2 = new ImageIcon(this.getClass().getResource(a.getType() + "_head " + a.getState() + ".png"));
		//images.add(ii2.getImage());
		
		return images;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(skyColor);
		g2.fillRect(0, 0, WIDTH, HEIGHT/2);
		
		g2.setColor(groundColor);
		g2.fillRect(0, HEIGHT/2, WIDTH, HEIGHT/2);
		
		g2.drawImage(fence, 0, HEIGHT/3, this);
		
		if (pokemon != null) {
			int bodyOffset = 10;
			int yOffset = HEIGHT/4;
			for (int i = 0; i < pokemon.size(); i++) {
				Pokemon a = pokemon.get(i);
				ArrayList<Image> images = getImages(a);
				g2.drawImage(images.get(0), bodyOffset, yOffset, this);
				
				g2.setColor(textColor);
				g2.setFont(new Font("Verdana", Font.PLAIN, 14));
				g2.drawString(a.getName(), bodyOffset + 10, yOffset - 10);
				
				int textX = 200;
				int textY = 40;
				
				g2.drawString("Level: " + a.getStats()[0], textX, textY);
				g2.drawString("HP: " + a.getStats()[1], textX, textY + 20);
				g2.drawString("Attack: " + a.getStats()[2], textX, textY + 40);
				g2.drawString("Defence: " + a.getStats()[3], textX, textY + 60);
				g2.drawString("Speed: " + a.getStats()[4], textX, textY + 80);
				g2.drawString("Special: " + a.getStats()[5], textX, textY + 100);
				
				/*
				if (a.getHowHappy() > 50) {
					g2.drawImage(happyFace, bodyOffset, yOffset, this);
				} else {
					g2.drawImage(unhappyFace, bodyOffset, yOffset, this);
				}
				*/
				
				bodyOffset += images.get(0).getWidth(null);
				yOffset += 80;
			}
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
	
}
