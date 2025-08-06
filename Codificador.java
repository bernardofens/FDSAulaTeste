import java.time.LocalDate;

public interface Codificador {
    // Retorna o nome do codificador
    public String getNome();

    // Retorna a data de imlementação do codificador (pode ser usado como versao)
    public LocalDate getDataCriacao();

    // Retorna o nivel de segurança do codificador (1 = muito baixo, 100 = muito alto)
    public int getNivelSeguranca();

    // Recebe um string e retorna o correspondente codificado
    public String codifica(String str);

    // Recebe um string codificado e retorna o correspondente decodificado
    public String decodifica(String str);

    // func criada por Bernardo -> adiciona 3 letras 'm' ao final da str
    public String codificaBernardo(String str);

<<<<<<< HEAD
    // func criada por Augusto -> "completar"
    public String codificaAugusto(String str);
=======
    // Func criada por Augusto -> valor ASCII do caractere + tamanho da string
    public String codificaAugusto(String str);

    // Func criada por Victor 
    public String codificaVictor(String str); 

    // Func criada por Elisa -> retorna a primeira letra da string "Elisa" (E)
    public String codificaElisa();

>>>>>>> 7978bae4e21ac4b2e2ed8734ef16e29b9c9e363e
}