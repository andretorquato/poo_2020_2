package projetoHospital;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		  Scanner scanner = new Scanner(System.in);
		    Hospital hospital = new Hospital();
		    
		    while(true){
		        String line = scanner.nextLine();
		        System.out.println("$" + line);
		        String ui[] = line.split(" ");
		        try {
		            if (ui[0].equals("end"))
		                break;
		            else if (ui[0].equals("addPacs")) {
		            	for (int i = 1; i < ui.length; i++) {
							String string = ui[i];
							String informacoes[] = string.split("-");
							String nome = informacoes[0];
							String diagnostico = informacoes[1];
							
							IPaciente paciente = new IPaciente(nome, diagnostico);
							hospital.addPacientes(paciente);
						}
		            	
		            }else if (ui[0].equals("addMeds")) {
		            	for (int i = 1; i < ui.length; i++) {
							String string = ui[i];
							String informacoes[] = string.split("-");
							String nome = informacoes[0];
							String especialidade = informacoes[1];
							
							IMedico medico = new IMedico(nome, especialidade);
							hospital.addMedicos(medico);
						}
		            	
		            } else if (ui[0].equals("seeAll")) {
		            		hospital.showAll();
		            } else if (ui[0].equals("tie")) {
		            	String nomeMedico = ui[1];
		             	for (int i = 2; i < ui.length; i++) {
							String nomePaciente = ui[i];
							hospital.vincular(nomePaciente, nomeMedico);
		             	}
		             	
		            }else if (ui[0].equals("msg")) {
		            	IPaciente paciente;
		            	IMedico medico;
		            	String msg = ui[1]+": ";
		                for(int i = 3; i < ui.length; i++)
		                    msg += ui[i] + " ";
		                
		            	if(hospital.pacientes.get(ui[1]) != null) {
		            		paciente = hospital.checkIsPatient(ui[1]);
		            		medico = hospital.checkIsDoctor(ui[2]);
		            		paciente.sendMessage(msg);
		            	}else {
		            		paciente = hospital.checkIsPatient(ui[2]);
		            		medico = hospital.checkIsDoctor(ui[1]);
		            		medico.sendMessage(msg);
		            	}
		            	if(paciente == null || medico == null) {
		            		System.out.println("fail: "+ ui[1]+ " não conheçe " +ui[2]);
		            	}
		                
		            }else if (ui[0].equals("inbox")) {
		            	IPaciente paciente;
		            	IMedico medico;
		            	if(hospital.pacientes.get(ui[1]) != null) {
		            		paciente = hospital.checkIsPatient(ui[1]);
		            		paciente.seeInbox();
		            		paciente.inbox.clear();
		            	}else if(hospital.medicos.get(ui[1]) != null){
		            		medico = hospital.checkIsDoctor(ui[1]);
		            		medico.seeInbox();
		            		medico.inbox.clear();
		            	}
		            }else if (ui[0].equals("update")) {
		            	//for(Conta conta: agencia.contas.values()) {
		            	//conta.atualizacaoMensal();
		            	//}
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
