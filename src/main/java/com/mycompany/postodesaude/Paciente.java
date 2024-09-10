/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.postodesaude;

/**
 *
 * @author Kalysson @author Ruan
 */


import java.time.LocalDate;


public class Paciente extends Pessoa{

    public Paciente(String string, String string1, LocalDate now, String maria_Oliveira) {
        this.numeroSus = numeroSus;
        this.prontuario = prontuario;
        this.dataCadastro = dataCadastro;
        
    }
    private String numeroSus;
    private String prontuario;
    private LocalDate dataCadastro;

    


    //O paciente vai solicitar uma consulta aqui, para isso devemos colocar objetos e dados no parâmetro.
    //Esse método vai retornar um objeto consulta.
    public Consulta solicitaConsulta(Medico medico, Paciente paciente, String data, String hora){
        Consulta consulta = new Consulta(data, hora, medico, this);
        System.out.println("Consulta solicitada com o médico:"+medico+"\n"+"Para o dia:"+data+"\n"+"No horario de:"+hora+"\n");
        return consulta;
    }  

    //Terminar implementação quando secretario estiver ok.
    public void cancelaAgendamento(Consulta consulta){
        System.out.println("Consulta com o médico " + consulta.getMedico().getNome() + "no dia"+consulta.getData()+" foi cancelada");
    }

    //Terminar a implementação dessa classe, quando houver uma classe farmacêutico.
    public void retirarMedicamentos(){
        System.out.println("Medicamento retirado com sucesso.");
    }

    public void tomarMedicacao(){
        System.out.println("medicação tomada com enfermeiro.");
    }

    

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
     // Sobrescrever o método toString para exibir o nome do paciente
    
}
