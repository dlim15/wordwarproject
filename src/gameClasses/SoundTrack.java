package gameClasses;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class SoundTrack {
	
	private Clip clip;
	private Clip gameClip[];
	private Clip shootingClip;
	private Clip shootingClip2;
	private Clip screamClip;
	private Clip attackedClip;
	private Clip attackedClip2;
	private Clip switchTarget;
	private Clip switchTarget2;
	private Clip type1;
	private Clip type2;
	private Clip type3;
	private Clip spiderweb;
	private Clip freeze;
	private Clip shield;
	private Clip repair;
	private Clip bomb;
	private Clip deathExplosion;
	private Clip buttonClick;
	private Clip buttonClick2;
	private Clip bossDeath;
	private Clip shield_deactivate;
	private Clip newWave;
	private Clip shockwave;
	private Clip shieldProtect;
	private Clip shieldProtect2;
	private Clip bonusAlienMiss;
	private Clip spiderwebExpire;
	private Clip freezeExpire;
	
	private boolean isSoundOn;
	private boolean isMusicOn;
	private boolean shootingSoundAlternate;
	private boolean switchTargetAlternate;
	private boolean attackedAlternate;
	private boolean shieldProtectAlternate;
	private boolean buttonClickAlternate;
	
	private int playedSong;
	
	private Random rand;
	
	
	public SoundTrack(){
		rand = new Random();
		setUpBGM();
		shootingSoundAlternate = false;
		switchTargetAlternate = false;
		attackedAlternate = false;
		isSoundOn = true;
		isMusicOn = true;
		buttonClickAlternate = false;
	}
	private void setUpBGM(){
		try{
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("soundTrack/opening.wav"));
			AudioInputStream gameStream0 = AudioSystem.getAudioInputStream(new File("soundTrack/game0.wav"));
			AudioInputStream gameStream1 = AudioSystem.getAudioInputStream(new File("soundTrack/game1.wav"));
			AudioInputStream gameStream2 = AudioSystem.getAudioInputStream(new File("soundTrack/game2.wav"));
			AudioInputStream gameStream3 = AudioSystem.getAudioInputStream(new File("soundTrack/game3.wav"));
			AudioInputStream shootingStream = AudioSystem.getAudioInputStream(new File("soundTrack/shootingSound.wav"));
			AudioInputStream shootingStream2 = AudioSystem.getAudioInputStream(new File("soundTrack/shootingSound.wav"));
			AudioInputStream screamStream = AudioSystem.getAudioInputStream(new File("soundTrack/bonusDeath.wav"));
			AudioInputStream attackedStream = AudioSystem.getAudioInputStream(new File("soundTrack/shipUnderAttack.wav"));
			AudioInputStream attackedStream2 = AudioSystem.getAudioInputStream(new File("soundTrack/shipUnderAttack.wav"));
			AudioInputStream switchTargetStream = AudioSystem.getAudioInputStream(new File("soundTrack/change_target.wav"));
			AudioInputStream switchTargetStream2 = AudioSystem.getAudioInputStream(new File("soundTrack/change_target.wav"));
			AudioInputStream type1Stream = AudioSystem.getAudioInputStream(new File("soundTrack/type1.wav"));
			AudioInputStream type2Stream = AudioSystem.getAudioInputStream(new File("soundTrack/type2.wav"));
			AudioInputStream type3Stream = AudioSystem.getAudioInputStream(new File("soundTrack/type3.wav"));
			AudioInputStream spiderwebStream = AudioSystem.getAudioInputStream(new File("soundTrack/spiderweb.wav"));
			AudioInputStream freezeStream = AudioSystem.getAudioInputStream(new File("soundTrack/freeze.wav"));
			AudioInputStream shieldStream = AudioSystem.getAudioInputStream(new File("soundTrack/shield.wav"));
			AudioInputStream repairStream = AudioSystem.getAudioInputStream(new File("soundTrack/repair.wav"));
			AudioInputStream bombStream = AudioSystem.getAudioInputStream(new File("soundTrack/bomb.wav"));
			AudioInputStream deathExplosionStream = AudioSystem.getAudioInputStream(new File("soundTrack/death_explosion.wav"));
			AudioInputStream buttonClickStream = AudioSystem.getAudioInputStream(new File("soundTrack/button_click.wav"));
			AudioInputStream buttonClickStream2 = AudioSystem.getAudioInputStream(new File("soundTrack/button_click.wav"));
			AudioInputStream bossDeathStream = AudioSystem.getAudioInputStream(new File("soundTrack/BossAlienDeath.wav"));
			AudioInputStream shield_deactivateStream = AudioSystem.getAudioInputStream(new File("soundTrack/shield_deactivate.wav"));
			AudioInputStream newWaveStream = AudioSystem.getAudioInputStream(new File("soundTrack/new_wave.wav"));
			AudioInputStream shockwaveStream = AudioSystem.getAudioInputStream(new File("soundTrack/shockwave.wav"));
			AudioInputStream shieldProtectStream = AudioSystem.getAudioInputStream(new File("soundTrack/shield_protect.wav"));
			AudioInputStream shieldProtectStream2 = AudioSystem.getAudioInputStream(new File("soundTrack/shield_protect.wav"));
			AudioInputStream bonusAlienMissStream = AudioSystem.getAudioInputStream(new File("soundTrack/bonusAlienMiss.wav"));
			AudioInputStream spiderwebExpireStream = AudioSystem.getAudioInputStream(new File("soundTrack/spiderweb_expire.wav"));
			AudioInputStream freezeExpireStream = AudioSystem.getAudioInputStream(new File("soundTrack/freeze_expire.wav"));
			
			
			clip = AudioSystem.getClip();
			gameClip = new Clip[4];
			for(int i=0; i<4; i++)
				gameClip[i] = AudioSystem.getClip();
			shootingClip = AudioSystem.getClip();
			shootingClip2 = AudioSystem.getClip();
			screamClip = AudioSystem.getClip();
			attackedClip = AudioSystem.getClip();
			attackedClip2 = AudioSystem.getClip();
			switchTarget = AudioSystem.getClip();
			switchTarget2 = AudioSystem.getClip();
			type1 = AudioSystem.getClip();
			type2 = AudioSystem.getClip();
			type3 = AudioSystem.getClip();
			spiderweb = AudioSystem.getClip();
			freeze = AudioSystem.getClip();
			shield = AudioSystem.getClip();
			repair = AudioSystem.getClip();
			bomb = AudioSystem.getClip();
			deathExplosion = AudioSystem.getClip();
			buttonClick = AudioSystem.getClip();
			buttonClick2 = AudioSystem.getClip();
			bossDeath = AudioSystem.getClip();
			shield_deactivate = AudioSystem.getClip();
			newWave = AudioSystem.getClip();
			shockwave = AudioSystem.getClip();
			shieldProtect = AudioSystem.getClip();
			shieldProtect2 = AudioSystem.getClip();
			bonusAlienMiss = AudioSystem.getClip();
			spiderwebExpire = AudioSystem.getClip();
			freezeExpire = AudioSystem.getClip();
			
			clip.open(inputStream);
			gameClip[0].open(gameStream0);
			gameClip[1].open(gameStream1);
			gameClip[2].open(gameStream2);
			gameClip[3].open(gameStream3);
			shootingClip.open(shootingStream);
			shootingClip2.open(shootingStream2);
			screamClip.open(screamStream);
			attackedClip.open(attackedStream);
			attackedClip2.open(attackedStream2);
			switchTarget.open(switchTargetStream);
			switchTarget2.open(switchTargetStream2);
			type1.open(type1Stream);
			type2.open(type2Stream);
			type3.open(type3Stream);
			spiderweb.open(spiderwebStream);
			freeze.open(freezeStream);
			shield.open(shieldStream);
			repair.open(repairStream);
			bomb.open(bombStream);
			deathExplosion.open(deathExplosionStream);
			buttonClick.open(buttonClickStream);
			buttonClick2.open(buttonClickStream2);
			bossDeath.open(bossDeathStream);
			shield_deactivate.open(shield_deactivateStream);
			newWave.open(newWaveStream);
			shockwave.open(shockwaveStream);
			shieldProtect.open(shieldProtectStream);
			shieldProtect2.open(shieldProtectStream2);
			bonusAlienMiss.open(bonusAlienMissStream);
			spiderwebExpire.open(spiderwebExpireStream);
			freezeExpire.open(freezeExpireStream);
			
		}catch(IOException ex){
			System.out.println("Cannot find the file.");
		}catch(UnsupportedAudioFileException ex){
			System.out.println("Unsupported Audio file type.");
		} catch (LineUnavailableException ex) {
			ex.printStackTrace();
		} 
	}
	public void freezeExpireSound(){
		playSound(freezeExpire);
	}
	public void spiderwebExpireSound(){
		playSound(spiderwebExpire);
	}
	public void bonusAlienMissSound(){
		playSound(bonusAlienMiss);
	}
	public void shieldProtectSound(){
		if (shieldProtectAlternate)
		{
			playSound(shieldProtect);
		}
		else{
			playSound(shieldProtect2);
		}
		shieldProtectAlternate = !shieldProtectAlternate;
	}
	public void shockwaveSound(){
		playSound(shockwave);
	}
	public void playShield_deactivateSound(){
		playSound(shield_deactivate);
	}
	public void playNewWaveSound()
	{
		playSound(newWave);
	}
	public void bossDeathSound(){
		playSound(bossDeath);
	}
	public void type1Sound(){
		playSound(type1);
	}
	public void type2Sound(){
		playSound(type2);
	}
	public void type3Sound(){
		playSound(type3);
	}
	public void buttonClickSound(){
		buttonClickAlternate = !buttonClickAlternate;
		if (buttonClickAlternate)
		{
			playSound(buttonClick);
		}
		else{
			playSound(buttonClick2);
		}
		
	}
	public void deathExplosionSound(){
		playSound(deathExplosion);
	}
	public void bombSound(){
		playSound(bomb);
	}
	public void repairSound(){
		playSound(repair);
	}
	public void shieldSound(){
		playSound(shield);
	}
	public void freezeSound(){
		playSound(freeze);
	}
	public void spiderwebSound(){
		playSound(spiderweb);
	}
	public void playMenuBGM(){
		playBGM(clip);
	}
	public void playGameBGM(){
		playedSong = rand.nextInt(4);
		playBGM(gameClip[playedSong]);
	}
	public void stopPlayingMenuBGM(){
		stopBGM(clip);
	}
	public void stopPlayingGameBGM(){
		stopBGM(gameClip[playedSong]);
	}
	private void playBGM(Clip c){
		if (isMusicOn)
		{
			try{
				c.loop(c.LOOP_CONTINUOUSLY);
				Thread.sleep(10);
			}catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	private void stopBGM(Clip c){
		c.stop();
		c.setFramePosition(0);
	}
	public void shootingSound(){
		if (shootingSoundAlternate){
			playSound(shootingClip);
		}
		else{
			playSound(shootingClip2);
		}
		shootingSoundAlternate = !shootingSoundAlternate;
	}
	public void screamSound(){
		playSound(screamClip);
	}
	public void shipIsUnderAttackSound(){
		if (attackedAlternate)
		{
			playSound(attackedClip);
		}
		else{
			playSound(attackedClip2);
		}
		attackedAlternate = !attackedAlternate;
	}
	
	public void changeTargetSound()
	{
		if (switchTargetAlternate)
		{
			playSound(switchTarget);
		}
		else{
			playSound(switchTarget2);
		}
		switchTargetAlternate = !switchTargetAlternate;
	}
	
	public String toggleSound()
	{
		isSoundOn = !isSoundOn;
		return currentSoundStatus();
	}
	public String currentSoundStatus(){
		if(isSoundOn)
			return "_on.png";
		return "_off.png";
	}
	
	public String toggleMusic(boolean isPlayingGame)
	{
		isMusicOn = !isMusicOn;
		return currentMusicStatus(isPlayingGame);
	}
	
	public String currentMusicStatus(boolean isPlayingGame){
		if (isMusicOn){
			playBGM(isPlayingGame ? gameClip[playedSong] : clip);
			return "_on.png";
		}
		
		stopBGM(isPlayingGame ? gameClip[playedSong] : clip);
		return "_off.png";
	}
	
	public boolean getToggle(boolean isMusic)
	{
		return isMusic ? isMusicOn : isSoundOn;
	}
	
	private void playSound(Clip c){
		if (isSoundOn)
		{
			c.setFramePosition(0);
			c.start();
		}
	}
}
