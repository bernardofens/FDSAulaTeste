
public class ValidadorMatricula implements IValidador {
    @Override
    public boolean valida(String valor) {
        // Usa ValidadorInteiro para checar se só tem dígitos
        ValidadorInteiro vInt = new ValidadorInteiro();
        if (!vInt.valida(valor)) return false;

        int sum = 0;
        for (int i = 0; i < valor.length() - 1; i++) {
            sum += Character.getNumericValue(valor.charAt(i));
        }
        int verificador = sum % 10;
        return verificador == Character.getNumericValue(valor.charAt(valor.length() - 1));
    }
}