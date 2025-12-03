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
public class VectorUsuarios {
    
    // Nomes dos ficheiros na "Base de Dados"
    private static final String ARQUIVO_ESTUDANTES = "base_estudantes.dat";
    private static final String ARQUIVO_DOCENTES = "base_docentes.dat";
    private static final String ARQUIVO_FUNCIONARIOS = "base_funcionarios.dat";
//==============================================================================================================================================================================================================================
    
//====================================================================================== CRIACAO DE VECTORES ===================================================================================================================
    
    private static Vector<Estudante> estudantes = (Vector<Estudante>) GestorArquivos.carregarVector(ARQUIVO_ESTUDANTES);
    private static Vector<Docente> docentes = (Vector<Docente>) GestorArquivos.carregarVector(ARQUIVO_DOCENTES);
    private static Vector<Funcionario> funcionarios = (Vector<Funcionario>) GestorArquivos.carregarVector(ARQUIVO_FUNCIONARIOS);
//==============================================================================================================================================================================================================================
    
//================================================================== COLOCAR OS OBJECTOS (USUARIOS) NOS SEUS DEVIDOS VECTORES ==================================================================================================
    
    public static void adicionar_estudantes (Estudante a){
        estudantes.add(a);
        GestorArquivos.salvarVector(estudantes, ARQUIVO_ESTUDANTES);
    }
    public static void adicionar_docentes (Docente d){
        docentes.add(d);
        GestorArquivos.salvarVector(docentes, ARQUIVO_DOCENTES);
    }
    public static void adicionar_funcionarios (Funcionario f){
        funcionarios.add(f);
        GestorArquivos.salvarVector(funcionarios, ARQUIVO_FUNCIONARIOS);
    }
    
//===============================================================================================================================================================================================================================
    
//======================================================================================== LISTAR USUARIOS ======================================================================================================================

    public static Vector<Estudante> listar_estudantes(){
        return estudantes;
    }
    
    public static Vector<Docente> listar_docentes(){
        return docentes;
    }
    
    public static Vector<Funcionario> listar_funcionarios(){
        return funcionarios;
    }
    
//===============================================================================================================================================================================================================================
    
//========================================================================================= REMOVER USUARIOS ====================================================================================================================
    // DENTRO DE VectorUsuarios.java

public static void atualizar_contadores() {
    // ----------------------------------------------------------
    // 1. Atualizar contador de ESTUDANTES (ALNxxx)
    // ----------------------------------------------------------
    int maxEstudante = 0;
    for (Estudante e : estudantes) {
        try {
            if (e.getID() != null && e.getID().length() > 3) {
                // Pula as 3 primeiras letras (ALN) e pega o resto
                String numeroStr = e.getID().substring(3); 
                int numero = Integer.parseInt(numeroStr);
                
                if (numero > maxEstudante) {
                    maxEstudante = numero;
                }
            }
        } catch (Exception ex) {
            // Ignora IDs antigos ou mal formatados para não travar
        }
    }
    // Define o contador para o máximo encontrado
    Estudante.setContador(maxEstudante);


    // ----------------------------------------------------------
    // 2. Atualizar contador de DOCENTES (DOCxxx)
    // ----------------------------------------------------------
    int maxDocente = 0;
    for (Docente d : docentes) {
        try {
            if (d.getID() != null && d.getID().length() > 3) {
                String numeroStr = d.getID().substring(3);
                int numero = Integer.parseInt(numeroStr);
                
                if (numero > maxDocente) {
                    maxDocente = numero;
                }
            }
        } catch (Exception ex) {}
    }
    Docente.setContador(maxDocente);


    // ----------------------------------------------------------
    // 3. Atualizar contador de FUNCIONÁRIOS (FUNxxx)
    // ----------------------------------------------------------
    int maxFuncionario = 0;
    for (Funcionario f : funcionarios) {
        try {
            if (f.getID() != null && f.getID().length() > 3) {
                String numeroStr = f.getID().substring(3);
                int numero = Integer.parseInt(numeroStr);
                
                if (numero > maxFuncionario) {
                    maxFuncionario = numero;
                }
            }
        } catch (Exception ex) {}
    }
    Funcionario.setContador(maxFuncionario);
}
    // =========================================================================
    // MÉTODOS DE REMOVER (MODERNOS - COM REFLECT NO ARQUIVO)
    // =========================================================================

    public static boolean remover_estudante(String codigo) {
        boolean removeu = estudantes.removeIf(e -> e.getID().equalsIgnoreCase(codigo));
        if (removeu) GestorArquivos.salvarVector(estudantes, ARQUIVO_ESTUDANTES);
        return removeu;
    }

    public static boolean remover_docente(String codigo) {
        boolean removeu = docentes.removeIf(d -> d.getID().equalsIgnoreCase(codigo));
        if (removeu) GestorArquivos.salvarVector(docentes, ARQUIVO_DOCENTES);
        return removeu;
    }

    public static boolean remover_funcionario(String codigo) {
        boolean removeu = funcionarios.removeIf(f -> f.getID().equalsIgnoreCase(codigo));
        if (removeu) GestorArquivos.salvarVector(funcionarios, ARQUIVO_FUNCIONARIOS);
        return removeu;
    }

    // =========================================================================
    // NOVO: MÉTODOS PARA LIMPAR TUDO ("DELETE ALL")
    // =========================================================================

    public static void limpar_todos_estudantes() {
        estudantes.clear(); // Limpa a memória RAM
        GestorArquivos.salvarVector(estudantes, ARQUIVO_ESTUDANTES); // Grava vazio no disco
    }

    public static void limpar_todos_docentes() {
        docentes.clear();
        GestorArquivos.salvarVector(docentes, ARQUIVO_DOCENTES);
    }

    public static void limpar_todos_funcionarios() {
        funcionarios.clear();
        GestorArquivos.salvarVector(funcionarios, ARQUIVO_FUNCIONARIOS);
    }
    
    // ... (Resto dos métodos de adicionar, listar, procurar mantêm-se) ...

//===============================================================================================================================================================================================================================
    
//=============================================================================== PROCURAR OS USUARIOS NOS VECTORES =============================================================================================================
    
    public static Estudante procurar_por_ID_do_estudante (String ID_pesquisado){
    
    System.out.println("--- INICIANDO PESQUISA ---");
    System.out.println("Procurando por: " + ID_pesquisado);

    for (Estudante estudante : listar_estudantes()){
        
        // O Espião: Vai mostrar no Output quem está na lista
        System.out.println("Verificando aluno: " + estudante.getNome() + " | ID: " + estudante.getID());

        // Solução para o problema de Maiúsculas/Minúsculas (use equalsIgnoreCase)
        if (estudante.getID() != null && ID_pesquisado.equalsIgnoreCase(estudante.getID())) {
            System.out.println(">> ENCONTRADO! <<");
            return estudante;
        }
    }
    System.out.println("--- FIM DA PESQUISA (Ninguém encontrado) ---");
    return null;
}
    
    public static Docente procurar_por_ID_do_docente (String ID_do_docente){
        for (Docente docente: listar_docentes()){
            if (docente.getID().equals(ID_do_docente)){
                return docente;
            }
        }
      return null;
    }
    
    public static Funcionario procurar_por_ID_do_funcionario (String ID_do_funcionario){
        for (Funcionario funcionario: listar_funcionarios()){
            if (funcionario.getID().equals(ID_do_funcionario)){
                return funcionario;
            }
        }
      return null;
    }
    
//===============================================================================================================================================================================================================================

//============================================================================= ACTUALIZAR OS USUARIOS NOS VECTORES =============================================================================================================
    
    public static boolean actualizar_estudante (String codigo_pesquisado, Estudante estudante_novo){
        for (int i = 0; i < estudantes.size(); i++){
            Estudante estudante_antigo = estudantes.get(i);
                if (estudante_antigo.getID().equals(codigo_pesquisado)){
                    estudante_novo.setID(codigo_pesquisado); 
                    estudantes.set(i, estudante_novo);
            return true;
        }
    }
    return false;
}
    
    public static boolean actualizar_docente (String codigo_pesquisado, Docente docente_novo){
        for (int i = 0; i < docentes.size(); i++){
            Docente docente_antigo = docentes.get(i);
                if (docente_antigo.getID().equals(codigo_pesquisado)){
                    docente_novo.setID(codigo_pesquisado); 
                    docentes.set(i, docente_novo);
                return true;
                }
        }
    return false;
}
    
    public static boolean actualizar_funcionario (String codigo_pesquisado, Funcionario funcionario_novo){
        for (int i = 0; i < funcionarios.size(); i++){
            Funcionario funcionario_antigo = funcionarios.get(i);
                if (funcionario_antigo.getID().equals(codigo_pesquisado)){
                    funcionario_novo.setID(codigo_pesquisado); 
                    funcionarios.set(i, funcionario_novo);
                    return true;
                }
        }
    return false;
    }
}
