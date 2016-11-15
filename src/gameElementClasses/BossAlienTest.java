package gameElementClasses;

import static org.junit.Assert.*;

import org.junit.Test;

public class BossAlienTest {

	@Test
	public void test() {
		String paragraph = "yes 1234 okay what now hwahahah lkasfnasknflas laksnfasdfkln asldnf alsasdf as fsaf asf as fasf asf asfd asdf asfa";
		BossAlien bossAlien = new BossAlien(paragraph, 4000, 4);
		
		assertEquals(bossAlien.getHitPoints(), paragraph.length());
		assertEquals(bossAlien.getNextChar(), 'y');
		assertNotEquals(bossAlien.getNextChar(), 'e');
		bossAlien.decrementHealth();
		assertEquals(bossAlien.getNextChar(), 'e');
		
		
		bossAlien.applyItemEffect(Item.BOMB);
		assertEquals(bossAlien.getWord(),"-----------------------------ah lkasfnasknflas laksnfasdfkln asldnf alsasdf as fsaf asf as fasf asf asfd asdf asfa");
		assertNotEquals(bossAlien.getNextChar(),'h');
		assertEquals(bossAlien.getNextChar(),'a');
		
		assertEquals(bossAlien.getLineOfParagraph(0),("-----------------------------ah lkasfnasknflas laksnfasdfkln asldnf alsasdf as fsaf asf"));
		assertEquals(bossAlien.getLineOfParagraph(1),(" as fasf asf asfd asdf asfa"));
		
		assertTrue(bossAlien.isProjectileEmpty());
		bossAlien.generateProjectile();
		assertFalse(bossAlien.isProjectileEmpty());
		bossAlien.shootProjectile();
		assertFalse(bossAlien.isProjectileEmpty());
		while(!bossAlien.isProjectileEmpty())
			bossAlien.shootProjectile();
		assertTrue(bossAlien.isProjectileEmpty());
		
		
		
	}

}
