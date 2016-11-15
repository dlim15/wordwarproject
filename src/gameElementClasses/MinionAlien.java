package gameElementClasses;

public class MinionAlien extends SpaceObject {
	private int damage;
	//
	public MinionAlien(String word, int score, int damage, int movePattern){
		super(word,score, movePattern);
		setDamage(damage);
	}
	public void setDamage(int damage){
		this.damage = damage;
	}
	public int getDamage(){
		return damage;
	}
	public void attack(Spaceship ship){
		ship.decrementHitPoints(damage);
	}
	public String toString(){
		String out = super.toString();
		out += "Damage : " + getDamage() + "\n";
		
		return out;
	}
	/****** Some test functions of this class : ********/
	/*
	public static void main(String[] args) {
		MinionAlien mAlien = new MinionAlien("--34567890", 100, 1);
		System.out.println(mAlien.getWord());
		System.out.println(mAlien.getNextChar());
		
		mAlien.applyItemEffect(Item.BOMB);
		System.out.println(mAlien.getWord());
	}
	*/
	
}
