package importClasses;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordListTest {

	@Test
	public void test() {
		WordList list = new WordList();
		list.addWord(0, "aa");
		list.addWord(0, "bb");
		list.addWord(0, "cc");
		list.addWord(0, "dd");

		list.addWord(1, "aaa");
		list.addWord(1, "bbb");
		list.addWord(1, "ccc");
		list.addWord(1, "ddd");
		
		list.addWord(2, "aaaa");
		list.addWord(2, "bbbb");
		list.addWord(2, "cccc");
		list.addWord(2, "dddd");
		
		list.generateWords(0, 1);
		System.out.println(list.getWord());
		assertTrue(list.isWordListEmpty());
		
		list.generateWords(3, 4);
		for(int i=0; i<3; i++){
			System.out.println(list.getWord());
			assertFalse(list.isWordListEmpty());
		}
		System.out.println(list.getWord());
		assertTrue(list.isWordListEmpty());
		
		list.addParagraph("Hello i am testing this out!");
		assertEquals(list.getParagraph(0), "Hello i am testing this out!");
		System.out.println(list.getParagraph(30));
	}

}
