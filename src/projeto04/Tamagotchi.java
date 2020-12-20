package projeto04;

import java.util.Scanner;

class Pet{
	private int energyMax;
	private int hungryMax;
	private int cleanMax;
	private int energy;
	private int hungry;
	private int clean;
	private int diamond;
	private int age;
	private boolean alive;
	
	Pet(int energyValue, int hungryValue, int cleanValue){
		this.setEnergyMax(energyValue);
		this.setHungryMax(hungryValue);
		this.setCleanMax(cleanValue);
		this.setDiamond(0);
		this.setAge(0);
		this.isAlive(true);
	}
	
	private void setEnergyMax(int value) {
		energyMax = value;
		this.setEnergy(energyMax);
	}
	private void setHungryMax(int value) {
		hungryMax = value;
		this.setHungry(hungryMax);
	}
	private void setCleanMax(int value) {
		cleanMax = value;
		this.setClean(cleanMax);
	}
	private int setEnergy(int value){
		 return this.energy += value;
	}
	private int setHungry(int value){
		 return this.hungry += value;
	}
	private int setClean(int value) {
		return this.clean += value;
	}
	private int setDiamond(int value) {
		return this.diamond += value;
	}
	
	private int setAge(int value) {
		return this.age += value;
	}
	
	private boolean isAlive(boolean alive){
		
		if(!alive) {
			System.out.println("fail: pet esta morto");
		}
		return this.alive = alive;
	}
	public void play(){
		if(alive) {
			if(energy > 0 ) {
				this.setEnergy(-2);	
			}else {
				System.out.println("fail: pet morreu de fraqueza");
				this.isAlive(false);
			}
			if(hungry > 0) {
				this.setHungry(-1);
			}else {
				System.out.println("fail: pet morreu de fome");
				this.isAlive(false);
			}
			if(clean > 0) {
				this.setClean(-3);
			}else{
				System.out.println("fail: pet morreu sujo");
				this.isAlive(false);
				
			}
			if(energy > 0 && hungry > 0 && clean > 0) {
				this.setDiamond(1);
				this.setAge(1);
			}
		}

		
	}
	public void show() {
		System.out.println("E:"+ energy + "/" + energyMax + " S: " + hungry + "/" + hungryMax + " L: " + clean + "/" + cleanMax
				+ "\nD:" + diamond + "\nI:" + age);
	}
	
	public void eat() {
		this.setEnergy(-1);
		this.setHungry(4);
		this.setClean(-2);
		this.setAge(1);
	}
	public void sleep() {
		this.setEnergy(energyMax);
	}
	public void clean() {
		this.setEnergy(-3);
		this.setHungry(-1);
		this.setClean(cleanMax);
		
	}
	
}
public class Tamagotchi {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		Scanner scan = new Scanner(System.in);
		
		String initTamagoth = scan.nextLine();
		String[] init = initTamagoth.split(" ");
		
		if(init[0].equals("init")) {
			Pet pet = new Pet(Integer.parseInt(init[1]), Integer.parseInt(init[2]), Integer.parseInt(init[3]));
			while(true) {
				String line = scan.nextLine();
				String[] ui = line.split(" ");
				if(line.equals("play")) {
					pet.play();
				}else
				if(line.equals("show")) {
					pet.show();
				}else if(line.equals("eat")) {
					pet.eat();
				}else if(line.equals("clean")){
					pet.clean();
				}else if(line.equals("sleep")){
					pet.sleep();
				}else if(line.equals("end")) {
					break;
				}
		}
		
		}
		
		
		scan.close();
	}

}
