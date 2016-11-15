package menuClasses;

import gameClasses.*;
import importClasses.ScoreList;
import importClasses.WordBank;

import java.awt.Toolkit;

import acm.graphics.*;
import acm.program.*;

public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 1200;
	public static final int WINDOW_HEIGHT = 700;
	// make the screen size unresizable.
	// make the screen size bigger.
	
	private SomePane somePane;
	private MenuPane menu;
	private ScorePane scores;
	private GraphicsGame game;
	private GameOver gameOver;
	private SoundTrack sounds;
	private CreditsPane credits;
	private ScoreList scoreList;
	private WordBank files;
	
	public void init() {
		setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-90);
		//setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		sounds = new SoundTrack();
	}
	
	public void run() {

		somePane = new SomePane(this);
		menu = new MenuPane(this);
		scores = new ScorePane(this);
		gameOver = new GameOver(this);
		credits = new CreditsPane(this);
		setupInteractions();
		files = new WordBank();
		scoreList = new ScoreList();
		files.importScore(scoreList);
		switchToSome(scoreList);
	}
	
	/* Method: setupInteractions
	 * -------------------------
	 * must be called before switching to another
	 * pane to make sure that interactivity
	 * is setup and ready to go.
	 */
	private void setupInteractions() {
		requestFocus();
		addKeyListeners();
		addMouseListeners();
	}
	
	public void switchBack(ScoreList scoreLists) {
		menu.setScoreList(scoreLists);
		switchToScreen(menu);
	}
	
	public void switchToGame(ScoreList scoreLists)
	{
		game = null;
		game = new GraphicsGame(this);
		game.setScoreList(scoreLists);
		sounds.stopPlayingMenuBGM();
		sounds.playGameBGM();
		switchToScreen(game);
		
	}
	
	public void switchToSome(ScoreList scoreLists) {
		somePane.setScoreList(scoreLists);
		sounds.stopPlayingGameBGM();
		game = null;
		switchToScreen(somePane);
		sounds.playMenuBGM();
	}
	
	public void switchToScore(ScoreList scoreLists){
		scores.setScoreList(scoreLists);
		switchToScreen(scores);
	}
	
	public void switchToGameOver(int gameOverScore, ScoreList scoreLists, String percents, Integer CPM, Integer wave){
		sounds.stopPlayingGameBGM();
		gameOver.setCPM(CPM);
		gameOver.setWave(wave);
		gameOver.setScoreList(scoreLists);
		gameOver.setGameOverScore(gameOverScore);
		gameOver.setPercentage(percents);
		switchToScreen(gameOver);
	}
	public void switchToCredits(ScoreList scoreLists)
	{
		credits.setScoreList(scoreLists);
		switchToScreen(credits);
	}
	
	public SoundTrack getSound(){
		return sounds;
	}
	
	
}
