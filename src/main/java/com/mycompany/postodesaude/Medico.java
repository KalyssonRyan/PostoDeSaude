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
      public void encaminharParaTratamento() {
      
    }

    public void encaminharParaMedicamento() {
        // Lógica para encaminhar para medicamento
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
