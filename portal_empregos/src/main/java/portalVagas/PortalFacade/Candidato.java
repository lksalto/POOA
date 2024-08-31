package portalVagas.PortalFacade;

import java.util.ArrayList;


import portalVagas.Observer.Observer;

public class Candidato extends Usuario implements Observer<Vaga>{

    private String cpf;
    private String telefone;
    private String sexo;
    private String dataNasc;



    public Candidato(String nome, String email, String senha, String cpf,
                        String telefone, String sexo, String dataNasc) {
        super(nome, email, senha);
        this.cpf = cpf;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
       
    }



    String getCpf() {
        return cpf;
    }

    String getTelefone() {
        return telefone;
    }

    String getSexo() {
        return sexo;
    }

    String getDataNasc() {
        return dataNasc;
    }

    public String getDocumento()
    {
        return getCpf();
    }

    @Override
    public void update(Vaga vaga) {
        System.out.println("Nova vaga adicionada: " + vaga.getNome());
    }

    
}