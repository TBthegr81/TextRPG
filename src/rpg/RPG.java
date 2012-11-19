package rpg;
import java.util.Scanner;
public class RPG
{
	public static void main(String [ ] args)
	{
		String command;
		Scanner sc = new Scanner(System.in);
		// Skriver ut menyn
		Lib.write("Pokémon - Awesome version");
		Lib.choice("Menue", new String[]{"New Game","Continue","Options"}, 0);

		// Kallar på event 0 vid new-game, välkomsteventet med Oak som ger player en introduktion av världen.
		Lib.event(0, "welcome");
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
		Pokemon pokemon[] = new Pokemon[5];
		pokemon[0] = new Pokemon(trainerpokemon,trainerpokemonname,5,0);
		Trainer trainer[] = new Trainer[2];
		trainer[0] = new Trainer(playername,0, pokemon);
		
		// Printa de stats och info som sattes när Pokémonen skapades
		System.out.println("Your new Pokémon:\n");
		System.out.println(Lib.LoadPokemon(10)[5]);
		pokemon[0].showInfo();
		
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
		pokemon[1] = new Pokemon(rp,"AssPoke",5,1);
		trainer[1] = new Trainer(rivalname,1, pokemon);
		
		// Här börjar första striden
		Battle.battle(0,1, trainer,0,pokemon);
		
		// Här är striden slut och man kan välja vad man själv ska göras. Denna kod ska outsourcas till Lib sen.
		System.out.print(">");
		while(!(command = sc.nextLine()).equals("exit")){
			String commanda[] = new String[10];
			commanda = command.split(" ");
			if(commanda[0].equals("trainer_info"))
			{
				try{
				int u = Integer.parseInt(commanda[1]);
				trainer[u].showInfo(u);
				}
				catch(Exception ex){System.out.println("U need Int noob");}
			}
			
			if(commanda[0].equals("pokemon_info"))
			{
				try{
				int u = Integer.parseInt(commanda[1]);
				pokemon[u].showInfo();
				}
				catch(Exception ex){System.out.println("U need Int noob");}
			}
			/*if(commanda[0].equals("battle"))
			{
				try{
				int u = Integer.parseInt(commanda[1]);
				int x = Integer.parseInt(commanda[2]);
				libPokemon.battle(u,x, trainer, 1, pokemon);
				}
				catch(Exception ex){System.out.println("U need Int noob");}
			}
			*/
			System.out.print(">");
		}
	
	}
}
