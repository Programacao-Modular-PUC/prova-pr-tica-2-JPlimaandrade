package pm_prova2_m;

import java.util.ArrayList;
import java.util.List;

public class AluguelExecutivo extends Aluguel implements Avaliavel {

    private boolean motorista;
    private int avaliacao;
    private boolean avaliado;
    private List<Veiculo> veiculos;

    public AluguelExecutivo(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {
        super(nomeCliente, quantidadeDias, valorTotal, status);
        this.motorista = true;
        this.avaliacao = 0;
        this.avaliado = false;
        this.veiculos = new ArrayList<>();
    }

    public boolean temMotorista() {
        return motorista;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        veiculo.setStatus(StatusVeiculo.ALUGADO);
        System.out.println("Veiculo " + veiculo.getModelo() + " associado ao aluguel Executivo de " + getNomeCliente() + ".");
    }

    @Override
    public void avaliar(int nota) {
        if (nota < 1 || nota > 5) {
            System.out.println("Nota invalida");
            return;
        }
        this.avaliacao = nota;
        this.avaliado = true;
        System.out.println("Aluguel Executivo do cliente " + getNomeCliente() + " avaliado com nota " + nota + ".");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(" ALUGUEL EXECUTIVO ");
        System.out.println("Cliente: " + getNomeCliente());
        System.out.println("Dias: " + getQuantidadeDias());
        System.out.println("Valor Total: R$ " + getValorTotal());
        System.out.println("Status: " + getStatus());
        System.out.println("Quilometragem: Ilimitada");
        System.out.println("Seguro: Incluso");
        System.out.println("Motorista Particular: Sim");
        System.out.println("Avaliacao: " + (avaliado ? avaliacao + "/5" : "Sem avaliacao"));
        System.out.println("Veiculos (" + veiculos.size() + "):");
        if (veiculos.isEmpty()) {
            System.out.println("  Nenhum veiculo associado.");
        } else {
            for (Veiculo v : veiculos) {
                System.out.println("  - " + v.getModelo() + " [" + v.getPlaca() + "]");
            }
        }
    }

    @Override
    public boolean possuiSeguroIncluso() {
        return true;
    }
}