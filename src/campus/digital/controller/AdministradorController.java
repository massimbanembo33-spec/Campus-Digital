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
    
    public AdministradorController(AdministradorFrame view) {
        this.view = view;
    }

    public void cadastrar_aluno (Aluno a){
        VectorUsuarios.adicionar_aluno(a);
        }
    
    public void cadastrar_docente (){
        try{
        AdministradorHelper helper = new AdministradorHelper(view);
        
        Docente docente = helper.obter_modelo_do_docente();// retorna null se validação falhar

        if (docente == null){
            JOptionPane.showMessageDialog(null, "Docente esta vazio/incompleto");
            return;
        }
        else{
            docente.gerarID();
            VectorUsuarios.adicionar_docente(docente);
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar" + e.getMessage());
       
        }
    }
    
    public void limpar_campos_do_docente(){
        try{
            
            AdministradorHelper helper = new AdministradorHelper(view);
            
            helper.limpar_campos_docente();
        }
        catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Estas mal!");
        }
    }
    
    public void procurar_docente (){
        
        String ID_do_docente = view.getTxt_codigo_de_pesquisa_do_docente().getText();
        
        if (ID_do_docente.isBlank()){
            JOptionPane.showMessageDialog(null, "Preencha o campo de pesquisa");
            return;
        }
        
        Docente docente = VectorUsuarios.procurar_por_ID_do_docente(ID_do_docente);
        AdministradorHelper helper = new AdministradorHelper(view);
        
        if (docente != null){
            helper.mostrar_docente_na_view(docente);
            JOptionPane.showMessageDialog(null, "Docente encontrado");
        }
        else{
            JOptionPane.showMessageDialog(null, "Docente nao encontrado");
        }
    }
    
    public void actualizar_docente(){
        
        AdministradorHelper helper = new AdministradorHelper(view);
        Docente docente_actualizado = helper.obter_modelo_do_docente();
        
        String codigo_do_docente = view.getTxt_codigo_de_pesquisa_do_docente().getText();
        
        if (codigo_do_docente == null || codigo_do_docente.isBlank()){
            JOptionPane.showMessageDialog(null, "Digite o codigo do docente!");
            return;
        }
        
        boolean actualizado = VectorUsuarios.actualizar_docente(codigo_do_docente, docente_actualizado);
        // estamos a guardar o resultado lógico (verdadeiro ou falso) do método atualizar_docente()
  
        if (actualizado){
        // Porque o if em Java já avalia diretamente a expressão booleana.
        // Por isso nao foi necessario "if (actualizado == true){}"
            JOptionPane.showMessageDialog(null, "Docente actualizado com sucesso!");
        }
        else{
            JOptionPane.showMessageDialog(null, "Docente nao encontrado!");
        }
    }
    
    public void eliminar_docente (){
        
        AdministradorHelper helper = new AdministradorHelper(view);
        
        String codigo_do_docente = view.getTxt_codigo_de_pesquisa_do_docente().getText();
        
        if (codigo_do_docente == null || codigo_do_docente.isBlank()){
            JOptionPane.showMessageDialog(null, "Digite o codigo do docente!");
            return;
        }
        
        // Confirmacao antes da exclusao
          int opcao = JOptionPane.showConfirmDialog(view,
          "Tem certeza que deseja eliminar o docente " + codigo_do_docente + "?",
          "Confirmação",
          JOptionPane.YES_NO_OPTION);

    if (opcao != JOptionPane.YES_OPTION) return;

        boolean eliminado = VectorUsuarios.remover_docente(codigo_do_docente);
        
        if (eliminado){
            JOptionPane.showMessageDialog(null, "Docente eliminado com sucesso!");
            helper.limpar_campos_docente();
        }
        else{
            JOptionPane.showMessageDialog(null, "Docente nao encontrado!");
        }
    }
    
    public void cadastrar_funcionario (Funcionario f){
        VectorUsuarios.adicionar_funcionarios(f);
    }
}
