package gameClasses;

import static org.junit.Assert.*;

import org.junit.Test;

import gameElementClasses.MinionAlien;
import importClasses.WordList;

public class GameTest {

	@Test
	public void test() {
		WordList list = new WordList();
		list.addWord(0, "aa");
		list.addWord(0, "ab");
		list.addWord(0, "ac");
		list.addWord(0, "ad");
		list.addWord(1, "aaa");
		list.addWord(1, "bbb");
		list.addWord(1, "ccc");
		list.addWord(1, "ddd");
		list.addParagraph("Hello i am testing this out!");
		list.addParagraph("Hello i am testing this out@@@@!");
		list.addParagraph("Hello i am testing this out!234");
		list.addParagraph("Hello i am testing this out@@@234@!");
		list.addParagraph("Hello i am testing this out526!");
		list.addParagraph("Hello i am testing this out@@@236@!");
		Game game = new Game(5, 1, 0, list);
		game.spawnObject();
		assertNotNull(game.getAlien(0));
		assertEquals(game.spawnObject(), 0);
		assertNotEquals(game.spawnObject(), 1);
		MinionAlien m = game.getAlien(0);
		System.out.println(m);
		assertNotEquals(game.shipAttackAlien(m, 0, 'a'), 1);
		assertEquals(game.shipAttackAlien(m, 0, 'e'), -1);
		System.out.println(m);
		game.alienAttackShip(m.getDamage());
		assertEquals(game.getSpaceship().getHitPoints(), 92);
		assertFalse(game.gameOver());
		for(int i=0; i<11; i++){
			game.alienAttackShip(m.getDamage());
			assertFalse(game.gameOver());
		}
		System.out.println(game.getSpaceship().getHitPoints());
		game.alienAttackShip(m.getDamage());
		assertTrue(game.gameOver());
		
		
		
		
	}

}
