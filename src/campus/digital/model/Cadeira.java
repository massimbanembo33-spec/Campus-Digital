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
public class Cadeira implements Serializable{
    
    private String codigo;
    private String nome;
    private int semestre;
    private int carga_horaria;
    private Curso curso_associado;
    private Cadeira precedencia;

    private static int contador = 0;

    public Cadeira() {}

    // Adiciona este método na classe Cadeira
    public static void setContador(int valor) {
        contador = valor;
    }
    
    public void gerarCodigo() {
        contador++;
        this.codigo = String.format("CAD%03d", contador);
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

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public Curso getCurso_associado() {
        return curso_associado;
    }

    public void setCurso_associado(Curso curso_associado) {
        this.curso_associado = curso_associado;
    }

    public Cadeira getPrecedencia() {
        return precedencia;
    }

    public void setPrecedencia(Cadeira precedencia) {
        this.precedencia = precedencia;
    }
    
    @Override
    public String toString() {
        return this.nome; 
}
    
}
