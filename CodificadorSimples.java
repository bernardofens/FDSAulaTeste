import java.time.LocalDate;

public class CodificadorSimples implements Codificador {
    public String getNome() {
        return "Codificador Simples";
    }

    public LocalDate getDataCriacao() {
        return LocalDate.of(2025, 03, 13);
    }

    public int getNivelSeguranca() {
        return 1;
    }

    public String codifica(String str) {
        StringBuilder encoded = new StringBuilder();

        for (char c : str.toCharArray()) {
            encoded.append((char) (c + 1));
        }

        return encoded.toString();
    }

    public String decodifica(String str) {
        StringBuilder encoded = new StringBuilder();

        for (char c : str.toCharArray()) {
            encoded.append((char) (c - 1));
        }

        return encoded.toString();
    }

    public String codificaBernardo(String str) {
        return str + "mmm";
    }

    public String codificaVictor(String str) {
        StringBuilder encoded = new StringBuilder();

        for (char c : str.toCharArray()) {
            encoded.append((char) (c + 19));
        }

        return encoded.toString();
    }

    public String codificaAugusto(String str) {
        StringBuilder codificacao = new StringBuilder();

        for (char c : str.toCharArray()) {
            codificacao.append((char) ((int) c + str.length()));
        }

        return codificacao.toString();
    }

    @Override
    public String codificaElisa(String str) {
        String string = "Elisa";
        return String.valueOf(string.charAt(0));
    }




}