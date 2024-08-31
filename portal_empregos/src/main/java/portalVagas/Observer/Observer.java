package portalVagas.Observer;

import portalVagas.PortalFacade.Inscricao;
import portalVagas.PortalFacade.Vaga;

public interface Observer<T> {
    void update(T tipo);

}
