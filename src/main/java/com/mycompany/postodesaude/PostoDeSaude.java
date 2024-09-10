/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.postodesaude;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PostoDeSaude {
    // Listas privadas
    static List<Paciente> pacientes = new ArrayList<>();
    private static List<Secretario> secretarios = new ArrayList<>();
    private static List<Enfermeiro> enfermeiros = new ArrayList<>();
    static List<Consulta> consultas = new ArrayList<>();
    private static List<Farmaceutico> farmacêuticos = new ArrayList<>();
    private static List<Medicamento> medicamentos = new ArrayList<>();
    private static List<Receita> receitas = new ArrayList<>();
    private static List<Medico> medicos = new ArrayList<>();
    private static List<Exame> exames = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicialização de dados (exemplo)
        Medico medico = new Medico();
        medico.setEspecialidade("Cardiologia");
        medico.setCrm("123456");
        medico.setNome("Dr. João"); // Corrigido o nome para "Dr. João"
        medicos.add(medico);
       
        medico.setEspecialidade("Plantão");
        medico.setCrm("54321");
        medico.setNome("Antonio"); // Corrigido o nome para "Dr. João"
        medicos.add(medico);

        Secretario secretario = new Secretario();
        secretario.setTurno("Manhã");
        secretarios.add(secretario);
        // Início do menu
        while (true) {
            System.out.println("Menu:");
            System.out.println("-------Secretaria-------");
            System.out.println("1 - Cadastrar Paciente");
            System.out.println("2 - Agendar consulta");
            System.out.println("3 - Cancelar consulta");
            System.out.println("-------Medico-------");
            System.out.println("5 - Realizer Dignostico da consulta");
            System.out.println("6 - Solicitar Exame");
            System.out.println("7 - Prescrever Receita");
            System.out.println("8 - Encaminhar para exame");
            System.out.println("9 - Encaminhar para receita");
            System.out.println("10-Inserir medicamento e ");
            System.out.println("11 - Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consome o newline após a escolha

            switch (escolha) {
                case 1:
                    // Inserir um novo paciente
                    System.out.print("Digite o Nome do paciente: ");
                     String nomePaciente = scanner.nextLine();
                    System.out.print("Digite o número do SUS do paciente: ");
                    String numeroSus = scanner.nextLine();
                    System.out.print("Digite o prontuário do paciente: ");
                    String prontuario = scanner.nextLine();
                    System.out.print("Digite a data de cadastro do paciente (yyyy-mm-dd): ");
                    String dataCadastroStr = scanner.nextLine();
                    
                    // Converter a data de cadastro para LocalDate
                    LocalDate dataCadastro = LocalDate.parse(dataCadastroStr);

                    // Criar um novo objeto Paciente
                    Paciente paciente = new Paciente(numeroSus, prontuario, dataCadastro,nomePaciente);

                    // Adicionar o paciente à lista de pacientes
                    pacientes.add(paciente);

                    // Confirmar adição
                    System.out.println("Paciente adicionado: " + paciente);
                    break;

                case 2:
                    // Agendar consulta
                    if (secretarios.isEmpty()) {
                        System.out.println("Nenhum secretário disponível para agendar consulta.");
                        break;
                    }
                    Secretario secretarioAtual = secretarios.get(0); 
                    secretarioAtual.agendarConsulta();
                    break;

                case 3:
                    // Cancelar consulta
                    if (consultas.isEmpty()) {
                        System.out.println("Nenhuma consulta agendada para cancelar.");
                        break;
                    }
                    System.out.print("Digite o número do SUS para cancelar a consulta: ");
                    var NumeroPaciente = scanner.nextLine();
                    Paciente pacienteCancelamento = encontrarPacientePorNumeroSus(NumeroPaciente);
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

                 case 4:
                    System.out.println("Realizando diagnóstico");
                    System.out.print("Digite o Numero do SUS do Paciente para o diagnóstico: ");
                    String pacienteSus = scanner.nextLine();
                    Paciente pacienteDiagnostico = encontrarPacientePorNumeroSus(pacienteSus);

                    if (pacienteDiagnostico != null) {
                        // Verifica se o paciente tem consulta agendada
                        Consulta consultaPaciente = encontrarConsultaPorPaciente(pacienteDiagnostico);
                        if (consultaPaciente != null) {
                            medico.realizarDiagnostico(pacienteDiagnostico);
                        } else {
                            System.out.println("Paciente não tem consulta marcada. Diagnóstico não permitido.");
                        }
                    } else {
                        System.out.println("Paciente não encontrado.");
                    }
                    break;    
              
                      
                case 6:
                    // Encaminhar para exame
                    System.out.println("Encaminhamento para exame ainda não implementado.");
                    break;

                case 7:
                    // Encaminhar para receita
                    System.out.println("Encaminhamento para receita ainda não implementado.");
                    break;

                case 8:
                    // Sair
                    System.out.println("Saindo...");
                    scanner.close();
                    return; // Encerra o programa
                case 10:
                     // Inserir medicamento e encaminhar para tratamento
                    System.out.print("Digite o nome do medicamento: ");
                    String nomeMedicamento = scanner.nextLine();
                    System.out.print("Digite a dosagem do medicamento: ");
                    String dosagem = scanner.nextLine();
                    System.out.print("Digite a quantidade do medicamento: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine(); // Consome o newline

                    // Criar o medicamento com o construtor correto
                    Medicamento medicamento = new Medicamento(nomeMedicamento, dosagem, quantidade);
                    medicamentos.add(medicamento);
                    System.out.println("Medicamento criado: " + medicamento);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Métodos auxiliares
    static Paciente encontrarPacientePorNumeroSus(String numeroSus) {
        for (Paciente p : pacientes) {
            if (p.getNumeroSus().equals(numeroSus)) {
                return p;
            }
        }
        return null;
    }

    static Medico encontrarMedicoPorNome(String nome) {
        for (Medico m : medicos) {
            if (m.getNome().equals(nome)) {
                return m;
            }
        }
        return null;
    }
    public static Consulta encontrarConsulta(String numeroSus, String data, String hora) {
        Paciente paciente = encontrarPacientePorNumeroSus(numeroSus);
        if (paciente == null) {
            return null;
        }
        for (Consulta c : consultas) {
            if (c.getPaciente().equals(paciente) &&
                c.getData().equals(data) &&
                c.getHora().equals(hora)) {
                return c;
            }
        }
        return null;
    }  
    public static void removerConsulta(Consulta consulta) {
        consultas.remove(consulta);
    }

 
    public static void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }
    
    public static Consulta encontrarConsultaPorPaciente(Paciente paciente) {
    for (Consulta c : consultas) {
        if (c.getPaciente().equals(paciente)) {
            return c; // Retorna a primeira consulta encontrada
        }
    }
    return null; // Retorna null se não encontrar nenhuma consulta
}

    
}