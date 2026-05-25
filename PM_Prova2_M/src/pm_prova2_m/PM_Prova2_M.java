package pm_prova2_m;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PM_Prova2_M {
    static List<Veiculo> veiculos = new ArrayList<>();
    static List<Aluguel> alugueis = new ArrayList<>();
    public static void main(String[] args) {
        
        // Inicializando os objetos - INICIO
        Carro carro1 = new Carro("AJC-1285", "Honda Civic", 2022, 250.0, 15000.0, StatusVeiculo.DISPONIVEL, 4);
        Moto moto1   = new Moto("XFH-5648", "Yamaha MT-07", 2021, 120.0, 8000.0, StatusVeiculo.MANUTENCAO, 700);
        Van van1     = new Van("EJH-9469", "Ford Transit", 2020, 400.0, 32000.0, StatusVeiculo.DISPONIVEL, 12);
        veiculos.add(carro1);
        veiculos.add(moto1);
        veiculos.add(van1);
        
        AluguelBasico basico = new AluguelBasico("João Silva", 3, 750.0, StatusAluguel.ATIVO);
        AluguelExecutivo executivo = new AluguelExecutivo("Maria Oliveira", 5, 3000.0, StatusAluguel.ATIVO);
        alugueis.add(basico);
        alugueis.add(executivo);
        // Inicializando os objetos - FIM
        
        Scanner sc = new Scanner(System.in);
        int opcao;
        
        // Painel principal
        do {
            System.out.println("SISTEMA DE ALUGUEL DE AUTOMOVEIS");
            
            System.out.println("1- Associar veiculo a um aluguel");
            System.out.println("2- Exibir todos os veiculos cadastrados");
            System.out.println("3- Exibir todos os alugueis cadastrados");
            System.out.println("4- Exibir apenas veiculos disponiveis");
            System.out.println("5- Avaliar um veiculo ou aluguel");
            System.out.println("6- Realizar inspecao em veiculo");
            System.out.println("7- Remover veiculos em manutencao");
            System.out.println("0- Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> associarVeiculoAluguel(sc);
                case 2 -> exibirTodosVeiculos();
                case 3 -> exibirTodosAlugueis();
                case 4 -> exibirVeiculosDisponiveis();
                case 5 -> avaliarObjeto(sc);
                case 6 -> realizarInspecao(sc);
                case 7 -> removerVeiculosEmManutencao();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opcao invalida!!");
            }
        } while (opcao != 0);

        sc.close();
    }
    //exibir itens INICIO
    private static void exibirTodosVeiculos() {
        System.out.println("\n Todos os Veiculos Cadastrados ");
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veiculo cadastrado.");
            return;
        }
        for (Veiculo v : veiculos) {
            v.exibirDetalhes();
            System.out.println("------------------------------");
        }
    }
 
    private static void exibirTodosAlugueis() {
        System.out.println("\n Todos os Alugueis Cadastrados ");
        if (alugueis.isEmpty()) {
            System.out.println("Nenhum aluguel cadastrado.");
            return;
        }
        for (Aluguel a : alugueis) {
            a.exibirDetalhes();
            System.out.println("------------------------------");
        }
    }

    private static void exibirVeiculosDisponiveis() {
        System.out.println("\n Veiculos Disponiveis ");
        boolean achou = false;
        for (Veiculo v : veiculos) {
            if (v.getStatus() == StatusVeiculo.DISPONIVEL) {
                v.exibirDetalhes();
                System.out.println("------------------------------");
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("Nenhum veiculo disponível no momento.");
        }
    }
    //exibir itens FIM
    
    private static void associarVeiculoAluguel(Scanner sc) {
        System.out.println("\n Associar Veiculo a Aluguel ");

       
        List<Veiculo> disponiveis = new ArrayList<>();
        for (Veiculo v : veiculos) {
            if (v.getStatus() == StatusVeiculo.DISPONIVEL) {
                disponiveis.add(v);
            }
        }

        if (disponiveis.isEmpty()) {
            System.out.println("Nenhum veiculo disponivel para associar.");
            return;
        }

        System.out.println("Veiculos disponiveis:");
        for (int i = 0; i < disponiveis.size(); i++) {
            System.out.println(i + " - " + disponiveis.get(i).getModelo()
                    + " [" + disponiveis.get(i).getPlaca() + "]");
        }
        System.out.print("Escolha o indice do veiculo: ");
        int idxV = sc.nextInt();
        sc.nextLine();

        if (idxV < 0 || idxV >= disponiveis.size()) {
            System.out.println("indice invalido.");
            return;
        }


        System.out.println("Alugueis disponiveis:");
        for (int i = 0; i < alugueis.size(); i++) {
            System.out.println(i + " - " + alugueis.get(i).getClass().getSimpleName()
                    + " | Cliente: " + alugueis.get(i).getNomeCliente());
        }
        System.out.print("Escolha o indice do aluguel: ");
        int idxA = sc.nextInt();
        sc.nextLine();

        if (idxA < 0 || idxA >= alugueis.size()) {
            System.out.println("Indice invalido.");
            return;
        }

        Veiculo vSelecionado = disponiveis.get(idxV);
        Aluguel aSelecionado = alugueis.get(idxA);

        if (aSelecionado instanceof AluguelBasico ab) {
            ab.adicionarVeiculo(vSelecionado);
        } else if (aSelecionado instanceof AluguelPremium ap) {
            ap.adicionarVeiculo(vSelecionado);
        } else if (aSelecionado instanceof AluguelExecutivo ae) {
            ae.adicionarVeiculo(vSelecionado);
        }
    }

    private static void avaliarObjeto(Scanner sc) {
        System.out.println("\n Avaliacao ");
        System.out.println("O que deseja avaliar?");
        System.out.println("1 - Veiculo");
        System.out.println("2 - Aluguel Executivo");
        System.out.print("Opcao: ");
        int tipo = sc.nextInt();
        sc.nextLine();

        if (tipo == 1) {
            List<Avaliavel> avaliaveis = new ArrayList<>();
            List<String> nomes = new ArrayList<>();
            for (Veiculo v : veiculos) {
                if (v instanceof Avaliavel av) {
                    avaliaveis.add(av);
                    nomes.add(v.getModelo() + " [" + v.getPlaca() + "]");
                }
            }
            if (avaliaveis.isEmpty()) {
                System.out.println("Nenhum veiculo avaliavel encontrado.");
                return;
            }
            for (int i = 0; i < avaliaveis.size(); i++) {
                System.out.println(i + " - " + nomes.get(i));
            }
            System.out.print("Escolha o indice: ");
            int idx = sc.nextInt();
            sc.nextLine();
            if (idx < 0 || idx >= avaliaveis.size()) {
                System.out.println("Indice invalido.");
                return;
            }
            System.out.print("Informe a nota (1 a 5): ");
            int nota = sc.nextInt();
            sc.nextLine();
            avaliaveis.get(idx).avaliar(nota);

        } else if (tipo == 2) {
            List<Avaliavel> avaliaveis = new ArrayList<>();
            List<String> nomes = new ArrayList<>();
            for (Aluguel a : alugueis) {
                if (a instanceof Avaliavel av) {
                    avaliaveis.add(av);
                    nomes.add(a.getClass().getSimpleName() + " - " + a.getNomeCliente());
                }
            }
            if (avaliaveis.isEmpty()) {
                System.out.println("Nenhum aluguel avaliavel encontrado.");
                return;
            }
            for (int i = 0; i < avaliaveis.size(); i++) {
                System.out.println(i + " - " + nomes.get(i));
            }
            System.out.print("Escolha o índice: ");
            int idx = sc.nextInt();
            sc.nextLine();
            if (idx < 0 || idx >= avaliaveis.size()) {
                System.out.println("Índice inválido.");
                return;
            }
            System.out.print("Informe a nota (1 a 5): ");
            int nota = sc.nextInt();
            sc.nextLine();
            avaliaveis.get(idx).avaliar(nota);

        } else {
            System.out.println("Opcao invalida.");
        }
    }

    private static void realizarInspecao(Scanner sc) {
        System.out.println("\n Inspecao de Veiculo ");
        List<Inspecionavel> inspecionaveis = new ArrayList<>();
        List<String> nomes = new ArrayList<>();

        for (Veiculo v : veiculos) {
            if (v instanceof Inspecionavel ins) {
                inspecionaveis.add(ins);
                nomes.add(v.getModelo() + " [" + v.getPlaca() + "] - Status: " + v.getStatus());
            }
        }

        if (inspecionaveis.isEmpty()) {
            System.out.println("Nenhum veiculo inspecionavel cadastrado.");
            return;
        }

        for (int i = 0; i < inspecionaveis.size(); i++) {
            System.out.println(i + " - " + nomes.get(i));
        }
        System.out.print("Escolha o indice do veiculo para inspecionar: ");
        int idx = sc.nextInt();
        sc.nextLine();

        if (idx < 0 || idx >= inspecionaveis.size()) {
            System.out.println("Indice invalido.");
            return;
        }
        inspecionaveis.get(idx).realizarInspecao();
    }

    private static void removerVeiculosEmManutencao() {
        System.out.println("\n Remocao de Veiculos em Manutencao ");
        int removidos = 0;
        Iterator<Veiculo> it = veiculos.iterator();
        while (it.hasNext()) {
            Veiculo v = it.next();
            if (v.getStatus() == StatusVeiculo.MANUTENCAO) {
                System.out.println("Removido: " + v.getModelo() + " [" + v.getPlaca() + "]");
                it.remove();
                removidos++;
            }
        }
        if (removidos == 0) {
            System.out.println("Nenhum veiculo em manutencao encontrado.");
        } else {
            System.out.println("Total removido: " + removidos + " veiculo(s).");
        }
    }
}