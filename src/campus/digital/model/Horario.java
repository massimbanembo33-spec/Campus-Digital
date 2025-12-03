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
public class Horario implements Serializable{
    
    private String ID;
    private Cadeira cadeira;
    private Docente docente;
    private Turma turma; 
    private String dia_semana;
    private String sala;
    private String hora_inicio; 
    private String hora_fim;
    
    private static int contador = 0;

    public Horario() {}

    public static void setContador(int valor) { contador = valor; }
    
    public void gerarID() {
        contador++;
        this.ID = String.format("HOR%03d", contador);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public Cadeira getCadeira() {
        return cadeira;
    }

    public void setCadeira(Cadeira cadeira) {
        this.cadeira = cadeira;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fim() {
        return hora_fim;
    }

    public void setHora_fim(String hora_fim) {
        this.hora_fim = hora_fim;
    }
    @Override
    public String toString() {
        return ID + " - " + dia_semana + " (" + hora_inicio + ")";
    }    
}
