package importClasses;

import java.util.ArrayList;
import java.util.Collections;

public class ScoreList {
	private ArrayList<String> names;
	private ArrayList<Integer> scores;
	private ArrayList<String> percents;
	private ArrayList<Integer> wave;
	private ArrayList<Integer> cpms;
	
	public ScoreList(){
		names =  new ArrayList<String>();
		scores = new ArrayList<Integer>();
		percents = new ArrayList<String>();
		wave = new ArrayList<Integer>();
		cpms = new ArrayList<Integer>();
		
	}
	
	public void addName(String name){
		names.add(name);
	}
	
	public void addScore(Integer score){
		scores.add(score);
	}
	
	public void addPercents(String percent){
		percents.add(percent);
	}
	
	public void addWave(Integer waves){
		wave.add(waves);
	}
	
	public void addCPM(Integer cpm){
		cpms.add(cpm);
	}
	
	public void addNewScore(String name, Integer score, String percent, Integer cpm, Integer waves){
		Integer size = names.size();
		if(size == 0){
			scores.add(score);
			names.add(name);
			percents.add(percent);
			wave.add(waves);
			cpms.add(cpm);
		}
		for(int i = 0; i < size; i++){
			if (getScores(i) < score){
				scores.add(i, score);
				names.add(i, name);
				percents.add(i, percent);
				wave.add(i, waves);
				cpms.add(i, cpm);
				break;
			}
			else if (i == size - 1){
				scores.add(score);
				names.add(name);
				percents.add(percent);
				wave.add(waves);
				cpms.add(cpm);
			}
		}
		if(names.size() > 50){
			scores.remove(scores.size() - 1);
			names.remove(names.size() - 1);
			percents.remove(percents.size() - 1);
			wave.remove(wave.size() - 1);
			cpms.remove(cpms.size() - 1);
		}
	}
	public void sortNames(){
		Integer size = names.size();
		for(int i = 0; i < size - 1; i++){
			int min = i;
			for(int j = i + 1; j < size; j++){
				int compare = names.get(min).compareTo(names.get(j));
				if (compare > 0){
					min = j;
				}
				else if(compare == 0){
					if(scores.get(j) > scores.get(min)){
						min = j;
					}
				}
			}
			swapValues(min, i);
		}
	}
	public void integerSort(ArrayList<Integer> integers){ //use for scores, waves, cpms
		Integer size = integers.size();
		for(int i = 0; i < size - 1; i++){
			int min = i;
			for(int j = i + 1; j < size; j++){
				if (integers.get(j) > integers.get(min)){
					min = j;
				}
				else if(integers.get(j) == integers.get(min)){
					int compare = names.get(min).compareTo(names.get(j));
					if (compare > 0){
						min = j;
					}
				}
			}
			swapValues(min, i);
		}
	}
	public void sortPercents(){
		Integer size = percents.size();
		for(int i = 0; i < size - 1; i++){
			int min = i;
			for(int j = i + 1; j < size; j++){
				if(Double.parseDouble(percents.get(j)) > Double.parseDouble(percents.get(min))){
					min = j;
				}
				else if(Double.parseDouble(percents.get(j)) == Double.parseDouble(percents.get(min))){
					if(scores.get(j) > scores.get(min)){
						min = j;
					}
				}
			}
			swapValues(min, i);
		}
	}
	private void swapValues(int minPosition, int iPosition){
		Integer scoresTemp1 = scores.get(minPosition);
		Integer scoresTemp2 = scores.get(iPosition);
		
		String percentsTemp1 = percents.get(minPosition);
		String percentsTemp2 = percents.get(iPosition);
		
		String namesTemp1 = names.get(minPosition);
		String namesTemp2 = names.get(iPosition);
		
		Integer waveTemp1 = wave.get(minPosition);
		Integer waveTemp2 = wave.get(iPosition);
		
		Integer cpmsTemp1 = cpms.get(minPosition);
		Integer cpmsTemp2 = cpms.get(iPosition);
		
		scores.set(minPosition, scoresTemp2);
		scores.set(iPosition, scoresTemp1);

		names.set(minPosition, namesTemp2);
		names.set(iPosition, namesTemp1);

		percents.set(minPosition, percentsTemp2);
		percents.set(iPosition, percentsTemp1);
		
		wave.set(minPosition, waveTemp2);
		wave.set(iPosition, waveTemp1);
		
		cpms.set(minPosition, cpmsTemp2);
		cpms.set(iPosition, cpmsTemp1);
	}
	
	public void reverseOrder(){
		Collections.reverse(names);
		Collections.reverse(percents);
		Collections.reverse(scores);
		Collections.reverse(wave);
		Collections.reverse(cpms);
	}
	
	public String getNames(Integer position){
		return names.get(position);
	}
	
	public Integer getScores(Integer position){
		return scores.get(position);
	}
	public String getPercents(Integer position){
		return percents.get(position);
	}
	public Integer getWave(Integer position){
		return wave.get(position);
	}
	public Integer getCPM(Integer position){
		return cpms.get(position);
	}
	
	public ArrayList<String> getList(){
		return names;
	}
	public ArrayList<Integer> getScores(){
		return scores;
	}
	public ArrayList<String> getPercents(){
		return percents;
	}
	public ArrayList<Integer> getWaves(){
		return wave;
	}
	public ArrayList<Integer> getCpms(){
		return cpms;
	}
}
