package rpg;

import java.util.ArrayList;

public class Trainer {
private String name;
@SuppressWarnings("unused")
private String pkmnname;
private int type;
//private Pokemon pokemons[]= new Pokemon[100];
private ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
//private Item bag[]= new Item[100];

	//Trainer(){}
	Trainer(String inName, int inType, ArrayList<Pokemon> inPokemons){
		name = inName;
		type = inType;
		pokemon = inPokemons;
	}
	public void showInfo(int trainernr){
		System.out.println(name + "\ntype: "+type + "\nPokemons: ");
		for(int i1=0; i1< pokemon.size(); i1++)
		{
			try{
			if (pokemon.get(i1).getOwner()==trainernr)System.out.println(pokemon.get(i1).getName());
			
			}
			catch(Exception ex){}
		}
	}
	
	public String returnname(){
		return name;
	}
}
