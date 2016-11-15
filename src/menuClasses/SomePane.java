package menuClasses;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.Program;
import importClasses.ScoreList;

public class SomePane extends GraphicsPane {
	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	private GImage background;
	private GImage start, instruction, highscores, exit, sound, music;
	private GLabel title;
	private GImage credits;
	private ScoreList scoreList;
	private Random rand;
	
	
	public SomePane(MainApplication app) {
		this.program = app;
		/**
		scores = new WordBank();
		//scoreList = new ScoreList();
		if(scoreList == null){
		//if(scoreList.getList().size() == 0){
			scoreList = new ScoreList();
			scores.importScore(scoreList);
		}
		**/	
		
		background = new GImage("screenImages/MainBackground.jpg",0,0);
		background.setSize(program.getWidth(), program.getHeight());
		start = new GImage("screenImages/earth.png", program.getWidth()*.65, program.getHeight()*.47);
		start.setSize(750, 750);
		instruction = new GImage("screenImages/moon.png", program.getWidth()*.25, program.getHeight()*.65);
		instruction.setSize(200,200);
		highscores = new GImage("screenImages/jupitar.png", program.getWidth()*.5, 0);
		highscores.setSize(350,350);
		credits = new GImage("screenImages/creditsPicture.png", program.getWidth() * 0.9, program.getHeight()/10 );
		credits.setSize(150,150);
		music = new GImage("screenImages/music_on.png", program.getWidth() - 25, 0);
		music.setSize(25, 25);
		sound = new GImage("screenImages/sound_on.png", program.getWidth() - 50, 0);
		sound.setSize(25, 25);
		
		
		exit = new GImage("screenImages/exit1.png", 0,0);
		rand = new Random();
		
		
		Timer temp = new Timer();
		temp.schedule(new TimerTask()
				{
					@Override
					public void run(){
						int timer = 0;
						int exitTimer = 0;
						boolean exitReversed = false;
						boolean reversed = false;
						boolean sideReverse = false;
						while (true)
						{
							timer++; exitTimer++;
							if (timer % 17 == 0)
							{
								reversed = !reversed;
							}
							if (timer % 101 == 0)
							{
								sideReverse = !sideReverse;
							}
							if (reversed)
							{
								credits.move(sideReverse?1:-1, 0.5);
							}
							else
							{
								credits.move(sideReverse?1:-1, -0.5);
							}
							if (exitTimer % 21 == 0)
							{
								exitReversed = !exitReversed;
							}
							exit.move(0, exitReversed? -0.7: 0.7);
							
							
							program.pause(200);
						}
					}
				}, 0);
		
		title = new GLabel("WORD WAR III", program.getWidth()/10, program.getHeight()/2);
		title.setColor(Color.white);
		title.setFont(new Font("Arial-BoldMT", Font.BOLD, 90));
	}
	
	@Override
	public void showContents() {
		String filename = "screenImages/exit" + Integer.toString(rand.nextInt(5) + 1) + ".png";
		exit = new GImage(filename);
		exit.setSize(120, 120);
		exit.setLocation(exit.getWidth(), exit.getWidth());
		program.add(background);
		program.add(instruction);
		program.add(start);
		program.add(highscores);
		program.add(credits);
		program.add(exit);
		if (program.getSound().getToggle(true))
		{
			music.setImage("screenImages/music_on.png");
		}
		else
		{
			music.setImage("screenImages/music_off.png");
		}
		if (program.getSound().getToggle(false))
		{
			sound.setImage("screenImages/sound_on.png");
		}
		else
		{
			sound.setImage("screenImages/sound_off.png");
		}
		music.setSize(25, 25);
		sound.setSize(25, 25);
		program.add(music);
		program.add(sound);
		
		program.add(title);
	}

	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(instruction);
		program.remove(start);
		program.remove(highscores);
		program.remove(credits);
		program.remove(exit);
		program.remove(music);
		program.remove(sound);
		program.remove(title);
	}
	

	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == instruction) {
			program.getSound().buttonClickSound();
			program.switchBack(scoreList);
		}
		else if (obj == start)
		{
			program.getSound().buttonClickSound();
			program.switchToGame(scoreList);
		}
		else if(obj == highscores){
			program.getSound().buttonClickSound();
			program.switchToScore(scoreList);
		}
		else if (obj == credits)
		{
			program.getSound().buttonClickSound();
			program.switchToCredits(scoreList);
		}
		else if (obj == exit)
		{
			program.getSound().buttonClickSound();
			System.exit(0);
		}
		else if (obj == music)
		{

			music.setImage("screenImages/music"+program.getSound().toggleMusic(false));
			music.setSize(25, 25);
		}
		else if (obj == sound)
		{
			sound.setImage("screenImages/sound"+program.getSound().toggleSound());
			sound.setSize(25, 25);
		}
		
	}
	
	public void setScoreList(ScoreList scoreLists){
		this.scoreList = scoreLists;
	}
	
}
