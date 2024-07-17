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

    public Usuario criaEmpresa(String nome, String email, String senha, 
                            String cnpj, String descricao, String cidade, 
                            PortalEmprego portal) {

        return new Empresa(nome, email, senha, cnpj, descricao, cidade, portal);
    }

    public Usuario criaFuncionario(String nome, String email, String senha, 
                            String cpf, String telefone, String sexo, String dataNasc, 
                            PortalEmprego portal)
    {
        return new Funcionario(nome, email, senha, cpf, telefone, sexo, dataNasc, portal);
    }
}