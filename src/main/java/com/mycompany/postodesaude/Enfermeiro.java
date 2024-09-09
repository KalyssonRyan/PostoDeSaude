/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.postodesaude;

/**
 *
 * @author Kalysson
 */
public class Enfermeiro extends Pessoa {

	private String coren;

	public void aplicarMedicacao(Paciente paciente,Medicamento medicamento) {
            System.out.println("Enfermeiro com COREN " + coren + " aplica o medicamento " + medicamento + " no paciente com prontuário " + paciente.getProntuario() + ".");
	}

	public void realizarInjecao(Paciente paciente) {
            System.out.println("Enfermeiro com COREN " + coren + " realizando injeção no paciente com prontuário " + paciente.getProntuario() + ".");
	}

	public String getCoren() {
		return null;
	}

	public void setCoren(String coren) {

	}

}
