package gameElementClasses;

import static org.junit.Assert.*;


import org.junit.Test;

public class SpaceshipTest {

	@Test
	public void test() {
		Spaceship spaceship = new Spaceship();
		spaceship.decrementHitPoints(5);
		assertEquals(spaceship.getHitPoints(), 95);
		spaceship.applyItemEffect(Item.SHIELD);
		spaceship.decrementHitPoints(5);
		assertNotEquals(spaceship.getHitPoints(), 90);
		try {
			Thread.sleep(11000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		spaceship.decrementHitPoints(5);
		assertEquals(spaceship.getHitPoints(), 90);
		spaceship.decrementHitPoints(5);
		assertEquals(spaceship.getHitPoints(), 85);
		spaceship.decrementHitPoints(5);
		assertEquals(spaceship.getHitPoints(), 80);
		spaceship.decrementHitPoints(5);
		assertEquals(spaceship.getHitPoints(), 75);
		spaceship.applyItemEffect(Item.REPAIR);
		assertEquals(spaceship.getHitPoints(), 100);
	}

}
