package importClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.hamcrest.core.IsInstanceOf;

public class WordList {
	ArrayList<ArrayList<String>> listStorage;
	ArrayList<String> wordsPerStage;
	ArrayList<String> paragraphStorage;
	int level;
	Random random;
	private final static int MAX_LENGTH_OF_WORD = 20;
	
	public WordList(){
		level = 0;
		listStorage =  new ArrayList<ArrayList<String>>();
		for(int i=0; i<MAX_LENGTH_OF_WORD; i++){
			listStorage.add(new ArrayList<String>());
		}
		wordsPerStage = new ArrayList<String>();
		paragraphStorage = new ArrayList<String>();
		random = new Random();
	}
	public void addWord(int row, String word){
		listStorage.get(row).add(word);
	}
	public void addParagraph(String paragraph){
		paragraphStorage.add(paragraph);
	}
	public ArrayList<ArrayList<String>> getList(){
		return listStorage;
	}
	public void generateWords(int stage, int numWord){
		wordsPerStage.clear();
		if(stage % 2 == 1)
			level = level != 17 ? level + 1 : level;
		
		int remain = numWord;
		for(int i=0; i<level; i++){
			for(int j=0; j< (int)Math.round(0.5 / level * numWord); j++){
				wordsPerStage.add(getFromStorage(i));
				remain--;
			}
		}
		String newWord;
		while(remain != 0){
			newWord = getFromStorage(level);
			if(!duplicateCheck(newWord)){
				wordsPerStage.add(newWord);
				remain--;
			}
				
		}
	}
	private boolean duplicateCheck(String word){
		return wordsPerStage.contains(word); 
	}
	
	public boolean isParagraphEmpty(int lev){
		return lev > paragraphStorage.size();
	}
	public String getParagraph(int lev){
		if(!isParagraphEmpty(lev))
			return paragraphStorage.get(lev);
		return generateRandomParagraph(lev);
	}
	private String generateRandomParagraph(int lev){
		String randStr = "";
		for(int i=0; i<lev*5; i++){
			randStr += (char)('a' + random.nextInt(26));
		}
		return randStr;
	}
	private String getFromStorage(int lev){
		return listStorage.get(lev).get(random.nextInt(listStorage.get(lev).size()));
	}
	
	public String getWord(){
		return wordsPerStage.remove(0);
	}
	
	public boolean isWordListEmpty(){
		return wordsPerStage.isEmpty();
	}
	
	public boolean isParagraphListEmpty(){
		return paragraphStorage.isEmpty();
	}
	
	public String toString(){
		String out = "";
		for(int i=0; i< MAX_LENGTH_OF_WORD; i++)
			for(int j=0; j < listStorage.get(i).size(); j++)
				out += listStorage.get(i).get(j) + "\n";

		return out;
	}
}
