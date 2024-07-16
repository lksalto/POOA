package portalVagas;

import java.util.List;

public class Funcionario extends User implements Observer {
    private PortalEmprego portal;

    public Funcionario(String nome, String email, PortalEmprego portal) {
        super(nome, email, portal);
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
        System.out.println("Atencao " + this.getNome() + "! \nNova vaga postada: " + vaga.getNome());
    }
}