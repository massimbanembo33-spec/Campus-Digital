/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.digital.model;

import java.util.Date;

/**
 *
 * @author simba
 */
public class Funcionario extends Usuarios {
    
    protected String email_do_funcionario;
    protected String senha;
    protected String departamento;
    protected String turno_de_trabalho;

    public Funcionario(String nome, int ID, char sexo, Date data_de_nascimento, int numero_de_celular) {
        super(nome, ID, sexo, data_de_nascimento, numero_de_celular);
    }

    public Funcionario(String email_do_funcionario, String senha, String departamento, String turno_de_trabalho, String nome, int ID, char sexo, Date data_de_nascimento, int numero_de_celular) {
        super(nome, ID, sexo, data_de_nascimento, numero_de_celular);
        this.email_do_funcionario = email_do_funcionario;
        this.senha = senha;
        this.departamento = departamento;
        this.turno_de_trabalho = turno_de_trabalho;
    }

    public String getEmail_do_funcionario() {
        return email_do_funcionario;
    }

    public void setEmail_do_funcionario(String email_do_funcionario) {
        this.email_do_funcionario = email_do_funcionario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTurno_de_trabalho() {
        return turno_de_trabalho;
    }

    public void setTurno_de_trabalho(String turno_de_trabalho) {
        this.turno_de_trabalho = turno_de_trabalho;
    }

    
}
