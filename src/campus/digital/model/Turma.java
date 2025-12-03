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
public class Turma implements Serializable{
    
    private String codigo; 
    private Curso curso;
    private Cadeira cadeira; 
    private Docente docente_responsavel; 
    private int ano_letivo;
    private int semestre;
    private int vagas;
    
    public Turma() {
    }

    // Lógica para gerar código bonito: SIGLA + ANO + SEMESTRE
    public void gerarCodigoAutomatico() {
        String sigla = "TUR";
        // Agora pegamos o nome de dentro do objeto curso
        if (this.curso != null) {
            String nomeCurso = this.curso.getNome();
            if (nomeCurso.length() >= 3) {
                sigla = nomeCurso.substring(0, 3).toUpperCase();
            }
        }
        this.codigo = sigla + "-" + ano_letivo + "-S" + semestre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Cadeira getCadeira() {
        return cadeira;
    }

    public void setCadeira(Cadeira cadeira) {
        this.cadeira = cadeira;
    }

    public Docente getDocente_responsavel() {
        return docente_responsavel;
    }

    public void setDocente_responsavel(Docente docente_responsavel) {
        this.docente_responsavel = docente_responsavel;
    }

    public int getAno_letivo() {
        return ano_letivo;
    }

    public void setAno_letivo(int ano_letivo) {
        this.ano_letivo = ano_letivo;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }
    
    @Override
    public String toString() {
        return this.codigo; 
    }
}
