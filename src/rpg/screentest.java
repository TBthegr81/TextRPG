package rpg;

import java.util.ArrayList;

public class screentest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Skriver ut menyn
		Lib.write("Pokémon - Awesome version");
		Lib.choice("Menue", new String[]{"New Game","Continue","Options"}, 0);
				
		ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
		Screen s = new Screen();
		pokemon.add(new Pokemon(1,"Bulbasaur",5,0));
		s.drawWorld(pokemon);
	}

}
