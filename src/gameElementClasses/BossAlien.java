package gameElementClasses;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

public class BossAlien extends SpaceObject{
	final static int MAX_CHAR_PER_LINE=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/22;
	private int difficulty;
	private ArrayList<MinionAlien> projectile;
	private Random random;
	private ArrayList<String> lines;
	private int numProjectile;
	private final int MOVING_VARIATIONS = 3;
	
	public BossAlien(String paragraph, int score, int level){
		super(paragraph, score, -1);
		random = new Random();
		projectile = new ArrayList<MinionAlien>();
		difficulty = (int)Math.ceil((double)level/5);
		difficulty = difficulty > 4 ? 4 : difficulty;
		lines = new ArrayList<String>();
		generateLinesOfParagraph();
		numProjectile = 8;
	}
	public boolean isProjectileEmpty(){
		return projectile.isEmpty();
	}
	
	public MinionAlien shootProjectile(){
		return projectile.remove(0);
	}
	public int getNumLineForParagraph(){
		return (int)Math.ceil((double)word.length() / MAX_CHAR_PER_LINE);
	}
	private void generateLinesOfParagraph(){
		for(int i=0; i<getNumLineForParagraph(); i++){
			if(i != getNumLineForParagraph() - 1)
				lines.add(word.substring(i*MAX_CHAR_PER_LINE, i*MAX_CHAR_PER_LINE + MAX_CHAR_PER_LINE));
			else
				lines.add(word.substring(i*MAX_CHAR_PER_LINE));
		}
	}
	private void updateLinesOfParagraph(){
		for(int i=0; i<getNumLineForParagraph(); i++){
			if(i != getNumLineForParagraph() - 1)
				lines.set(i, word.substring(i*MAX_CHAR_PER_LINE, i*MAX_CHAR_PER_LINE + MAX_CHAR_PER_LINE));
			else
				lines.set(i, word.substring(i*MAX_CHAR_PER_LINE));
		}
	}
	public String getLineOfParagraph(int lineNum){
		updateLinesOfParagraph();
		return lines.get(lineNum);
	}
	public void generateProjectile(){
		
		for(int i=0; i<numProjectile; i++){
			projectile.add(new MinionAlien(generateRandomChars(), 0, 5, 1));
		}
	}
	public int getProjectileNumber(){
		return numProjectile;
	}
	public void applyItemEffect(Item item){
		if(item == Item.BOMB)
			bombItemEffect(25);
	}
	private String generateRandomChars(){
		String chars = "";
		
		for(int i=0; i<difficulty; i++){
			chars += (char)(random.nextInt(26) + 'a');
		}
		
		return chars;
	}
	
	/****** Some test functions of this class : ********/
	/*
	public static void main(String[] args) {
		BossAlien boss = new BossAlien("abcde", 200, 100, 200, 10);
		boss.generateProjectile();
		
		while(!boss.isProjectileEmpty()){
			System.out.println(boss.shootProjectile().getWord());
		}
		
		boss.generateProjectile();
		
		while(!boss.isProjectileEmpty()){
			System.out.println(boss.shootProjectile().getWord());
		}
		
	}
	*/
}
