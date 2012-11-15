package rpg;

import java.util.Scanner;

public class Battle {

	public static void battle(int player1, int player2, Trainer tr[], int type, Pokemon pk[])
	{
		Scanner sc = new Scanner(System.in);
		int battletype=type;
		int rounds = 0;
		System.out.println("New Battle!\n"+ tr[player1].returnname() + " VS " + tr[player2].returnname());
		boolean battle = true;
		while(battle){
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
				case 1: System.out.println("Your attacks:");
				for(int i = 0; i < 4; i++)
				{
					if(pk[0].getAttacks(i) != null)
					{
						System.out.print("[" + i + "]" + pk[0].getAttacks(i));
					}
				}
				int attack = sc.nextInt();
				// Kallar på funktionen som ska skada motståndaren
				damage(pk, attack);
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
	}
	
	// Funktion som ska skada motståndaren
	private static void damage(Pokemon pk[], int attack)
	{
		System.out.println( pk[0].getName() + " attacks " + pk[1].getName() + " with " + pk[1].getAttacks(attack));
		// Försöker räkna ut damage baserat på stats. Attackerande pokemonen attack gånger 2 delat i försvarande
		// Pokémons defense
		int damage = pk[0].getStats()[1] * 2 / pk[1].getStats()[2];
		if(damage <= 0)
		{
			damage = 1;
		}
		System.out.print("Damage:" + damage);
	}
}
