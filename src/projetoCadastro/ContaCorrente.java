package projetoCadastro;

public class ContaCorrente extends Conta{
	
	float tarifaMensal;
	
	ContaCorrente(int id, String idCliente) {
		super(id, idCliente);
	}

	public void atualizacaoMensal() {
		float saldo = this.getSaldo() - 20;
		this.setSaldo(saldo);
	}
	
	@Override
	public String toString() {
		return "R$"+this.getSaldo() + ":CC";
	}

}
