package rpg;

import java.awt.EventQueue;

public class BattleTest {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen2 frame = new Screen2();
					frame.setVisible(true);
					frame.Draw();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
