/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.digital.model;

import java.awt.Color;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author simba
 */
public class Estudante extends Usuarios implements Serializable{

    private String ID;
    private String instituicao_de_ensino;
    private String curso;
    private int semestre;
    private char[] senha;
    private char[] senha_repetida;
    
    static int contador = 0;

    public Estudante() {}

    public Estudante(String ID, String instituicao_de_ensino, String curso, int semestre, char [] senha, char [] senha_repetida, String nome, String sexo, String numero_de_BI, int numero_de_NUIT, LocalDate data_de_nascimento, String nacionalidade, int numero_de_celular, String email, String nivel_academico, String turno) {
        super(nome, sexo, numero_de_BI, numero_de_NUIT, data_de_nascimento, nacionalidade, numero_de_celular, email, nivel_academico, turno);
        this.ID = ID;
        this.instituicao_de_ensino = instituicao_de_ensino;
        this.curso = curso;
        this.semestre = semestre;
        this.senha = senha;
        this.senha_repetida = senha_repetida;
    }
public static void setContador(int valor) {
    contador = valor;
}
    public void gerarID() {
        contador++;
        this.ID = String.format("ALN%03d", contador);
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public String getInstituicao_de_ensino() {
        return instituicao_de_ensino;
    }

    public void setInstituicao_de_ensino(String instituicao_de_ensino) {
        this.instituicao_de_ensino = instituicao_de_ensino;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
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
    
    

    
    
}
