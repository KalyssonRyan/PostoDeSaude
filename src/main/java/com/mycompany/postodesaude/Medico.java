/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.postodesaude;

import static com.mycompany.postodesaude.PostoDeSaude.encontrarPacientePorNumeroSus;
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
     public void realizarDiagnostico(Paciente paciente) {
    // Exibir informações do paciente
    System.out.println("Analisando o prontuário número " + paciente.getProntuario() + " do paciente " + paciente.getNome());

    // Menu de ações do médico
    System.out.println("O que o médico irá fazer?");
    System.out.println("1 - Encaminhar para Tratamento");
    System.out.println("2 - Encaminhar para Exame");
    System.out.print("Escolha uma opção: ");
    int escolha = scanner.nextInt();
    scanner.nextLine();  // Consumir a nova linha

    switch (escolha) {
        case 1:
            System.out.print("Digite o número do SUS do paciente para encaminhar para tratamento: ");
            String pacienteNumero = scanner.nextLine();
            Paciente pacienteTratamento = encontrarPacientePorNumeroSus(pacienteNumero);
            if (pacienteTratamento != null) {
                encaminharParaTratamento(pacienteTratamento);
            } else {
                System.out.println("Paciente não encontrado para tratamento.");
            }
            break;
   
        case 2:
            System.out.println("Encaminhando paciente para exame.");
            // Lógica para solicitar exame
            solicitarExame();
            break;
        default:
            System.out.println("Opção inválida.");
    }
}
   public void encaminharParaTratamento(Paciente paciente) {
             System.out.println("Encaminhando paciente com prontuário " + paciente.getProntuario() + " para tratamento.");
             

              
      
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
                    break;
                case 2:
                    System.out.println("Ainda nao implementado");
                    break;
                         
            }
            
            
        
            
            
    }

      public void encaminharParaMedicamento(Paciente paciente, Medicamento medicamento) {
        Farmaceutico farmaceutico = new Farmaceutico(); 
        farmaceutico.forneceMedicamentos(paciente, medicamento);
    }

    

    public void solicitarExame() {
        // Lógica para solicitar exame
    }

    public void prescreverReceita() {
        // Lógica para prescrever receita
    }

     //public void emcaminharParaTratamento()
}
