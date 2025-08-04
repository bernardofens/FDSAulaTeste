public class CodificadorVictor implements Codificador {
    public String getNome() {
        return "Codificador Victor";
    }

    public LocalDate getDataCriacao() {
        return LocalDate.of(2025, 03, 13);
    }

    public int getNivelSeguranca(){
        return 56;
    }

    public String codifica(String str) {
        StringBuilder encoded = new StringBuilder();

        for (char c : str.toCharArray()) {
            encoded.append((char) (c + 56));
        }

        return encoded.toString();
    }

    public String decodifica(String str) {
        StringBuilder decoded = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            decoded.append((char) (c - 56));
        }
        
        return decoded.toString();
    }
        
    public String getDescricao() {
        return "Codificador criado por Victor, com nível de segurança 56.";
    }

    public String getTipo() {
        return "Codificador de Texto";
    }

    public String getVersao() {
        return "1.0";
    }

    public String getAutor() {
        return "Victor";
    }

    public String getEmail() {
        return "victor.closs@edu.pucrs.br";
    }

}