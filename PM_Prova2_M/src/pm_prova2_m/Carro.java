package pm_prova2_m;

public class Carro extends Veiculo implements Avaliavel {

    private int quantidadePortas;
    private int avaliacao;
    private boolean avaliado;

    public Carro(String placa, String modelo, int anoFabricacao, double valorDiaria,
                 double quilometragem, StatusVeiculo status, int quantidadePortas) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.quantidadePortas = quantidadePortas;
        this.avaliacao = 0;
        this.avaliado = false;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    @Override
    public void avaliar(int nota) {
        if (nota < 1 || nota > 5) {
            System.out.println("Nota invalida");
            return;
        }
        this.avaliacao = nota;
        this.avaliado = true;
        System.out.println("Carro " + getModelo() + " avaliado com nota " + nota + ".");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(" CARRO ");
        System.out.println("Placa: " + getPlaca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Ano: " + getAnoFabricacao());
        System.out.println("Valor da Diária: R$ " + getValorDiaria());
        System.out.println("Quilometragem: " + getQuilometragem() + " km rodados");
        System.out.println("Portas: " + quantidadePortas);
        System.out.println("Status: " + getStatus());
        System.out.println("Avaliação: " + (avaliado ? avaliacao + "/5" : "Sem avaliação"));
        System.out.println("Seguro Especial: " + (possuiSeguroEspecial() ? "Sim" : "Não"));
    }

    @Override
    public boolean possuiSeguroEspecial() {
        return false;
    }
}
