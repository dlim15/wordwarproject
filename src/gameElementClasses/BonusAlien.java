package gameElementClasses;

public class BonusAlien extends SpaceObject{
	private Item carriedItem;
	//
	public BonusAlien(String word, int score, Item item, int movePattern){
		super(word, score, movePattern);
		setItem(item);
	}
	public void setItem(Item item){
		carriedItem = item;
	}
	public Item getItem(){
		return carriedItem;
	}
	public String toString(){
		String out = super.toString();
		out += "Carried Item : " + carriedItem + "\n";
		
		return out;
	}
	/****** Some test functions of this class : ********/
	/*
	public static void main(String[] args) {
		BonusAlien bAlien = new BonusAlien("aaa", 200, 200, 100, Item.BOMB);
		
		System.out.println(bAlien);
		
	}
	*/
}
