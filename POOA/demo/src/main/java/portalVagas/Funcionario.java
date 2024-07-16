package portalVagas;
import portalVagas.*;
import java.util.List;

public class Funcionario extends User implements Observer {
    private PortalEmprego portal;

    public Funcionario(String nome, String email, PortalEmprego portal) {
        super(nome, email);
        this.portal = portal;
        portal.registerObserver(this);
    }

    public List<Vaga> buscaVagas(String x) {
        return portal.buscaVagas(x);
    }

    public void aplicarVaga(Vaga vaga) {
        vaga.addFuncionario(this);
    }

    @Override
    public void update(Vaga vaga) {
        System.out.println("Nova vaga postada: " + vaga.getNome());
    }
}