/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.postodesaude;

/**
 *
 * @author Kalysson
 */
public class Farmaceutico extends Pessoa {

	private String crf;

	public String getCrf() {
		return crf;
	}

	public void setCrf(String crf) {
               this.crf = crf;
	}

	public void atualizarEstoque() {

	}
        public void forneceMedicamentos(Paciente paciente, Medicamento medicamento) {
        Receita receita = encontrarReceita(paciente);
        if (receita != null && receita.getListaMedicamentos().contains(medicamento)) {
            System.out.println("Farmacêutico com CRF " + crf + " fornecendo medicamento " + medicamento.getNomeMedicamento() + " para o paciente com prontuário " + paciente.getProntuario() + ".");
        } else {
            System.out.println("Paciente não tem uma receita para este medicamento.");
        }
    }

   
    private Receita encontrarReceita(Paciente paciente) {
    for (Receita receita : PostoDeSaude.getReceitas()) {
        if (receita.getPaciente().equals(paciente)) {
            return receita;
        }
    }
    return null;
}

}
