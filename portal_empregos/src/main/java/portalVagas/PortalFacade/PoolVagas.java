package portalVagas.PortalFacade;

import java.util.ArrayList;
import java.util.List;
import portalVagas.Observer.Observer;
import portalVagas.Observer.Subject;

public class PoolVagas implements Subject<Vaga> {

    private ArrayList<Vaga> vagas;
    private List<Observer> observers;

    public PoolVagas() {
        this.vagas = new ArrayList<>();
        this.observers = new ArrayList<>(); // Initialize observers list
    }

    public PoolVagas(ArrayList<Vaga> vagas) {
        this.vagas = vagas;
        this.observers = new ArrayList<>(); // Initialize observers list
    }

    public ArrayList<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(ArrayList<Vaga> vagas) {
        this.vagas = vagas;
    }

    public void adicionarVaga(Vaga vaga) {
        this.vagas.add(vaga);

        notificar(vaga); 
    }

    @Override
    public void adicionarObserver(Observer observer) {
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA");
        this.observers.add(observer);
    }

    @Override
    public void removerObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notificar(Vaga vaga) {
        for (Observer observer : observers) {
            observer.update(vaga);
        }
    }
}
