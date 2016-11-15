package gameElementClasses;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {

	@Test
	public void test() {
		assertEquals(Item.BOMB.toString(),"Mega Bomb");
		assertEquals(Item.FREEZE.toString(),"Atomic Freezer");
		assertEquals(Item.REPAIR.toString(),"Mechanical Repair Kit");
		assertEquals(Item.SHIELD.toString(),"Gigawatt Shield");
		assertEquals(Item.SPIDERWEB.toString(),"Titanium Spiderweb");
		
	}

}
