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
    public static boolean remover_docente (String codigo){
        for (int i = 0; i < docentes.size(); i++){
            Docente docente = docentes.get(i);
                if (docente.getID().equals(codigo)){
                    docentes.remove(i);
                    return true;
            }
        }
      return false;
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
    
    // Procurar usuarios
    public static Docente procurar_por_ID_do_docente (String ID_do_docente){
        for (Docente docente: listar_docentes()){
            if (docente.getID().equals(ID_do_docente)){
                return docente;
            }
        }
      return null;
    }
    
    // Criacao de uma funcao que retorna um booleano
    public static boolean actualizar_docente (String codigo, Docente docente_actualizado){
        for (int i = 0; i < docentes.size(); i++){
            Docente docente_existente = (Docente) docentes.get(i);
                if (docente_existente.getID().equals(codigo)){
                    docente_actualizado.ID = docente_existente.getID(); // Mantem o ID
                    // substitui o antigo pelo novo
                    docentes.setElementAt(docente_actualizado, i);
                    return true;
                }
        }
    return false;
    }
}
