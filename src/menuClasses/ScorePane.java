package menuClasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GObject;
import importClasses.ScoreList;

public class ScorePane extends GraphicsPane {
	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	private GImage exit;
	private GImage background;
	private ScoreList scoreList;
	private ArrayList<GLabel> nameLabels;
	private ArrayList<GLabel> scoreLabels;
	private ArrayList<GLabel> percentLabels;
	private ArrayList<GLabel> waveLabels;
	private ArrayList<GLabel> cpmLabels;
	private Integer paneCounter;
	private GLabel next;
	private GLabel prev;
	private GLabel names;
	private GLabel scores;
	private GLabel percentage;
	private GLine line;
	private boolean scoresS;
	private boolean namesS;
	private boolean accuS;
	private boolean waveS;
	private boolean cpmS;
	private boolean scoresR;
	private boolean namesR;
	private boolean accuR;
	private boolean waveR;
	private boolean cpmR;
	private GLine arrowL;
	private GLine arrowR;
	private GLine arrowT;
	private GLabel waveNumber;
	private GLabel cpm;
	
	
	public ScorePane(MainApplication app) {
		
		program = app;
		paneCounter = 0;
		
		nameLabels = new ArrayList<GLabel>();
		scoreLabels = new ArrayList<GLabel>();
		percentLabels = new ArrayList<GLabel>();
		waveLabels = new ArrayList<GLabel>();
		cpmLabels = new ArrayList<GLabel>();
		
		scoresS = true;
		namesS = false;
		accuS = false;
		waveS = false;
		cpmS = false;
		scoresR = false;
		namesR = false;
		accuR = false;
		waveR = false;
		cpmR = false;
		
		background = new GImage("screenImages/highscore background.jpg",0,0);
		background.setSize(program.getWidth(), program.getHeight());
		
		exit = new GImage("screenImages/back_button.png", 24, program.getHeight() - 130);
		exit.setSize(145, 87);
		
		next = new GLabel(">", program.getWidth()*.82, program.getHeight()*.8);
		next.setColor(Color.white);
		next.setFont(new Font("Arial-BoldMT", Font.BOLD, 60));
		
		prev = new GLabel("<", program.getWidth()*.15, program.getHeight()*.8);
		prev.setColor(Color.white);
		prev.setFont(new Font("Arial-BoldMT", Font.BOLD, 60));
		
		names = new GLabel("Name", (program.getWidth() / 4) + 33, program.getHeight() / 5 - 60);
		names.setFont(new Font("Arial-BoldMT", Font.BOLD, 35));
		names.setColor(Color.white);
		
		scores = new GLabel("Score", program.getWidth() *.4, program.getHeight() / 5 - 60);
		scores.setFont(new Font("Arial-BoldMT", Font.BOLD, 35));
		scores.setColor(Color.white);
		
		percentage = new GLabel("Accuracy", program.getWidth() *.49, program.getHeight() / 5 - 60);
		percentage.setFont(new Font("Arial-BoldMT", Font.BOLD, 35));
		percentage.setColor(Color.white);
		
		cpm = new GLabel("CPM", program.getWidth() *.6, program.getHeight() / 5 - 60);
		cpm.setFont(new Font("Arial-BoldMT", Font.BOLD, 35));
		cpm.setColor(Color.white);
		
		waveNumber = new GLabel("Wave", program.getWidth() *.67, program.getHeight() / 5 - 60);
		waveNumber.setFont(new Font("Arial-BoldMT", Font.BOLD, 35));
		waveNumber.setColor(Color.white);
		
		line = new GLine((program.getWidth() / 4) + 33, program.getHeight() / 5 - 45, program.getWidth() *.67 + waveNumber.getWidth() + 25, program.getHeight() / 5 - 45);
		line.setColor(Color.white);
		

	}
	@Override
	public void showContents() {
		paneCounter = 0;
		scoresS = true;
		namesS = false;
		accuS = false;
		waveS = false;
		cpmS = false;
		scoresR = false;
		namesR = false;
		accuR = false;
		waveR = false;
		cpmR = false;
		
		initializeLabels();
		program.add(background);
		addScoreLabels();
		program.add(exit);
		program.add(next);
		program.add(line);
		program.add(names);
		program.add(scores);
		program.add(percentage);
		program.add(cpm);
		program.add(waveNumber);
		
		arrowL = new GLine(scores.getX() + scores.getWidth() + 5, scores.getY() - (scores.getHeight()/4), scores.getX() + scores.getWidth() + 15, scores.getY());
		arrowR = new GLine(scores.getX() + scores.getWidth() + 25, scores.getY() - (scores.getHeight()/4), scores.getX() + scores.getWidth() + 15, scores.getY());
		arrowL.setColor(Color.white);
		arrowR.setColor(Color.white);
		
		arrowT = new GLine(scores.getX() + scores.getWidth() + 5, scores.getY() - (scores.getHeight()/4), scores.getX() + scores.getWidth() + 25, scores.getY() - (scores.getHeight()/4));
		arrowT.setColor(Color.white);
		
		program.add(arrowL);
		program.add(arrowR);
		program.add(arrowT);
	}
	
	public void initializeLabels(){
		nameLabels = new ArrayList<GLabel>();
		scoreLabels = new ArrayList<GLabel>();
		percentLabels = new ArrayList<GLabel>();
		waveLabels = new ArrayList<GLabel>();
		cpmLabels = new ArrayList<GLabel>();
		for(int i = 0; i < 50; i++){
			if(i >= scoreList.getList().size()){
				nameLabels.add(new GLabel((i+1) + "."));
				scoreLabels.add(new GLabel(""));
				percentLabels.add(new GLabel(""));
				waveLabels.add(new GLabel(""));
				cpmLabels.add(new GLabel(""));
			}
			else{
				nameLabels.add(new GLabel((i+1)+ ". " + scoreList.getNames(i)));
				scoreLabels.add(new GLabel("" + scoreList.getScores(i)));
				percentLabels.add(new GLabel(scoreList.getPercents(i) + "%"));
				waveLabels.add(new GLabel("" + scoreList.getWave(i)));
				cpmLabels.add(new GLabel("" + scoreList.getCPM(i)));
			}
		}
		
		for (int i = 0; i < 50; ++i)
		{
			if(i < 9){
				nameLabels.get(i).setLocation(program.getWidth() / 4 , program.getHeight() / 5 + (i % 10) * (nameLabels.get(i).getHeight() + 38));
			}
			else{
				nameLabels.get(i).setLocation((program.getWidth() / 4) - 18 , program.getHeight() / 5 + (i % 10) * (nameLabels.get(i).getHeight() + 38));
			}
			
			scoreLabels.get(i).setLocation(program.getWidth() *.4, program.getHeight() / 5 + (i % 10) * (nameLabels.get(i).getHeight() + 38));
			percentLabels.get(i).setLocation(program.getWidth() *.49, program.getHeight() / 5 + (i % 10) * (nameLabels.get(i).getHeight() + 38));
			waveLabels.get(i).setLocation(program.getWidth() *.67, program.getHeight() / 5 + (i % 10) * (nameLabels.get(i).getHeight() + 38));
			cpmLabels.get(i).setLocation(program.getWidth() *.6, program.getHeight() / 5 + (i % 10) * (nameLabels.get(i).getHeight() + 38));
			
			nameLabels.get(i).setFont(new Font("Arial-BoldMT", Font.BOLD, 30));
			scoreLabels.get(i).setFont(new Font("Arial-BoldMT", Font.BOLD, 30));
			percentLabels.get(i).setFont(new Font("Arial-BoldMT", Font.BOLD, 30));
			waveLabels.get(i).setFont(new Font("Arial-BoldMT", Font.BOLD, 30));
			cpmLabels.get(i).setFont(new Font("Arial-BoldMT", Font.BOLD, 30));
			
			nameLabels.get(i).setColor(Color.white);
			scoreLabels.get(i).setColor(Color.white);
			percentLabels.get(i).setColor(Color.white);
			waveLabels.get(i).setColor(Color.white);
			cpmLabels.get(i).setColor(Color.white);
		}
	}

	private void addScoreLabels(){
		for (int i = 0 + (paneCounter*10); i < 10 + (paneCounter*10); ++i)
		{
			if(nameLabels.size() > i){
				program.add(nameLabels.get(i));
				program.add(scoreLabels.get(i));
				program.add(percentLabels.get(i));
				program.add(waveLabels.get(i));
				program.add(cpmLabels.get(i));
			}
		}
	}
	private void removeScoreLabels(){
		for (int i = 0 + (paneCounter*10); i < 10 + (paneCounter*10); ++i)
		{
			if(nameLabels.size() > i){
				program.remove(nameLabels.get(i));
				program.remove(scoreLabels.get(i));
				program.remove(percentLabels.get(i));
				program.remove(waveLabels.get(i));
				program.remove(cpmLabels.get(i));
			}
		}
	}
	
	private void changeArrow(){
		program.remove(arrowL);
		program.remove(arrowR);
		program.remove(arrowT);
		if(scoresS && !scoresR){
			setArrowDown(scores);
		}
		else if(scoresS && scoresR){
			setArrowUp(scores);
		}
		else if(namesS && !namesR){
			setArrowDown(names);
		}
		else if(namesS && namesR){
			setArrowUp(names);
		}
		else if(accuS && !accuR){
			setArrowDown(percentage);
		}
		else if(accuS && accuR){
			setArrowUp(percentage);
		}
		else if(cpmS && !cpmR){
			setArrowDown(cpm);
		}
		else if(cpmS && cpmR){
			setArrowUp(cpm);
		}
		else if(waveS && !waveR){
			setArrowDown(waveNumber);
		}
		else if(waveS && waveR){
			setArrowUp(waveNumber);
		}
		program.add(arrowL);
		program.add(arrowR);
		program.add(arrowT);
	}
	
	private void setArrowUp(GLabel arrowPlace){
		arrowL.setStartPoint(arrowPlace.getX() + arrowPlace.getWidth() + 5, arrowPlace.getY() - (arrowPlace.getHeight()/4));
		arrowL.setEndPoint(arrowPlace.getX() + arrowPlace.getWidth() + 15, arrowPlace.getY() - arrowPlace.getHeight()/2);
		arrowR.setStartPoint(arrowPlace.getX() + arrowPlace.getWidth() + 25, arrowPlace.getY() - (arrowPlace.getHeight()/4));
		arrowR.setEndPoint(arrowPlace.getX() + arrowPlace.getWidth() + 15, arrowPlace.getY() - arrowPlace.getHeight()/2);
	}
	
	private void setArrowDown(GLabel arrowPlace){
		arrowL.setStartPoint(arrowPlace.getX() + arrowPlace.getWidth() + 5, arrowPlace.getY() - (arrowPlace.getHeight()/4));
		arrowL.setEndPoint(arrowPlace.getX() + arrowPlace.getWidth() + 15, arrowPlace.getY());
		arrowR.setStartPoint(arrowPlace.getX() + arrowPlace.getWidth() + 25, arrowPlace.getY() - (arrowPlace.getHeight()/4));
		arrowR.setEndPoint(arrowPlace.getX() + arrowPlace.getWidth() + 15, arrowPlace.getY());
		arrowT.setStartPoint(arrowPlace.getX() + arrowPlace.getWidth() + 5, arrowPlace.getY() - (arrowPlace.getHeight()/4));
		arrowT.setEndPoint(arrowPlace.getX() + arrowPlace.getWidth() + 25, arrowPlace.getY() - (arrowPlace.getHeight()/4));
	}
	@Override
	public void hideContents() {
		program.remove(exit);
		program.remove(background);
		program.remove(next);
		program.remove(prev);
		program.remove(line);
		program.remove(names);
		program.remove(scores);
		program.remove(percentage);
		program.remove(arrowL);
		program.remove(arrowR);
		program.remove(arrowT);
		program.remove(cpm);
		program.remove(waveNumber);
		removeScoreLabels();
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == exit) {
			program.getSound().buttonClickSound();
			scoreList.integerSort(scoreList.getScores());
			program.switchToSome(scoreList);
		}
		
		if(obj == next){
			program.getSound().buttonClickSound();
			removeScoreLabels();
			if(paneCounter == 0){
				program.add(prev);
			}
			paneCounter++;
			if(paneCounter == 4){
				program.remove(next);
			}
			addScoreLabels();
		}
		
		if(obj == prev){
			program.getSound().buttonClickSound();
			removeScoreLabels();
			paneCounter--;
			if(paneCounter == 0){
				program.remove(prev);
			}
			if(paneCounter == 3){
				program.add(next);
			}
			addScoreLabels();
		}
		if (obj == scores){
			if(!scoresS){
				scoresS = true;
				namesS = false;
				accuS = false;
				waveS = false;
				cpmS = false;
				scoresR = false;
				namesR = false;
				accuR = false;
				waveR = false;
				cpmR = false;
				sorting(scoreList.getScores());
			}
			else if(scoresS && !scoresR){
				scoresR = true;
				moveArrow();
			}
			else{
				scoresR = false;
				moveArrow();
			}
		}
		if(obj == names){
			if(!namesS){
				scoresS = false;
				namesS = true;
				accuS = false;
				waveS = false;
				cpmS = false;
				scoresR = false;
				namesR = false;
				accuR = false;
				waveR = false;
				cpmR = false;
				sorting(scoreList.getList());
			}
			else if(namesS && !namesR){
				namesR = true;
				moveArrow();
			}
			else{
				namesR = false;
				moveArrow();
			}
		}
		if(obj == percentage){
			if(!accuS){
				scoresS = false;
				namesS = false;
				accuS = true;
				waveS = false;
				cpmS = false;
				scoresR = false;
				namesR = false;
				accuR = false;
				waveR = false;
				cpmR = false;
				sorting(scoreList.getPercents());
			}
			else if(accuS && !accuR){
				accuR = true;
				moveArrow();
			}
			else{
				accuR = false;
				moveArrow();
			}
		}
		if(obj == cpm){
			if(!cpmS){
				scoresS = false;
				namesS = false;
				accuS = false;
				waveS = false;
				cpmS = true;
				scoresR = false;
				namesR = false;
				accuR = false;
				waveR = false;
				cpmR = false;
				sorting(scoreList.getCpms());
			}
			else if(cpmS && !cpmR){
				cpmR = true;
				moveArrow();
			}
			else{
				cpmR = false;
				moveArrow();
			}
		}
		if(obj == waveNumber){
			if(!waveS){
				scoresS = false;
				namesS = false;
				accuS = false;
				waveS = true;
				cpmS = false;
				scoresR = false;
				namesR = false;
				accuR = false;
				waveR = false;
				cpmR = false;
				sorting(scoreList.getWaves());
			}
			else if(waveS && !waveR){
				waveR = true;
				moveArrow();
			}
			else{
				waveR = false;
				moveArrow();
			}
		}
	}
	
	public void setScoreList(ScoreList scoreLists){
		this.scoreList = scoreLists;
	}
	
	public void moveArrow(){
		changeArrow();
		removeScoreLabels();
		scoreList.reverseOrder();
		initializeLabels();
		addScoreLabels();
	}
	
	public void sorting(ArrayList arrayToSort){
		changeArrow();
		removeScoreLabels();
		if(arrayToSort.equals(scoreList.getList())){
			scoreList.sortNames();
		}
		else if(arrayToSort.equals(scoreList.getPercents())){
			scoreList.sortPercents();
		}
		else{
			scoreList.integerSort((ArrayList<Integer>)arrayToSort);
		}
		initializeLabels();
		addScoreLabels();
		
	}
}
