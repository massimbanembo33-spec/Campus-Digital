/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.digital.model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author simba
 */
public class Docente extends Usuarios{  
    
    protected String email_do_docente;
    protected char[] senha;
    protected char[] senha_repetida;
    protected String cadeira;
    protected String nivel_academico;
    protected String horario_de_trabalho;

    public Docente() {} // - Para ser capaz de criar de instanciar sem passar nenhum parrametros
    

    public Docente(String nome, String ID, char sexo, String numero_de_BI, String nacionalidade, LocalDate data_de_nascimento, int numero_de_celular) {
        super(nome, ID, sexo, numero_de_BI, nacionalidade, data_de_nascimento, numero_de_celular);
    }

    public Docente(String email_do_docente, char[] senha, char[] senha_repetida, String cadeira, String nivel_academico, String horario_de_trabalho, String nome, String ID, char sexo, String numero_de_BI, String nacionalidade, LocalDate data_de_nascimento, int numero_de_celular) {
        super(nome, ID, sexo, numero_de_BI, nacionalidade, data_de_nascimento, numero_de_celular);
        this.email_do_docente = email_do_docente;
        this.senha = senha;
        this.senha_repetida = senha_repetida;
        this.cadeira = cadeira;
        this.nivel_academico = nivel_academico;
        this.horario_de_trabalho = horario_de_trabalho;
    }

    public String getEmail_do_docente() {
        return email_do_docente;
    }

    public void setEmail_do_docente(String email_do_docente) {
        this.email_do_docente = email_do_docente;
    }

    public char[] getSenha() {
        return senha;
    }

    public void setSenha(char[] senha) {
        this.senha = senha;
    }
    
    public char[] getSenha_repetida() {
        return senha_repetida;
    }
    
    public void setSenha_repetida(char[] senha_repetida) {
        this.senha_repetida = senha_repetida;
    }

    public String getCadeira() {
        return cadeira;
    }

    public void setCadeira(String cadeira) {
        this.cadeira = cadeira;
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
