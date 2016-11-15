package gameElementClasses;

import java.util.Timer;
import java.util.TimerTask;

public class Spaceship {
	final private int MAXHITPOINT=100;
	private int hitPoints;
	private boolean invulnerable;
	private TimerTask task;
	
	public Spaceship(){
		hitPoints = MAXHITPOINT;
		invulnerable = false;
	}
	public boolean isDestroyed(){
		return hitPoints == 0;
	}
	
	public int getHitPoints(){
		return hitPoints;
	}
	
	public void setInvulnerable(){
		invulnerable = true;
		setVulnerable(10000);
	}
	public void setVulnerable(int msec){
		Timer temp = new Timer();
		temp.schedule(new TimerTask() {
			
			@Override
			public void run() {
				temp.cancel();
				try {
					Thread.sleep(msec);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				invulnerable = false;
			}
		}, 0);
		
	}
	public boolean isInvulnerable(){
		return invulnerable;
	}
	public boolean getVulnerable()
	{
		return this.invulnerable;
	}
	public void setHitPoints(int num){
		hitPoints = num;
	}
	public void decrementHitPoints(int num){
		if(!invulnerable)
			hitPoints -= num;
		if (hitPoints < 0){
			hitPoints = 0;
		}
	}
	public void incrementHitPoints(int num){
		hitPoints += num;
		if (hitPoints > MAXHITPOINT)
		{
			hitPoints = MAXHITPOINT;
		}
	}
	public void attack(SpaceObject alien){
		alien.decrementHealth();
	}
	public void applyItemEffect(Item item){
		switch(item){
		case REPAIR:
			incrementHitPoints(25);
			break;
		case SHIELD:
			setInvulnerable();
			break;
		default:
			break;
		}
	}
	
	/****** Some test functions of this class : ********/
	/*
	public static void main(String[] args) {
		Spaceship ship = new Spaceship();
		BonusAlien bAlien = new BonusAlien("bbbbb", 200, 200, 100, Item.BOMB);
		
		while(true){
			ship.attack(bAlien);
			System.out.println(bAlien);
			
			if(bAlien.isDead()){
				ship.addItem(bAlien.getItem());
				break;
			}
		}
		ship.printItem();
		BonusAlien fAlien = new BonusAlien("ffffff", 200, 200, 100, Item.FREEZE);
		BonusAlien sAlien = new BonusAlien("sssss", 200, 200, 100, Item.SPIDERWEB);
		BonusAlien rAlien = new BonusAlien("rrrrrrr", 200, 200, 100, Item.REPAIR);
		while(true){
			ship.attack(fAlien);
			System.out.println(fAlien);
			
			if(fAlien.isDead()){
				ship.addItem(fAlien.getItem());
				break;
			}
		}
		ship.printItem();
		while(true){
			ship.attack(sAlien);
			System.out.println(sAlien);
			
			if(sAlien.isDead()){
				ship.addItem(sAlien.getItem());
				break;
			}
		}
		ship.printItem();
		while(true){
			ship.attack(rAlien);
			System.out.println(rAlien);
			
			if(rAlien.isDead()){
				ship.addItem(rAlien.getItem());
				break;
			}
		}
		ship.printItem();
		
		MinionAlien mAlien = new MinionAlien("Minion", 200, 100, 200, 1);
		
		mAlien.applyItemEffect(ship.useItem(0));
		System.out.println("After using bomb \n: " + mAlien);
		mAlien.applyItemEffect(ship.useItem(1));
		System.out.println("After using Freeze \n: " + mAlien);
		mAlien.backToOriginal();
		System.out.println("After 5 seconds : \n" + mAlien);
		mAlien.applyItemEffect(ship.useItem(2));
		System.out.println(mAlien.toString());
		mAlien.backToOriginal();
		System.out.println("After 5 seconds :\n: " + mAlien);
	}
	*/
}

