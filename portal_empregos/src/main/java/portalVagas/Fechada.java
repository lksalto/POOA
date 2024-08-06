package portalVagas;

public class Fechada implements Estado {
    String desc = "Fechada";
    @Override
    public void abrir(Vaga vaga)
    {
        vaga.setEstado(new Aberta());
        System.out.println("A vaga '" + vaga.getNome() + "' foi reaberta!");
        vaga.salvarEstado(); 
    }

    @Override
    public void fechar(Vaga vaga)
    {
        System.out.println("A vaga '" + vaga.getNome() + "' já está fechada!");
    }

    @Override
    public void cancelar(Vaga vaga)
    {
        vaga.setEstado(new Cancelada());
        System.out.println("A vaga '" + vaga.getNome() + "' foi cancelada!");
        vaga.salvarEstado(); 
    }
    public String getDesc()
    {
        return desc;
    }
}
