/*package rpg;

import java.util.ArrayList;

public class Trainer2 {
private String name;
@SuppressWarnings("unused")
private String pkmnname;
private int type;
private Pokemon pokemons[]= new Pokemon[100];
private ArrayList<Pokemon> pokemon;
//private Item bag[]= new Item[100];

	//Trainer(){}
	Trainer2(String inName, int inType, Pokemon inPokemons){
		name = inName;
		type = inType;
		pokemon = inPokemons;
	}
	public void showInfo(int trainernr){
		System.out.println(name + "\ntype: "+type + "\nPokemons: ");
		for(int i1=0; i1< pokemons.length; i1++)
		{
			try{
			if (pokemons[i1].getOwner()==trainernr)System.out.println(pokemons[i1].getName());
			
			}
			catch(Exception ex){}
		}
	}
	
	public String returnname(){
		return name;
	}
}
*/
