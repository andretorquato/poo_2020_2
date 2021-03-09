package projetoCadastro;

public class ContaPoupanca extends Conta {
	float rendimento;
	
	ContaPoupanca(int id, String idCliente) {
		super(id, idCliente);
	}

	public void atualizacaoMensal() {
		float saldo = (float) (this.getSaldo() * 0.5) + this.getSaldo();
		this.setSaldo(saldo);
	}
	@Override
	public String toString() {
		return "R$"+this.getSaldo() + ":CP";
	}

}
