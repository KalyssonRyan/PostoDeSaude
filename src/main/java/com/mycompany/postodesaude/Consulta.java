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


    private Date data;
    private Time hora;
    //setando o medico da consulta
    private Medico medico;
    //setando o paciente da consulta
    private Paciente paciente;

    public Consulta(Date data, Time hora, Medico medico, Paciente paciente){

        this.data = data;
        this.hora = hora;
        this.medico = medico;
        this.paciente = paciente;
    }

    public void setData(Date data){
        this.data = data;
    }

    public String getData(Date data){
        return data;
    }

    public void setHora(Time hora){
        this.hora = hora;
    }

    public Time getHora(){
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


}
