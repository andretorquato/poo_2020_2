package projeto02;

import java.util.Scanner;

public class Car {
	int gas;
	int gasMax;
	int pass;
	int passMax;
	int km;
	boolean drive;
	
	Car(){
		this.gas=0;
		this.gasMax=100;
		this.pass=0;
		this.passMax=2;
		this.km=0;
		this.drive=false;
	}

	boolean in() {
		if(this.pass >= 0 && this.pass < this.passMax) {
			this.pass++;
			return true;
		}
		System.out.println("Nivel maximo de passageiros atingido");
		return false;
	}
	boolean out() {
		if(this.pass > 0) {
			this.pass--;
			return true;
		}
		System.out.println("Carro está vazio");
		return false;
	}
	void fuel(int value) {
		this.gasMax -= this.gas;
		if(value > this.gasMax) {
			this.gas += (value - this.gasMax);
			return;
		}else if(value < this.gasMax){
			this.gas += value;
			return;
		}
	}
	boolean drive(int distance) {
		if(this.pass > 0 && this.gas > 0) 
		{
			if(distance >= this.gas) {
				distance = this.gas;
				this.km = distance;
				this.gas = 0;
				System.out.println("possivel andar apenas " + distance + " km");
			}else if(distance <= this.gas){
				this.km = distance;
				this.gas -= distance;
				System.out.println("trajeto completo");
			}
		
			return true;	
		
		}else if(this.pass == 0 && this.gas == 0) {
			System.out.println("Sem gasolina e passageiro");
		}else if(this.pass == 0) {
			System.out.println("Não a passageiros");
		}else if(this.gas == 0) {
			System.out.println("Sem gasolina");
		}
		return false;
	}
	public String toString() {
		return "pass: " + pass + " gas: " + gas + " km: " + km;  
	}
	public static void main(String[] args) {
		Car car = new Car();
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			String line = scan.nextLine();
			String[] ui = line.split(" ");
			if(line.equals("end")) {
				break;
			}else if(line.equals("$show")){
                System.out.println(car);
            }else if(line.equals("$in")){
                car.in();
            }else if(line.equals("$out")){
                car.out();
            }else if(ui[0].equals("$fuel")){
                car.fuel(Integer.parseInt(ui[1]));
            }else if(ui[0].equals("$drive")){
                car.drive(Integer.parseInt(ui[1]));
            }else{
                System.out.println("fail: comando invalido");
            }
		}
		scan.close();
	}

}
