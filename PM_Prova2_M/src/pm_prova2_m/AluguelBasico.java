package pm_prova2_m;

import java.util.ArrayList;
import java.util.List;

public class AluguelBasico extends Aluguel {

    private static final int KM_LIMITE_POR_DIA = 100;
    private List<Veiculo> veiculos;

    public AluguelBasico(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {
        super(nomeCliente, quantidadeDias, valorTotal, status);
        this.veiculos = new ArrayList<>();
    }

    public int getKmLimitePorDia() {
        return KM_LIMITE_POR_DIA;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        veiculo.setStatus(StatusVeiculo.ALUGADO);
        System.out.println("Veiculo " + veiculo.getModelo() + " associado ao aluguel Básico de " + getNomeCliente() + ".");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(" ALUGUEL BASICO ");
        System.out.println("Cliente: " + getNomeCliente());
        System.out.println("Dias: " + getQuantidadeDias());
        System.out.println("Valor Total: R$ " + getValorTotal());
        System.out.println("Status: " + getStatus());
        System.out.println("Limite de KM/dia: " + KM_LIMITE_POR_DIA + " km");
        System.out.println("Seguro: Não incluso");
        System.out.println("Veiculos (" + veiculos.size() + "):");
        if (veiculos.isEmpty()) {
            System.out.println("  Nenhum veiculo associado");
        } else {
            for (Veiculo v : veiculos) {
                System.out.println("  - " + v.getModelo() + " [" + v.getPlaca() + "]");
            }
        }
    }

    @Override
    public boolean possuiSeguroIncluso() {
        return false;
    }
}