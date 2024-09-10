/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.postodesaude;


import java.util.ArrayList;

public class Receita {
    private Paciente paciente;
    private Medico medico;
    private ArrayList<Medicamento> listaMedicamentos;

    public Receita() {
        listaMedicamentos = new ArrayList<>();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public ArrayList<Medicamento> getListaMedicamentos() {
        return listaMedicamentos;
    }

    public void adicionarMedicamento(Medicamento medicamento) {
        listaMedicamentos.add(medicamento);
    }

    public void removerMedicamento(Medicamento medicamento) {
        listaMedicamentos.remove(medicamento);
    }
}