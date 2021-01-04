package projeto06;



import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Operacao{
	String descricao;
	float valor;
	float saldo;
	
	Operacao(String descricao, float valor){
		this.descricao = descricao;
		this.valor = valor;
		this.saldo += (this.valor);
	}
	@Override
	public String toString() {
		return this.descricao+":  "+ this.valor+":  "+this.saldo;
	}
}
class Conta {
	private float saldo;
	int numero;
	ArrayList<Operacao> extrato = new ArrayList<>();
	
	Conta(int numero){
		this.numero = numero;
		this.saldo = 0;
		Operacao operacao = new Operacao("abertura", this.saldo);
		this.extrato.add(operacao);
		
	}
	
	public float getSaldo() {
		return saldo;
	}
	
	public void setSaldo() {
		this.saldo = 0;
		for(Operacao operacao: extrato) {
			this.saldo += operacao.valor;
		}
		
	}
	
	boolean depositar(float value) {
		if(value > 0) {
			Operacao operacao = new Operacao("depositar", value);
			extrato.add(operacao);
			this.setSaldo();
			return true;
		}else {
			System.out.println("digite um valor valido");
			return false;
		}
	}
	
	boolean saque(float value){
		if(value > 0) {
			if((this.getSaldo() - value) < 0 ) {
				System.out.println("Saldo insuficiente");
				return false;
			}else {
				Operacao operacao = new Operacao("saque", (-1*(value)));
				extrato.add(operacao);
				this.setSaldo();
				return true;
			}
				
		}else{
			System.out.println("digite um valor valido");
			return false;
		}
	}
	boolean tarifa(float value) {
		if(value > 0) {
		
			Operacao operacao = new Operacao("tarifa", (-1*(value)));
			extrato.add(operacao);
			this.setSaldo();
			return true;
				
		}else{
			System.out.println("digite um valor valido");
			return false;
		}
	}
	void getExtrato() {
		int i = 0;
 		for(Operacao op: this.extrato) {
 			System.out.println(i+":"+op);
 			i++;
 		}
	}
	void getExtratoLast(int value) {
		for (int i = value; i < extrato.size(); i++) {
			System.out.println(i+":"+extrato.get(i));
		}
	}
	
	void extornar(String[] values){
		List<String>  positions = new ArrayList<>(); 
		for(int i = 1; i < values.length;i++) {
			positions.add(values[i]);
		}
		for (int j = 0; j < positions.size(); j++) {
			if(Integer.parseInt(positions.get(j)) >= extrato.size()) {
				System.out.println("Extrato Inexistente");
			}else{
				if(extrato.get(Integer.parseInt(positions.get(j))).descricao == "tarifa") { 
					extrato.remove(Integer.parseInt(positions.get(j)));
				}else {
					System.out.println("A posição"+ Integer.parseInt(positions.get(j))+" não é uma tarifa");
				}
			}
		}
		this.setSaldo();
	}
	@Override
	public String toString() {
		return "conta:"+this.numero+" saldo: "+this.getSaldo();
	}
}

public class Tarifas {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Conta conta = new Conta(0);
		
		while(true) {
		 	String command = scan.nextLine();
		 	String[] word = command.split(" ");
		 	
		 	if(word[0].equals("init")){
		 		if(Integer.parseInt(word[1]) != conta.numero) {
		 			conta = new Conta(Integer.parseInt(word[1]));
		 		}
		 	}else if(word[0].equals("depositar")) {
		 		conta.depositar(Float.parseFloat(word[1]));
		 	}else if(word[0].equals("saque")) {
		 		conta.saque(Float.parseFloat(word[1]));
		 	}else if(word[0].equals("tarifa")) {
		 		conta.tarifa(Float.parseFloat(word[1]));
		 	}else if(word[0].equals("extrato")) {
		 		conta.getExtrato();
		 	}else if(word[0].equals("extornar")) {
		 		conta.extornar(word);
		 	}else if(word[0].equals("extratoN")) {
		 		conta.getExtratoLast(Integer.parseInt(word[1]));
		 	}else if(word[0].equals("show")) {
		 		System.out.println(conta);
		 	}else if(word[0].equals("end")) {
		 		break;	
		 	}
		 
		}
		
		scan.close();
	}

}
