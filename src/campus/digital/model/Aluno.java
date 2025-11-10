/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.digital.model;

import java.awt.Color;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author simba
 */
public class Aluno extends Usuarios{

    protected String email_do_aluno;
    protected String senha;
    protected String curso_do_aluno;
    protected byte ano_do_aluno;
    protected Date ano_da_matricula;
    protected String endereco;

    public Aluno(String nome, int ID, char sexo, String numero_de_BI, String nacionalidade, Date data_de_nascimento, int numero_de_celular) {
        super(nome, sexo, numero_de_BI, nacionalidade, data_de_nascimento, numero_de_celular);
    // Super quer dizer que vem da nossa super classe, que e "Usuarios" que e a mae das classes (aluno, funcionario e docente)
    } 

    public Aluno(String email_do_aluno, String senha, String curso_do_aluno, byte ano_do_aluno, Date ano_da_matricula, String endereco, String nome, int ID, char sexo, String numero_de_BI, String nacionalidade, Date data_de_nascimento, int numero_de_celular) {
        super(nome, sexo, numero_de_BI, nacionalidade, data_de_nascimento, numero_de_celular);
        this.email_do_aluno = email_do_aluno;
        this.senha = senha;
        this.curso_do_aluno = curso_do_aluno;
        this.ano_do_aluno = ano_do_aluno;
        this.ano_da_matricula = ano_da_matricula;
        this.endereco = endereco;
    }
    
    

    public String getEmail_do_aluno() {
        return email_do_aluno;
    }

    public void setEmail_do_aluno(String email_do_aluno) {
        this.email_do_aluno = email_do_aluno;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCurso_do_aluno() {
        return curso_do_aluno;
    }

    public void setCurso_do_aluno(String curso_do_aluno) {
        this.curso_do_aluno = curso_do_aluno;
    }

    public byte getAno_do_aluno() {
        return ano_do_aluno;
    }

    public void setAno_do_aluno(byte ano_do_aluno) {
        this.ano_do_aluno = ano_do_aluno;
    }

    public Date getAno_da_matricula() {
        return ano_da_matricula;
    }

    public void setAno_da_matricula(Date ano_da_matricula) {
        this.ano_da_matricula = ano_da_matricula;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
}
