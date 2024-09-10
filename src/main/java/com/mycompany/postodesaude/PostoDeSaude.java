/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.postodesaude;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostoDeSaude {
    // Listas privadas
    private static List<Paciente> pacientes = new ArrayList<>();
    private static List<Secretario> secretarios = new ArrayList<>();
    private static List<Enfermeiro> enfermeiros = new ArrayList<>();
    private static List<Consulta> consultas = new ArrayList<>();
    private static List<Farmaceutico> farmacêuticos = new ArrayList<>();
    private static List<Medicamento> medicamentos = new ArrayList<>();
    private static List<Receita> receitas = new ArrayList<>();
    private static List<Medico> medicos = new ArrayList<>();
    private static List<Exame> exames = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicialização de dados (exemplo)
        Paciente paciente = new Paciente("123456789", "P001", LocalDate.now());
        pacientes.add(paciente);

        Medico medico = new Medico();
        medico.setEspecialidade("Cardiologia");
        medico.setCrm("123456");
        medico.setNome("Dr. João");
        medicos.add(medico);

        // Início do menu
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Agendar consulta");
            System.out.println("2. Cancelar consulta");
            System.out.println("3. Inserir medicamento e encaminhar para tratamento");
            System.out.println("4. Encaminhar para exame");
            System.out.println("5. Encaminhar para receita");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consome o newline após a escolha

            switch (escolha) {
                case 1:
                    // Agendar consulta
                    System.out.print("Digite o nome do médico para a consulta: ");
                    String nomeMedico = scanner.nextLine();
                    Medico medicoEscolhido = encontrarMedicoPorNome(nomeMedico);
                    if (medicoEscolhido == null) {
                        System.out.println("Médico não encontrado.");
                        break;
                    }

                    System.out.print("Digite a data da consulta (formato YYYY-MM-DD): ");
                    String dataConsulta = scanner.nextLine();
                    System.out.print("Digite a hora da consulta (formato HH:MM): ");
                    String horaConsulta = scanner.nextLine();

                    Consulta novaConsulta = paciente.solicitaConsulta(medicoEscolhido, paciente, dataConsulta, horaConsulta);
                    consultas.add(novaConsulta);
                    break;

                case 2:
                    // Cancelar consulta
                    if (consultas.isEmpty()) {
                        System.out.println("Nenhuma consulta agendada para cancelar.");
                        break;
                    }
                    System.out.print("Digite o número do prontuário para cancelar a consulta: ");
                    String prontuarioPaciente = scanner.nextLine();
                    Paciente pacienteCancelamento = encontrarPacientePorProntuario(prontuarioPaciente);
                    if (pacienteCancelamento == null) {
                        System.out.println("Paciente não encontrado.");
                        break;
                    }

                    System.out.print("Digite a data da consulta para cancelar (formato YYYY-MM-DD): ");
                    String dataCancelamento = scanner.nextLine();
                    System.out.print("Digite a hora da consulta para cancelar (formato HH:MM): ");
                    String horaCancelamento = scanner.nextLine();

                    Consulta consultaCancelada = null;
                    for (Consulta c : consultas) {
                        if (c.getData().equals(dataCancelamento) && c.getHora().equals(horaCancelamento) && c.getPaciente().equals(pacienteCancelamento)) {
                            consultaCancelada = c;
                            break;
                        }
                    }
                    if (consultaCancelada != null) {
                        pacienteCancelamento.cancelaAgendamento(consultaCancelada);
                        consultas.remove(consultaCancelada);
                    } else {
                        System.out.println("Consulta não encontrada.");
                    }
                    break;

                case 3:
                    // Inserir medicamento e encaminhar para tratamento
                    System.out.print("Digite o nome do medicamento: ");
                    String nomeMedicamento = scanner.nextLine();
                    System.out.print("Digite a dosagem do medicamento: ");
                    String dosagem = scanner.nextLine();
                    System.out.print("Digite a quantidade do medicamento: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine(); // Consome o newline

                    Medicamento medicamento = new Medicamento();
                    medicamento.setNomeMedicamento(nomeMedicamento);
                    medicamento.setDosagem(dosagem);
                    medicamento.setQuantidade(quantidade);
                    medicamentos.add(medicamento);
                    System.out.println("Medicamento criado: " + medicamento);

                    // Encaminhar para tratamento
                    Medico medicoTratamento = encontrarMedicoPorNome("Dr. João"); // Usando nome fixo para exemplo
                    if (medicoTratamento != null) {
                        medicoTratamento.encaminharParaTratamento(paciente);
                    }
                    break;

                case 4:
                    // Encaminhar para exame
                    System.out.println("Encaminhamento para exame ainda não implementado.");
                    break;

                case 5:
                    // Encaminhar para receita
                    System.out.println("Encaminhamento para receita ainda não implementado.");
                    break;

                case 6:
                    // Sair
                    System.out.println("Saindo...");
                    scanner.close();
                    return; // Encerra o programa

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Métodos auxiliares
    private static Paciente encontrarPacientePorProntuario(String prontuario) {
        for (Paciente p : pacientes) {
            if (p.getProntuario().equals(prontuario)) {
                return p;
            }
        }
        return null;
    }

    private static Medico encontrarMedicoPorNome(String nome) {
        for (Medico m : medicos) {
            if (m.getNome().equals(nome)) {
                return m;
            }
        }
        return null;
    }
}
