package gameElementClasses;

public abstract class SpaceObject {
	protected String word;
	protected int hitPoints;
	protected int score;
	protected int movementPattern;
	//
	public SpaceObject(String word, int score, int movePattern){
		
		this.word = word;
		this.score = score;
		hitPoints = word.length();
		this.movementPattern = movePattern;
	}
	
	public String getWord(){
		return word;
	}
	public int getScore(boolean userCauseDefeat){
		if(!userCauseDefeat)
			return 0;
		return score;
	}
	public int getHitPoints(){
		return hitPoints;
	}
	
	public boolean isDead(){
		return hitPoints == 0;
	}
	
	public int getMovementPattern()
	{
		return this.movementPattern;
	}
	
	public void decrementHealth(){
		int i=0;
		
		while(i < word.length()){
			if(word.charAt(i) != '-'){
				word = word.substring(0, i) + '-' + word.substring(i+1);
				hitPoints--;
				break;
			}
			i++;
		}
	}
	
	public void applyItemEffect(Item item){
		if(item == Item.BOMB)
			bombItemEffect(67);
		
	}
	public char getNextChar(){
		int i=0;
		
		while(i < word.length()){
			if(word.charAt(i)== '-')
				i++;
			else{
				return word.charAt(i);
			}
		}
		return '-';	
		
		
	}
	protected void bombItemEffect(double percent){
		
		int damage = word.length() == 1 ? 1 : (int)(word.length() * (percent / 100));
		
		for(int i = 0; i < damage; i++){
			if(isDead())
				break;
			decrementHealth();
		}
	}
	
	public String toString(){
		String out =   "Word : " + getWord() + "\n" 
				+ "HitPoints : " + getHitPoints() + "\n"
				+ "Score : " + getScore(true) + "\n";
		return out;
	}

	
}
