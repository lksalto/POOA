package portalVagas;


import portalVagas.Factory.UserFactory;
import portalVagas.Factory.VagaFactory;

import portalVagas.PortalFacade.PortalEmprego;
import portalVagas.PortalFacade.Usuario;
import portalVagas.PortalFacade.Fechar;
import portalVagas.PortalFacade.Abrir;
import portalVagas.PortalFacade.Cancelar;
import portalVagas.PortalFacade.Vaga;

public class Main {
    public static void main(String[] args) {
        // Instanciacao de fabricas
        VagaFactory vagaFactory = VagaFactory.getInstance();
        UserFactory userFactory = UserFactory.getInstance();
       

        // Criacao dos objetos concretos
        PortalEmprego portal1 = new PortalEmprego("Portal de POOA");
        Usuario empresa1 = userFactory.criarEmpresa("TechCorp", "techplus@exemplo.com",  
        "TechCorp_123", "12.341.488/0001-08", "Empresa de tecnologia", "Sao Paulo");
        Usuario empresa2 = userFactory.criarEmpresa("Escola", "escola@exemplo.com",  
        "Escola_123", "41.341.432/0021-02", "Escola fundamental", "Sao Paulo");
        
        Usuario candidato1 = userFactory.criarCandidato("Fulano", "fulano@gmail.com", 
        "Senha123","123.123.123-09", "(11) 1234-5678", "Masculino", "09/02/1931");
        
        // Definicao dos observers em Empresa1 e Candidato1
        portal1.adicionarObserverInscricao(empresa1);
        portal1.adicionarObserverVaga(candidato1, empresa1);

        // Registro de empresa e candidato no portal
        portal1.registrarEmpresa(empresa1);
        portal1.registrarCandidato(candidato1);

        Vaga vagaESoftware = vagaFactory.criaVaga("Engenheiro de Software", 
                "Vaga para desenvolvedores plenos", empresa1);
        Vaga vagaEProd = vagaFactory.criaVaga("Engenheiro de Producao", 
                "Vaga Producao", empresa1);
        Vaga vagaEDados = vagaFactory.criaVaga("Engenheiro de Dados", 
                "Vaga Dados", empresa1);
        Vaga vagaMarketing = vagaFactory.criaVaga("Assitente de Marketing", 
                "Vaga Marketing", empresa1);
        Vaga vagaProf = vagaFactory.criaVaga("Professor", 
                "Vaga Escola", empresa2);
        Vaga vagaSecretario = vagaFactory.criaVaga("Secretario", 
                "Vaga Secretaria", empresa2);
        
        // Adicao de vagas
        portal1.postarVaga(vagaESoftware);
        portal1.postarVaga(vagaEProd);
        portal1.postarVaga(vagaEDados);
        portal1.postarVaga(vagaMarketing);
        //Não estão no observer
        portal1.postarVaga(vagaProf);
        portal1.postarVaga(vagaSecretario);
        
        // Candidaturas
        portal1.candidatura(candidato1, vagaESoftware);
        portal1.candidatura(candidato1, vagaMarketing);
        //Não está no observer
        portal1.candidatura(candidato1, vagaSecretario);
                
        //Strategy + State
        portal1.acaoVaga(0, new Fechar());
        portal1.acaoVaga(0, new Fechar());
        portal1.acaoVaga(0, new Abrir());
        portal1.acaoVaga(0, new Cancelar());
        portal1.acaoVaga(0, new Fechar());
        portal1.acaoVaga(0, new Abrir());
        
    }
}
