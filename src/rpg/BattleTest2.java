package rpg;

import java.awt.EventQueue;

public class BattleTest2 {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen2 frame = new Screen2();
					frame.setVisible(true);
					//Screen2.setpkmn1NewHP(40);
					Screen2.setpkmn2HP(5);
					Screen2.setpkmn1NewXP(70);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
