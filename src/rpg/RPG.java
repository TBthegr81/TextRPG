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

		// Globala variabler
		Pokemon pokemon[] = new Pokemon[5];
		Trainer trainer[] = new Trainer[2];
		
		// Kallar på event 0 vid new-game, välkomsteventet med Oak som ger player en introduktion av världen.
		Event.event_1(pokemon, trainer);
		
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
