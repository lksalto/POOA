package portalVagas;

public class MementoVaga {
    private final Estado estado;

    public MementoVaga(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
