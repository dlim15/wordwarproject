package menuClasses;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.Program;
import gameClasses.GraphicsGame;
import importClasses.ScoreList;

public class CreditsPane extends GraphicsPane {
	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	private GImage background;
	private ArrayList<GLabel> names;
	private ArrayList<GLabel> musicCredits;
	private GImage exit;
	private ScoreList scoreList;
	
	
	public CreditsPane(MainApplication app) {
		
		this.program = app;
		background = new GImage("screenImages/credits background.jpg",0,0);
		background.setSize(program.getWidth(), program.getHeight());
		names = new ArrayList<GLabel>();
		musicCredits = new ArrayList<GLabel>();
		exit = new GImage("screenImages/back_button.png", 24, program.getHeight() - 130);
		exit.setSize(145, 87);
		initializeNames();
	}
	
	private void initializeNames()
	{
		// SORRY I DIDN'T CARE ABOUT EFFICIENCY OR SPACE, GOT KINDA LAZY :P
		names.add(new GLabel("Credits"));
		names.get(names.size() - 1).setColor(Color.orange);
		names.get(names.size() - 1).setFont(new Font("Arial-BoldMT", Font.BOLD, 50));
		names.get(names.size() - 1).setLocation(program.getWidth() / 4 ,program.getHeight() / 12 );
		names.add(new GLabel(""));
		names.add(new GLabel("Developers - Team Chrome Tunes:"));
		names.get(names.size() - 1).setColor(Color.white);
		names.add(new GLabel("Jeremy Ronquillo   j_ronquillo@u.pacific.edu"));
		names.get(names.size() - 1).setColor(Color.green);
		names.add(new GLabel("Devin Lim                d_lim10@u.pacific.edu"));
		names.get(names.size() - 1).setColor(Color.green);
		names.add(new GLabel("Spencer McKean    s_mckean@u.pacific.edu"));
		names.get(names.size() - 1).setColor(Color.green);
		names.add(new GLabel(""));
		names.add(new GLabel("Play Testers:"));
		names.get(names.size() - 1).setColor(Color.white);
		names.add(new GLabel("Osvaldo Jimenez"));
		names.add(new GLabel("Courtney Banh"));
		names.add(new GLabel("Mitchell Chang"));
		names.add(new GLabel("Chris Chao"));
		names.add(new GLabel("John Kim"));
		names.add(new GLabel("Rachel Flores"));
		names.add(new GLabel("Grant Fong"));
		names.add(new GLabel("Jacob Campbell"));
		names.add(new GLabel("Jamie Culilap"));
		names.add(new GLabel("Steven Tang"));
		
		musicCredits.add(new GLabel("Music:"));
		musicCredits.get(musicCredits.size() - 1).setColor(Color.white);
		musicCredits.add(new GLabel("Blizzard Co. Soundtrack"));
		musicCredits.add(new GLabel("Star Wars Soundtrack"));
		for (int i = 0; i < musicCredits.size(); ++i)
		{
			musicCredits.get(i).setLocation(program.getWidth() / 1.8, program.getHeight() / 1.5 + i * (names.get(i).getHeight() + 17));
			musicCredits.get(i).setFont(new Font("Arial-BoldMT", Font.BOLD, 32));
			if (i > 0)
			{
				musicCredits.get(i).setColor(Color.cyan);			
			}

		}
		
		
		for (int i = 1; i < names.size(); ++i)
		{
			names.get(i).setLocation(program.getWidth() / 4 , program.getHeight() / 10 + i * (names.get(i).getHeight() + 17));
			names.get(i).setFont(new Font("Arial-BoldMT", Font.BOLD, 32));
			if (i > 7)
			{
				names.get(i).setColor(Color.yellow);
			}
		}
	}
	
	@Override
	public void showContents() {
		program.add(background);
		for (int i = 0; i < names.size(); ++i)
		{
			program.add(names.get(i));
		}
		for (int i = 0; i < musicCredits.size(); i++)
		{
			program.add(musicCredits.get(i));
		}
		program.add(exit);

	}

	@Override
	public void hideContents() {
		program.remove(background);
		for (int i = 0; i < names.size(); ++i)
		{
			program.remove(names.get(i));
		}
		for (int i = 0; i < musicCredits.size(); i++)
		{
			program.remove(musicCredits.get(i));
		}
		program.remove(exit);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == exit)
		{
			program.getSound().buttonClickSound();
			program.switchToSome(scoreList);
		}

	}
	public void setScoreList(ScoreList scoreLists){
		this.scoreList = scoreLists;
	}
	
}
