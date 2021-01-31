package projeto07;

import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {

	
	ArrayList<Contato> contatos = new ArrayList<>();
	
	Agenda(){}
	
	public void adicionarContato(String command) {
		String[] word = command.split(" ");
			
		ArrayList<String> labels = new ArrayList<>();
		String nome =  word[1];
		labels = pegarNumeros(word);
		Contato contato = new Contato(nome);
		int verificaContato = findContato(nome);
		
		if(verificaContato == -1) {
			for(int numero = 0; numero < labels.size(); numero++) {
				String label = labels.get(numero);
				contato.addFone(label);
			}
			
			contatos.add(contato);
		}else {
			for(int numero = 0; numero < labels.size(); numero++) {
				String label = labels.get(numero);
				contatos.get(verificaContato).addFone(label);
			}
			
		}
	}
	
	public void removeContato(String command) {
		String[] word = command.split(" ");
		String nome =  word[1];
		int posicaoContato = findContato(nome);
		int index = -1;
		if(word.length > 2) {
			 index = Integer.parseInt(word[2]);
		}
		
		if(index == -1 && posicaoContato != -1) {
			contatos.remove(posicaoContato);
		}else if(index != -1 && posicaoContato != -1) {
			contatos.get(posicaoContato).removeFone(index);
			
		}else{
			System.out.println("Contato não encontrado");
		}
		
		
		
	}
	
	ArrayList<Contato> search(String pattern){
	    ArrayList<Contato> result = new ArrayList<>();
	     
	    for(Contato contato : this.contatos){
	    	
	    	if(contato.nome.indexOf(pattern) != -1) {
	        	result.add(contato);
	        }else {
	        	for(Fone fone : contato.fones) {
		    		if(fone.label.indexOf(pattern) != -1 || fone.number.indexOf(pattern) != -1 ) {
			        	result.add(contato);
			        }
		    	}
	        }
	    	
	    }
	    
	    if(result.size() == 0) {
	    	System.out.println("nada encontrado");
	    }else {
	    	for(Contato contato: result) {
		    	System.out.println(contato.ToString());
		    }
	    }
	    
	    return result;
	}
	public int findContato(String nome) {
		int posicao = -1;
	     for(int posicaoDoContato = 0; posicaoDoContato < contatos.size(); posicaoDoContato++) {
				if(contatos.get(posicaoDoContato).nome.equals(nome)) {
					posicao = posicaoDoContato;
				}
			}
	     return posicao;
	}
	
	public ArrayList<String> pegarNumeros(String[] numeros) {
		ArrayList<String> labels = new ArrayList<>();
		if(numeros.length > 1) {
			for(int numero = 2; numero < numeros.length; numero++) {
				labels.add(numeros[numero]);
			}
		}
		  
		return labels; 
	}
	@Override
	public String toString() {
		String allContatos = "";
		for(Contato contato: contatos) {
			allContatos += contato.ToString();
		}
		return ""+allContatos+"";
	}
	public static void main(String[] args) {

		Agenda agenda = new Agenda();
		Scanner scan = new Scanner(System.in);
		
		
		while(true) {
			String command = scan.nextLine();
			String[] word = command.split(" ");
			if(word[0].equals("add")) {
				agenda.adicionarContato(command);
			}else if(word[0].equals("rm")) {
				agenda.removeContato(command);
			}else if(word[0].equals("show")){
				System.out.println(agenda.toString());
			}else if(word[0].equals("search")){
				agenda.search(word[1]);
			}else if(word[0].equals("end")) {
				System.out.println("PROGRAMA ENCERRADO!");
				break;
			}
			
		}
		scan.close();
	}

}
