package rpg;

import java.util.Scanner;

public class Battle {

	public static void battle(int player1, int player2, int type)
	{
		Scanner sc = new Scanner(System.in);
		Screen s = new Screen();
		//ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>(Arrays.asList(pk));
		
		int battletype=type;
		int rounds = 0;
		System.out.println("New Battle!\n"+ RPG.trainer.get(0).returnname() + " VS " + RPG.trainer.get(1).returnname());
		boolean battle = true;
		while(battle){
			s.drawWorld();
			rounds++;
			System.out.println("\nRound: " + rounds);
			// Alternativen man har i början av sin runda. Fight låter en attackera
			// Items listar de items man kan använda
			// PKMN listar de andra Pokémon man har med sig och kan byta till
			// Run försöker fly från striden. Funkar inte mot andra tränare
			int command = Lib.choice("", new String[]{"Fight","Items","PKMN","Run"}, 0);
			
			switch(command)
			{
				// Listar de Attackerna man har
				case 1: int attack = Lib.choice("Your attacks:", RPG.trainer.get(0).pokemon.get(0).getAttacks(), 0);
				// Kallar på funktionen som ska skada motståndaren
				damage(attack);
				break;
				// Listar de items man har. Kommer sen när databas funkar bättre
				case 2: System.out.println("You dont have any items");
				break;
				// Listar de Pokémon man har med sig, kommer sen med databas
				case 3: System.out.println("You only have 1 Pokémon");
				break;
				// Försöker fly, kollar om battletype är trainer battle eller annat. Går inte att fly från tränare
				case 4:
						if(battletype >= 0)
						{
							System.out.println("You ran away, chicken");
							battle = false;
						}
						else
						{
							System.out.println("No running from a trainer battle!");
						}
				break;
			}

		}
		sc.close();
	}
	
	// Funktion som ska skada motståndaren
	private static void damage(int attack)
	{
		System.out.println(RPG.trainer.get(0).pokemon.get(0).getName() + " attacks " + RPG.trainer.get(1).pokemon.get(0).getName() + " with " + RPG.trainer.get(0).pokemon.get(0).getAttack(attack));
		// Försöker räkna ut damage baserat på stats. Attackerande pokemonen attack gånger 2 delat i försvarande
		// Pokémons defense
		int damage = RPG.trainer.get(0).pokemon.get(0).getStats()[1] * 2 / RPG.trainer.get(1).pokemon.get(0).getStats()[2];
		if(damage <= 0)
		{
			damage = 1;
		}
		System.out.print("Damage:" + damage);
	}
}
