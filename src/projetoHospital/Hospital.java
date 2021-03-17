package projetoHospital;

import java.util.HashMap;

import java.util.Map;

public class Hospital {
	
	Map<String, IPaciente> pacientes = new HashMap<String, IPaciente>();
	Map<String, IMedico> medicos = new HashMap<String, IMedico>();

	public void addPacientes(IPaciente paciente){
		pacientes.put(paciente.nome, paciente);
	}
	public void addMedicos(IMedico medico ){
		medicos.put(medico.nome, medico);
	}
	
	public void vincular(String nomePaciente, String nomeMedico){
		
		IMedico medico = medicos.get(nomeMedico);
		IPaciente paciente = pacientes.get(nomePaciente);
		if(medico != null && paciente != null) {
			if(!checkMedicoEspecialiade(paciente, medico) && !checkListMedico(paciente, medico)) {
				pacientes.get(nomePaciente).addMedico(medico);
				medicos.get(nomeMedico).addPaciente(paciente);
			}
			
		}else {
			System.out.println("Ops.. Medico ou Paciente não encontrado");
		}
	}
	
	public void showAll(){
		this.showPacs();
		this.showMeds();	
	}
	
	public void showPacs(){
		for (IPaciente paciente: this.pacientes.values()) {
			System.out.println(paciente.toString());
		}
	}
	
	public void showMeds(){
		for (IMedico medico : this.medicos.values()) {
			System.out.println(medico.toString());
		}
	}
	public IMedico checkIsDoctor(String nome){
		IMedico medico = medicos.get(nome);
		return medico;
	}
	
	public IPaciente checkIsPatient(String nome){
		IPaciente paciente = pacientes.get(nome);
		return paciente;
	}
	
	public Boolean checkMedicoEspecialiade(IPaciente paciente, IMedico medConsultado) {
		for(IMedico medico: paciente.medicos.values()) {
			if(medico.especialidade.equals(medConsultado.especialidade)) {
				return true;
			}
		}
		return false;
	}
	public Boolean checkListMedico(IPaciente pacienteConsultado, IMedico medico) {
		for(IPaciente paciente: medico.pacientes.values()) {
			if(paciente.nome.equals(pacienteConsultado.nome)) {
				return true;
			}
		}
		return false;
	}
}
