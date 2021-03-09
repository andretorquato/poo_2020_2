package projetoCadastro;

import java.util.HashMap;
import java.util.Map;

public class Agencia {
		
	Map<String, Cliente> clientes = new HashMap<String, Cliente>();
	Map<Integer, Conta> contas = new HashMap<Integer, Conta>();
		
	public void adicionarCliente(String idCliente){
		int numContas = contas.size();
		clientes.put(idCliente, new Cliente(idCliente, numContas));
		
		cliente(idCliente);
	}
	
	public void cliente(String idCliente) {
		if(clientes.get(idCliente) != null) {
			for(Conta conta: clientes.get(idCliente).contas.values()) {
				contas.put(conta.id, conta);
			}
		}else {
			System.out.println("Usuário não encontrado!");
		}
	}

	public String getClientes() {
		String clientes = "";
		for(Cliente cliente: this.clientes.values()) {
			clientes += cliente;
		}
		
		return clientes;
	}
	@Override
	public String toString() {
		return this.getClientes();
	}
}
