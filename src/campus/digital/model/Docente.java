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
public class Docente extends Usuarios{  
    
    protected String email_do_docente;
    protected String senha;
    protected String cedeira;
    protected String nivel_academico;
    protected String horario_de_trabalho;

    public Docente(String nome, int ID, char sexo, String numero_de_BI, String nacionalidade, Date data_de_nascimento, int numero_de_celular) {
        super(nome, ID, sexo, numero_de_BI, nacionalidade, data_de_nascimento, numero_de_celular);
    }

    public Docente(String email_do_docente, String senha, String cedeira, String nivel_academico, String horario_de_trabalho, String nome, int ID, char sexo, String numero_de_BI, String nacionalidade, Date data_de_nascimento, int numero_de_celular) {
        super(nome, ID, sexo, numero_de_BI, nacionalidade, data_de_nascimento, numero_de_celular);
        this.email_do_docente = email_do_docente;
        this.senha = senha;
        this.cedeira = cedeira;
        this.nivel_academico = nivel_academico;
        this.horario_de_trabalho = horario_de_trabalho;
    }

    public String getEmail_do_docente() {
        return email_do_docente;
    }

    public void setEmail_do_docente(String email_do_docente) {
        this.email_do_docente = email_do_docente;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCedeira() {
        return cedeira;
    }

    public void setCedeira(String cedeira) {
        this.cedeira = cedeira;
    }

    public String getNivel_academico() {
        return nivel_academico;
    }

    public void setNivel_academico(String nivel_academico) {
        this.nivel_academico = nivel_academico;
    }

    public String getHorario_de_trabalho() {
        return horario_de_trabalho;
    }

    public void setHorario_de_trabalho(String horario_de_trabalho) {
        this.horario_de_trabalho = horario_de_trabalho;
    }
    
    
  
    
}
