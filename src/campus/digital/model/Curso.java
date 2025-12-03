/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.digital.model;

import java.io.Serializable;

/**
 *
 * @author simba
 */
public class Curso implements Serializable{
    
    private String codigo;
    private String nome;
    private String grau;
    private int duracao;
    
    private static int contador = 0;

    public Curso() {
    }
    
    // Adiciona isto:
    public static void setContador(int valor) {
        contador = valor;
    }

    public void gerarCodigo() {
        contador++;
        this.codigo = String.format("CUR%03d", contador);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGrau() {
        return grau;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
    @Override
    public String toString() {
        return this.nome; 
}
    
}
