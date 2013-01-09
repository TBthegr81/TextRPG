package rpg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Screen2 extends JFrame {
	
	private JPanel contentPane;
	private static JProgressBar pkmn1_xpbar;
	private static JProgressBar pkmn1_hpbar;
	private static JProgressBar pkmn2_hpbar;
	private static Timer timer;
	private static int i = 0;
	int number1 = 1;
	int number2 = 4;
	
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
		pkmn1_sprite.setIcon(new ImageIcon(Screen2.class.getResource("images/backsprites/"+number1+".png")));
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
		
		pkmn1_xpbar = new JProgressBar();
		pkmn1_xpbar.setValue(1);
		pkmn1_xpbar.setForeground(Color.DARK_GRAY);
		pkmn1_xpbar.setBounds(170, 56, 122, 10);
		pkmn1_stats.add(pkmn1_xpbar);
		
		pkmn1_hpbar = new JProgressBar();
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
		lblNewLabel.setIcon(new ImageIcon(Screen2.class.getResource("images/frontsprites/"+number2+".png")));
		pkmn2.add(lblNewLabel);
		
		JPanel pkmn2_stats = new JPanel();
		foe.add(pkmn2_stats, BorderLayout.CENTER);
		pkmn2_stats.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Screen2.class.getResource("/rpg/images/enemyhpbar.png")));
		lblNewLabel_1.setBounds(0, 0, 213, 76);
		pkmn2_stats.add(lblNewLabel_1);
		
		pkmn2_hpbar = new JProgressBar();
		pkmn2_hpbar.setValue(50);
		pkmn2_hpbar.setStringPainted(true);
		pkmn2_hpbar.setForeground(Color.DARK_GRAY);
		pkmn2_hpbar.setBounds(38, 24, 100, 14);
		pkmn2_stats.add(pkmn2_hpbar);
	}
<<<<<<< HEAD
=======
	
	public static void setpkmn1NewXP(final int newXP)
	{ 
		int delay = 20; //milliseconds
		ActionListener taskPerformer = new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				if(i < newXP)
				{
					pkmn1_xpbar.setValue(pkmn1_xpbar.getValue() + 1);
				}
				else
				{
					timer.stop();
					i = 0;
					System.out.println(i);
				}
				i++;
		    }
		};
		timer = new Timer(delay, taskPerformer);
		timer.start();
		
	}
	public static void setpkmn1XP(int newXP)
	{ 
		pkmn1_xpbar.setValue(newXP);
	}
	
	public static void setpkmn1NewHP(final int newHP)
	{ 
		int delay = 20; //milliseconds
		ActionListener taskPerformer = new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				if(i < newHP)
				{
					pkmn1_xpbar.setValue(pkmn1_hpbar.getValue() + 1);
				}
				else
				{
					timer.stop();
				}
				i++;
		    }
		};
		timer = new Timer(delay, taskPerformer);
		timer.start();
	}

	
	public static void setpkmn1HP(int newHP)
	{ 
		pkmn1_hpbar.setValue(newHP);
	}
	
	
	public static void setpkmn2NewHP(int newHP)
	{ 
		
	}
	
	public static void setpkmn2HP(int newHP)
	{ 
		pkmn2_hpbar.setValue(newHP);
	}
>>>>>>> refs/remotes/origin/master
}
