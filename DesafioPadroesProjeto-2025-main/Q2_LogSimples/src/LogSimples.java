import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LogSimples implements Iterable<String>{
    private List<String> mensagens;

    private static LogSimples instancia; // adicionado


    private LogSimples(){ // mudei public para private
        mensagens = new LinkedList<>();
    }

    public static LogSimples getInstancia(){ // método para obter a instância
        if (instancia == null){
            instancia = new LogSimples();
        }
        return instancia;
    }

    public void log(String m){
        String logM = LocalDate.now().toString() + " : " + m;
        mensagens.add(logM);
    }

    @Override
    public Iterator<String> iterator() {
        return mensagens.iterator();
    }
}
