package projeto09;

public class Car {
	int fuel;
	int fuelMax;
	int people;
	int peopleMax;
	int km;
	boolean drive;
	
	Car(){
		this.fuel=0;
		this.fuelMax=100;
		this.people=0;
		this.peopleMax=2;
		this.km=0;
		this.drive=false;
	}

	boolean in() {
		if(this.people >= 0 && this.people < this.peopleMax) {
			this.people++;
			return true;
		}
		System.out.println("Nivel maximo de peopleageiros atingido");
		return false;
	}
	boolean out() {
		if(this.people > 0) {
			this.people--;
			return true;
		}
		System.out.println("Carro está vazio");
		return false;
	}
	void fuel(int value) {
		this.fuelMax -= this.fuel;
		if(value > this.fuelMax) {
			this.fuel += (value - this.fuelMax);
			return;
		}else if(value < this.fuelMax){
			this.fuel += value;
			return;
		}
	}
	boolean drive(int distance) {
		if(this.people > 0 && this.fuel > 0) 
		{
			if(distance >= this.fuel) {
				distance = this.fuel;
				this.km = distance;
				this.fuel = 0;
				System.out.println("possivel andar apenas " + distance + " km");
			}else if(distance <= this.fuel){
				this.km = distance;
				this.fuel -= distance;
				System.out.println("trajeto completo");
			}
		
			return true;	
		
		}else if(this.people == 0 && this.fuel == 0) {
			System.out.println("Sem Combustivel e Passageiros");
		}else if(this.people == 0) {
			System.out.println("Não a passageiro");
		}else if(this.fuel == 0) {
			System.out.println("Sem Combustivel");
		}
		return false;
	}
	
	public void controls(Car car, String command) {
		
		String line = command;
		String[] ui = line.split(" ");
		if(line.equals("$show")){
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
	
	public String toString() {
		return "people: " + people + " fuel: " + fuel + " km: " + km;  
	}


}
