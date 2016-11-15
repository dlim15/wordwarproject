package gameElementClasses;
public enum Item {
	BOMB, FREEZE, REPAIR, SHIELD, SPIDERWEB, EMPTY;
	
	public String toString(){
		switch (this){
		case BOMB:
			return "Mega Bomb";
		case FREEZE:
			return "Atomic Freezer";
		case REPAIR:
			return "Mechanical Repair Kit";
		case SHIELD:
			return "Gigawatt Shield";
		case SPIDERWEB:
			return "Titanium Spiderweb";
		case EMPTY:
			return "Empty"; 
		}
		return "";
	}
}
