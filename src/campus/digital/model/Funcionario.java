/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.digital.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author simba
 */
public class Funcionario extends Usuarios implements Serializable{
    
    private String ID;
    private String departamento;
    private Long conta_bancaria;
    private char[] senha;
    private char[] senha_repetida;
    
    static int contador = 0;

    public Funcionario() {}
    
    public Funcionario(String ID, String departamento, Long conta_bancaria, char[] senha, char[] senha_repetida, String nome, String sexo, String numero_de_BI, int numero_de_NUIT, LocalDate data_de_nascimento, String nacionalidade, int numero_de_celular, String email, String nivel_academico, String turno) {
        super(nome, sexo, numero_de_BI, numero_de_NUIT, data_de_nascimento, nacionalidade, numero_de_celular, email, nivel_academico, turno);
        this.ID = ID;
        this.departamento = departamento;
        this.conta_bancaria = conta_bancaria;
        this.senha = senha;
        this.senha_repetida = senha_repetida;
    }

    public char[] getSenha_repetida() {
        return senha_repetida;
    }

    public void setSenha_repetida(char[] senha_repetida) {
        this.senha_repetida = senha_repetida;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

public static void setContador(int valor) {
    contador = valor;
}
    
    public void gerarID() {
        contador++;
        this.ID = String.format("FUN%03d", contador);
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Long getConta_bancaria() {
        return conta_bancaria;
    }

    public void setConta_bancaria(Long conta_bancaria) {
        this.conta_bancaria = conta_bancaria;
    }

    public char[] getSenha() {
        return senha;
    }

    public void setSenha(char[] senha) {
        this.senha = senha;
    }

    

    
}
