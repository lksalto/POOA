package portalVagas;

import java.util.ArrayList;
import java.util.List;

public class Vaga {
    private String nome;
    private String descricao;
    private Empresa empresa;
    private List<Funcionario> funcionarios;

    public Vaga(String nome, String descricao, Empresa empresa) {
        this.nome = nome;
        this.descricao = descricao;
        this.empresa = empresa;
        this.funcionarios = new ArrayList<>();

    }

    public void addFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void setNome(String n)
    {
        this.nome = n;
    }
    public String getNome()
    {
        return this.nome;
    }
    public void setDescricao(String d)
    {
        this.nome = d;
    }
    public String getDescricao()
    {
        return this.descricao;
    }
    public void setEmpresa(Empresa e)
    {
        this.empresa = e;
    }
    public Empresa getEmpresa()
    {
        return this.empresa;
    }
}
