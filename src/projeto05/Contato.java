package projeto05;

import java.util.ArrayList;
import java.util.Scanner;

class Fone{
	String label;
	String number;
	
	Fone(String label, String number){
		this.label= label;
		this.number= number;
	}
	boolean validate(String number){
		for(int i = 0; i < number.length();i++) {
			if(number.charAt(i) == '0' || number.charAt(i) == '1' || number.charAt(i) == '2' || number.charAt(i) == '3' || number.charAt(i) == '4' || number.charAt(i) == '5' ||  number.charAt(i) == "6" || number.charAt(i) == '7' || number.charAt(i) == '8' || number.charAt(i) == '9' ||number.charAt(i) == '(' || number.charAt(i) == ')' ) {
				if((i+1) == number.length()) {
					return true;
				}
			}else {
				return false;
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.label+":"+this.number;
	}
}
public class Contato {
	String nome;
	Fone fone;
	ArrayList<Fone> fones = new ArrayList<>();
	
	Contato(int id){
		this.nome = "";
	}
	
	void addFone(String label, String number) {
		this.fone = new Fone(label, number);
		if(this.fone.validate(number) == true) {
			this.fones.add(fone);
		}else {
		System.out.println("fail: numero invalido");
		}
	}
	
	void removeFone(int index) {
		fones.remove(index);
	}
	public String ToString() {
		String allFones = "";
		int position = 0;
		for(Fone fone: this.fones) {
			allFones += " "+String.valueOf(position)+":"+fone;
			position++;
		}
		return "- " + this.nome+" ["+allFones+"]";
	}
	
	
	public static void main(String[] args) {
		
		ArrayList<Contato> contatos = new ArrayList<>();
		int qtdContatos = contatos.size();
		Contato contato = new Contato(qtdContatos);
		Scanner scan = new Scanner(System.in);
		
		
		while(true) {
			String command = scan.nextLine();
			String[] word = command.split(" ");
			if(word[0].equals("init")) {
				contato.nome = word[1];
			}else if(word[0].equals("add")) {
				contato.addFone(word[1], word[2]);
			}else if(word[0].equals("remove")) {
				contato.removeFone(Integer.parseInt(word[1]));
			}else if(word[0].equals("show")){
				System.out.println(contato.ToString());
			}else if(word[0].equals("end")) {
				System.out.println("PROGRAMA ENCERRADO!");
				break;
			}
			
		}
		scan.close();
	}	
	
}
