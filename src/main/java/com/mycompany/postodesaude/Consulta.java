/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.postodesaude;
import java.sql.Time;
import java.util.Date;


/**
 *
 * @author Kalysson @author Ruan
 */


public class Consulta {


    private String data;
    private String hora;
    //setando o medico da consulta
    private Medico medico;
    //setando o paciente da consulta
    private Paciente paciente;

    public Consulta(String data, String hora, Medico medico, Paciente paciente){

        this.data = data;
        this.hora = hora;
        this.medico = medico;
        this.paciente = paciente;
    }

    public void setData(String data){
        this.data = data;
    }

    public String getData(){
        return data;
    }

    public void setHora(String hora){
        this.hora = hora;
    }

    public String getHora(){
        return hora;
    }

    public void setMedico(Medico medico){
        this.medico = medico;
    }

    public Medico getMedico(){
        return medico;
    }

    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }

    public Paciente getPaciente(){
        return paciente;
    }


}
