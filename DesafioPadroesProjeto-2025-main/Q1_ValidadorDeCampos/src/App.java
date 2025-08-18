public class App {
    public static void main(String[] args) throws Exception {

        String email = "augusto@gmail.com";
        String emailInv = "augusto.fisch";
        String inteiro = "1234";
        String intInv = "12a34";
        String mat = "20102131";
        String matriculaInvalida = "123abc";

        IValidador validadorEmail = ValidadorFactory.criarValidador(ValidadorFactory.TipoValidador.EMAIL);
        System.out.println("Email válido '" + email + "': " + validadorEmail.valida(email));
        System.out.println("Email inválido '" + emailInv + "': " + validadorEmail.valida(emailInv));

        // Testando inteiros
        IValidador validadorInteiro = ValidadorFactory.criarValidador(ValidadorFactory.TipoValidador.INTEIRO);
        System.out.println("Inteiro válido '" + inteiro + "': " + validadorInteiro.valida(inteiro));
        System.out.println("Inteiro inválido '" + intInv + "': " + validadorInteiro.valida(intInv));

        // Testando matrículas
        IValidador validadorMatricula = ValidadorFactory.criarValidador(ValidadorFactory.TipoValidador.MATRICULA);
        System.out.println("Matrícula válida '" + mat + "': " + validadorMatricula.valida(mat));
        System.out.println(
                "Matrícula inválida '" + matriculaInvalida + "': " + validadorMatricula.valida(matriculaInvalida));
    }
}