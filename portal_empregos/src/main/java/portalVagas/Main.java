package portalVagas;


import portalVagas.Factory.UserFactory;
import portalVagas.Factory.VagaFactory;

import portalVagas.PortalFacade.PortalEmprego;
import portalVagas.PortalFacade.Usuario;
import portalVagas.PortalFacade.Empresa;
import portalVagas.PortalFacade.Candidato;
import portalVagas.PortalFacade.Vaga;

public class Main {
    public static void main(String[] args) {
        // Instanciacao de fabricas
        VagaFactory vagaFactory = VagaFactory.getInstance();
        UserFactory userFactory = UserFactory.getInstance();
        
        // Criacao dos objetos concretos
        PortalEmprego portal1 = new PortalEmprego("Portal de POOA");
        Usuario empresa1 = userFactory.criarEmpresa("TechCorp", "techplus@exemplo.com",  "TechCorp_123", "12.341.488/0001-08", "Empresa de tecnologia", "Sao Paulo");
        Usuario candidato1 = userFactory.criarCandidato("Fulano", "fulano@gmail.com", "Senha123","123.123.123-09", "(11) 1234-5678", "Masculino", "09/02/1931");

        Vaga vaga1 = vagaFactory.criaVaga("Engenheiro de Software", "Vaga para desenvolvedores plenos", empresa1);
        Vaga vaga2 = vagaFactory.criaVaga("Engenheiro de Producao", "Vaga Producao", empresa1);
        Vaga vaga3 = vagaFactory.criaVaga("Engenheiro de Dados", "Vaga Dados", empresa1);
        Vaga vaga4 = vagaFactory.criaVaga("Assitente de Marketing", "Vaga Marketing", empresa1);
        Vaga vaga5 = vagaFactory.criaVaga("Professor", "Vaga Escola", empresa1);
        Vaga vaga6 = vagaFactory.criaVaga("Secretario", "Vaga Secretaria", empresa1);
        
        // Definicao dos observers em Empresa e Candidato
        portal1.adicionarEmpresaObserver((Empresa) empresa1, candidato1);
        portal1.adicionarCandidatoObserver((Candidato) candidato1, empresa1);
        // Registro de empresa e candidato no portal
        portal1.registrarEmpresa(empresa1);
        portal1.registrarCandidato(candidato1);
        
        // Adicao de vagas
        portal1.postarVaga(empresa1, vaga1);
        portal1.postarVaga(empresa1, vaga2);
        portal1.postarVaga(empresa1, vaga3);
        portal1.postarVaga(empresa1, vaga4);
        portal1.postarVaga(empresa1, vaga5);
        portal1.postarVaga(empresa1, vaga6);
        
        // Candidaturas
        portal1.candidatura(candidato1, vaga1);
        portal1.candidatura(candidato1, vaga4);
        portal1.candidatura(candidato1, vaga5);
        /*
        //Strategy + State
        portal1.acaoVaga(0, new Fechar());
        portal1.acaoVaga(0, new Fechar());
        portal1.acaoVaga(0, new Abrir());
        portal1.acaoVaga(0, new Cancelar());
        portal1.acaoVaga(0, new Fechar());
        portal1.acaoVaga(0, new Abrir());
        */
    }
}
