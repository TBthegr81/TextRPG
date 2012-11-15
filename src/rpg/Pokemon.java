package rpg;
public class Pokemon{
	// De flesta variabler här kommer få mer användning när databasen sen funkar och jag kan smidigt lagra dem
private String name;
private int pkmnnr;
private int owner;
private int lvl;
private int stats[] = new int[5];
private int xp;
private int maxxp;
private String attacks[] = new String[4];

	Pokemon(){}
	Pokemon(int inpkmnr, String inName, int inLvl, int inOwner){
		pkmnnr = inpkmnr;
		name = inName;
		lvl = inLvl;
		owner = inOwner;
		// stats randomas mellan 0 och 20, kommer bli olika sen beroende på lv/vilken pokemon och annat
		stats[0] = (int)Math.round(Math.random()*20); //HP
		stats[1] = (int)Math.round(Math.random()*20); //Attack
		stats[2] = (int)Math.round(Math.random()*20); //Defense
		stats[3] = (int)Math.round(Math.random()*20); //Speed
		stats[4] = (int)Math.round(Math.random()*20); //Special
		attacks[0] = "Tackle";
		attacks[1] = "Growl";
	}
	// printar namn, level, stats och såntdär.
	public void showInfo(){
		System.out.println(name + "\nLevel: "+lvl + "\nHP: " + stats[0] + "\nAttack: " + stats[1] + "\nDefense: " + stats[2] + "\nSpeed: " + stats[3] + "\nSpecial: " + stats[4] + "\n");
	}
	// Ger tillbaka namnet
	public String getName(){
	return name;
	}
	
	// Ger tillbaka vilken trainer som har denna Pokémon
	public int getOwner(){
	return owner;
	}
	
	// Ger tillbaka array med attacker
	public String getAttacks(int id){
		return attacks[id];
	}
	
	// Ska plussa på XP, gör det inte än.
	public void xpgain(int gainedxp) {
		System.out.println(gainedxp);
	}
	
	// Ger tillabaka alla stats
	public int[] getStats()
	{
		return stats;
	}
}
