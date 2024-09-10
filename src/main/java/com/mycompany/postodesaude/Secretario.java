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
public class Secretario extends Pessoa{
    private String turno;

    public Secretario(String nome, String cpf, int idade, String telefone, String turno){
        super(nome, cpf, idade, telefone);
        this.turno = turno;
    }

    public void setTurno(String turno){
        this.turno = turno;
    }

    public String getTurno(){
        return turno;
    }
    public void verificarDocumentos(Paciente paciente) {
        
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
        // Lógica para cadastrar documentos
    }


}
