package projeto0602;

public class Pass {
	String name;
	int idade;
	
	Pass(String id, int idade){
		this.name = id;
		this.idade = idade;
	}
	
	@Override
	public String toString() {
		return this.name +":"+ this.idade+" ";
	}
}
