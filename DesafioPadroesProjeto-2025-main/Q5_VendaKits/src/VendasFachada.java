import java.util.List;

// Interface da fachada modificada para trabalhar com ItemVendavel
public interface VendasFachada {
    
    /**
     * Cria uma nova venda e inicia o processo de venda
     * @return a venda recém criada
     */
    Venda iniciarVenda();
    
    /**
     * Registra um novo item de venda (produto ou kit) em uma venda
     * @param umaVenda a venda atual sendo processada
     * @param codigoItem o código do item vendido (produto ou kit)
     * @param quantidade a quantidade vendida do item
     */
    void registrarVenda(Venda umaVenda, int codigoItem, int quantidade);
    
    /**
     * Emite o comprovante de venda a ser impresso
     * @param umaVenda a venda para emissão do comprovante
     * @return uma String representando o comprovante de venda
     */
    String emitirComprovante(Venda umaVenda);

    /**
     * Consulta a lista de itens disponíveis para venda (produtos e kits)
     * @return a lista de itens disponíveis para venda
     */
    List<ItemVendavel> buscarItens();
    
    /**
     * Cria um novo kit com os itens especificados
     * @param id código único do kit
     * @param nome nome do kit
     * @param codigosItens lista com códigos dos itens que compõem o kit
     * @return o kit criado
     */
    Kit criarKit(int id, String nome, List<Integer> codigosItens);
}