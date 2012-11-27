package rpg;

import java.util.ArrayList;

public class Event {
	
	public static void event_triggers()
	{
	}
	
	public static void event_1(ArrayList<Pokemon> pokemon, ArrayList<Trainer> trainer)
	{
		Lib.writed("Oak: Hello and welcome to the world of Pokémon!\nMy name is professor Oak. But people just call me the Pokémon Professor!\nPokémon are the strange creatures that inhabitats this land. Some people uses them as pets and some even uses them to battle others!\n");
		
		// Inputa player-name
		String playername = Lib.input("But first, what is your name?");
		
		// Välj din första Pokémon
		int trainerpokemon = 0;
		trainerpokemon = Lib.choice("Wich pokemon do you want?", new String[]{"Bulbasaur","Charmander","Squirtle"}, 0);
		String trainerpokemonname  = "Noname";
		// Switchsats som sätter namn beroende på vilken siffra man valde.
		switch(trainerpokemon)
		{
		case 1: System.out.println("You choose Bulbasaur\n");
		trainerpokemonname = "Bulbasaur";
		break;
		case 2: System.out.println("You choose Charmander\n");
		trainerpokemonname = "Charmander";
		break;
		case 3:	System.out.println("You choose  Squirtle\n");
		trainerpokemonname = "Squirtle";
		break;
		}
		
		// En ja/nej fråga om man vill ge ett nickname till sin Pokémon
		int answer = Lib.choiceyn("Do you want to name your new pokémon?",0);
		if(answer == 1)
		{
			trainerpokemonname = Lib.input("Great, what is its name?");
		}
		
		// Här skapas äntligen Pokémon och Trainerobjekten
		try {
			pokemon.add(new Pokemon(trainerpokemon,trainerpokemonname,5,0,new int[5]));
		} catch (Fail e) {
			e.printStackTrace();
		}
		trainer.add(new Trainer(0,playername,0));
		
		// Printa de stats och info som sattes när Pokémonen skapades
		System.out.println("Your new Pokémon:\n");
		//System.out.println(Lib.LoadPokemon(10)[5]);
		pokemon.get(0).showInfo();
		
		// Välj namn för din rival
		String rivalname = Lib.input("Oak: Now this is my grandson. He have been your rival ever since you where embryos. Now what was his name again?");
		
		// Rivalen börjar med att utmana en för ens första strid
		Lib.writed("Oak: Oh i remember now! His name is "  + rivalname + "!");
		Lib.writed(rivalname + ": So, " + playername + " you wanna test this Pokémon out? Lets battle!");
		int rp=0;
		
		// Precis innan Battle-funktionen kallas så skapas rivalen och hans Pokémon.
		// Hans Pokémon bestäms av vad player valde så de inte kan ha samma.
		if(trainerpokemon==1) rp = 2;
		else if(trainerpokemon==2) rp = 3;
		else if(trainerpokemon==3) rp = 1;
		try {
			pokemon.add(new Pokemon(rp,"AssPoke",5,1,new int[5]));
		} catch (Fail e) {
			e.printStackTrace();
		}
		trainer.add(new Trainer(0,rivalname,1));
		
	}
	
	public static void event_2()
	{
		
	}
	
}
