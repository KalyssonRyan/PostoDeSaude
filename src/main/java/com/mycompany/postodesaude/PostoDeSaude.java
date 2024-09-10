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
    private static List<Farmaceutico> farmaceuticos = new ArrayList<>();
    private static List<Medicamento> medicamentos = new ArrayList<>();
    
    private static List<Receita> receitas = new ArrayList<>(); // Declarando a lista de receitas

    private static List<Medico> medicos = new ArrayList<>();
    private static List<Exame> exames = new ArrayList<>();
    
    public static void adicionarReceita(Receita receita) {
        receitas.add(receita); // Adiciona uma receita à lista de receitas
    }
    
    public static List<Receita> getReceitas() {
        return receitas; // Retorna a lista de receitas
    }
    
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
        medico.setNome("Antonio");
        medicos.add(medico);

        Secretario secretaria = new Secretario();
        secretaria.setTurno("matutino");
        secretarios.add(secretaria);

        // Início do menu
        while (true) {
            System.out.println("Menu:");
            System.out.println("-------Secretaria-------");
            System.out.println("1 - Cadastrar Paciente");
            System.out.println("2 - Agendar consulta");
            System.out.println("3 - Cancelar consulta");
            System.out.println("-------Medico-------");
            System.out.println("4 - Realizar Diagnóstico da consulta");
            System.out.println("10 - Inserir medicamento");
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
                    Paciente paciente = new Paciente(numeroSus, prontuario, dataCadastro, nomePaciente);

                    // Adicionar o paciente à lista de pacientes
                    pacientes.add(paciente);

                    // Confirmar adição
                    System.out.println("Paciente adicionado: " + paciente);
                    
                    Farmaceutico farmaceutico = new Farmaceutico();
                    Medicamento med = new Medicamento("Paracetamol", "500mg", 1);

                    // Testar fornecimento de medicamento
                    farmaceutico.forneceMedicamentos(paciente, med);
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
                    String numeroPaciente = scanner.nextLine();
                    Paciente pacienteCancelamento = encontrarPacientePorNumeroSus(numeroPaciente);
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
                    // Realizando diagnóstico
                    System.out.println("Realizando diagnóstico");
                    System.out.print("Digite o Numero do SUS do Paciente para o diagnóstico: ");
                    String pacienteSus = scanner.nextLine();
                    Paciente pacienteDiagnostico = encontrarPacientePorNumeroSus(pacienteSus);

                    if (pacienteDiagnostico != null) {
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

                case 10:
                    // Inserir medicamento
                    System.out.print("Digite o nome do medicamento: ");
                    String nomeMedicamento = scanner.nextLine();
                    System.out.print("Digite a dosagem do medicamento: ");
                    String dosagem = scanner.nextLine();
                    System.out.print("Digite a quantidade do medicamento: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine(); // Consome o newline

                    Medicamento medicamento = new Medicamento(nomeMedicamento, dosagem, quantidade);
                    medicamentos.add(medicamento);
                    System.out.println("Medicamento criado: " + medicamento);
                    break;

                case 11:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

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

    public static Consulta encontrarConsultaPorPaciente(Paciente paciente) {
        for (Consulta c : consultas) {
            if (c.getPaciente().equals(paciente)) {
                return c;
            }
        }
        return null;
    }
}
