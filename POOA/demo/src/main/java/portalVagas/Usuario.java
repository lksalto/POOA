package portalVagas;


public abstract class Usuario {
    protected String nome;
    protected String email;
    protected String senha;
    protected PortalEmprego portal;

    public Usuario(String nome, String email, String senha, PortalEmprego portal) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.portal = portal;
        
    }

    
}