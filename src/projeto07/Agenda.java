package projeto07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Agenda {

	
	Map<String, Contato> contatos = new HashMap<String, Contato>();
	Map<String, Contato> favoritos = new HashMap<String, Contato>();
	Agenda(){}
	
	public void adicionarContato(String command) {
		String[] word = command.split(" ");
			
		ArrayList<String> labels = new ArrayList<>();
		String nome =  word[1];
		labels = pegarNumeros(word);
		Contato contato = new Contato(nome);
		String contatoNotFound = "";
		String idContato = findContato(nome);
		
		if(idContato.equals(contatoNotFound)) {
			for(int numero = 0; numero < labels.size(); numero++) {
				String label = labels.get(numero);
				contato.addFone(label);
			}
			String id = contato.nome;
			contatos.put(id,contato);
		}else {
			for(int numero = 0; numero < labels.size(); numero++) {
				String label = labels.get(numero);
				contatos.get(idContato).addFone(label);
			}
			
		}
	}
	
	public void removeContato(String command) {
		String[] word = command.split(" ");
		String nome =  word[1];
		String idContato = findContato(nome);
		String contatoNotFound = "";
		
		// este index é para saber sé é para deletar um número de telefone
		// ou contato se contiver mais de uma palavra commando então deleta número em vez
		// do contato
		int index = -1;
		if(word.length > 2) {
			 index = Integer.parseInt(word[2]);
		}
		
		if(index == -1 && !idContato.equals(contatoNotFound)) {
			contatos.remove(idContato);
			if(favoritos.get(idContato) != null) {
				favoritos.remove(idContato);
			}
		}else if(index != -1 && !idContato.equals(contatoNotFound)) {
			contatos.get(idContato).removeFone(index);
			
		}else{
			System.out.println("Contato não encontrado");
		}
		
		
		
	}
	
	ArrayList<Contato> search(String pattern){
	    ArrayList<Contato> result = new ArrayList<>();
	     
	    for(Contato contato : this.contatos.values()){
	    	
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
	
	public String findContato(String nome) {
		String id = "";
	     for(String find: contatos.keySet()) {
				if(contatos.get(find).nome.equals(nome)) {
					id = find;
				}
			}
	     return id;
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
		for(String contato: contatos.keySet()) {
			allContatos += contatos.get(contato).ToString() + System.lineSeparator();
		}
		return ""+allContatos+"";
	}
	
	
	public void bookmark(String id){
		if(contatos.get(id) != null) {
		Contato contato = contatos.get(id);
		contato.nome = "@"+contato.nome;
		favoritos.put(id, contato);
		}else {
			System.out.println("fail: contato não encontrado");
		}
	}
	
	public void unBookmark(String id) {
		if(contatos.get(id) != null) {
		Contato contato = contatos.get(id);
		contato.nome = id;
		for(String procurar: favoritos.keySet()) {
			if(procurar.equals(id)) {
				favoritos.remove(id);
			}
			}
		}else {
			System.out.println("fail: contato não encontrado");
		}
	}
	public void getBookmarks() {
		String bookmarks = "";
		for(String contato: favoritos.keySet()) {
			bookmarks += favoritos.get(contato).ToString() + System.lineSeparator();
		}
		System.out.println(bookmarks);
	}
	public static void main(String[] args) {

		Agenda agenda = new Agenda();
		Scanner scan = new Scanner(System.in);
		
		
		while(true) {
			String command = scan.nextLine();
			String[] word = command.split(" ");
			if(word[0].equals("add") && word.length > 1) {
				agenda.adicionarContato(command);
			}else if(word[0].equals("rm") && word.length > 1) {
				agenda.removeContato(command);
			}else if(word[0].equals("show")){
				System.out.println(agenda.toString());
			}else if(word[0].equals("search")){
				agenda.search(word[1]);
			}else if(word[0].equals("star") && word.length > 1){
				agenda.bookmark(word[1]);
			}else if(word[0].equals("unstar") && word.length > 1){
				agenda.unBookmark(word[1]);
			}else if(word[0].equals("starred")){
				agenda.getBookmarks();
			}else if(word[0].equals("end")) {
				System.out.println("PROGRAMA ENCERRADO!");
				break;
			}else {
				System.out.println("fail: erro no comando");
			}
			
		}
		scan.close();
	}

}
