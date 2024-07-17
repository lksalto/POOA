package portalVagas;

import java.util.List;

public class Funcionario extends Usuario implements Observer {
    private PortalEmprego portal;
    String cpf;
    String telefone;
    String sexo;
    String dataNasc;

    public Funcionario(String nome, String email, String senha, String cpf,
                        String telefone, String sexo, String dataNasc, 
                        PortalEmprego portal) {
        super(nome, email, senha, portal);
        this.cpf = cpf;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
    }

    public List<Vaga> buscaVagas(String x) {
        return portal.buscaVagas(x);
    }

    public void aplicarVaga(Vaga vaga) {
        vaga.addFuncionario(this);
    }

    public String getNome()
    {
        return this.nome;
    }

    @Override
    public void update(Vaga vaga) {
        System.out.println("\nAtencao " + this.getNome() + "! \nNova vaga postada: " + vaga.getNome() + "\n");
    }
}