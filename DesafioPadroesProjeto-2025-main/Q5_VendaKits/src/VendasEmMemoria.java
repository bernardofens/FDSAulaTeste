import java.time.LocalDateTime;
import java.util.*;

// Implementação da fachada para trabalhar com produtos e kits
public class VendasEmMemoria implements VendasFachada {
    private List<ItemVendavel> itens; // Lista unificada de produtos e kits

    public VendasEmMemoria() {
        itens = new ArrayList<>();
        inicializarProdutos();
        criarKitsExemplo();
    }

    private void inicializarProdutos() {
        // Produtos individuais
        itens.add(new Produto(1, "Caneta", 1.55));
        itens.add(new Produto(2, "Borracha", 1.15));
        itens.add(new Produto(3, "Caderno", 32.99));
        itens.add(new Produto(4, "Lápis", 0.85));
        itens.add(new Produto(5, "Régua", 2.30));
    }

    private void criarKitsExemplo() {
        // Kit Básico: Caneta + Borracha
        Kit kitBasico = new Kit(100, "Kit Básico");
        kitBasico.adicionarItem(buscarItemPorId(1)); // Caneta
        kitBasico.adicionarItem(buscarItemPorId(2)); // Borracha
        itens.add(kitBasico);

        // Kit Escolar: Caderno + Lápis + Régua
        Kit kitEscolar = new Kit(101, "Kit Escolar");
        kitEscolar.adicionarItem(buscarItemPorId(3)); // Caderno
        kitEscolar.adicionarItem(buscarItemPorId(4)); // Lápis
        kitEscolar.adicionarItem(buscarItemPorId(5)); // Régua
        itens.add(kitEscolar);

        // Kit Completo: Kit Básico + Kit Escolar (kit de kits!)
        Kit kitCompleto = new Kit(102, "Kit Completo");
        kitCompleto.adicionarItem(kitBasico);
        kitCompleto.adicionarItem(kitEscolar);
        itens.add(kitCompleto);
    }

    private ItemVendavel buscarItemPorId(int id) {
        return itens.stream()
                   .filter(item -> item.getId() == id)
                   .findFirst()
                   .orElse(null);
    }

    @Override
    public Venda iniciarVenda() {
        return new Venda(LocalDateTime.now());
    }

    @Override
    public void registrarVenda(Venda umaVenda, int codigoItem, int quantidade) {
        ItemVendavel item = buscarItemPorId(codigoItem);
        if (item != null) {
            umaVenda.registrarVenda(item, quantidade);
        } else {
            System.out.println("Item com código " + codigoItem + " não encontrado!");
        }
    }

    @Override
    public String emitirComprovante(Venda umaVenda) {
        return umaVenda.emitirComprovante();
    }

    @Override
    public List<ItemVendavel> buscarItens() {
        return Collections.unmodifiableList(itens);
    }

    @Override
    public Kit criarKit(int id, String nome, List<Integer> codigosItens) {
        // Verifica se já existe item com esse ID
        if (buscarItemPorId(id) != null) {
            throw new IllegalArgumentException("Já existe um item com ID " + id);
        }

        Kit novoKit = new Kit(id, nome);
        for (Integer codigo : codigosItens) {
            ItemVendavel item = buscarItemPorId(codigo);
            if (item != null) {
                novoKit.adicionarItem(item);
            } else {
                System.out.println("Aviso: Item com código " + codigo + " não encontrado e não foi adicionado ao kit.");
            }
        }
        itens.add(novoKit);
        return novoKit;
    }
}