package portalVagas.PortalFacade;

import java.util.ArrayList;
import java.util.List;
import portalVagas.Observer.Observer;
import portalVagas.Observer.Subject;

public class PoolInscricao implements Subject<Inscricao> {

    private ArrayList<Inscricao> inscricoes;
    private List<Observer> observers;

    public PoolInscricao() {
        this.inscricoes = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public PoolInscricao(ArrayList<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
        this.observers = new ArrayList<>(); 
    }

    public ArrayList<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(ArrayList<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public void adicionarInscricao(Inscricao inscricao) {
        this.inscricoes.add(inscricao);
        notificar(inscricao);
    }

    @Override
    public void adicionarObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removerObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notificar(Inscricao inscricao) {
        for (Observer observer : observers) {
            observer.update(inscricao);
        }
    }
}
