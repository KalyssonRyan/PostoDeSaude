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

    public void aplicarMedicacao(Paciente paciente, Medicamento medicamento, Medico medico) {
        Receita receita = encontrarReceita(paciente, medico);
        if (receita != null && receita.getListaMedicamentos().contains(medicamento)) {
            System.out.println("Enfermeiro com COREN " + coren + " aplica o medicamento " + medicamento.getNomeMedicamento()+ " no paciente com prontuário " + paciente.getProntuario() + ".");
        } else {
            System.out.println("Paciente não tem uma receita para este medicamento.");
        }
    }

    public void realizarInjecao(Paciente paciente, Medico medico) {
        Receita receita = encontrarReceita(paciente, medico);
        if (receita != null) {
            System.out.println("Enfermeiro com COREN " + coren + " realizando injeção no paciente com prontuário " + paciente.getProntuario() + ".");
        } else {
            System.out.println("Paciente não tem uma receita para injeção.");
        }
    }

    public String getCoren() {
        return this.coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
    }

    private Receita encontrarReceita(Paciente paciente, Medico medico) {
        for (Receita receita : medico.getReceitas()) {
            if (receita.getPaciente().equals(paciente)) {
                return receita;
            }
        }
        return null;
    }
}