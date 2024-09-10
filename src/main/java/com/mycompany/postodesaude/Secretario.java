/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.postodesaude;

import static com.mycompany.postodesaude.PostoDeSaude.pacientes;
import java.time.LocalDate;
import java.util.Scanner;

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

    // Dentro da classe Secretario
      public void cancelaAgendamento(String prontuarioPaciente, String dataConsulta, String horaConsulta) {
        Consulta consulta = PostoDeSaude.encontrarConsulta(prontuarioPaciente, dataConsulta, horaConsulta);
        if (consulta != null) {
            Paciente paciente = consulta.getPaciente();
            paciente.cancelaAgendamento(consulta);
            PostoDeSaude.removerConsulta(consulta);
            System.out.println("Consulta cancelada com sucesso.");
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }



    public void verificarDisponibilidadeDosMedicos() {
        // Lógica para verificar disponibilidade dos médicos
    }

    public void agendarConsulta() {
            Scanner scanner = new Scanner(System.in);

            // Solicitar informações para agendar a consulta
            System.out.print("Digite o número do SUS do paciente: ");
            String numeroSusPaciente = scanner.nextLine();
            Paciente paciente = PostoDeSaude.encontrarPacientePorNumeroSus(numeroSusPaciente);
            if (paciente == null) {
                System.out.println("Paciente não encontrado.");
                return;
            }

            System.out.print("Digite o nome do médico para a consulta: ");
            String nomeMedico = scanner.nextLine();
            Medico medico = PostoDeSaude.encontrarMedicoPorNome(nomeMedico);
            if (medico == null) {
                System.out.println("Médico não encontrado.");
                return;
            }

            System.out.print("Digite a data da consulta (formato YYYY-MM-DD): ");
            String dataConsulta = scanner.nextLine();
            System.out.print("Digite a hora da consulta (formato HH:MM): ");
            String horaConsulta = scanner.nextLine();

            // Criar uma nova consulta e adicionar à lista de consultas
            Consulta novaConsulta = paciente.solicitaConsulta(medico, paciente, dataConsulta, horaConsulta);
            PostoDeSaude.adicionarConsulta(novaConsulta);
            System.out.println("Consulta agendada com sucesso.");
        }
    public void cadastrarDocumentos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o Nome do paciente: ");
        String nomePaciente = scanner.nextLine();
       
        System.out.print("Digite o número do SUS do paciente: ");
        String numeroSus = scanner.nextLine();
         try{
            System.out.println("sei nao");
        }catch(NullPointerException erro){
            System.out.println(erro);
        }
        System.out.print("Digite o prontuário do paciente: ");
        String prontuario = scanner.nextLine();
        System.out.print("Digite a data de cadastro do paciente (yyyy-mm-dd): ");
        String dataCadastroStr = scanner.nextLine();

        // Converter a data de cadastro para LocalDate
        LocalDate dataCadastro = LocalDate.parse(dataCadastroStr);

        // Criar um novo objeto Paciente
        Paciente paciente = new Paciente(numeroSus, prontuario, dataCadastro,nomePaciente);

        // Adicionar o paciente à lista de pacientes
        PostoDeSaude.adicionarPaciente(paciente);

        // Confirmar adição
        System.out.println("Paciente adicionado com sucesso!");
    }


}
