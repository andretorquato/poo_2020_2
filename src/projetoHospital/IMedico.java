package projetoHospital;


import java.util.ArrayList;
import java.util.HashMap;


interface Medico{
	public String getId();
	public void addPaciente(IPaciente paciente);
	public void removerPaciente(String idPaciente);
	public String getPacientes();
}

public class IMedico implements Medico{

	String nome;
	String especialidade;
	HashMap<String, IPaciente> pacientes = new HashMap<String, IPaciente>();
	ArrayList<String> inbox = new ArrayList<String>();
	
	IMedico(String nome, String especialidade){
		this.nome = nome;
		this.especialidade = especialidade;
		
	}
	@Override
	public String getId() {return null;}

	@Override
	public void addPaciente(IPaciente paciente) {
		this.pacientes.put(paciente.nome, paciente);
		
	}

	@Override
	public void removerPaciente(String idPaciente) {}

	@Override
	public String getPacientes() {
	
		String pacientes = "";
		
		if(this.pacientes.size() > 0) {
			for (IPaciente paciente: this.pacientes.values()) {
				pacientes += " " + paciente.nome + " ";
			}
		}
		
		return pacientes;
	}
	public void sendMessage(String message) {
		inbox.add(message);
	}
	public  void seeInbox() {
		for (String msg : inbox) {
			System.out.println(msg);
		}
	}
	@Override
	public String toString() {
		
		return "Med: " + this.nome +":"+ this.especialidade + "  Pacs: [" + this.getPacientes() + "]";
	}
	
	
}