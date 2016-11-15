package gameElementClasses;

import static org.junit.Assert.*;

import org.junit.Test;

public class BonusAlienTest {

	@Test
	public void test() {
		BonusAlien alien = new BonusAlien("test", 20, Item.BOMB, 2);
		assertFalse(alien.isDead());
		alien.decrementHealth();
		assertFalse(alien.isDead());
		alien.decrementHealth();
		assertFalse(alien.isDead());
		alien.decrementHealth();
		assertFalse(alien.isDead());
		alien.decrementHealth();
		assertTrue(alien.isDead());
		
		BonusAlien alien2 = new BonusAlien("test123", 20, Item.BOMB, 2);
		assertFalse(alien2.isDead());
		alien2.applyItemEffect(Item.BOMB);
		assertFalse(alien2.isDead());
		alien2.applyItemEffect(Item.BOMB);
		assertTrue(alien2.isDead());
		
		BonusAlien alien3 = new BonusAlien("test1234", 20, Item.BOMB, 2);
		assertEquals(alien3.getScore(true), 20);
		assertEquals(alien3.getScore(false), 0);
		assertEquals(alien3.getHitPoints(), 8);
		assertEquals(alien3.getItem(), Item.BOMB);
		assertNotEquals(alien3.getItem(), Item.EMPTY);
		assertEquals(alien3.getWord(), "test1234");
		assertNotEquals(alien3.getWord(), "121");
		
	}

}
