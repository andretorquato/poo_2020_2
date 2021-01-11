package projetoCinema;

import java.util.ArrayList;

class Cliente{
	String id;
	String fone;
	Cliente(String id, String fone){
		this.id = id;
		this.fone = fone;
	}
	@Override
	public String toString() {
		return this.id+":"+this.fone;
	}
}

public class Cinema {
	
	ArrayList<Cliente> cliente = new ArrayList<>();
	
	Cinema(int size){
		for (int i = 0; i < size; i++) {
			cliente.add(null);
		}
	}
	
	void reservar(String id, String fone, int indice) {
		Cliente cliente = new Cliente(id, fone);
		this.cliente.set(indice, cliente);
	}
	
	boolean cancelar(String id) {
		for (int i = 0; i < this.cliente.size(); i++) {
			if(id == this.cliente.get(i).id) {
				this.cliente.set(i, null);
				System.out.println("cliente cancelado");
				return true;
			}
		}
		System.out.println("cliente não reservado!");
		return false;
	}
	@Override
	public String toString() {
		String clientes = " ";
		for(Cliente cliente: this.cliente) {
			if(cliente == null) {
				clientes += " - ";
			}else {
				clientes += cliente;
			}
		}
		return "["+ clientes+ "]";
	}
	public static void main(String[] args) {
		Cinema cinema = new Cinema(3);
		System.out.println(cinema);
		cinema.reservar("André", "8899", 0);
		System.out.println(cinema);
		cinema.cancelar("André");
		System.out.println(cinema);
	}

}
