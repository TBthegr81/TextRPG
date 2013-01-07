package rpg;

import java.util.ArrayList;

public class Battletest {
	public static ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
	public static ArrayList<Trainer> trainer = new ArrayList<Trainer>();
	
	public static void battleTest(){
		Screen s = new Screen();
		for(int i = 0; i <= 100; i++)
		{
			Main.trainer.get(0).pokemon.get(0).stats[0] = i;
			s.drawWorld();
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
