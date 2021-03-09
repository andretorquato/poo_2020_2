package projetoCadastro;

public class Conta {

	int id;
	String idCliente;
	private float saldo;
	String type;
	
	Conta(int id, String idCliente ){
		this.id = id;
		this.idCliente = idCliente;
		this.saldo = 0;
	}
	
	public void depositar(float value) {
		float saldo = this.getSaldo() + value;
		this.setSaldo(saldo);
	}

	public void sacar(float value) {
		
		if(this.getSaldo() < value) {
			System.out.println("fail: Você não tem saldo suficiente!");
		}else {
			float saldo = this.getSaldo() - value;
			this.setSaldo(saldo);	
		}
	}
	
	public void transferir(float value, String type) {
		if(this.getSaldo() < value && !type.equals("recebe")) {
			System.out.println("fail: Saldo insuficiente para a transferência");
		}else {
			if(type.equals("envia")) {
				float saldo = this.getSaldo() - value;
				this.setSaldo(saldo);
			}else if(type.equals("recebe")) {
				float saldo = this.getSaldo() + value;
				this.setSaldo(saldo);
			}
		}

	}
	
	public void atualizacaoMensal() {}
	
	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
}
