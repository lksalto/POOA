package portalVagas;



public class UserFactory {
    // Instância única da classe
    private static UserFactory instance;

    // Construtor privado para evitar instanciamento externo
    private UserFactory() {}

    // Método estático para obter a instância única da classe
    public static UserFactory getInstance() {
        if (instance == null) {
            instance = new UserFactory();
        }
        return instance;
    }

    public User criaUser(String tipo, String nome, String email, PortalEmprego portal) {
        if (tipo.equalsIgnoreCase("Empresa")) {
            return new Empresa(nome, email, portal);
        } else if (tipo.equalsIgnoreCase("Funcionario")) {
            return new Funcionario(nome, email, portal);
        }
        return null;
    }
}