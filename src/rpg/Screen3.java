package rpg;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class Screen3 extends JFrame {

	private JPanel contentPane;
	private static JTextField textField;
	private static JLabel pkmn = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen3 frame = new Screen3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Screen3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainpanel = new JPanel();
		mainpanel.setBounds(5, 5, 438, 200);
		contentPane.add(mainpanel);
		mainpanel.setLayout(null);
		
		pkmn.setIcon(new ImageIcon(Screen3.class.getResource("/rpg/images/frontsprites/1.png")));
		pkmn.setBounds(162, 48, 96, 96);
		mainpanel.add(pkmn);
		
		textField = new JTextField();
		textField.setBounds(5, 220, 375, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText("OMG! Bulbasaur is evolving!");
		
		JButton okbtn = new JButton("OK");
		okbtn.setBounds(384, 217, 55, 53);
		contentPane.add(okbtn);
		okbtn.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
			    Thread queryThread = new Thread() {
			      public void run() {
			    	  evolveAni(1,2);
			      }
			    };
			    queryThread.start();
			  }
			});
	}
	
	public static void evolveAni(int pkmn1, int pkmn2)
	{
		ImageIcon icon1 = new ImageIcon(Screen3.class.getResource("/rpg/images/frontsprites/1.png"));
		ImageIcon icon2 = new ImageIcon(Screen3.class.getResource("/rpg/images/frontsprites/2.png"));
		
		for(int i = 1000; i > 0; i = i - 100)
		{
			try {
				Thread.sleep(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			updateProgress1(icon1);
			System.out.println(pkmn.getIcon());
			try {
				Thread.sleep(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			updateProgress2(icon2);
			System.out.println(pkmn.getIcon());
		}
		textField.setText("Bulbasaur evolved into Ivysaur!");
		
	}
	
	private static void updateProgress2(final ImageIcon icon2) {
		  SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		      // Here, we can safely update the GUI
		      // because we'll be called from the
		      // event dispatch thread
		    	pkmn.setIcon(icon2);
		    }
		  });
		}
	
	private static void updateProgress1(final ImageIcon icon1) {
		  SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		      // Here, we can safely update the GUI
		      // because we'll be called from the
		      // event dispatch thread
		    	pkmn.setIcon(icon1);
		    }
		  });
	}
}
