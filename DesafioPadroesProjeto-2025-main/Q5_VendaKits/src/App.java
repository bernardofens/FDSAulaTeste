import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        VendasFachada sistema = new VendasEmMemoria();
        
        System.out.println("=== ITENS DISPONÍVEIS PARA VENDA ===");
        exibirItensDisponiveis(sistema);
        
        System.out.println("\n=== REALIZANDO VENDA ===");
        realizarVendaExemplo(sistema);
        
        System.out.println("\n=== CRIANDO NOVO KIT DINAMICAMENTE ===");
        criarNovoKitExemplo(sistema);
    }

    private static void exibirItensDisponiveis(VendasFachada sistema) {
        List<ItemVendavel> itensDisponiveis = sistema.buscarItens();
        for (ItemVendavel item : itensDisponiveis) {
            item.exibirDetalhes("");
            System.out.println();
        }
    }

    private static void realizarVendaExemplo(VendasFachada sistema) {
        Venda venda = sistema.iniciarVenda();
        
        sistema.registrarVenda(venda, 1, 2); 
        sistema.registrarVenda(venda, 3, 1); 
        
       
        sistema.registrarVenda(venda, 100, 1); 
        sistema.registrarVenda(venda, 102, 1); 
        
        System.out.println(sistema.emitirComprovante(venda));
    }

    private static void criarNovoKitExemplo(VendasFachada sistema) {
        try {
            Kit novoKit = sistema.criarKit(103, "Kit Personalizado", Arrays.asList(1, 4, 5));
            System.out.println("Kit criado com sucesso:");
            novoKit.exibirDetalhes("");
            
            System.out.println("\n=== VENDENDO O NOVO KIT ===");
            Venda vendaNovoKit = sistema.iniciarVenda();
            sistema.registrarVenda(vendaNovoKit, 103, 1);
            System.out.println(sistema.emitirComprovante(vendaNovoKit));
            
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar kit: " + e.getMessage());
        }
    }
}