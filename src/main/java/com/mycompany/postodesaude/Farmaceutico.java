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
        // Verifica se o paciente tem uma receita associada
        Receita receitaPaciente = null;
        for (Receita receita : PostoDeSaude.getReceitas()) {
            if (receita.getPaciente().equals(paciente)) {
                receitaPaciente = receita;
                break;
            }
        }
        
        if (receitaPaciente == null) {
            System.out.println("Paciente não possui receita.");
            return;
        }
        
        // Verifica se o medicamento está na receita
        boolean medicamentoPrescrito = false;
        for (Medicamento med : receitaPaciente.getListaMedicamentos()) {
            if (med.getNomeMedicamento().equals(medicamento.getNomeMedicamento())) {
                medicamentoPrescrito = true;
                break;
            }
        }
        
        if (medicamentoPrescrito) {
            System.out.println("Medicamento " + medicamento.getNomeMedicamento() + " fornecido ao paciente " + paciente.getNome() + ".");
        } else {
            System.out.println("Medicamento " + medicamento.getNomeMedicamento() + " não está prescrito na receita.");
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
