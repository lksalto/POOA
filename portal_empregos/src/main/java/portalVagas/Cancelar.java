package portalVagas;

public class Cancelar implements Acao {
    @Override
    public void executar(Vaga vaga)
    {
        vaga.cancelar();
    }
    
}
