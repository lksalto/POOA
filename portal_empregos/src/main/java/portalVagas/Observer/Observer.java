package portalVagas.Observer;

import portalVagas.PortalFacade.Inscricao;
import portalVagas.PortalFacade.Vaga;

public interface Observer {
    void update(Vaga vaga);
    void update(Inscricao inscricao);
}
