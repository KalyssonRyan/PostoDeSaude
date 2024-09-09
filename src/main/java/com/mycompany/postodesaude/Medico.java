/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.postodesaude;

/**
 *
 * @author Kalysson
 */
public class Medico extends Pessoa{
     private String especialidade;
     private String crm;

     public void setEspecialidade(String especialidade){
         this.especialidade = especialidade;
     }

     public String getEspecialidade(){
         return especialidade;
     }

     public void setCrm(String crm){
         this.crm = crm;
     }

     public String getCrm(){
         return crm;
     }
      public void encaminharParaTratamento(Paciente paciente) {
             System.out.println("Encaminhando paciente com prontuário " + paciente.getProntuario() + " para tratamento.");
    }

      public void encaminharParaMedicamento(Paciente paciente, Medicamento medicamento) {
        Farmaceutico farmaceutico = new Farmaceutico(); 
        farmaceutico.forneceMedicamentos(paciente, medicamento);
    }

    public void realizarDiagnostico() {
        // Lógica para realizar diagnóstico
    }

    public void solicitarExame() {
        // Lógica para solicitar exame
    }

    public void prescreverReceita() {
        // Lógica para prescrever receita
    }

     //public void emcaminharParaTratamento()
}
