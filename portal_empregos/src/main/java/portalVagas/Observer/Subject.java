package portalVagas.Observer;

public interface Subject<T> {
    void adicionarObserver(Observer observer);
    void removerObserver(Observer observer);
    void notificar(T entity);
}