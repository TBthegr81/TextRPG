package rpg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import rpg.Lib;

public class Comunication {
	static String url = "jdbc:mysql://server.snekabel.se/pokemonrpg2";
    static String user = "pok";
    static String password = "Pokemon1";
    
		// Funktion för att ladda listan med forumtrådar
		public static ArrayList<String> loadForumlist()
		{
			Connection con = null;
		    PreparedStatement pst = null;
		    ResultSet rs = null;
		    ArrayList<String> Answers = new ArrayList<String>();
	        
	        try {
	            
	        	con = DriverManager.getConnection(url, user, password);
	        	pst = con.prepareStatement("SELECT id,name FROM Forumlist");
	        	rs = pst.executeQuery();
	        	
	        	while (rs.next())
	        	{
	        		Answers.add(rs.getString(2));
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

	            } catch (SQLException ex)
	            {
	            	Logger lgr = Logger.getLogger(Lib.class.getName());
	            	lgr.log(Level.WARNING, ex.getMessage(), ex);
	            }
	    }
	return Answers;
	}
		
		public static void loadThread(int threadid)
		{
			//ArrayList<String> Posts = new ArrayList<String>();
			Connection con = null;
		    PreparedStatement pst = null;
		    ResultSet rs = null;
	        
	        try {
	            
	        	con = DriverManager.getConnection(url, user, password);
	        	pst = con.prepareStatement("SELECT whensaid,Trainers_id,text FROM Forum where forum = " + threadid);
	        	rs = pst.executeQuery();
	        	
	        	while (rs.next())
	        	{
	        		//Posts.add("Time: " + rs.getString(4) + " Comment: " + rs.getString(2));
	        		Lib.write(rs.getString(1) + " <" + loadTrainername(rs.getInt(2)) + "> " + rs.getString(3));
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

	            } catch (SQLException ex)
	            {
	            	Logger lgr = Logger.getLogger(Lib.class.getName());
	            	lgr.log(Level.WARNING, ex.getMessage(), ex);
	            }
	    }
			
			//return Posts;
	}
		
		public static void postForumComment(String text, int forumthread, int Trainer_id)
		{
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
		    
		    try {
		    	con = DriverManager.getConnection(url, user, password);
		    	pst = con.prepareStatement("INSERT INTO Forum(text,Trainers_id,wheresaid,hidden,forum,ip) VALUES(?,?,?,?,?,?)");
	            pst.setString(1, text);
	            pst.setInt(2, Trainer_id);
	            pst.setString(3, "In your face");
	            pst.setInt(4, 0);
	            pst.setInt(5, forumthread);
	            pst.setString(6, "192.168.0.1");
	            pst.executeUpdate();
		        	
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
	}
		
		public static String loadTrainername(int Trainer_id)
		{
			String Nickname = "";
			Connection con = null;
		    PreparedStatement pst = null;
		    ResultSet rs = null;
	        
	        try {
	            
	        	con = DriverManager.getConnection(url, user, password);
	        	pst = con.prepareStatement("SELECT nick FROM Trainers WHERE Trainers_id = " + Trainer_id);
	        	rs = pst.executeQuery();
	        	
	        	while (rs.next())
	        	{
	        		Nickname = rs.getString(1);
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

	            } catch (SQLException ex)
	            {
	            	Logger lgr = Logger.getLogger(Lib.class.getName());
	            	lgr.log(Level.WARNING, ex.getMessage(), ex);
	            }
	    }
			
		return Nickname;
	}
}
