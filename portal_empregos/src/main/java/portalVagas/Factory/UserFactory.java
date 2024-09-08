package portalVagas.Factory;
import portalVagas.PortalFacade.Candidato;
import portalVagas.PortalFacade.Empresa;
import portalVagas.PortalFacade.Usuario;

public class UserFactory {
    private static UserFactory instance;

    private UserFactory() {}

    public static UserFactory getInstance() {
        if (instance == null) {
            instance = new UserFactory();
        }
        return instance;
    }

    public Usuario criarEmpresa(String nome, String email, String senha, String cnpj, String descricao, String cidade) {
        return new Empresa(nome, email, senha, cnpj, descricao, cidade);
    }

    public Usuario criarCandidato(String nome, String email, String senha, String cpf, String telefone, String sexo, String dataNasc) {
        return new Candidato(nome, email, senha, cpf, telefone, sexo, dataNasc);
    }
}