class ValidadorFactory {
 public enum TipoValidador {EMAIL, MATRICULA, INTEIRO};

 public static IValidador criarValidador(TipoValidador tipo) {
        switch (tipo) {
            case EMAIL:
                return new ValidadorEmail();
            case INTEIRO:
                return new ValidadorInteiro();
            case MATRICULA:
                return new ValidadorMatricula();
            default:
                throw new IllegalArgumentException("Tipo de validador não suportado: " + tipo);
        }
    }
}