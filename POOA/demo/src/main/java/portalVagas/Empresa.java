package portalVagas;


import java.util.ArrayList;
import java.util.List;

public class Empresa extends Usuario {
    private List<Vaga> vagas = new ArrayList<>();
    String cnpj;
    String descricao;
    String cidade;

    public Empresa(String nome, String email, String senha,String cnpj,
                    String descricao, String cidade,PortalEmprego portal) {
        super(nome, email, senha, portal);
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.cidade = cidade;
    }

    public void postVaga(Vaga vaga) {
        vagas.add(vaga);
        portal.addVaga(vaga);
    }
}