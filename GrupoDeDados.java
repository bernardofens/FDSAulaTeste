import java.util.ArrayList;
import java.util.List;

public class GrupoDeDados implements ComponenteDado {
    private List<ComponenteDado> dados = new ArrayList<>();

    public void adicionar(ComponenteDado dado) {
        dados.add(dado);
    }

    @Override
    public void rolar() {
        for (ComponenteDado dado : dados) {
            dado.rolar();
        }
    }

    @Override
    public int getValor() {
        int soma = 0;
        for (ComponenteDado dado : dados) {
            soma += dado.getValor();
        }
        return soma;
    }
}