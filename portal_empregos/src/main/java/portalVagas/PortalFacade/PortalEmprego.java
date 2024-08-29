package portalVagas.PortalFacade;

import java.util.ArrayList;
import java.util.List;

import portalVagas.Observer.Observer;

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

    public void adicionarEmpresaObserver(Empresa empresa, Observer observer) {

        empresa.getInscricoes().adicionarObserver(observer);
        empresa.getVagas().adicionarObserver(observer);
    }

    public void adicionarCandidatoObserver(Candidato candidato, Observer observer) {

        //candidato.getInscricoes().adicionarObserver(observer);

    }



    public void removerEmpresaObserver(Usuario empresa, Observer observer) {
        empresa.removerObserver(observer);
    }

    public void removerCandidatoObserver(Usuario candidato, Observer observer) {
        candidato.removerObserver(observer);
    }

    public void candidatura(Usuario candidato, Vaga vaga) {
        Empresa empresa = (Empresa) vaga.getEmpresa();
        Inscricao inscricao = new Inscricao(vaga, (Candidato) candidato);
        empresa.getInscricoes().adicionarInscricao(inscricao);

    }

    public void notificarEmpresa(Vaga vaga) {
        Usuario empresa = vaga.getEmpresa();
        int indiceEmpresa = this.empresas.indexOf(empresa);
        this.empresas.get(indiceEmpresa).notificar(vaga);
    }

    public void notificarCandidatos(Vaga vaga) {
        for (Usuario candidato : candidatos) {
            candidato.notificar(vaga);
        }
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