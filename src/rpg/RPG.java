package rpg;
import java.util.List;
import java.util.Scanner;

public class RPG
{
	static Pokemon pokemon[] = new Pokemon[5];
	static Trainer trainer[] = new Trainer[2];
	
	public static void main(String [ ] args)
	{
		String command;
		Scanner sc = new Scanner(System.in);
		// Ger inloggningsruta
		boolean notloggedin = true;
		int Trainer_id = 0;
		String username = "";
		while(notloggedin)
		{
			username = Lib.input("Username:");
			String password = Lib.md5(Lib.input("Password:"));
			Trainer_id = Lib.Login(username,password);
			if(Trainer_id < 1)
			{
				Lib.write("Sry, username or password was wrong.");
			}
			else
			{
				notloggedin = false;
			}
		}
		
		// Skriver ut menyn
		Lib.write("Pokémon - Awesome version");
		int choice = Lib.choice("Menue", new String[]{"New Game","Continue","Forum","Options"}, 0);
		if(choice == 3)
		{
			List<String> list = Comunication.loadForumlist();
			String [] forumlist = list.toArray(new String[list.size()]);
			int threadid = Lib.choice("Choose discussion", forumlist , 0);
			while(true)
			{
				Comunication.loadThread(threadid);
				Comunication.postForumComment(Lib.input("Say somthing"), threadid, Trainer_id);
			}
		}
		else if(choice == 1)
		{
			// Globala variabler
			Pokemon pokemon[] = new Pokemon[5];
			Trainer trainer[] = new Trainer[2];
			
			// Kallar på event 0 vid new-game, välkomsteventet med Oak som ger player en introduktion av världen.
			Event.event_1(pokemon, trainer);
			
			// Här börjar första striden
			Battle.battle(0,1, trainer,0,pokemon);
			
			// Här är striden slut och man kan välja vad man själv ska göras. Denna kod ska outsourcas till Lib sen.
			command = Lib.input("");
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
				if(commanda[0].equals("battle"))
				{
					try{
					int u = Integer.parseInt(commanda[1]);
					int x = Integer.parseInt(commanda[2]);
					Battle.battle(u,x, trainer, 1, pokemon);
					}
					catch(Exception ex){System.out.println("U need Int noob");}
				}
			}
		}
		else if(choice == 2)
		{	
			Lib.LoadPokemon(Trainer_id);
			String[] poke = Lib.LoadPokemon(Trainer_id);
			int pokemonid = Integer.parseInt(poke[0]);
			String nickname = poke[1];
			int level = Integer.parseInt(poke[7]);
			try {
				pokemon[0] = new Pokemon(pokemonid,nickname,level,0);
			} catch (Fail e) {
				e.printStackTrace();
			}
			trainer[0] = new Trainer(username,0, pokemon);
			
			try {
				pokemon[1] = new Pokemon(4,"AssPoke",5,1);
			} catch (Fail e) {
				e.printStackTrace();
			}
			trainer[1] = new Trainer("Dick",1, pokemon);
			pokemon[0].showInfo();
			Battle.battle(0,1, trainer,0,pokemon);
			
		}
		
		else if(choice == 4)
		{
			Lib.write("Sry, no options yet!");
		}
	}
}
