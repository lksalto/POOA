package portalVagas;


public class Main {
    public static void main(String[] args) {
        PortalEmprego portal1 = new PortalEmprego();

        UserFactory userFactory = UserFactory.getInstance();

        Empresa empresa1 = (Empresa) userFactory.criaUser("Empresa", "TechCorp", "techplus@exemplo.com", portal1);
        Funcionario funcionario1 = (Funcionario) userFactory.criaUser("Funcionario", "Fulano", "fulano@gmail.com", portal1);

        portal1.registrarEmpresa(empresa1);
        portal1.registrarFuncionario(funcionario1);

        Vaga vaga1 = new Vaga("Engenheiro de Software", "Vaga para desenvolvedores plenos", empresa1);
        empresa1.postVaga(vaga1);
        portal1.addVaga(vaga1);
    }
}
