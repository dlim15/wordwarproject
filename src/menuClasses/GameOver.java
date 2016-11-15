package menuClasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import importClasses.WordBank;
import importClasses.ScoreList;

public class GameOver extends GraphicsPane {
	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	private GLabel over;
	private int gameOverScore;
	private String percentage;
	private GImage background;
	private GLabel enterName;
	private ScoreList scoreList;
	private WordBank files;
	private String nameStr;
	private GLabel name;
	private GLabel underscore;
	private GLabel scoreLabel;
	private GLabel accuracyLabel;
	private GLabel score;
	private GLabel accuracy;
	private GLabel pressEnter;
	private Integer CPM;
	private Integer waveNumber;
	private GLabel waveLabel;
	private GLabel CPMLabel;
	private GLabel wave;
	private GLabel charPerMin;
	
	Timer under = new Timer();
	
	
	public GameOver(MainApplication app) {
		program = app;
		initializeing();
	}
	private void initializeing(){
		background = new GImage("screenImages/Background.jpg",0,0);
		background.setSize(program.getWidth(), program.getHeight());
		
		over = new GLabel("Game Over");
		over.setFont(new Font("Arial-BoldMT", Font.BOLD, 100));
		over.setLocation(program.getWidth()/2 - (over.getWidth()/2), program.getHeight()*.15);
		over.setColor(Color.red);

		nameStr = "";
		
		enterName = new GLabel("Enter Name");
		enterName.setFont(new Font("Arial-BoldMT", Font.BOLD, 36));
		enterName.setLocation(program.getWidth()/2 - (enterName.getWidth()/2), program.getHeight()*.8);
		enterName.setColor(Color.white);
		
		
		scoreLabel = new GLabel("Score:");
		scoreLabel.setFont(new Font("Arial-BoldMT", Font.BOLD, 60));
		scoreLabel.setLocation(program.getWidth()/2 - scoreLabel.getWidth(), program.getHeight()*.4);
		scoreLabel.setColor(Color.white);
		
		accuracyLabel = new GLabel("Accuracy:");
		accuracyLabel.setFont(new Font("Arial-BoldMT", Font.BOLD, 60));
		accuracyLabel.setLocation(program.getWidth()/2 - accuracyLabel.getWidth(), program.getHeight()*.5);
		accuracyLabel.setColor(Color.white);
		
		waveLabel = new GLabel("Wave:");
		waveLabel.setFont(new Font("Arial-BoldMT", Font.BOLD, 60));
		waveLabel.setLocation(program.getWidth()/2 - waveLabel.getWidth(), program.getHeight()*.3);
		waveLabel.setColor(Color.white);
		
		CPMLabel = new GLabel("CPM:");
		CPMLabel.setFont(new Font("Arial-BoldMT", Font.BOLD, 60));
		CPMLabel.setLocation(program.getWidth()/2 - CPMLabel.getWidth(), program.getHeight()*.6);
		CPMLabel.setColor(Color.white);
		
		pressEnter = new GLabel("Press Enter to Continue");
		pressEnter.setFont(new Font("Arial-BoldMT", Font.BOLD, 23));
		pressEnter.setLocation((program.getWidth()/2) - (pressEnter.getWidth()/2), program.getHeight()*.9);
		pressEnter.setColor(Color.white);
		
		gameOverScore = 0;
		percentage = "";

	}
	@Override
	public void showContents() {
		program.add(background);
		program.add(enterName);
		//program.add(exit);
		//program.add(rect);
		program.add(over);
		nameStr = "";
		
		underscore = new GLabel("_");
		underscore.setFont(new Font("Arial-BoldMT", Font.BOLD, 36));
		underscore.setLocation(program.getWidth()/2 - (underscore.getWidth()/2), enterName.getY() + enterName.getHeight() + 5);
		underscore.setColor(Color.white);
		
		score = new GLabel(" " + getGameOverScore());
		score.setFont(new Font("Arial-BoldMT", Font.BOLD, 60));
		score.setLocation(scoreLabel.getX() + scoreLabel.getWidth(), program.getHeight()*.4);
		score.setColor(Color.white);
		
		accuracy = new GLabel(" " + percentage + "%");
		accuracy.setFont(new Font("Arial-BoldMT", Font.BOLD, 60));
		accuracy.setLocation(accuracyLabel.getX() + accuracyLabel.getWidth(), program.getHeight()*.5);
		accuracy.setColor(Color.white);
		
		wave = new GLabel(" " + waveNumber);
		wave.setFont(new Font("Arial-BoldMT", Font.BOLD, 60));
		wave.setLocation(waveLabel.getX() + waveLabel.getWidth(), program.getHeight()*.3);
		wave.setColor(Color.white);
		
		charPerMin = new GLabel(" " + CPM);
		charPerMin.setFont(new Font("Arial-BoldMT", Font.BOLD, 60));
		charPerMin.setLocation(CPMLabel.getX() + CPMLabel.getWidth(), program.getHeight()*.6);
		charPerMin.setColor(Color.white);
		
		program.add(underscore);
		program.add(scoreLabel);
		program.add(accuracyLabel);
		program.add(score);
		program.add(accuracy);
		program.add(pressEnter);
		program.add(charPerMin);
		program.add(CPMLabel);
		program.add(waveLabel);
		program.add(wave);

		startTimer();


	}

	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(over);
		program.remove(over);
		program.remove(accuracy);
		program.remove(charPerMin);
		program.remove(wave);
		program.remove(score);
		program.remove(enterName);
		program.remove(CPMLabel);
		program.remove(waveLabel);
		program.remove(scoreLabel);
		program.remove(accuracyLabel);
		if(name != null){
			program.remove(name);
		}
		if(underscore != null){
			program.remove(underscore);
		}
		program.remove(pressEnter);

	}
	@Override
	public void keyPressed(KeyEvent e){
		typeName(e);
	}
	
	private void showUnderScore(){
		
		if(underscore != null){
			program.remove(underscore);
		}
		if(nameStr.length() == 0){
			underscore = new GLabel("_");
			underscore.setFont(new Font("Arial-BoldMT", Font.BOLD, 36));
			underscore.setLocation(program.getWidth()/2 - (underscore.getWidth()/2), enterName.getY() + enterName.getHeight() + 5);
			underscore.setColor(Color.white);
			program.add(underscore);
		}
		else if (nameStr.length() < 10){
			underscore = new GLabel("_", name.getX() + name.getWidth(), enterName.getY() + enterName.getHeight() + 5);
			underscore.setFont(new Font("Arial-BoldMT", Font.BOLD, 36));
			underscore.setColor(Color.white);
			program.add(underscore);
		}
	}
	
	public void typeName(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			if (nameStr.length() == 0){
					nameStr = "Defender";
			}
			files = new WordBank();
			scoreList.addNewScore(nameStr, getGameOverScore(), percentage, CPM, waveNumber);
			files.exportScore(scoreList);
			program.switchToSome(scoreList);
		}
		else if (e.getKeyChar() != ' '){
			if (name != null){
				program.remove(name);
			}
			if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
				if(nameStr.length() != 0){
					nameStr = nameStr.substring(0, nameStr.length()-1);
				}
			}
			else if (e.getKeyCode() != KeyEvent.VK_SHIFT && nameStr.length() < 10){
				nameStr += e.getKeyChar();
			}
			name = new GLabel(nameStr);
			name.setFont(new Font("Arial-BoldMT", Font.BOLD, 36));
			name.setLocation(program.getWidth()/2 - (name.getWidth()/2), enterName.getY() + enterName.getHeight() + 5);
			name.setColor(Color.white);
			showUnderScore();
			program.add(name);
		}
		
	}
	private void startTimer(){
		Timer under = new Timer();
		under.schedule(new TimerTask()
				{
					boolean showUnderscore = true;
					public void run(){
						if(showUnderscore){
							underscore.setColor(Color.blue);
							showUnderscore = false;
						}
						else if(!showUnderscore){
							underscore.setColor(Color.white);
							showUnderscore = true;
						}
					}
				}, 0, 750);
	}
	public int getGameOverScore() {
		return gameOverScore;
	}
	public void setGameOverScore(int gameOverScore) {
		this.gameOverScore = gameOverScore;
	}
	public void setScoreList(ScoreList scoreLists){
		this.scoreList = scoreLists;
	}
	public void setPercentage(String typePercentage){
		this.percentage = typePercentage;
	}
	public void setCPM(Integer characters){
		this.CPM = characters;
	}
	public void setWave(Integer wave){
		this.waveNumber = wave;
	}
}
