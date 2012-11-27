package rpg;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lib{
	static String url = "jdbc:mysql://server.snekabel.se/pokemonrpg2";
    static String user = "pok";
    static String password = "Pokemon1";
	
	// Förkorting av System.out.println metoden.
	public static void write(String input){
	System.out.println(input);
	}
	
	// Funktion för att skriva ut text med delay mellan tecknen så man får skrivmaskinskänslan
	public static void writed(String input){
		// variabel för hur snabbt texten skrivs ut (hur lång tid den ska sova mellan varje bokstav)
		int textspeed=5;
		for(int i1 = 0; i1 < input.length(); i1++){
			System.out.print(input.charAt(i1));
						try{
							Thread.sleep(textspeed);				
						}
						catch(Exception ex){}
		}
		System.out.println();
	}
	// Metod för att generera MD5 hash av password
	public static String md5(String input) {
	    
	    String md5 = null;
	     
	    if(null == input) return null;
	     
	    try {
	         
	    //Create MessageDigest object for MD5
	    MessageDigest digest = MessageDigest.getInstance("MD5");
	     
	    //Update input string in message digest
	    digest.update(input.getBytes(), 0, input.length());

	    //Converts message digest value in base 16 (hex) 
	    md5 = new BigInteger(1, digest.digest()).toString(16);

	    } catch (NoSuchAlgorithmException e) {

	        e.printStackTrace();
	    }
	    return md5;
	}
	
	// Funktion för att enkelt kunna skapa ett val för player.
	// Tar emot Frågan som ska ställas, de alternativ man kan välja som en Array
	// och om det finns ett svar man måste välja så tas det in också.
	public static int choice(String question, String[] choices, int rightAnswer)
	{
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		Lib.writed(question);
		boolean notfail = true;
		for(int i = 0; i < choices.length; i++)
		{
			// Skapar ett val för varje inlägg i Arrayen med tillhörande siffra
			System.out.println("[" + (i+1) + "]" + choices[i]);
		}
		// Sålänge man skriver svar som inte godtas kommer loopen köras om
		while(notfail)
		{
			// Här läser den in vad player skriver
			System.out.print(">");
			answer = sc.nextInt();
			
			System.out.println("Your choice: " + answer);
			// Check ifall man väljer något som inte finns med i listan
			if(answer > choices.length)
			{
				System.out.println("Not a valid answer");
			}
			else
			{
				// Om svaret godtas så avbryts loopen och svaret returneras
				break;
			}
		}
		return answer;
	}
	
	// Funktion liknande den andra choice, men med skillnaden att denna alltid ger Yes/No som alternativ.
	public static int choiceyn(String question, int rightAnswer)
	{
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		Lib.writed(question);
		boolean notfail = true;
		
		// Sålänge man skriver svar som inte godtas kommer loopen köras om
		while(notfail)
		{
			System.out.println("[Y]es, [N]o");
			System.out.print(">");
			String choice;
			choice = sc.nextLine();
			// kollar om man har skrivit yes eller åtmindstånde y, isåfall är svaret 1
			if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y"))
			{
				answer = 1;
				break;
			}
			// Skriver man no eller n blir svaret 0
			else if(choice.equalsIgnoreCase("no") || choice.equalsIgnoreCase("n"))
			{
				answer = 0;
				break;
			}
			// Skriver man något annat än yes,y,no,n så får man skriva om
		}
		return answer;
	}
	
	// Basic funktion för att skriva ut > symbolen och ta in input
	public static String input(String Question)
	{
		Lib.writed("\n" + Question);
		System.out.print(">");
		Scanner  sc = new Scanner(System.in);
		String text = sc.nextLine();
		return text;
	}
	
	// Ska vidareutvecklas, men idéen är typ att alla strider, folk som pratar med player och liknande ska vara events
	// och hämtas från en databas för enkelt kunna ändra hur spelet körs.
	public static void event(int id, String name)
	{
		if(id != 0)
		{
			System.out.println("Event nr: " + id);
		}
		else if (name != null)
		{
			System.out.println("Event name: " + name);
		}
		else
		{
			System.out.println("Invalid Event ID or Name!");
		}
	}
	
	// Funktion för att skicka POST-data till en hemsida, inte testad än.
	public void doSubmit(String url, Map<String, String> data) throws Exception {
		URL siteUrl = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) siteUrl.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		
		DataOutputStream out = new DataOutputStream(conn.getOutputStream());
		
		Set<String> keys = data.keySet();
		Iterator<String> keyIter = keys.iterator();
		String content = "";
		for(int i=0; keyIter.hasNext(); i++) {
			Object key = keyIter.next();
			if(i!=0) {
				content += "&";
			}
			content += key + "=" + URLEncoder.encode(data.get(key), "UTF-8");
		}
		System.out.println(content);
		out.writeBytes(content);
		out.flush();
		out.close();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line = "";
		while((line=in.readLine())!=null) {
			System.out.println(line);
		}
		in.close();
	}
	
	// Loginfunktion
	public static int Login(String username, String userpassword)
	{
		int id = 0;
		
		Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;
	        
		String url = "jdbc:mysql://server.snekabel.se/snekabel";
        String user = "pok";
        String password = "Pokemon1";
        
        try {
            
        	con = DriverManager.getConnection(url, user, password);
        	pst = con.prepareStatement("SELECT id FROM users WHERE nickname = '" + username + "' AND password = '" + userpassword + "'");
        	rs = pst.executeQuery();

        	while (rs.next()) {
        		id = rs.getInt(1);
        	}
        	
        } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Lib.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Lib.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
		return id;
	}
	
	// Funktion för 		//ArrayList<Integer> pokemon = new ArrayList<Integer>();att ladda en Pokémon från DB ägd av den trainer som loggat in
	public static void LoadPokemon(int Pokemon_id)
	{
		int[] stats = new int[5];
		int pokemonid = 0;
		String nickname = "";
		int level = 0;
		
		Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;
        
        try
        {
            
        	con = DriverManager.getConnection(url, user, password);
        	pst = con.prepareStatement("SELECT pokemonid,nickname,attack,defense,spatt,spdef,speed,level FROM Pokemons WHERE id = '" + Pokemon_id + "'");
        	rs = pst.executeQuery();
        	
        	while (rs.next())
        	{
        		pokemonid = rs.getInt(1);
        		nickname 	= rs.getString(2);
        		stats[0] 	= rs.getInt(3);
        		stats[1] 	= rs.getInt(4);
        		stats[2] 	= rs.getInt(5);
        		stats[3] 	= rs.getInt(6);
        		stats[4] 	= rs.getInt(7);
        		level 		= rs.getInt(8);
        	}
        	
        }        
        catch (SQLException ex)
        
        {
                Logger lgr = Logger.getLogger(Lib.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
        finally
        {

            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (pst != null)
                {
                    pst.close();
                }
                if (con != null)
                {
                    con.close();
                }

            }
            catch (SQLException ex)
            {
            	Logger lgr = Logger.getLogger(Lib.class.getName());
            	lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        if(pokemonid != 0 && nickname != null && level > 0)
        {
        	try {
    			RPG.pokemon.add(new Pokemon(pokemonid,nickname,level,0));
    		} catch (Fail e) {
    			e.printStackTrace();
    		}
        }
		
	}
	
	// Funktion för att ladda en Tränares data från DB
	public static void LoadTrainer(int Trainer_id)
		{
			String nickname = "";
			int type = 0;
			Connection con = null;
		    PreparedStatement pst = null;
		    ResultSet rs = null;
	        
	        try
	        {
	            
	        	con = DriverManager.getConnection(url, user, password);
	        	pst = con.prepareStatement("SELECT nick,type FROM Trainers WHERE trainers_id = '" + Trainer_id + "'");
	        	rs = pst.executeQuery();
	        	
	        	while (rs.next())
	        	{
	        		nickname = rs.getString(1);
	        		type = rs.getInt(2);
	        	}
	        	
	        }        
	        catch (SQLException ex)
	        
	        {
	                Logger lgr = Logger.getLogger(Lib.class.getName());
	                lgr.log(Level.SEVERE, ex.getMessage(), ex);

	        }
	        finally
	        {

	            try
	            {
	                if (rs != null)
	                {
	                    rs.close();
	                }
	                if (pst != null)
	                {
	                    pst.close();
	                }
	                if (con != null)
	                {
	                    con.close();
	                }

	            }
	            catch (SQLException ex)
	            {
	            	Logger lgr = Logger.getLogger(Lib.class.getName());
	            	lgr.log(Level.WARNING, ex.getMessage(), ex);
	            }
	        }
	        if(nickname != null)
	        {
	        	RPG.trainer.add(new Trainer(nickname, type, RPG.pokemon));
	        	Lib.write("yay");
	        }
			
		}
	
	// Funktion för att ladda lista med Pokémon en tränare äger
	public static void LoadPokemonList(int Trainer_id)
	{
		//ArrayList<Integer> pokemon = new ArrayList<Integer>();
		Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;
        
        try
        {
            
        	con = DriverManager.getConnection(url, user, password);
        	pst = con.prepareStatement("SELECT pokemonid,nickname,attack,defense,spatt,spdef,speed,level FROM Pokemons WHERE trainer = '" + Trainer_id + "'");
        	rs = pst.executeQuery();
        	while (rs.next())
        	{
                try {
            		RPG.pokemon.add(new Pokemon(rs.getInt(1),rs.getString(2),rs.getInt(8),0));
            	} catch (Fail e) {
            		e.printStackTrace();
            	}
        	}
        	
        }        
        catch (SQLException ex)
        
        {
                Logger lgr = Logger.getLogger(Lib.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        finally
        {

            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (pst != null)
                {
                    pst.close();
                }
                if (con != null)
                {
                    con.close();
                }

            }
            catch (SQLException ex)
            {
            	Logger lgr = Logger.getLogger(Lib.class.getName());
            	lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
		//return pokemon;
	}
	        
	// Funktion för att ladda in spel
	public static void LoadGame(int Trainer_id)
	{
		Lib.LoadTrainer(Trainer_id);
		Lib.LoadPokemonList(Trainer_id);
		
		//RPG.trainer[0] = new Trainer(RPG.username,0, RPG.pokemon);
		Lib.LoadTrainer(3);
		Lib.LoadPokemonList(3);
		
		//RPG.trainer[1] = new Trainer("Dick",1, RPG.pokemon);
		RPG.pokemon.get(0).showInfo();
		RPG.pokemon.get(1).showInfo();
		Battle.battle(0,1,0);
	}
}