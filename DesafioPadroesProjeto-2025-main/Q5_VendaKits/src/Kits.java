import java.util.*;

public class Kit implements ItemVendavel {
    private int id;
    private String nome;
    private List<ItemVendavel> itens;
    private static final double DESCONTO = 0.10; 

    public Kit(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemVendavel item) {
        itens.add(item);
    }

    public void removerItem(ItemVendavel item) {
        itens.remove(item);
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
        double precoTotal = 0.0;
        for (ItemVendavel item : itens) {
            precoTotal += item.getPreco();
        }
        return precoTotal * (1 - DESCONTO);
    }

    public List<ItemVendavel> getItens() {
        return Collections.unmodifiableList(itens);
    }

    @Override
    public void exibirDetalhes(String indentacao) {
        System.out.println(indentacao + nome + " (Kit) - R$ " + getPreco());
        for (ItemVendavel item : itens) {
            item.exibirDetalhes(indentacao + "  ");
        }
    }
}