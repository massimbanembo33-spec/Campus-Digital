/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.digital.controller;

import campus.digital.controller.helper.AdministradorHelper;
import campus.digital.model.Aluno;
import campus.digital.model.Docente;
import campus.digital.model.Funcionario;
import campus.digital.model.VectorUsuarios;
import campus.digital.view.AdministradorFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author simba
 */
public class AdministradorController {
    
    private final AdministradorFrame view;
    private final AdministradorHelper helper;

    public AdministradorController(AdministradorFrame view) {
        this.view = null;
        this.helper = null;
    }
    
    public void cadastrar_aluno (Aluno a){
        VectorUsuarios.adicionar_aluno(a);
        }
    
    public void cadastrar_docente (){
        try{
        Docente docente = helper.obter_modelo_do_docente();// retorna null se validação falhar
        
        if (docente == null){
            JOptionPane.showMessageDialog(null, "Docente esta vazio/incompleto");
            return;
        }
        else{
            VectorUsuarios.adicionar_docente(docente);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar " + e.getMessage());
       
        }
    }
    
    public void limpar_campos_do_docente(){
        helper.limpar_campos_docente();
    }
    
    public void cadastrar_funcionario (Funcionario f){
        VectorUsuarios.adicionar_funcionarios(f);
    }
}
