/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.postodesaude;
import java.util.Scanner;
/**
 *
 * @author Kalysson
 */
public class Medico extends Pessoa{
     private String especialidade;
     private String crm;
     Scanner scanner = new Scanner(System.in);

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
             

              // Exemplos de medicamento
       
        while(true){
             System.out.println("----------------");
            System.out.println("Tratamento:");
            System.out.println("1-Encaminhar para Medicamento");
            System.out.println("2-Encaminhar para injeção");
            System.out.print("Escolha uma opção: ");
        
            int escolha = scanner.nextInt();
            scanner.nextLine(); 
            switch(escolha){
                case 1:
                    Medicamento medicamento = new Medicamento("Paracetamol", "500mg",1);
                    encaminharParaMedicamento(paciente, medicamento);
        // Aplicar medicação (supondo que o enfermeiro é responsável por isso)
                    Enfermeiro enfermeiro = new Enfermeiro();
                    enfermeiro.setCoren("12345");
                    enfermeiro.aplicarMedicacao(paciente, medicamento);   
                    scanner.close();
                case 2:
                    System.out.println("Ainda nao implementado");
                         
            }
            
            
        }
            
            
    }

      public void encaminharParaMedicamento(Paciente paciente, Medicamento medicamento) {
        Farmaceutico farmaceutico = new Farmaceutico(); 
        farmaceutico.forneceMedicamentos(paciente, medicamento);
    }

    public void realizarDiagnostico(Paciente paciente) {
        // Lógica para realizar diagnóstico
        System.out.println("Analisando o Prontuario numero "+ paciente.getProntuario()+" do paciente "+paciente.getNome());
    }

    public void solicitarExame() {
        // Lógica para solicitar exame
    }

    public void prescreverReceita() {
        // Lógica para prescrever receita
    }

     //public void emcaminharParaTratamento()
}
