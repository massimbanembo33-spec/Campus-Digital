/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.digital.model;

import campus.digital.dados.GestorArquivos;
import java.util.Vector;

/**
 *
 * @author simba
 */
public class VectorAcademico {
    

    private static final String FILE_CURSOS = "base_cursos.dat";
    private static final String FILE_CADEIRAS = "base_cadeiras.dat";
    private static final String FILE_TURMAS = "base_turmas.dat";
    private static final String FILE_HORARIOS = "base_horarios.dat";

    private static Vector<Curso> cursos = (Vector<Curso>) GestorArquivos.carregarVector(FILE_CURSOS);
    private static Vector<Cadeira> cadeiras = (Vector<Cadeira>) GestorArquivos.carregarVector(FILE_CADEIRAS);
    private static Vector<Turma> turmas = (Vector<Turma>) GestorArquivos.carregarVector(FILE_TURMAS);
    private static Vector<Horario> horarios = (Vector<Horario>) GestorArquivos.carregarVector(FILE_HORARIOS);

    
    public static void adicionar_curso(Curso c) {
        cursos.add(c);
        GestorArquivos.salvarVector(cursos, FILE_CURSOS);
    }
    public static void adicionar_cadeira(Cadeira c) {
        cadeiras.add(c);
        GestorArquivos.salvarVector(cadeiras, FILE_CADEIRAS);
    }
    public static void adicionar_turma(Turma t) {
        turmas.add(t);
        GestorArquivos.salvarVector(turmas, FILE_TURMAS);
    }
    public static void adicionar_horario(Horario h) {
        horarios.add(h);
        GestorArquivos.salvarVector(horarios, FILE_HORARIOS);
    }

    // --- LISTAR ---
    public static Vector<Curso> listar_cursos() {
        return cursos; 
    }
    public static Vector<Cadeira> listar_cadeiras() {
        return cadeiras; 
    }
    public static Vector<Turma> listar_turmas() { 
        return turmas; 
    }
    public static Vector<Horario> listar_horarios() { 
        return horarios; 
    }
    // No VectorAcademico.java

public static void atualizar_contadores() {
    // 1. Cursos
    int maxCurso = 0;
    for (Curso c : cursos) {
        try {
            // Tenta pegar os últimos 3 dígitos
            String numStr = c.getCodigo().substring(c.getCodigo().length() - 3);
            int num = Integer.parseInt(numStr);
            if (num > maxCurso) maxCurso = num;
        } catch (Exception e) { /* Ignora códigos mal formatados */ }
    }
    Curso.setContador(maxCurso);

    // 2. Cadeiras (O CRÍTICO PARA TI AGORA)
    int maxCad = 0;
    for (Cadeira c : cadeiras) {
        try {
            String numStr = c.getCodigo().substring(c.getCodigo().length() - 3);
            int num = Integer.parseInt(numStr);
            if (num > maxCad) maxCad = num;
        } catch (Exception e) { }
    }
    Cadeira.setContador(maxCad);
}

    // --- PROCURAR ---
    public static Curso procurar_curso(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) return c;
        }
        return null;
    }
    
    public static Cadeira procurar_cadeira(String codigo) {
        for (Cadeira c : cadeiras) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) return c;
        }
        return null;
    }
    
    public static Turma procurar_turma(String codigo) {
        for (Turma t : turmas) {
            if (t.getCodigo().equalsIgnoreCase(codigo)) return t;
        }
        return null;
    }

    // --- REMOVER (NOVO) ---
    public static boolean remover_curso(String codigo) {
        boolean removeu = cursos.removeIf(c -> c.getCodigo().equalsIgnoreCase(codigo));
        if (removeu) GestorArquivos.salvarVector(cursos, FILE_CURSOS);
        return removeu;
    }
    
    public static boolean remover_cadeira(String codigo) {
        boolean removeu = cadeiras.removeIf(c -> c.getCodigo().equalsIgnoreCase(codigo));
        if (removeu) GestorArquivos.salvarVector(cadeiras, FILE_CADEIRAS);
        return removeu;
    }
    
    public static boolean remover_turma(String codigo) {
        boolean removeu = turmas.removeIf(t -> t.getCodigo().equalsIgnoreCase(codigo));
        if (removeu) GestorArquivos.salvarVector(turmas, FILE_TURMAS);
        return removeu;
    }

    // ==================================================================
    // NOVO: MÉTODOS PARA LIMPAR TUDO
    // =========================================================================
    
    public static void limpar_todos_cursos() {
        cursos.clear();
        GestorArquivos.salvarVector(cursos, FILE_CURSOS);
    }

    public static void limpar_todas_cadeiras() {
        cadeiras.clear();
        GestorArquivos.salvarVector(cadeiras, FILE_CADEIRAS);
    }

    public static void limpar_todas_turmas() {
        turmas.clear();
        GestorArquivos.salvarVector(turmas, FILE_TURMAS);
    }
    
    // --- ACTUALIZAR (NOVO) ---
    public static boolean actualizar_curso(String codigo, Curso novo) {
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                novo.setCodigo(codigo); // Mantém o ID original
                cursos.set(i, novo);
                GestorArquivos.salvarVector(cursos, FILE_CURSOS);
                return true;
            }
        }
        return false;
    }
    
    public static boolean actualizar_cadeira(String codigo, Cadeira novo) {
        for (int i = 0; i < cadeiras.size(); i++) {
            if (cadeiras.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                novo.setCodigo(codigo);
                cadeiras.set(i, novo);
                GestorArquivos.salvarVector(cadeiras, FILE_CADEIRAS);
                return true;
            }
        }
        return false;
    }
    
    public static boolean actualizar_turma(String codigo, Turma novo) {
        for (int i = 0; i < turmas.size(); i++) {
            if (turmas.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                novo.setCodigo(codigo);
                turmas.set(i, novo);
                GestorArquivos.salvarVector(turmas, FILE_TURMAS);
                return true;
            }
        }
        return false;
    }
}
