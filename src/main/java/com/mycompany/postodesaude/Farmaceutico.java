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
		return null;
	}

	public void setCrf(String crf) {

	}

	public void atualizarEstoque() {

	}

	public void forneceMedicamentos(Paciente paciente,Medicamento medicamento) {
        // Lógica para fornecer medicamentos ao paciente
        System.out.println("Farmacêutico fornecendo medicamento " + medicamento + " para o paciente com prontuário " + paciente.getProntuario() + ".");
    }

}
