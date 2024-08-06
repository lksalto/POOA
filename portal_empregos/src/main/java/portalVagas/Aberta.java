package portalVagas;

public class Aberta implements Estado {
    String desc = "Aberta";
    @Override
    public void abrir(Vaga vaga)
    {
        
        System.out.println("A vaga '" + vaga.getNome() + "'já está aberta!");
    }

    @Override
    public void fechar(Vaga vaga)
    {
        vaga.setEstado(new Fechada());
        System.out.println("A vaga '" + vaga.getNome() + "' foi fechada!");
        vaga.salvarEstado(); //Memento
    }

    @Override
    public void cancelar(Vaga vaga)
    {
        vaga.setEstado(new Cancelada());
        System.out.println("A vaga '" + vaga.getNome() + "' foi cancelada!");
        vaga.salvarEstado(); //Memento
    }

    public String getDesc()
    {
        return desc;
    }
    
}
