package pm_prova2_m;

public class Van extends Veiculo implements Avaliavel, Inspecionavel {

    private int maxPassageiros;
    private int avaliacao;
    private boolean avaliada;
    private boolean inspecionada;

    public Van(String placa, String modelo, int anoFabricacao, double valorDiaria,
               double quilometragem, StatusVeiculo status, int maxPassageiros) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.maxPassageiros = maxPassageiros;
        this.avaliacao = 0;
        this.avaliada = false;
        this.inspecionada = false;
    }

    public int getMaxPassageiros() {
        return maxPassageiros;
    }

    public void setMaxPassageiros(int maxPassageiros) {
        this.maxPassageiros = maxPassageiros;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public boolean isInspecionada() {
        return inspecionada;
    }

    @Override
    public void avaliar(int nota) {
        if (nota < 1 || nota > 5) {
            System.out.println("Nota invalida");
            return;
        }
        this.avaliacao = nota;
        this.avaliada = true;
        System.out.println("Van " + getModelo() + " avaliada com nota " + nota + ".");
    }

    @Override
    public void realizarInspecao() {
        this.inspecionada = true;
        System.out.println("Inspeção realizada na van " + getModelo() + " (Placa: " + getPlaca() + ").");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(" VAN ");
        System.out.println("Placa: " + getPlaca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Ano: " + getAnoFabricacao());
        System.out.println("Valor da Diária: R$ " + getValorDiaria());
        System.out.println("Quilometragem: " + getQuilometragem() + " km rodados");
        System.out.println("Maximo Passageiros: " + maxPassageiros);
        System.out.println("Status: " + getStatus());
        System.out.println("Avaliação: " + (avaliada ? avaliacao + "/5" : "Sem avaliação"));
        System.out.println("Inspecionada: " + (inspecionada ? "Sim" : "Não"));
        System.out.println("Seguro Especial: " + (possuiSeguroEspecial() ? "Sim" : "Não"));
    }

    @Override
    public boolean possuiSeguroEspecial() {
        return false;
    }
}