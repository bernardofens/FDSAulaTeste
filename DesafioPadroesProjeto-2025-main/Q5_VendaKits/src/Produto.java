public class Produto implements ItemVendavel {
    private int id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public void exibirDetalhes(String indentacao) {
        System.out.println(indentacao  + nome + " - R$ " + String.format("%.2f", preco));
    }
}