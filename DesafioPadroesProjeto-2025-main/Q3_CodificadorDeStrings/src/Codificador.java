import java.util.HashMap;
import java.util.Map;

public class Codificador{
    public enum Tipo {SIMPLES,DESLOCA};
    private Map<Character,Character> tabCod;
    private Map<Character,Character> tabDeCod;

    public Codificador(){
        tabCod = new HashMap<>();
        tabCod.put('a','@');
        tabCod.put('e','#');
        tabCod.put('i','!');
        tabCod.put('o','$');
        tabCod.put('u','%');
        tabDeCod = new HashMap<>();
        tabDeCod.put('@','a');
        tabDeCod.put('#','e');
        tabDeCod.put('!','i');
        tabDeCod.put('$','o');
        tabDeCod.put('%','u');
        
    }

    private String codificaSimples(String str){
        char[] aux = str.toCharArray();
        char[] resp = new char[str.length()];
        for(int i=0;i<aux.length;i++){
            if (tabCod.containsKey(aux[i])){
                resp[i] = tabCod.get(aux[i]);
            }else{
                resp[i] = aux[i];
            }
        }
        return(new String(resp));
    }

    private String deCodificaSimples(String str){
        char[] aux = str.toCharArray();
        char[] resp = new char[str.length()];
        for(int i=0;i<aux.length;i++){
            if (tabDeCod.containsKey(aux[i])){
                resp[i] = tabDeCod.get(aux[i]);
            }else{
                resp[i] = aux[i];
            }
        }
        return(new String(resp));
    }

    private String codificaDesloca(String str){
        char[] aux = str.toCharArray();
        char[] resp = new char[str.length()];
        for(int i=0;i<aux.length;i++){
            resp[i] = (char)(Character.valueOf(aux[i])+1);
        }
        return(new String(resp));
    }

    private String deCodificaDesloca(String str){
        char[] aux = str.toCharArray();
        char[] resp = new char[str.length()];
        for(int i=0;i<aux.length;i++){
            resp[i] = (char)(Character.valueOf(aux[i])-1);
        }
        return(new String(resp));
    }

    public String codifica(Tipo tipo,String str){
        switch(tipo){
            case SIMPLES:
                return codificaSimples(str);
            case DESLOCA:
                return codificaDesloca(str);
            default:
                return str;
        }
    }

    public String deCodifica(Tipo tipo,String str){
        switch(tipo){
            case SIMPLES:
                return deCodificaSimples(str);
            case DESLOCA:
                return deCodificaDesloca(str);
            default:
                return str;
        }
    }

}