package portalVagas;


import java.util.ArrayList;
import java.util.List;

public class Empresa extends User {
    private List<Vaga> vagas = new ArrayList<>();

    public Empresa(String nome, String email, PortalEmprego portal) {
        super(nome, email, portal);
    }

    public void postVaga(Vaga vaga) {
        vagas.add(vaga);
    }
}