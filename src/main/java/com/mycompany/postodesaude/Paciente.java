/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.postodesaude;

/**
 *
 * @author Kalysson
 */
import java.time.LocalDate;
import java.util.Date;

public class Paciente extends Pessoa{
    private String numeroSus;
    private String prontuario;
    private LocalDate dataCadastro;

    public void setNumeroSus(String numeroSus) {
        this.numeroSus = numeroSus;
    }

    public String getNumeroSus(){
        return numeroSus;
    }

    public void setProntuario( String prontuario){
        this.prontuario = prontuario;
    }

    public String getProntuario(){
        return prontuario;
    }

    public void setDataCadastro(LocalDate dataCadastro){
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataCadastro(){
        return dataCadastro;
    }

    public void solicitaConsulta(){

    }

    public void cancelaAgendamento(){

    }

    public void retiraMedicamentos(){

    }

    public void tomarMedicacao(){

    }



}
