package portalVagas.PortalFacade;

import java.util.ArrayList;
import java.util.List;


import portalVagas.Observer.*;

public class PortalEmprego {
    private String nome;
    private List<Usuario> empresas;
    private List<Usuario> candidatos;
    private List<Vaga> vagas;

    public PortalEmprego(String nome) {
        this.empresas = new ArrayList<>();
        this.candidatos = new ArrayList<>();
        this.vagas = new ArrayList<>();
        this.nome = nome;
    }

    public List<Usuario> getEmpresas() {
        return empresas;
    }

    public List<Usuario> getCandidatos() {
        return candidatos;
    }

    public String getNome() {
        return this.nome;
    }

    public void adicionarObserverInscricao(Usuario user) {
        Empresa empresa = (Empresa) user;
        empresa.getInscricoes().adicionarObserver(empresa);
    }

    public void adicionarObserverVaga(Usuario user, Usuario emp) {
        Candidato candidato = (Candidato) user;
        Empresa empresa = (Empresa) emp;
        empresa.getVagas().adicionarObserver(candidato);
    }

    public void candidatura(Usuario candidato, Vaga vaga) {
        Empresa empresa = (Empresa) vaga.getEmpresa();
        Inscricao inscricao = new Inscricao(vaga, (Candidato) candidato);
        
        empresa.getInscricoes().adicionarInscricao(inscricao);
        
        
    }

    public void registrarEmpresa(Usuario empresa) {
        empresas.add(empresa);
    }

    public void registrarCandidato(Usuario candidato) {
        candidatos.add(candidato);
    }

    public void postarVaga(Usuario empresa, Vaga vaga) {
        vagas.add(vaga);
        empresa.adicionarVaga(vaga);
        //notificarCandidatos(vaga);
    }

    public List<Vaga> buscaVagasFiltradas(String filtro) {
        List<Vaga> result = new ArrayList<>();
        for (Vaga vaga : vagas) {
            if (vaga.getNome().contains(filtro) || vaga.getDescricao().contains(filtro)) {
                result.add(vaga);
            }
        }
        return result;
    }

    public List<Vaga> buscaVagasGerais() {
        return this.vagas;
    }

    //Tentativa de uso do factory + state
    public void acaoVaga(int indice, Acao acao) {
        if (indice >= 0 && indice < vagas.size()) {
            Vaga vaga = vagas.get(indice);
            System.out.println("\nPORTAL TENTANDO " + acao.getClass().getSimpleName() + " A VAGA DE " + vaga.getNome());
            vaga.executarAcao(acao);
        } else {
            System.out.println("Indice de vaga invalido.");
        }
    }

}