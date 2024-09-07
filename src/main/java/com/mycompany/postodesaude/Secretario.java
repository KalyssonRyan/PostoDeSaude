/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.postodesaude;

/**
 *
 * @author Kalysson
 */
public class Secretario extends Pessoa{
    private String turno;

    public void setTurno(String turno){
        this.turno = turno;
    }

    public String getTurno(){
        return turno;
    }
    public void verificarDocumentos(Paciente paciente) {
        // Lógica para verificar documentos
    }

    public void cancelaAgendamento(Paciente paciente) {
        // Lógica para cancelar agendamento
    }

    public void verificarDisponibilidadeDosMedicos() {
        // Lógica para verificar disponibilidade dos médicos
    }

    public void agendarConsulta() {
        // Lógica para agendar consulta
    }

    public void cadastrarDocumentos() {
        // Lógica para cadastrar documentos
    }


}
