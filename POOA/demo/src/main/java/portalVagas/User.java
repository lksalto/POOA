package portalVagas;


public abstract class User {
    protected String nome;
    protected String email;
    protected PortalEmprego portal;

    public User(String nome, String email, PortalEmprego portal) {
        this.nome = nome;
        this.email = email;
        this.portal = portal;
    }

    
}