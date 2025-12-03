/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.digital.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author simba
 */
// Estamos dizendo que a classe "Usuarios" e uma classe abstracta, logo sera impossivel criar/instanciar um "Usuario"
abstract public class Usuarios implements Serializable{
    
    protected String nome;
    protected String sexo;
    protected String numero_de_BI;
    protected int numero_de_NUIT;
    protected LocalDate data_de_nascimento;
    protected String nacionalidade;
    protected int numero_de_celular;
    protected String email;
    protected String nivel_academico;
    protected String turno;
    
    public Usuarios(){} //- Para ser capaz de instanciar sem passar parrametros

    // Isso para ser capaz de criar um usuario com todos atributos (alunos, docentes)
    public Usuarios(String nome, String sexo, String numero_de_BI, int numero_de_NUIT, LocalDate data_de_nascimento, String nacionalidade,  int numero_de_celular, String email, String nivel_academico, String turno) {
        this.nome = nome;
        this.sexo = sexo;
        this.numero_de_BI = numero_de_BI;
        this.numero_de_NUIT = numero_de_NUIT;
        this.data_de_nascimento = data_de_nascimento;
        this.nacionalidade = nacionalidade;
        this.numero_de_celular = numero_de_celular;
        this.email = email;
        this.nivel_academico = nivel_academico;
        this.turno = turno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNumero_de_BI() {
        return numero_de_BI;
    }

    public void setNumero_de_BI(String numero_de_BI) {
        this.numero_de_BI = numero_de_BI;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getNumero_de_NUIT() {
        return numero_de_NUIT;
    }

    public void setNumero_de_NUIT(int numero_de_NUIT) {
        this.numero_de_NUIT = numero_de_NUIT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNivel_academico() {
        return nivel_academico;
    }

    public void setNivel_academico(String nivel_academico) {
        this.nivel_academico = nivel_academico;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public LocalDate getData_de_nascimento() {
        return data_de_nascimento;
    }

    public void setData_de_nascimento(LocalDate data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }

    public int getNumero_de_celular() {
        return numero_de_celular;
    }

    public void setNumero_de_celular(int numero_de_celular) {
        this.numero_de_celular = numero_de_celular;
    }
    
    
}
