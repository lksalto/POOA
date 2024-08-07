package portalVagas;

public abstract class Usuario {
    private String email;
    private String nome;
    private String senha;


    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }



    public void adicionarVaga(Vaga vaga) {}

    public abstract void adicionarObserver(Observer observer);
    public abstract void removerObserver(Observer observer);
    public abstract void notificar(Vaga vaga);
    public abstract String getDocumento();
    
    
}