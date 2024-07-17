package portalVagas;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Criar portal de emprego
        PortalEmprego portal1 = new PortalEmprego();

        //Instanciar fábrica de Usuários (Utilizando Factory + Singleton)
        UserFactory userFactory = UserFactory.getInstance();

        //Criando objetos concretos
        Empresa empresa1 = (Empresa) userFactory.criaEmpresa("TechCorp", "techplus@exemplo.com", 
                                                        "TechCorp_123", "12.341.488/0001-08", 
                                                        "Empresa de tecnologia", 
                                                "Sao Paulo", portal1);
        Funcionario funcionario1 = (Funcionario) userFactory.criaFuncionario("Fulano", "fulano@gmail.com","Senha123","123.123.123-09", 
                                                        "(11) 1234-5678", "Masculino", "09/02/1931" , portal1);

        //Registrar empresa e funcionario no portal
        portal1.registrarEmpresa(empresa1);
        portal1.registrarFuncionario(funcionario1);

        //Adicionar vaga, utilizando Observer para informar o funcionário que está no portal.
        Vaga vaga1 = new Vaga("Engenheiro de Software", "Vaga para desenvolvedores plenos", empresa1);
        Vaga vaga2 = new Vaga("Engenheiro de Producao", "Vaga Producao", empresa1);
        Vaga vaga3 = new Vaga("Engenheiro de Dados", "Vaga Dados", empresa1);
        Vaga vaga4 = new Vaga("Assitente de Marketing", "Vaga Marketing", empresa1);
        Vaga vaga5 = new Vaga("Professor", "Vaga Escola", empresa1);
        Vaga vaga6 = new Vaga("Secretario", "Vaga Secretaria", empresa1);

        empresa1.postVaga(vaga1);
        empresa1.postVaga(vaga2);
        empresa1.postVaga(vaga3);
        empresa1.postVaga(vaga4);
        empresa1.postVaga(vaga5);
        empresa1.postVaga(vaga6);

        List<Vaga> vagas = new ArrayList<>();
        vagas = portal1.buscaVagas("Engenheiro");
        for(int i = 0; i<vagas.size(); i++)
        {
            System.out.println(vagas.get(i).getNome() + "\n");
        }
        
    }
}
