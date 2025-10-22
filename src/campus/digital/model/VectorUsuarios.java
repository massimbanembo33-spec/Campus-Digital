/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.digital.model;

import java.util.Vector;

/**
 *
 * @author simba
 */
public class VectorUsuarios {
    
    // Criacao dos vectores
    private static Vector<Aluno> alunos = new Vector <>();
    private static Vector<Docente> docentes = new Vector <>();
    private static Vector<Funcionario> funcionarios = new Vector <>();

    // Adicionar usuarios aos respectivos vectores
    public static void adicionar_aluno (Aluno a){
        alunos.add(a);
    }
    public static void adicionar_docente (Docente d){
        docentes.add(d);
    }
    public static void adicionar_funcionarios (Funcionario f){
        funcionarios.add(f);
    }
    
    // Remover usuarios dos respectivos vectores
    public static void remover_aluno (Aluno a){
        alunos.remove(a);
    }
    public static void remover_docente (Docente d){
        docentes.remove(d);
    }
    public static void remover_funcionario (Funcionario f){
        funcionarios.remove(f);
    }
    
    // Listar usuarios
    public static Vector<Aluno> listar_alunos(){
        return alunos;
    }
    
    public static Vector<Docente> listar_docentes(){
        return docentes;
    }
    
    public static Vector<Funcionario> listar_funcionario(){
        return funcionarios;
    }
}
