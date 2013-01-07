package GUItest;


import java.util.ArrayList;

public class screentest {
	
	public static void main(String[] args) {
		ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
		Screen s = new Screen();
		pokemon.add(new Pokemon(1,"Bulbasaur",5,0));
		pokemon.add(new Pokemon(13,"Weedle",5,0));
		
		s.drawWorld(pokemon);
		
		for(int i = 0; i < 100; i++)
		{
			System.out.println(i);
			pokemon.get(0).stats[0]--;
			pokemon.get(1).stats[0]--;
			s.drawWorld(pokemon);
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
