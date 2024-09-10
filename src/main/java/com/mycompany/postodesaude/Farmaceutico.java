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

	public Farmaceutico(String nome, String cpf, int idade, String telefone, String crf){
		setNome(nome);
		setCpf(cpf);
		setIdade(idade);
		setTelefone(telefone);
		this.crf = crf;
	}

	public void setCrf(String crf) {
		this.crf = crf;
	}

	public String getCpf(){
		return crf;
	}

	public void atualizarEstoque() {

	}

	public void forneceMedicamentos(Paciente paciente,Medicamento medicamento) {
        // Lógica para fornecer medicamentos ao paciente
        System.out.println("Farmacêutico fornecendo medicamento " + medicamento.getNomeMedicamento() + " para o paciente com prontuário " + paciente.getProntuario() + ".");
    }

}
