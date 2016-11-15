
package gameClasses;
import java.util.Random;

import javax.print.attribute.Size2DSyntax;

import org.hamcrest.core.IsInstanceOf;

import acm.graphics.GObject;
import importClasses.*;

import java.awt.List;
import java.util.ArrayList;

import gameElementClasses.*;
import gameElementClasses.*;

public class Game {
	private Spaceship ship;
	WordList wordList;
	private ArrayList<MinionAlien> minions;
	private ArrayList<BonusAlien> bonus;
	private BossAlien boss;
	private boolean isBossThere;
	private ArrayList<Item> items;
	private int powerupsThisLevel;
	private int level;
	private int numSpawnAlienCap;
	private int numAlienCount;
	private Random rand;
	private final int MOVING_VARIATIONS = 4;
	
	public Game(int numAliensThisWave, int levelNum, int powerups, WordList words)
	{
		setBossThere(false);
		wordList = words;
		level = levelNum;
		rand = new Random();
		initializeSpaceObjects();
		createSpaceship();
		items = new ArrayList<Item>();
		numSpawnAlienCap = numAliensThisWave;
		powerupsThisLevel = powerups;
		
		wordList.generateWords(levelNum, numAliensThisWave);
	}
	private void initializeSpaceObjects(){
		minions = new ArrayList<MinionAlien>();
		bonus = new ArrayList<BonusAlien>();
		boss = new BossAlien(wordList.getParagraph((level-1)*5 + rand.nextInt(5)), 2000, level);
	}
	public void incrementLevel()
	{
		++level;
	}
	public Item getUserItem(int index){
		if (items.size() <= index)
			return Item.EMPTY;
		return items.get(index);
	}
	public Item addItem(int index, boolean b)
	{
		if (items.size() < 3 && b)
		{
			items.add(bonus.get(index).getItem());
			removeBonus(index);
			return items.get(items.size() - 1);
			
		}
		else
		{
			removeBonus(index);
			return Item.EMPTY;
		}
		
		
	}
	
	public void useItem(int nth)
	{
		if(!items.isEmpty() && items.size() >= nth){
			Item earnedItem = items.remove(nth-1);
			
			
			if (earnedItem == Item.REPAIR || earnedItem == Item.SHIELD && !ship.getVulnerable()){
				ship.applyItemEffect(earnedItem);
			}
			else if(earnedItem == Item.BOMB){
				for(int i=0; i<minions.size(); i++)
					minions.get(i).applyItemEffect(earnedItem);
				for(int i=0; i<bonus.size(); i++)
					bonus.get(i).applyItemEffect(earnedItem);
				if (isBossThere)
				{
					boss.applyItemEffect(earnedItem);
				}
			}
		}
	}
	
	public int spawnObject()
	{
		++numAlienCount;
		if (powerupsThisLevel >= 1 && numSpawnAlienCap - numAlienCount > 1 && rand.nextInt(numSpawnAlienCap - numAlienCount) == 0)
		{
			return spawnBonusAlien();
		}
		return spawnMinionAlien();
	}

	private int spawnMinionAlien() {
		MinionAlien temp = new MinionAlien(wordList.getWord(), 100, 8, rand.nextInt(MOVING_VARIATIONS));
		minions.add(temp);
		return 0;
	}

	private int spawnBonusAlien() {
		--powerupsThisLevel;
		bonus.add(new BonusAlien(wordList.getWord(), 100, getItem(rand.nextInt(5)), rand.nextInt(MOVING_VARIATIONS)));
		return 1;
	}
	
	
	private Item getItem(int num){
		switch (num){
		case 0: 
			return Item.BOMB;
		case 1:
			return Item.FREEZE;
		case 2:
			return Item.REPAIR;
		case 3:
			return Item.SHIELD;
		case 4:
			return Item.SPIDERWEB;
		default:
			return Item.EMPTY; 
		}
	}
	public int shipAttackAlien(SpaceObject obj, int index, char typed)
	{
		SpaceObject temp;
		if (obj instanceof MinionAlien)
		{
			temp = minions.get(index);
		}
		else if(obj instanceof BonusAlien)
		{
			temp = bonus.get(index);
		}
		else
		{
			temp = boss;
		}
		if(typed == temp.getNextChar()){
			temp.decrementHealth();
		}
		else{
			return -1;
		}
			
		return temp.isDead() ? 1:0;
	}
	
	public void removeAlien(int index)
	{
		minions.remove(index);
	}
	
	public void removeBonus(int index){
		bonus.remove(index);
	}
	
	public void removeBoss(){
		while(!boss.isProjectileEmpty())
			boss.shootProjectile();
		setBossThere(false);
	}
	
	public void alienAttackShip(int num)
	{
		ship.decrementHitPoints(num);
	}
	
	public void createSpaceship()
	{
		ship = new Spaceship();
	}
	
	public boolean gameOver()
	{
		return ship.isDestroyed();
	}

	
	public MinionAlien getAlien(int index)
	{
		return minions.get(index);
	}
	
	public BonusAlien getBonus(int index)
	{
		return bonus.get(index);
	}
	
	public BossAlien getBoss(){
		return boss;
	}
	
	public void prepareProjectile(){
		boss.generateProjectile();
		
	}
	
	public boolean isProjectileReady(){
		return !boss.isProjectileEmpty();
	}
	public void loadProjectile(){
			minions.add(boss.shootProjectile());
	}
	public void setCoordinates(int xCoord, int yCoord, int index)
	{
		MinionAlien temp = getAlien(index);
		minions.set(index, temp);
	}

	public int getNumAlienCount() {
		return numAlienCount;
	}

	public void setNumAlienCount(int numAlienCount) {
		this.numAlienCount = numAlienCount;
	}

	public int getNumSpawnAlienCap() {
		return numSpawnAlienCap;
	}

	public void setNumSpawnAlienCap(int numSpawnAlienCap) {
		this.numSpawnAlienCap = numSpawnAlienCap;
	}
	
	public ArrayList<Item> getItemList()
	{
		return items;
	}
	
	public void setItemList(ArrayList<Item> itemList)
	{
		items = itemList;
	}
	
	public Spaceship getSpaceship()
	{
		return ship;
	}
	
	public void setSpaceship(Spaceship s)
	{
		ship = s;
	}
	public boolean isSpaceInvulnerable(){
		return ship.isInvulnerable();
	}
	public boolean isBossThere() {
		return isBossThere;
	}
	public void setBossThere(boolean isBossThere) {
		this.isBossThere = isBossThere;
	}
}
