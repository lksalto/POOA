package portalVagas;

import java.util.ArrayList;
import java.util.List;

public class Vaga {
    private String nome;
    private String descricao;
    private Usuario empresa;
    private List<Usuario> funcionarios;
    //State
    private Estado estado;
    //Memento
    private List<MementoVaga> historico;


    public Vaga(String nome, String descricao, Usuario empresa) {
        this.nome = nome;
        this.descricao = descricao;
        this.empresa = empresa;
        this.funcionarios = new ArrayList<>();

        //Inicializar com estado = aberto
        this.estado = new Aberta();
        this.historico = new ArrayList<>();
        //Memento (estado inicial)
        salvarEstado();
    }

    public void addFuncionario(Usuario funcionario) {
        funcionarios.add(funcionario);
    }

    public void setNome(String n) {
        this.nome = n;
    }
    
    public String getNome() {
        return this.nome;
    }

    public void setDescricao(String d) {
        this.nome = d;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setEmpresa(Empresa e) {
        this.empresa = e;
    }

    public Usuario getEmpresa() {
        return this.empresa;
    }

    //getters e setters para estado
    public void setEstado(Estado estado)
    {
        this.estado = estado;
    }
    public Estado getEstado()
    {
        return this.estado;
    }

    // Métodos para abrir, fechar ou cancelar a vaga
    public void abrir() {
        estado.abrir(this);
        //Memento
        
       
    }

    public void fechar() {
        estado.fechar(this);
        //Memento
        

        
    }

    public void cancelar() {
        estado.cancelar(this);
        //Memento
        
        
    }

    // Método para executar a ação (factory)
    public void executarAcao(Acao acao) {
        //O state vai decidir o que acontece ao executar cada ação.
        acao.executar(this);
        
    }

    // Métodos Memento
    public void salvarEstado() {
        historico.add(new MementoVaga(estado));
        
    }

    public MementoVaga criarMemento() {
        return new MementoVaga(estado);
    }

    public List<MementoVaga> getHistorico() {
        return historico;
    }

    public void voltaMemento()
    {
        if(historico.size() >= 2)
        {
            System.err.println("Voltando o estado: " + historico.get(historico.size()-1).getEstado().getDesc() + "--->" + historico.get(historico.size()-2).getEstado().getDesc() );
            historico.remove(historico.get(historico.size()-1));
            setEstado(historico.get(historico.size()-1).getEstado());
        }
        else
        {
            System.err.println("Não é possivel voltar o estado!");
        }

    }
}
