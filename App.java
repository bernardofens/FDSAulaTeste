// Padrão Composite: que envolve a classe Dado. 
// O Composite é um padrão estrutural que permite tratar objetos 
// individuais e composições de objetos de maneira uniforme.

/*

Análise do Problema:

No código fornecido, temos a classe Dado, que simula um dado de N lados. 
O objetivo é modificar essa estrutura para permitir:
- Dados individuais (como já existe).
- Grupos de dados (composite), onde podemos rolar vários dados de uma vez 
e obter um valor agregado (soma, média, etc.).

Solução com o Padrão Composite:

1) Interface/Classe Abstrata (ComponenteDado):
    Define operações comuns para dados simples e compostos.

2) Classe Dado (Folha):
    Implementa um dado individual (igual ao existente, mas seguindo a interface).

3) Classe GrupoDeDados (Composite):
    Agrupa vários ComponenteDado (que podem ser Dado ou GrupoDeDados) 
    e implementa a mesma interface.

*/

public class App {
    public static void main(String[] args) {
        // Dados individuais
        Dado d6 = new Dado(6);
        Dado d20 = new Dado(20);

        // Grupo de dados (composite)
        GrupoDeDados grupo = new GrupoDeDados();
        grupo.adicionar(new Dado(6)); // Adiciona um D6
        grupo.adicionar(new Dado(6)); // Adiciona outro D6

        // Rola todos
        d6.rolar();
        d20.rolar();
        grupo.rolar();

        // Exibe resultados
        System.out.println("D6: " + d6.getValor());
        System.out.println("D20: " + d20.getValor());
        System.out.println("Grupo (2D6): " + grupo.getValor()); // Soma dos dois D6
    }
}