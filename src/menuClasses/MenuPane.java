package menuClasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import importClasses.ScoreList;

public class MenuPane extends GraphicsPane {
	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	private GImage background;
	private ArrayList<GLabel> instructions;
	private GImage exit;
	private ScoreList scoreList;
	
	public MenuPane(MainApplication app) {
		program = app;
		instructions = new ArrayList<GLabel>();
		background = new GImage("screenImages/instructions background.jpg",0,0);
		background.setSize(program.getWidth(), program.getHeight());
		exit = new GImage("screenImages/back_button.png", 24, program.getHeight() - 130);
		exit.setSize(145, 87);
		initializeInstructions();
	}
	
	private void initializeInstructions(){
		instructions.add(new GLabel("You are in the midst of a large scale invasion"));
		instructions.add(new GLabel("of your home planet, Earth. You must do your best"));
		instructions.add(new GLabel("to fend off as many of the invading aliens as possible."));
		instructions.add(new GLabel("The fate of the planet rests in your hands."));
		instructions.add(new GLabel(""));
		instructions.add(new GLabel("Eliminate the aliens by:"));
		instructions.add(new GLabel("-Typing the word attached to them using the keyboard"));
		instructions.add(new GLabel("-Pressing the numbers keys to use power-ups obtained"));
		instructions.add(new GLabel(" by saving your comrades"));
		instructions.add(new GLabel(""));
		instructions.add(new GLabel(""));
		instructions.add(new GLabel("Features that may aid you in your defense:"));
		instructions.add(new GLabel("-Press the ESC key to pause the game"));
		instructions.add(new GLabel("-Switch targets by using the arrow keys"));
		instructions.add(new GLabel(""));
		instructions.add(new GLabel("Watch out for bosses! They are tougher than the others."));
		instructions.add(new GLabel(""));
		instructions.add(new GLabel("Good luck and fight hard, Hero!"));
		
		for (int i = 0; i < instructions.size(); ++i)
		{
			instructions.get(i).setFont(new Font("Arial-BoldMT", Font.BOLD, 20));
			instructions.get(i).setColor(Color.white);
			if(i < instructions.size()/2){
				instructions.get(i).setLocation(program.getWidth() / 5 , program.getHeight() /2 + i * (instructions.get(i).getHeight() + 17));
			}
			else{
				instructions.get(i).setLocation(program.getWidth() *.55 , program.getHeight() /2.25 + (i-instructions.size()/2) * (instructions.get(i).getHeight() + 17));
			}

		}
	}
	
	@Override
	public void showContents() {
		program.add(background);
		for (int i = 0; i < instructions.size(); ++i)
		{
			program.add(instructions.get(i));
		}
		program.add(exit);
	}
	

	@Override
	public void hideContents() {
		program.remove(exit);
		for (int i = 0; i < instructions.size(); ++i)
		{
			program.remove(instructions.get(i));
		}
		program.remove(background);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == exit) {
			program.getSound().buttonClickSound();
			program.switchToSome(scoreList);
		}
	}
	
	public void setScoreList(ScoreList scoreLists){
		this.scoreList = scoreLists;
	}
}


