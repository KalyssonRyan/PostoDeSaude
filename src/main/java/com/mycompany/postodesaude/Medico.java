/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.postodesaude;

import static com.mycompany.postodesaude.PostoDeSaude.encontrarPacientePorNumeroSus;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Kalysson
 */
public class Medico extends Pessoa{
     private String especialidade;
     private String crm;
     private static ArrayList<Receita> receitas = new ArrayList<>(); 
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
         System.out.println("3- Prescrever receita");
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha

        switch (escolha) {
            case 1 -> {
                System.out.print("Digite o número do SUS do paciente para encaminhar para tratamento: ");
                
                
                String pacienteNumero = scanner.nextLine();
                Paciente pacienteTratamento = encontrarPacientePorNumeroSus(pacienteNumero);
                if (pacienteTratamento != null) {
                    encaminharParaTratamento(pacienteTratamento);
                } else {
                    System.out.println("Paciente não encontrado para tratamento.");
                }
             }

            case 2 -> {
                System.out.println("Encaminhando paciente para exame.");
                // Lógica para solicitar exame
                solicitarExame(paciente);
             }
            case 3->{
                prescreverReceita(paciente);
            }
            default -> System.out.println("Opção inválida.");
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
           // Inserir dados do medicamento
            System.out.print("Digite o nome do medicamento: ");
            String nomeMedicamento = scanner.nextLine();
            System.out.print("Digite a dosagem do medicamento: ");
            String dosagem = scanner.nextLine();
            
            Medicamento medicamento = new Medicamento(nomeMedicamento, dosagem, 1); // Exemplo com quantidade 1
            Enfermeiro enfermeiro = new Enfermeiro();
            enfermeiro.setCoren("12345");
            
            enfermeiro.aplicarMedicacao(paciente, medicamento, this);
            break;

       case 2:
           Enfermeiro enfermeira = new Enfermeiro();
           enfermeira.setCoren("12345");
           enfermeira.realizarInjecao(paciente, this); // Passa o médico atual
           break;

       }
            
            
        
            
            
    }

     public void encaminharParaMedicamento(Paciente paciente, Medicamento medicamento) {
        Farmaceutico farmaceutico = new Farmaceutico(); 
        farmaceutico.forneceMedicamentos(paciente, medicamento);
    }

    

    public void solicitarExame(Paciente paciente) {
     
   
        System.out.println("Digite o nome do exame a ser solicitado:");
        String nomeExame = scanner.nextLine();

        System.out.println("Digite o tipo do exame:");
        String tipoExame = scanner.nextLine();

        // Exibir a confirmação da solicitação
        System.out.println("Exame '" + nomeExame + "' do tipo '" + tipoExame + "' solicitado para o paciente " + paciente.getNome() + ".");

        // Apenas exibe a data de solicitação sem criar uma nova classe Exame ou armazenar os dados em listas
        System.out.println("Data da solicitação: " + new Date());
    }
    public void prescreverReceita(Paciente paciente) {
    Receita receita = new Receita();
    receita.setPaciente(paciente);
    receita.setMedico(this); // O médico que está prescrevendo

    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite a descrição dos medicamentos (em um único texto): ");
    String descricaoMedicamentos = scanner.nextLine();
    
    // Cria um Medicamento genérico com a descrição fornecida
    Medicamento medicamento = new Medicamento(descricaoMedicamentos, "dosagem padrão", 1);
    receita.adicionarMedicamento(medicamento);

    // Adiciona a receita à lista global de receitas
    PostoDeSaude.adicionarReceita(receita);
    System.out.println("Receita prescrita com sucesso.");
}
 
     
        
      //public void emcaminharParaTratamento()
}
