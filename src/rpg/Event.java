package rpg;

import java.util.ArrayList;

public class Event {
	
	public static void event_1(ArrayList<Pokemon> pokemon, ArrayList<Trainer> trainer)
	{
		Lib.writed("Oak: Hello and welcome to the world of Pokémon!\nMy name is professor Oak. But people just call me the Pokémon Professor!\nPokémon are the strange creatures that inhabitats this land. Some people uses them as pets and some even uses them to battle others!\n");
		
		// Inputa player-name
		String playername = "";
		playername = Lib.input("But first, what is your name?");
		
		// Välj din första Pokémon
		int trainerpokemon = 0;
		trainerpokemon = Lib.choice("Wich pokemon do you want?", new String[]{"Bulbasaur","Charmander","Squirtle"}, 0);
		String trainerpokemonname  = "Noname";
		// Switchsats som sätter namn beroende på vilken siffra man valde.
		switch(trainerpokemon)
		{
		case 1: System.out.println("You choose Bulbasaur\n");
		trainerpokemon = 1;
		trainerpokemonname = "Bulbasaur";
		//Lib.pokemonInfo("http://archives.bulbagarden.net/media/upload/thumb/2/21/001Bulbasaur.png/120px-001Bulbasaur.png", "Bulbasaur");
		break;
		case 2: System.out.println("You choose Charmander\n");
		trainerpokemonname = "Charmander";
		//Lib.pokemonInfo("http://archives.bulbagarden.net/media/upload/thumb/7/73/004Charmander.png/120px-004Charmander.png", "Charmander");
		trainerpokemon = 4;
		break;
		case 3:	System.out.println("You choose  Squirtle\n");
		trainerpokemonname = "Squirtle";
		//Lib.pokemonInfo("http://archives.bulbagarden.net/media/upload/thumb/3/39/007Squirtle.png/116px-007Squirtle.png", "Squirtle");
		trainerpokemon = 7;
		break;
		}
		
		// En ja/nej fråga om man vill ge ett nickname till sin Pokémon
		int answer = Lib.choiceyn("Do you want to name your new pokémon?",0);
		if(answer == 1)
		{
			trainerpokemonname = Lib.input("Great, what is its name?");
		}
		
		// Här skapas äntligen Pokémon och Trainerobjekten
		trainer.add(new Trainer(0,playername,0));
		try {
			Main.trainer.get(0).pokemon.add(new Pokemon(trainerpokemon,trainerpokemonname,5,0,new int[]{0,0,0,0,0,0}));
		} catch (Fail e) {
			e.printStackTrace();
		}
		
		// Printa de stats och info som sattes när Pokémonen skapades
		System.out.println("Your new Pokémon:\n");
		//System.out.println(Lib.LoadPokemon(10)[5]);
		Main.trainer.get(0).pokemon.get(0).showInfo();
		
		// Välj namn för din rival
		String rivalname = Lib.input("Oak: Now this is my grandson. He have been your rival ever since you where embryos. Now what was his name again?");
		
		// Rivalen börjar med att utmana en för ens första strid
		Lib.writed("Oak: Oh i remember now! His name is "  + rivalname + "!");
		Lib.writed(rivalname + ": But grandpa!! Why dont you remember my name??");
		Lib.writed(rivalname + ": So, " + playername + " you wanna test this Pokémon out? Lets battle!");
		int rp=0;

		// Precis innan Battle-funktionen kallas så skapas rivalen och hans Pokémon.
		// Hans Pokémon bestäms av vad player valde så de inte kan ha samma.
		trainer.add(new Trainer(0,rivalname,1));
		if(trainerpokemon==1) rp = 4;
		else if(trainerpokemon==4) rp = 7;
		else if(trainerpokemon==7) rp = 1;
		try {
			Main.trainer.get(1).pokemon.add(new Pokemon(rp,"Asspoke",5,1,new int[]{0,0,0,0,0,0}));
		} catch (Fail e) {
			e.printStackTrace();
		}
		
		// Här börjar första striden
		//Battle.battle(0,1,0);
		//Battletest.battleTest();
	}
	
	public static void event_2()
	{
		
	}
	
}
