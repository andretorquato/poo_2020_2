package projetoHospital;

import java.util.ArrayList;
import java.util.HashMap;

interface Paciente{
	public String getId();
	public void addMedico(IMedico medico);
	public void removerMedico(String idMedico);
	public String getMedicos();
}

public class IPaciente implements Paciente{

	String nome;
	String diagnostico;
	HashMap<String, IMedico> medicos = new HashMap<String, IMedico>();
	ArrayList<String> inbox = new ArrayList<String>();
	
	IPaciente(String nome, String problema){
		this.nome = nome;
		this.diagnostico = problema;
	}
	@Override
	public String getId() {
		return this.nome;
	}

	@Override
	public void addMedico(IMedico medico) {		
		this.medicos.put(medico.nome, medico);
	}

	@Override
	public void removerMedico(String idMedico) {}

	@Override
	public String getMedicos() {
		String allMedicos = "";
		
		if(this.medicos.size() > 0) {
			for (IMedico medico: this.medicos.values()) {
				allMedicos += " " + medico.nome + " ";
			}
		}
		return allMedicos;
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
		return "Pac: " + this.nome +":"+ this.diagnostico + "  Meds: [" + this.getMedicos() + "]";
	}
	
}