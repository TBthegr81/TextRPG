package rpg;
public class Trainer {
private String name;
@SuppressWarnings("unused")
private String pkmnname;
private int type;
private Pokemon pokemons[]= new Pokemon[100];
//private Item bag[]= new Item[100];

	//Trainer(){}
	Trainer(String inName, int inType, Pokemon inPokemons[]){
		name = inName;
		type = inType;
		pokemons = inPokemons;
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
