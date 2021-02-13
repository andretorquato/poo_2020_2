package projeto08;

import java.util.ArrayList;

public class Contato {
	String nome;
	Fone fone;
	ArrayList<Fone> fones = new ArrayList<>();
	
	Contato(String nome){
		this.nome = nome;
	}
	
	void addFone(String labelData) {
		String newlabelData[] = labelData.split(":");
		String label = newlabelData[0];
		String number = newlabelData[1];
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
	
}
