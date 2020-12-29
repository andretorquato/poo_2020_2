package projeto03;


enum Moeda {
 	M10(0.10, 1),
    M25(0.25, 2),
    M50(0.50, 3),
    M100(1.00, 4);

    double valor;
    int volume;

    Moeda(double valor, int volume) {
        this.valor = valor;
        this.volume = volume;
    }

    public String toString() {
        return "Valor: " + valor + " Volume: " + valor;
    }
}

class Item{
	String descricao;
	int volume;
	
	Item(String descricao, int volume){
		this.descricao = descricao;
		this.volume = volume;
	}
}

class Porco{
	String itens;
	double valor;
	int volume;
	int volumeMax;
	boolean estaQuebrado;
	
	Porco(int volumeMax){
		this.volumeMax = volumeMax;
		this.itens="";
		this.valor = 0;
		this.volume = 0;
		this.estaQuebrado = false;
	}
	
	boolean addMoeda(Moeda moeda) {
		if(this.volume >= this.volumeMax) {
			System.out.println("o cofre está cheio");
			return false;
		}
		
		if(!this.estaQuebrado) {
			this.valor += moeda.valor;
			this.volume += moeda.volume;
			return true;
		}
		
		System.out.println("o cofre está quebrado, pegue suas moedas e itens");
		return false;
	}
	boolean addItem(Item item) {
		if(this.volume >= this.volumeMax) {
			System.out.println("o cofre está cheio");
			return false;
		}
		
		if(!this.estaQuebrado) {
			this.itens += item.descricao + ",";
			this.volume += item.volume;
			return true;
		}
		
		System.out.println("o cofre está quebrado, pegue suas moedas e itens");
		return false;
	}
	
	boolean quebrar() {
		if(!this.estaQuebrado){
			this.estaQuebrado = true;
			return true;
		}
		System.out.println("o cofre já está quebrado");
		return false;
	}
	float pegarMoedas() {
		if(!this.estaQuebrado) {
			System.out.println("cofre não está quebrado");
		}
		System.out.println(this.valor);
		return (float)this.valor;
	}
	
	String pegarItens() {
		if(!this.estaQuebrado) {
			System.out.println("cofre não está quebrado");
		}
		System.out.println(this.itens);
		return this.itens;
	}
	public String toString() {
		return "I:("+this.itens+") M:"+this.valor+" V:"+this.volume+"/"+this.volumeMax+" EQ:"+this.estaQuebrado;
	}
}

public class cofre {

	public static void main(String[] args) {
		Porco porco = new Porco(20);
		System.out.println(porco);
		 System.out.println(porco); //I:() M:0 V:0/20 EQ:false
	        porco.addMoeda(Moeda.M10);
	        porco.addMoeda(Moeda.M50);
	        System.out.println(porco); //I:() M:0.6 V:4/20 EQ:false

	        porco.addItem(new Item("ouro", 3));
	        System.out.println(porco); //I:(ouro) M:0.6 V:7/20 EQ:false

	        porco.addItem(new Item("passaporte", 2));
	        System.out.println(porco); //I:(ouro, passaporte) M:0.6 V:9/20 EQ:false

	        porco.pegarItens();  //Voce deve quebrar o cofre primeiro
	        porco.pegarMoedas(); //Voce deve quebrar o cofre primeiro
	        System.out.println(porco); //I:(ouro, passaporte) M:0.6 V:9/20 EQ:false

	        porco.quebrar();
	        porco.quebrar(); //O cofre ja esta quebrado

	        System.out.println(porco.pegarItens());  //ouro, passaporte
	        System.out.println(porco.pegarMoedas()); //0.6
	        System.out.println(porco); //I:() M:0.0 V:9/20 EQ:true
	}

}
