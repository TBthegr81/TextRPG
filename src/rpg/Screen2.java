package rpg;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Screen2 extends JFrame {

	private JPanel contentPane;
	BattlePainter painter;
	
	/**
	 * Create the frame.
	 */
	public Screen2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnfight = new JButton("[FIGHT]");
		panel.add(btnfight);
		
		JButton btnitems = new JButton("[ITEMS]");
		panel.add(btnitems);
		
		JButton btnpkmn = new JButton("[PKMN]");
		panel.add(btnpkmn);
		
		JButton btnrun = new JButton("[RUN]");
		panel.add(btnrun);
		
		JPanel field = new JPanel();
		contentPane.add(field, BorderLayout.CENTER);
		field.setLayout(new BorderLayout(0, 0));
		
		JPanel player = new JPanel();
		field.add(player, BorderLayout.SOUTH);
		player.setLayout(new BorderLayout(0, 0));
		
		JPanel pkmn1 = new JPanel();
		player.add(pkmn1, BorderLayout.WEST);
		
		JLabel pkmn1_sprite = new JLabel("");
		pkmn1_sprite.setIcon(new ImageIcon(Screen2.class.getResource("/rpg/images/backsprites/1.png")));
		pkmn1.add(pkmn1_sprite);
		
		JPanel pkmn1_stats = new JPanel();
		player.add(pkmn1_stats, BorderLayout.CENTER);
		pkmn1_stats.setLayout(null);
		
		JLabel pkmn1_statsimg = new JLabel("");
		pkmn1_statsimg.setIcon(new ImageIcon(Screen2.class.getResource("/rpg/images/playerhpbar.png")));
		pkmn1_statsimg.setHorizontalAlignment(SwingConstants.CENTER);
		pkmn1_statsimg.setFont(new Font("Dialog", Font.BOLD, 12));
		pkmn1_statsimg.setForeground(Color.GREEN);
		pkmn1_statsimg.setBounds(107, 12, 225, 82);
		pkmn1_stats.add(pkmn1_statsimg);
		
		JProgressBar pkmn1_xpbar = new JProgressBar();
		pkmn1_xpbar.setValue(50);
		pkmn1_xpbar.setForeground(Color.DARK_GRAY);
		pkmn1_xpbar.setBounds(170, 56, 122, 10);
		pkmn1_stats.add(pkmn1_xpbar);
		
		JProgressBar pkmn1_hpbar = new JProgressBar();
		pkmn1_hpbar.setForeground(Color.RED);
		pkmn1_hpbar.setStringPainted(true);
		pkmn1_hpbar.setValue(50);
		pkmn1_hpbar.setBounds(193, 32, 102, 14);
		pkmn1_stats.add(pkmn1_hpbar);
		
		JPanel foe = new JPanel();
		field.add(foe, BorderLayout.NORTH);
		foe.setLayout(new BorderLayout(0, 0));
		
		JPanel pkmn2 = new JPanel();
		foe.add(pkmn2, BorderLayout.EAST);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Screen2.class.getResource("/rpg/images/frontsprites/4.png")));
		pkmn2.add(lblNewLabel);
		
		JPanel pkmn2_stats = new JPanel();
		foe.add(pkmn2_stats, BorderLayout.CENTER);
		pkmn2_stats.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Screen2.class.getResource("/rpg/images/enemyhpbar.png")));
		lblNewLabel_1.setBounds(0, 0, 213, 76);
		pkmn2_stats.add(lblNewLabel_1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(50);
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.DARK_GRAY);
		progressBar.setBounds(38, 24, 100, 14);
		pkmn2_stats.add(progressBar);
        painter = new BattlePainter();
        painter.pokemonA = loadImage("1");
        painter.pokemonB = loadImage("3");
	}
}
