package pm_prova2_m;

import java.util.ArrayList;
import java.util.List;

public class AluguelPremium extends Aluguel {

    private List<Veiculo> veiculos;

    public AluguelPremium(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {
        super(nomeCliente, quantidadeDias, valorTotal, status);
        this.veiculos = new ArrayList<>();
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        veiculo.setStatus(StatusVeiculo.ALUGADO);
        System.out.println("Veiculo " + veiculo.getModelo() + " associado ao aluguel Premium de " + getNomeCliente() + ".");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(" ALUGUEL PREMIUM ");
        System.out.println("Cliente: " + getNomeCliente());
        System.out.println("Dias: " + getQuantidadeDias());
        System.out.println("Valor Total: R$ " + getValorTotal());
        System.out.println("Status: " + getStatus());
        System.out.println("Quilometragem: Ilimitada");
        System.out.println("Seguro: Incluso");
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