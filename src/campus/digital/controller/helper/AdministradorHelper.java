/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.digital.controller.helper;

import campus.digital.model.Docente;
import campus.digital.view.AdministradorFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author simba
 */
public class AdministradorHelper {

    private final AdministradorFrame view;
    
    public AdministradorHelper(campus.digital.view.AdministradorFrame view) {
        this.view = view;
    }
    
    public Docente obter_modelo_do_docente (){
        // Aqui buscamos os campos do nosso frame e armazenamos em variaveis "legiveis"
        String nome = view.getTxt_nome_do_docente().getText();
        char sexo = (char) view.getCbx_sexo_do_docente().getSelectedIndex();
        String numero_de_BI = view.getTxt_bi_do_docente().getText();
        String nacionalidade = view.getCbx_nacionalidade_do_docente().getSelectedIndex() + "";
        String data = view.getTxt_data_de_nascimento_do_docente().getText() + "";
        int numero_de_celular = Integer.parseInt(view.getTxt_numero_de_celular_do_docente().getText());
        String email_do_docente = view.getTxt_email_do_docente().getText() + "";
        char [] senha = view.getPwd_senha_do_docente().getPassword();
        char [] senha_repetida = view.getPwd_confirmacao_de_senha_do_docente().getPassword();
        String cadeira = view.getCbx_cadeira_do_docente().getSelectedIndex() + "";
        String nivel_academico = view.getCbx_nivel_academico_do_docente().getSelectedIndex() + "";
        String horario_de_trabalho = view.getCbx_turno_do_docente().getSelectedIndex() + "";
   
        
        // Aqui criamos o nosso objecto
        Docente docente = new Docente();
        
        docente.setNome(nome);
        docente.setSexo(sexo);
        docente.setNumero_de_BI(numero_de_BI);
        docente.setNacionalidade(nacionalidade);
        docente.setData_de_nascimento(Utilitarios.obter_data_de_nascimento(data));
        docente.setNumero_de_celular(numero_de_celular);
        docente.setEmail_do_docente(email_do_docente);
        
        if (Utilitarios.validar_senha(senha, senha_repetida) == true){
            docente.setSenha(senha);
            docente.setSenha_repetida(senha_repetida);
        }
        
        docente.setCadeira(cadeira);
        docente.setNivel_academico(nivel_academico);
        docente.setHorario_de_trabalho(horario_de_trabalho);

        String mensagem = Utilitarios.Validar_Campus(docente);
        
        if (mensagem.equals("OK")){
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        return docente;
        }
        else{
            JOptionPane.showMessageDialog(null, mensagem);
        return null;
        }
    }
    
    public void limpar_campos_docente (){
        
        view.getTxt_nome_do_docente().setText("");
        view.getTxt_bi_do_docente().setText("");
        view.getTxt_data_de_nascimento_do_docente().setText("");
        view.getTxt_numero_de_celular_do_docente().setText("");
        view.getTxt_email_do_docente().setText("");
        view.getPwd_senha_do_docente().setText("");
        view.getPwd_confirmacao_de_senha_do_docente().setText("");
        view.getCbx_sexo_do_docente().setSelectedIndex(0);
        view.getCbx_nacionalidade_do_docente().setSelectedIndex(0);
        view.getCbx_cadeira_do_docente().setSelectedIndex(0);
        view.getCbx_nivel_academico_do_docente().setSelectedIndex(0);
        view.getCbx_turno_do_docente().setSelectedIndex(0);
        JOptionPane.showMessageDialog(null, "Limpo!");
    }
    
    
    
}
