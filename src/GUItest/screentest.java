package GUItest;


import java.util.ArrayList;

public class screentest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
		Screen s = new Screen();
		pokemon.add(new Pokemon(1,"Bulbasaur",5,0));
		pokemon.add(new Pokemon(4,"Charmander",5,0));
		s.drawWorld(pokemon);
	}

}
