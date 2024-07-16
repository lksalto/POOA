package portalVagas;
import portalVagas.*;
import java.util.ArrayList;
import java.util.List;


public class Empresa extends User {
    private List<Vaga> vagas;

    public Empresa(String name, String email) {
        super(name, email);
        this.vagas = new ArrayList<>();
    }

    public void postVaga(Vaga vaga) {
        vagas.add(vaga);
    }

    public List<Vaga> getVagas() {
        return vagas;
    }
}