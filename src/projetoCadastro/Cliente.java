package projetoCadastro;

import java.util.HashMap;
import java.util.Map;

public class Cliente {
	String id;
	
	Map<Integer, Conta> contas = new HashMap<Integer, Conta>();
	
	Cliente(String idCliente, int numContas){
		this.id = idCliente;
		
		int idContaCorrente = numContas + 1;
		int idContaPoupanca = idContaCorrente + 1;
		
		contas.put(idContaCorrente, new ContaCorrente(idContaCorrente, idCliente));
		contas.put(idContaPoupanca, new ContaPoupanca(idContaPoupanca, idCliente));
		
	}

	public String getContas() {
		String contas = "";
		String nome = this.id;
		for(Integer numConta: this.contas.keySet()) {
			contas += 
					numConta+": " 
					+ nome + ": "
					+ this.contas.get(numConta) 
					+ System.lineSeparator();  
		}
		return contas;
	}
	@Override
	public String toString() {
		return this.getContas();
	}
}
