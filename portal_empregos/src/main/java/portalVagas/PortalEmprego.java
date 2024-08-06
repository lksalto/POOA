package portalVagas;

import java.util.ArrayList;
import java.util.List;

public class PortalEmprego {
    private String nome;
    private List<Usuario> empresas;
    private List<Usuario> funcionarios;
    private List<Vaga> vagas;

    public PortalEmprego(String nome) {
        this.empresas = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.vagas = new ArrayList<>();
        this.nome = nome;
    }

    public List<Usuario> getEmpresas() {
        return empresas;
    }

    public List<Usuario> getFuncionarios() {
        return funcionarios;
    }

    public String getNome() {
        return this.nome;
    }

    public void adicionarEmpresaObserver(Usuario empresa, Observer observer) {
        empresa.adicionarObserver(observer);
    }

    public void adicionarFuncionarioObserver(Usuario empresa, Observer observer) {
        empresa.adicionarObserver(observer);
    }

    public void removerEmpresaObserver(Usuario empresa, Observer observer) {
        empresa.removerObserver(observer);
    }

    public void removerFuncionarioObserver(Usuario funcionario, Observer observer) {
        funcionario.removerObserver(observer);
    }

    public void candidatura(Usuario funcionario, Vaga vaga) {
        int indiceVaga = this.vagas.indexOf(vaga);
        this.vagas.get(indiceVaga).addFuncionario(funcionario);
        notificarEmpresa(vaga);
    }

    public void notificarEmpresa(Vaga vaga) {
        Usuario empresa = vaga.getEmpresa();
        int indiceEmpresa = this.empresas.indexOf(empresa);
        this.empresas.get(indiceEmpresa).notificar(vaga);
    }

    public void notificarFuncionarios(Vaga vaga) {
        for (Usuario funcionario : funcionarios) {
            funcionario.notificar(vaga);
        }
    }

    public void registrarEmpresa(Usuario empresa) {
        empresas.add(empresa);
    }

    public void registrarFuncionario(Usuario funcionario) {
        funcionarios.add(funcionario);
    }

    public void postarVaga(Usuario empresa, Vaga vaga) {
        vagas.add(vaga);
        empresa.adicionarVaga(vaga);
        notificarFuncionarios(vaga);
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
            System.out.println("PORTAL TENTANDO " + acao.getClass().getSimpleName() + " A VAGA DE " + vaga.getNome());
            vaga.executarAcao(acao);
        } else {
            System.out.println("Indice de vaga invalido.");
        }
    }

    // Memento: Mostrar histórico
    public void listarHistoricoVaga(int indice) {
        if (indice >= 0 && indice < vagas.size()) {
            Vaga vaga = vagas.get(indice);
            String historico = "";
            System.out.println("Histórico de estados da vaga '" + vaga.getNome() + "':");
            for (MementoVaga memento : vaga.getHistorico()) {
                historico += (memento.getEstado().getDesc() + " -> ");
            }
            historico = historico.substring(0, historico.length() - 3);
            System.out.println(historico);
        } else {
            System.out.println("Índice de vaga inválido.");
        }
    }

}