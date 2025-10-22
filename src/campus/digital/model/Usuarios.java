/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.digital.model;

import java.time.LocalDate;

/**
 *
 * @author simba
 */
// Estamos dizendo que a classe "Usuarios" e uma classe abstracta, logo sera impossivel criar/instanciar um "Usuario"
abstract public class Usuarios {
    
    protected String nome;
    protected String ID;
    protected char sexo;
    protected String numero_de_BI;
    protected String nacionalidade;
    protected LocalDate data_de_nascimento;
    protected int numero_de_celular;
    
    public Usuarios(){} //- Para ser capaz de instanciar sem passar parrametros

    // Isso para ser capaz de criar um usuario com quase todos atributos (funcionarios)
    public Usuarios(String nome, String ID, char sexo, LocalDate data_de_nascimento, int numero_de_celular) {
        this.nome = nome;
        this.ID = ID;
        this.sexo = sexo;
        this.data_de_nascimento = data_de_nascimento;
        this.numero_de_celular = numero_de_celular;
    }
    // Isso para ser capaz de criar um usuario com todos atributos (alunos, docentes)
    public Usuarios(String nome, String ID, char sexo, String numero_de_BI, String nacionalidade, LocalDate data_de_nascimento, int numero_de_celular) {
        this.nome = nome;
        this.ID = ID;
        this.sexo = sexo;
        this.numero_de_BI = numero_de_BI;
        this.nacionalidade = nacionalidade;
        this.data_de_nascimento = data_de_nascimento;
        this.numero_de_celular = numero_de_celular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getID() {
        return ID;
    }
    
    public void setID(String ID){
        this.ID = ID;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
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
