package projetoCadastro;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		  Scanner scanner = new Scanner(System.in);
		    Agencia agencia = new Agencia();
		    
		    while(true){
		        String line = scanner.nextLine();
		        System.out.println("$" + line);
		        String ui[] = line.split(" ");
		        try {
		            if (ui[0].equals("end"))
		                break;
		            else if (ui[0].equals("addCli")) {
		                agencia.adicionarCliente(ui[1]);
		            } else if (ui[0].equals("show")) {
		                System.out.print(agencia);
		            } else if (ui[0].equals("deposito")) {
		            	Conta conta = agencia.contas.get(Integer.parseInt(ui[1]));
		            	conta.depositar(Float.parseFloat(ui[2]));
		            }else if (ui[0].equals("saque")) {
		            	Conta conta = agencia.contas.get(Integer.parseInt(ui[1]));
		            	conta.sacar(Float.parseFloat(ui[2]));
		            }else if (ui[0].equals("transf")) {
		            	Conta contaEnvia = agencia.contas.get(Integer.parseInt(ui[1]));
						contaEnvia.transferir(Float.parseFloat(ui[3]), "envia");
						Conta contaRecebe = agencia.contas.get(Integer.parseInt(ui[2]));
						contaRecebe.transferir(Float.parseFloat(ui[3]), "recebe");
		            }else if (ui[0].equals("update")) {
		            	for(Conta conta: agencia.contas.values()) {
		            		conta.atualizacaoMensal();
		            	}
		            }else{
		                System.out.println("fail: comando invalido");
		            }
		        }catch(RuntimeException rt){
		            System.out.println(rt.getMessage());
		        }
		    }
		    scanner.close();
		}


	

}
