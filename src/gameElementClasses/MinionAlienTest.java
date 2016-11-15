package gameElementClasses;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinionAlienTest {

	@Test
	public void test() {
		MinionAlien minionAlien = new MinionAlien("abc", 20, 5, 3);
		assertEquals(minionAlien.getDamage(), 5);
		assertEquals(minionAlien.getNextChar(), 'a');
		minionAlien.decrementHealth();
		assertNotEquals(minionAlien.getNextChar(), 'a');
		assertEquals(minionAlien.getNextChar(), 'b');
		
		MinionAlien minionAlien2 = new MinionAlien("a", 20, 5, 3);
		assertFalse(minionAlien2.isDead());
		minionAlien2.applyItemEffect(Item.BOMB);
		assertTrue(minionAlien2.isDead());
	}

}
