package portalVagas.PortalFacade;

import java.util.ArrayList;

import portalVagas.Observer.Observer;

public class Empresa extends Usuario implements Observer<Inscricao>{
    private PoolVagas vagas;
    private PoolInscricao inscricoes;
    private String cnpj;
    private String descricao;
    private String cidade;
    private ArrayList<Observer> observers;

    public Empresa(String nome, String email, String senha,String cnpj,
                    String descricao, String cidade) {
        super(nome, email, senha);
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.cidade = cidade;
        this.observers = new ArrayList<>();
        this.vagas = new PoolVagas();
        this.inscricoes = new PoolInscricao();

    }

    public Empresa(String nome, String email, String senha,String cnpj,
                    String descricao, String cidade, ArrayList<Observer> observers) {
        super(nome, email, senha);
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.cidade = cidade;
        this.observers = observers;
        this.vagas = new PoolVagas();
        this.inscricoes = new PoolInscricao();
    }

    public String getCnpj() {
        return cnpj;
    }

    public PoolVagas getVagas() {
        return vagas;
    }
    
    public PoolInscricao getInscricoes() {
        return inscricoes;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCidade() {
        return cidade;
    }
    
    public String getDocumento()
    {
        return getCnpj();
    }


    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    public void adicionarObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removerObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void adicionarVaga(Vaga vaga) {
        vagas.adicionarVaga(vaga);
    }

    public void adicionarInscricao(Inscricao inscricao) {
        inscricoes.adicionarInscricao(inscricao);
    }

    @Override
    public void update(Inscricao inscricao) {
        System.out.println(inscricao.getCandidato().getNome() + " se inscreveu na vaga: " + inscricao.getVaga().getNome());
    }

}