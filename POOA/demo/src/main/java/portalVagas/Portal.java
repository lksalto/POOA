package portalVagas;
import portalVagas.*;
import java.util.ArrayList;
import java.util.List;

public class Portal {
    private List<Empresa> empresas;
    private List<Funcionario> funcionarios;
    private List<Vaga> vagas;

    public Portal() {
        this.empresas = new ArrayList<>();
        this.empresas = new ArrayList<>();
        this.vagas = new ArrayList<>();
    }

    public void registrarEmpresa(Empresa empresa) {
        empresas.add(empresa);
    }

    public void registrarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void adicionarVaga(Vaga vaga) {
        vagas.add(vaga);
    }

    public List<Vaga> buscaVaga(String x) {
        List<Vaga> result = new ArrayList<>();
        for (Vaga vaga : vagas) {
            if (vaga.getNome().contains(x) || vaga.getDescricao().contains(x)) {
                result.add(vaga);
            }
        }
        return result;
    }
}