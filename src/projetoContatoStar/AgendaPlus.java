package projetoContatoStar;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AgendaPlus extends Agenda{
	
	Map<String, Contato> favoritos = new HashMap<String, Contato>();
	
	
	public void removeContato(String command) {
		super.removeContato(command);
		
		String[] word = command.split(" ");
		String nome =  word[1];
		String idContato = findContato(nome);
	
		if(favoritos.get(nome) != null) {
			
			if(!favoritos.get(nome).equals(idContato)) {
				favoritos.remove(nome);
			}
		}

		
	}
	public void getBookmarks() {
		String bookmarks = "";
		for(String contato: favoritos.keySet()) {
			bookmarks += favoritos.get(contato).ToString() + System.lineSeparator();
		}
		System.out.println(bookmarks);
	}
	
	public void bookmark(String id){
		if(contatos.get(id) != null) {
		Contato contato = contatos.get(id);
		contato.nome = "@"+contato.nome;
		id = contato.nome;
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
	
	public static void main(String[] args) {

		AgendaPlus agenda = new AgendaPlus();
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
