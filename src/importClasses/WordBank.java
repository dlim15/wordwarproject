
package importClasses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;

public class WordBank {
	private String filename[];
	private String combInpt;
	
	public WordBank(){
		filename = new String[3];
		filename[0] = "supportingTextFiles/WordList.txt";
		filename[1] = "supportingTextFiles/ParagraphList.txt";
		filename[2] = "supportingTextFiles/ScoreList.txt";
		
	}
	public void importWord(WordList words){
		String line = "";
		String fName = filename[0];
		
		int wordLength =3;
		try{
			FileReader filereader = new FileReader(fName);
			BufferedReader bufferedReader = new BufferedReader(filereader);
			while((line = bufferedReader.readLine()) != null){
				while(line.length() != wordLength)
					wordLength++;
				words.addWord(wordLength-3, line);
			}
			bufferedReader.close();
		}catch(FileNotFoundException ex){
			System.out.println("Unable to open file : " + fName + "");
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
	}
	public void importParagraph(WordList par){
		String line = "";
		String fName = filename[1];
		
		try{
			FileReader filereader = new FileReader(fName);
			BufferedReader bufferedReader = new BufferedReader(filereader);
			while((line = bufferedReader.readLine()) != null){
				par.addParagraph(line);
			}
			bufferedReader.close();
		}catch(FileNotFoundException ex){
			System.out.println("Unable to open file : " + fName + "");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	public void importScore(ScoreList scores){
		String line = "";
		String fName = filename[2];
		
		try{
			FileReader filereader = new FileReader(fName);
			BufferedReader bufferedReader = new BufferedReader(filereader);
			while((line = bufferedReader.readLine()) != null){
				//line = line.trim();
				String[] parts = line.split(" ");
				scores.addName(parts[0]);
				scores.addScore(Integer.parseInt(parts[1]));
				scores.addPercents(parts[2]);
				scores.addCPM(Integer.parseInt(parts[3]));
				scores.addWave(Integer.parseInt(parts[4]));
			}
			bufferedReader.close();
		}
		catch(FileNotFoundException ex){
			System.out.println("");
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
	public void exportScore(ScoreList scores){
		try{
			File file = new File(filename[2]);
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter filewriter = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			for(int i = 0; i < scores.getList().size(); i++){
				String input = scores.getNames(i);
				Integer input1 = scores.getScores(i);
				String input2 = scores.getPercents(i);
				Integer input3 = scores.getCPM(i);
				Integer input4 = scores.getWave(i);

				if (i != scores.getList().size() - 1){
					combInpt = input + " " + input1 + " " + input2 + " " + input3 + " " + input4 + "\r\n";
				}
				else{
					combInpt = input + " " + input1 + " " + input2 + " " + input3 + " " + input4;
				}
				bufferedwriter.write(combInpt);
			}
			bufferedwriter.close();
		} catch (IOException ex){
			ex.printStackTrace();
		}
	}
	
	/****** Some test functions of this class : ********/
	/*
	public static void main(String[] args) {
		WordList word = new WordList();
		WordBank bank = new WordBank();
		
		bank.importWord(word);
		
		for(int j=0; j<20; j++){
			System.out.println("Stage " + j);
	 		word.generateWords(j);
			for(int i=0; i<25; i++){
				System.out.println(word.getWord());
			}
		}
		
	}
	*/
}
