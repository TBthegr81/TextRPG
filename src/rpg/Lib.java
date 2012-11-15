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
	public static int choice(String question, String choices[], int rightAnswer)
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
	
	// Funktion för att köra MySQL Querry, används inte
	public static String[] LoadPokemon(int id)
	{
		Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;
	    String[] Answers = new String[40];
	        
		String url = "jdbc:mysql://";
        String user = "";
        String password = "";
        
        try {
            
        	con = DriverManager.getConnection(url, user, password);
        	pst = con.prepareStatement("SELECT * FROM Pokemons WHERE id =" + id);
        	rs = pst.executeQuery();
        	
        	java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();

            int numberOfColumns = rsMetaData.getColumnCount();
            System.out.println("Number of columns:" + numberOfColumns);
        	while (rs.next()) {
        		for(int i =1; i <= numberOfColumns; i++)
        		{
        			Answers[i] = rs.getString(i);
        			//System.out.println(i);
        			//System.out.println(rs.getString(i));
        			//System.out.println(rsMetaData.getColumnType(i));
        		}
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
        return Answers;
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
}
