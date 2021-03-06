# wordwarIII

By:
Devin Lim,
Spencer McKean,
Jeremy Ronquillo


Key Changes in Project Objectives:

•	Along with helping people to practice typing, we also encourage friendly competition between other people with the high score list.

Use Case Changes:

    •	Describes menu actions more in detail.
    
    •	Specifies what data structures we are using (ArrayList).
    
    •	Added sound class and interactions with the sound class.
    
    •	Describes the boss’s projectiles in more detail.

System Design Changes:

    •	Increase in RAM (2.0 GB) and storage (600MB) required.
    
    •	Graphics card not needed.
    
    •	Audio output to listen to the sound effects.

Interaction Diagram Changes:

    •	If the user types in a wrong character, score will be deducted by 5 points.
    
    •	The class SoundTrack loads when the main menu is loaded.

Class Diagram Changes:

    •	SoundTrack class was added to the class diagram.
    
    •	Many objects and methods have been added to GraphicsGame.

Customer Statement of Requirements

    We want to create an application that helps people practice typing in a fun and entertaining way.  Practicing typing is important in becoming a confident typist, especially in the workforce.  Here are some statistics shown in an infographic from ratatype.com on the left.

    People who have developed typing skills know how to type faster and more accurately. This allows students in high school and college to receive better grades.  Fast and accurate typing also is a key skill that may go on one’s resume when applying for a job, which overall results in better job offers. However, quick and accurate typing demand practice; those who type faster than average tend to practice 3 times as long than those who have average or below average words per minute speeds. Anybody can practice typing typing at any age, though statistics show that the largest group of people who practice are the younger audience.

    Rather than making a boring typing tutor, we opted to make a typing game, so that our users will be more motivated to play our game while practicing typing as well.  Though we aim for our game to target all ages who have interest in typing, we hope to continue helping the younger audience practice, as typing is a very important skill in society today and in the future.
    
Glossary:

    •	queue - a line of items, words in our program, waiting their turn to be used (first in, first out order)
    
    •	imported - bring something into the program from an outside source
    
    •	lock-on - select a specific target
    
    •	hit points - the amount of times the player can be hit before losing the game
    
    •	exported - put something from the program into an outside source
    
    •	power-up - an item that can be collected and then used to give a benefit to the player
    
    •	spaceship - this is the player’s character
    
    •	aliens - the enemy characters trying to defeat the player
    
    •	wave - a level of the game
    
    •	text file - database of words that the program reads
    
    •	user - the person who is running the program
    
    •	Clip - Java class that allow user to add the sound and play.
    
    •	CPM - stands for Character per minute. It calculates average number of letters user can type in a minute. 
    
    •	projectile - Type of missile Boss Alien shoots. It is made up of randomly generated characters. It can be targeted and 
    removed just like Minion Alien.
    
    •	i5-core processor - CPU specification.


Functional Requirements Specification

Functional Requirements Specification: Stakeholders

    The user group we are aiming for are youths learning how to type, elders who want to continue typing, and anybody who has an interest in improving their typing skills. Since our program is a game, youths will be more attracted to our program, simultaneously having fun and learning and improving their typing skills.  Elders who have little or no experience would benefit from our game; their ability to type would improve if they continued playing our game.  Finally, anybody who has an interest in improving their typing skills would find our program suitable to their needs.  Typing is important in most, if not, all office jobs.  Faster, efficient typing will be beneficial for this user group.

Functional Requirements Specification: Actors and Goals

	Our actors are going to be our user, the text files, sound files, and image files. The user’s goal is to get a high score in the game, the word list text file will display words to the user, and the high score list text file will display the recorded high scores to the user. Sound files will be used for background music and game sound effects, and the image files will be used for the background images and the images of objects.

Functional Requirements Specification: Use Case (informal):

    The game will show the title screen with the “Instructions”, “Play Game”, “Credits”, “High Scores”, and “Exit” buttons. When the player selects the “Play Game” button, aliens with words attached will come from top to bottom. The user will type the word to kill each of the aliens. After the user kills a certain number of aliens and the boss, it will move onto the next wave with a slight increase in difficulty (the aliens’ speed and length of words will increase). The user will lose hit points when they fail to type out the alien’s or projectile’s letters before it crashes into the bottom. The game will be over when the user is out of hit points. The user will enter his name to record scores, accuracy, achieved wave, accuracy, and characters per minute on the scoreboard if the user gets higher point than the lowest point on the scoreboard if there are 50 scores.


Functional Requirements Specification: Use case(Formal)
   
    1. The user will start the game
    
        a.	Opening the program
        
        b.	Words will be added to ArrayList from a text file, paragraphs will be added to ArrayList from a text file, high score list will be added from text file, images of aliens and background will be added, and sound for the background music and game effects will be added to Clips from .wav file.
        
        c.	When the user clicks on the start game icon, the game will begin by sending out the aliens with their words attached.
        
        d.	The user can view the high scores, see the instructions, see the credits page, and exit the game from the main screen.
    
    2. The user destroys the alien. 
    
        a.	User will lock-on to the alien by using the arrow keys.
        
        b.	User will type out the word that is attached to each alien.
        
        c.	When the user successfully types out the word the alien will be destroyed, and the user’s score will be increased.
        
        d.	If  the user types an incorrect letter their score will be reduced by 5, and their accuracy will decrease as well. If 
        the user fails to type out the alien’s word before it reaches the user’s spaceship, the bottom of the screen, the user’s hit points will be reduced by 8%.
    
    3. The user and items
    
        a.	A bonus alien, depicted by an astronaut, with a word attached, will appear randomly.
        
        b.	If the user successfully types out the word before it reaches the bottom, they will get a random item and the astronaut will make a screaming sound.
        
        c.	Items will be added to user’s item list that has a limit of 3 slots. The user can use the items by pressing 1, 2, or 3.
        
        d.	If all the item slots are full the user cannot get more items until there is an empty slot. Also, if the user fails to type out the word of the astronaut before it reaches the bottom the user’s hit points will not be reduced, and the astronaut will make a laughing sound.
    
    4. The user will need to destroy the boss alien.
    
        a.	The user will face the boss alien of the wave after destroying a set number of aliens.
        
        b.	The user will defend against the projectiles the boss alien shoots by changing the target and typing out the letters. Then the user will have to type out the paragraph that the boss alien has as its life.
        
        c.	When the user successfully types out the boss alien’s paragraph, the boss alien will be destroyed and it will wipe out the projectiles if there is any. The user will move onto the next wave.
        
        d.	If the user fails to type out the boss alien’s paragraph and fails to defend against the boss alien’s projectiles, the game will be over.
    
    5. The user will move onto next wave.
    
        a.	The user needs to defeat boss alien.
        
        b.	On odd numbered waves the speed of the game will be increased. On even numbered waves the maximum length of the word 
        will be increased.
        
        c.	Next wave starts.
        
        d.	If the user loses all hit points, the game will be over.
    
    6. Game will be over.
    
        a.	The user loses all hit points.
        
        b.	Switches to the game over screen.
        
        c.	It will get the user’s name and put it on the score list based on their score. The user’s name, score, wavenumber, characters per minute, and accuracy will all be saved.
        
        d.	Once the user presses enter, their stats will be saved and they will be switched back to the main screen. If the user did not enter a name their name will be defaulted to “Defender”. Also, if the scoreList is longer than 50 it will remove the last one on the list.


System Architecture and System Design

    There is no need for our program to run on multiple machines because it is a single player game, and there is no data that needs to be shared between players like global highscores. Since we do not use multiple machines we do not have any network protocols.


Hardware requirements

    •	Color Screen display (minimum resolution 640 x 480 pixels)
    
    •	Keyboard
    
    •	Mouse
    
    •	Minimum 2.0 GB of RAM
    
    •	600MB minimum of storage
    
    •	Graphic card not needed
    
    •	Recommend at least i5-core processor.
    
    •	Any type of audio output to enjoy the sound-track of the game.


Algorithms and Data Structures

•	Algorithms:

    o	Alien Movement
    
        	There will be many preset patterns of movement.
        
        	Each object moves in the other Thread.
        
        	A space object is given a movement pattern when it spawns.
        
        	The movement patterns will all eventually home into the user’s spaceship, causing damage and depleting the user’s spaceship’s health
    
    o	Auto Lock-On
    
        	When the user destroys an alien, the next target should be the lowest alien on the screen
        
        	When a boss is present, auto lock-on will prioritize the Projectiles on screen
    
    o	Change Target
    
        	Pressing the arrow key left or up will target the next alien in the queue (the game will target a higher alien on the 
        screen)
        
        	Pressing the arrow key right or down will target the previous alien in the queue (the game will target a lower alien on the screen)
        
        	Pressing the arrow key left or up when a boss is present (traversing through the queue) will lock onto the projectiles, pressing the arrow keys right or down (traversing to the front of the queue) will target the boss.
    
    o	Matching next letter of the word to what user typed
    
        	After each letter is typed correctly, it changes the char of that position to ‘-’.
        
        	It will generate a while loop that passes all ‘-’ and gets next letter to compare with what user typed.
    
    o	Projectile shooting frequency 
    
        	It generate new set of Projectile every 25 seconds using timers.
        
        	Once a set of Projectile is generated, it goes to the Alien movement algorithm to shoot it towards user.
    
    o	Calculating score
    
        	Score will added when user kills the aliens, but also reduces if user types the incorrect letter.
        
        	When score is added, the color of the score changed into green for a second.
        
        	When score is reduced, the color of the score changed into red for a second.
    
    o	Calculating accuracy
    
        	It will count the total number of typed character related keys.
        
        	It will also count the total number of correct typed keys.
        
        	Then, it will calculate (number of correct typed / number of total typed) * 100 %.
    
    o	Calculating average number of letters user can type per minute
    
        	It will count each second using timer that is scheduled for every 1000ms(1sec) then increment the second variable by one.
        
        	It will also keep track of the total correct letter user types then use it to calculate lpm(letter per min) with formula : (number of correct typed / second passed sec) * 60 sec / 1min
    
    o	Freeze Item effect
    
        	It makes the boolean freezeEffectActive to true for 5 seconds using sleep on other thread. After 5 seconds, it makes freezeEffectActive back to false.
        
        	moveObject is continuously checking if freezeEffectActive is true. If it does, it will break out of the moveObject.
    
    o	Spiderweb Item effect
    
        	It makes the boolean spiderwebEffectActive to true for 10 seconds using sleep on other thread. After 10 seconds, it makes spiderwebEffectActive back to false.
        
        	moveObject is continuously checking if spiderwebEffectActive is true. If it does, it reduces the speed to 1.1 from 3.1.
    
    o	Score List sorting
    
        	When the game is over it will add the user’s stats into the correct position based on their score.
        
        	In the score screen the user can sort the score list based on all the different stats. It will go through the entire score list until it finds the biggest value then it will swap the values.

•	Data Structures:

    o	Array:
    
        	Colors
    
    o	ArrayList:
    
        	High score list
        
        	Item list
        
        	Aliens on screen
        
        	Word List
    
    	Paragraph List

User Design and Implementation : User Effort Estimation

a.	Ease of use 


•	Title Screen:

User may use either mouse to select from five options: Instruction, High score, Credits, exit, and starting game. Also, user may mute/unmute the sound.

With mouse:

1.	Move the mouse to the option you will select and left click it.

2.	Move the mouse to the Music/Sound Icon and right click it to mute/unmute.

With keyboard:
       	None.

•	Instruction:

User can go back to the Title screen after reading the instruction.

With mouse:

Move the mouse to the “Back” label and right click it to go back to the title screen.

With keyboard:

       	None.


•	Credits:

User can go back to the Title screen after reading the credits.

With mouse:

Move the mouse to the “Back” label and right click it to go back to the title screen.
With keyboard:

       	None.


•	High score:

User can sort the list by the name,  score, wave, accuracy, and CPM. 

With mouse:

1.	Move the mouse to the “NAMES”,  “SCORE”, “WAVE”, “ACCURACY”, or “CPM” label and right click it to sort the list.

2.	Move the mouse to the “>” or “<” and right click it to see the next page.

3.	Move the mouse to the “Back” label and right click it to go back to the title screen.

With keyboard:

       	None.

•	Gameplay:

With keyboard:

User use following keys :

1.      alphabet keys (a – z, 4-0, ‘’, ., “”, ?) : to type the word

-> If the user types unmatched letter, there is a penalty of reducing score and accuracy.

2.      Arrow keys (←↑→↓) : to select the word to type

3.      Three number keys (1, 2, 3) : to use the item

4.      Esc key : to pause the game

With mouse:

		When game is paused, user can use the move the mouse and right click to mute/unmute the music, and go back to the main screen.

•	Game Over:

	With keyboard:

User types user’s name if the user gets the score higher than the lowest score of the score board. After finishing typing user’s name, press enter to record it.


History of Work and Current Status of Implementation

Milestones:

•	March 29, 2016

    o	Repository was created.
    
    o	Project was started!

•	April 3, 2016

    o	The class diagram was implemented into the project.
    
    o	All classes have been made but have not been filled out yet.

•	April 6, 2016

    o	Words are assigned to aliens from the text file.
    
    o	Item inventory was added.

•	April 7, 2016

    o	Able to switch targets using arrow keys.

•	April 13, 2016

    o	All items and item effects have been implemented.
    
    o	Sound effects were added to the game.

•	April 15, 2016

    o	Boss alien was added.

•	April 19, 2016

    o	Boss alien AI was implemented
    
    o	Movement patterns were added to the aliens

•	April 20, 2016

    o	GraphicsGame was revamped and improved.
    
    o	Credits page was completed.

•	April 24, 2016

    o	Many game graphics have been improved.
    
    o	Major game balancing.
    
    o	Bosses have randomized sentences as heath.
    
    o	Statistical data was added and tracks user’s live typing statistics.

•	April 26, 2016

    o	Many graphical improvements.
    
    o	Many new sounds added.

    o	High score screen was completed.
    
    o	Game over screen was completed.

•	April 27, 2016

    o	Finished programming the project!
    
    o	Everything we wanted implemented in the project has been fully added!!


