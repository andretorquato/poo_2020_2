package projeto0602;

import java.util.ArrayList;
import java.util.Scanner;

public class Topic {
	
	ArrayList<Pass> cadeiras = new ArrayList<>();
	int qtdPref;
	Topic(int lotacao, int qtdPref){
		for(int i = 0; i < lotacao; i++) {
			this.cadeiras.add(null);
		}
		this.qtdPref =qtdPref;
	}
	void subir(String id, int idade){
		
		Pass pass = new Pass(id, idade);
		int position = -1;
		for(int i = 0; i < this.cadeiras.size();i++) {
			
			if(cadeiras.get(i) != null && this.cadeiras.get(i).name.equals(id)) {
				System.out.println("usuario j� est� embarcado");
				return;
			}
		}
		if(idade >= 60) {
			for(int i = 0; i < this.qtdPref ;i++) {
				if(cadeiras.get(i) == null) {
					position = i;
					break;
				}else {
				position = -1;
				}
			}
			if(position == -1) {
			for(int i = 0; i < this.cadeiras.size();i++) {
			  if(cadeiras.get(i) == null) {
					position = i;
					break;
				 }
			  }
			if(position == -1) {
				System.out.println(id + " est� lotado!");
			}
		   }

		}else {

			for(int i = 0; i < this.cadeiras.size();i++) {
				 if(cadeiras.get(i) == null && i > this.qtdPref -1){
					  position = i;
					  break;
				  }else if(i == cadeiras.size() -1) {
						for(int j = 0; j < this.qtdPref; j++) {
							if(this.cadeiras.get(j) == null) {
								position = j;
								break;
							}
						}
						break;
					 }else {
					 		position = -1;
					 }
			}
			if(position == -1) {
				System.out.println(id + " est� lotado!");
			}
		}
		if(position >= 0) {
			cadeiras.set(position, pass);
		}
		
	}
	
	void descer(String name) {
		int position = -1;
		
		for(int i = 0; i < cadeiras.size(); i++) {
			if(cadeiras.get(i) == null) {
	
			}else if(cadeiras.get(i).name.equals(name)) {
				position = i;
			}
		}
		if(position >= 0) {
			this.cadeiras.set(position, null);
		}
	}
	
	@Override
	public String toString() {
		String passengers = "";
		int qtdPreferenciais = this.qtdPref;
		for(int i=0; i < cadeiras.size(); i++) {
			if(i < qtdPreferenciais) {
				if(this.cadeiras.get(i) == null) {
					passengers += " @ ";
				}else {
					passengers += " @"+this.cadeiras.get(i);
				}
					
			}else{
				if(this.cadeiras.get(i) == null) {
					passengers += " = ";
				}else {
					passengers += " ="+this.cadeiras.get(i);
				}
			}
			
		}
		return "[" + passengers +"]";
	}
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Topic topic;
		
		while(true) {
			String start = scan.nextLine();
			String[] wordStart = start.split(" ");
			if(wordStart[0].equals("init")) {
				topic = new Topic(Integer.parseInt(wordStart[1]), Integer.parseInt(wordStart[2]));
				break;
			}else {
				System.out.println("inicie o projeto com: init quantidadeCadeiras quantidadeCadeirasPreferenciais");	
			}
			
		}
		while(true) {
			String command = scan.nextLine();
			String[] word = command.split(" ");
			if(word[0].equals("show")) {
				System.out.println(topic);
			}else if(word[0].equals("entrar")){
				topic.subir(word[1], Integer.parseInt(word[2]));
			}else if(word[0].equals("descer")){
				topic.descer(word[1]);
			}else if(word[0].equals("end")){
				break;
			}
		}
		scan.close();
	}

}
