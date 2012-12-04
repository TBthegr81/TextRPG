package rpg;
public class Pokemon{
	// De flesta variabler här kommer få mer användning när databasen sen funkar och jag kan smidigt lagra dem
private String name;
private int pkmnnr;
private int owner;
private int lvl;
private int stats[] = new int[6];
private int xp;
private int maxxp;
private String attacks[] = new String[4];

	//Pokemon(){}
	Pokemon(int inpkmnr, String inName, int inLvl, int inOwner, int[] instats) throws Fail{
		pkmnnr = inpkmnr;
		if(pkmnnr >= 1 && pkmnnr <= 649)
		{
		stats = instats;
		name = inName;
		lvl = inLvl;
		owner = inOwner;
		// stats randomas mellan 0 och 20, kommer bli olika sen beroende på lv/vilken pokemon och annat
		if(stats[0] == 0)
		stats[0] = (int)Math.round(Math.random()*20); //HP
		if(stats[1] == 0)
		stats[1] = (int)Math.round(Math.random()*20); //Attack
		if(stats[2] == 0)
		stats[2] = (int)Math.round(Math.random()*20); //Defense
		if(stats[3] == 0)
		stats[3] = (int)Math.round(Math.random()*20); //Speed
		if(stats[4] == 0)
		stats[4] = (int)Math.round(Math.random()*20); //SpecialAttack
		if(stats[5] == 0)
		stats[5] = (int)Math.round(Math.random()*20); //SpecialDefense
		attacks[0] = "Tackle";
		attacks[1] = "Growl";
		xp = 1;
		maxxp = 50;
		}
		else
		{
			throw new Fail("Number is not valid Pokémon");
		}
	}
	// printar namn, level, stats och såntdär.
	public void showInfo(){
		System.out.println(name + "\nLevel: "+lvl + "\nHP: " + stats[0] + "\nAttack: " + stats[1] + "\nDefense: " + stats[2] + "\nSpeed: " + stats[3] + "\nSpecialAttack: " + stats[4] + "\nSpecialDefense: " + stats[5] + "\n");
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
	public String[] getAttacks(){
		return attacks;
	}
	
	// Ger tillbaka namnet på en attack via dess id
		public String getAttack(int id){
			return attacks[id];
		}
	
	// Ska plussa på XP, gör det inte än.
	public void xpgain(int gainedxp) {
		System.out.println(gainedxp);
	}
	
	// Ger tillabaka alla stats
	public int[] getStats2()
	{
		return stats;
	}
	
	public int getXP()
	{
		return xp;
	}
	
	public int getMaxXP()
	{
		return maxxp;
	}
	
	public int getPkmnNr()
	{
		return pkmnnr;
	}
	
	public int[] getStats()
	{
		int enarray[] = new  int[6];
		enarray[0] = lvl;
		enarray[1] = stats[0];
		enarray[2] = stats[1];
		enarray[3] = stats[2];
		enarray[4] = stats[3];
		enarray[5] = stats[4];
		
		return enarray;
	}
}
