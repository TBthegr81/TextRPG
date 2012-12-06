package rpg;
import java.util.ArrayList;
import java.util.List;

public class Main
{
	//public static Pokemon pokemon[] = new Pokemon[5];
	public static ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
	//public static Trainer trainer[] = new Trainer[2];
	public static ArrayList<Trainer> trainer = new ArrayList<Trainer>();
	public static String username = "";
	public static int Trainer_id = 0;
	
	public static void main(String [ ] args)
	{
		//Scanner sc = new Scanner(System.in);
		// Ger inloggningsruta
		boolean notloggedin = true;
		
		while(notloggedin)
		{
			//String username = Lib.input("Username");
			//String password = Lib.md5(Lib.input("Password"));
			String Logindata[] = Lib.loginPopup();
			String username = Logindata[0];
			String password = Lib.md5(Logindata[1]);
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
			// Kallar på event 0 vid new-game, välkomsteventet med Oak som ger player en introduktion av världen.
			Event.event_1(pokemon, trainer);
		}
		else if(choice == 2)
		{
			Lib.LoadGame(Trainer_id);
		}
		
		else if(choice == 4)
		{
			Lib.write("Sry, no options yet!");
		}
		while(true)
		{
			//Event_check.check();
			Lib.command();
		}
	}
}
