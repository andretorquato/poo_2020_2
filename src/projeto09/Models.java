package projeto09;

import java.util.Scanner;

public class Models extends Car{
	String model;
	String fuelType;
	Models(String model, String type){
		this.model = model;
		this.fuelType = type;
	}
	
	public void TypeOfFuel(String type, int quantity) {
		if(type.equals("Eletrico")) {
			
				System.out.println("Iniciando o carregamento");
				int i=0;
				while( i < quantity) {
					System.out.println("Carregando...");
					try
					{
					Thread.sleep(400);
					}catch(InterruptedException ex)
					{
					    Thread.currentThread().interrupt();
					}
				    
				    i++;
				}
				
				System.out.println("Seu carro esta pronto!");
			
		}else {
		
		}
		
	}
	
	public void goThrough(int distance){
		int i = 0;
		while( i < distance) {
			if(distance/2 == i) {
				System.out.println("Estrada ruim da peste");
			}
			if(i + 1 == distance) {
				System.out.println("Estamos chegando");
			}
			System.out.println("km " + i);
			try
			{
			Thread.sleep(400);
			}catch(InterruptedException ex)
			{
			    Thread.currentThread().interrupt();
			}
		    
		    i++;
		}
		
	}
	
	boolean drive(int distance) {
		this.goThrough(distance);
		super.drive(distance);
		
		return false;
	}
	public void fuel(int value) {
		this.TypeOfFuel(this.fuelType, value);
		super.fuel(value);
	}
	
	@Override
	public String toString() {
	
		return "Modelo:" + this.model + " " + super.toString();
	}
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o modelo do carro");
		String model = scan.nextLine();
		System.out.println("Tipo de combustivel");
		String type = scan.nextLine();
		
		Car car = new Models(model, type);
		
		while(true) {
			String command = scan.nextLine();
			if(command.equals("end")) {
				break;
			}else { 
			car.controls(car, command);
			}
		}
		
		
		
		scan.close();
		
		
	}
}
