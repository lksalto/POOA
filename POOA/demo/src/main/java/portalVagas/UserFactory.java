package portalVagas;
import portalVagas.*;


public class UserFactory {
    public static User criaUser(String tipo, String nome, String email, PortalEmprego portal) {
        if (tipo.equalsIgnoreCase("Empresa")) {
            return new Empresa(nome, email);
        } else if (tipo.equalsIgnoreCase("Funcionario")) {
            return new Funcionario(nome, email, portal);
        }
        return null;
    }
}