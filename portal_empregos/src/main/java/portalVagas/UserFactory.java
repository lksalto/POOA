package portalVagas;

import java.util.ArrayList;

public class UserFactory {
    private static UserFactory instance;

    private UserFactory() {}

    public static UserFactory getInstance() {
        if (instance == null) {
            instance = new UserFactory();
        }
        return instance;
    }

    public Usuario criarEmpresa(String nome, String email, String senha, String cnpj, String descricao, String cidade) {
        return new Empresa(nome, email, senha, cnpj, descricao, cidade);
    }

    public Usuario criarEmpresa(String nome, String email, String senha, String cnpj, String descricao, String cidade, ArrayList<Observer> observers) {
        return new Empresa(nome, email, senha, cnpj, descricao, cidade, observers);
    }

    public Usuario criarFuncionario(String nome, String email, String senha, String cpf, String telefone, String sexo, String dataNasc) {
        return new Funcionario(nome, email, senha, cpf, telefone, sexo, dataNasc);
    }

    public Usuario criarFuncionario(String nome, String email, String senha, String cpf, String telefone, String sexo, String dataNasc, ArrayList<Observer> observers) {
        return new Funcionario(nome, email, senha, cpf, telefone, sexo, dataNasc, observers);
    }
}