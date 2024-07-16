package portalVagas;
import portalVagas.*;
import java.util.ArrayList;
import java.util.List;

public class PortalEmprego {
    private List<Empresa> empresas;
    private List<Funcionario> funcionarios;
    private List<Vaga> vagas;
    private List<Observer> observers;

    public PortalEmprego() {
        this.empresas = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.vagas = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Vaga vaga) {
        for (Observer observer : observers) {
            observer.update(vaga);
        }
    }

    public void registrarEmpresa(Empresa empresa) {
        empresas.add(empresa);
    }

    public void registrarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void addVaga(Vaga vaga) {
        vagas.add(vaga);
        notifyObservers(vaga);
    }

    public List<Vaga> buscaVagas(String x) {
        List<Vaga> result = new ArrayList<>();
        for (Vaga vaga : vagas) {
            if (vaga.getNome().contains(x) || vaga.getDescricao().contains(x)) {
                result.add(vaga);
            }
        }
        return result;
    }
}