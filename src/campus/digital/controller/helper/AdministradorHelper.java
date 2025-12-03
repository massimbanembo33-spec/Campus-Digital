/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.digital.controller.helper;

import campus.digital.model.Cadeira;
import campus.digital.model.Curso;
import campus.digital.model.Docente;
import campus.digital.model.Estudante;
import campus.digital.model.Funcionario;
import campus.digital.model.Horario;
import campus.digital.model.Turma;
import campus.digital.view.AdministradorFrame;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    
//===============================================================================================================================================================================================================================
    
//==================================================================================== OBTER MODELO DO GESTAO DE USUARIOS =======================================================================================================
    
    public Estudante obter_modelo_do_estudante (){
       
        String nome = view.getTxt_nome_do_estudante().getText();
        String sexo = "";
        
        if (view.getRdb_sexo_masculino_do_estudante().isSelected()){
            sexo = "Masculino";
        }
        if (view.getRdb_sexo_femenino_do_estudante().isSelected()){
            sexo = "Femenino";
        }
        
        String numero_de_BI = view.getTxt_BI_do_estudante().getText();
        int numero_de_NUIT = Utilitarios.converter_para_int(view.getTxt_NUIT_do_estudante().getText());
        String data = view.getTxt_data_de_nascimento_do_estudante().getText();
        String nacionalidade = view.getCbx_nacionalidade_do_estudante().getSelectedItem() + "";
        int numero_de_celular = Utilitarios.converter_para_int(view.getTxt_numero_de_celular_do_estudante().getText());
        String email = view.getTxt_email_do_estudante().getText();
        String nivel_academico = view.getCbx_nivel_academico_do_estudante().getSelectedItem() + "";
        String instituicao_de_ensino = view.getTxt_instituicao_de_ensino().getText();

    // ANTES: String curso = view.getCbx_curso().getSelectedItem() + "";
    
    // AGORA (Mais seguro):
    Object itemCurso = view.getCbx_curso().getSelectedItem();
    String nomeCurso = "";
    
    if (itemCurso instanceof Curso) {
        nomeCurso = ((Curso) itemCurso).getNome(); // Pega o nome do objeto
    } else {
        nomeCurso = "Selecione:"; // Ou deixa vazio para falhar na validação
    }
    
    
        String horario_de_estudo = view.getCbx_turno_do_estudante().getSelectedItem() + "";
        int semestre = Utilitarios.converter_para_int(view.getTxt_semestre().getText());
        char [] senha = view.getPwd_senha_do_estudante().getPassword();
        char [] senha_repetida = view.getPwd_senha_repetida_do_estudante().getPassword();
   
        
        // Aqui criamos o nosso objecto
        Estudante estudante = new Estudante();

        estudante.setNome(nome);
        estudante.setSexo(sexo);
        estudante.setNumero_de_BI(numero_de_BI);
        estudante.setNumero_de_NUIT(numero_de_NUIT);
        estudante.setData_de_nascimento(Utilitarios.obter_data_de_nascimento(data));
        estudante.setNacionalidade(nacionalidade);
        estudante.setNumero_de_celular(numero_de_celular);
        estudante.setEmail(email);
        estudante.setNivel_academico(nivel_academico);
        estudante.setInstituicao_de_ensino(instituicao_de_ensino);
        estudante.setCurso(nomeCurso);
        estudante.setTurno(horario_de_estudo);
        estudante.setSemestre(semestre);
        
        // Colocamos a senha e a senha repetida crua no objecto
            estudante.setSenha(senha);
            estudante.setSenha_repetida(senha_repetida);
        
        // A noite magica!
        String mensagem = Utilitarios.Validar_Campus_Estudante(estudante);
        
        if (mensagem.equals("OK")){
        return estudante;
        }
        else{
            JOptionPane.showMessageDialog(null, mensagem);
        return null;
        }
    }
    
    public Docente obter_modelo_do_docente (){
        // Aqui buscamos os campos do nosso frame e armazenamos em variaveis "legiveis"
        String nome = view.getTxt_nome_do_docente().getText();
        String sexo = "";
        
        if (view.getRdb_sexo_masculino_do_docente().isSelected()){
            sexo = "Masculino";
        }
        if (view.getRdb_sexo_femenino_do_docente().isSelected()){
            sexo = "Femenino";
        }
        
        String numero_de_BI = view.getTxt_BI_do_docente().getText();
        int numero_de_NUIT = Utilitarios.converter_para_int(view.getTxt_NUIT_do_docente().getText());
        String data = view.getTxt_data_de_nascimento_do_docente().getText();
        String nacionalidade = view.getCbx_nacionalidade_do_docente().getSelectedItem() + "";
        int numero_de_celular = Utilitarios.converter_para_int(view.getTxt_numero_de_celular_do_docente().getText());
        String email = view.getTxt_email_do_docente().getText();
        // ... ler nome, bi, etc ...

    // Para a Cadeira do Docente
    Object itemCadeira = view.getCbx_cadeira().getSelectedItem();
    String nomeCadeira = "";
    
    if (itemCadeira instanceof Cadeira) {
        nomeCadeira = ((Cadeira) itemCadeira).getNome();
    } else {
        nomeCadeira = "Selecione:";
    }
    
    
        String nivel_academico = view.getCbx_nivel_academico_do_docente().getSelectedItem() + "";
        String horario_de_trabalho = view.getCbx_turno_do_docente().getSelectedItem() + "";
        Long conta_bancaria = Utilitarios.converter_para_Long(view.getTxt_conta_bancaria_do_docente().getText());
        char [] senha = view.getPwd_senha_do_docente().getPassword();
        char [] senha_repetida = view.getPwd_senha_repetida_do_docente().getPassword();
   
        
        // Aqui criamos o nosso objecto
        Docente docente = new Docente();

        docente.setNome(nome);
        docente.setSexo(sexo);
        docente.setNumero_de_BI(numero_de_BI);
        docente.setNumero_de_NUIT(numero_de_NUIT);
        docente.setData_de_nascimento(Utilitarios.obter_data_de_nascimento(data));
        docente.setNacionalidade(nacionalidade);
        docente.setNumero_de_celular(numero_de_celular);
        docente.setEmail(email);
        docente.setCadeira(nomeCadeira);
        docente.setNivel_academico(nivel_academico);
        docente.setTurno(horario_de_trabalho);
        docente.setConta_bancaria(conta_bancaria);
        
        // Colocamos a senha e a senha repetida crua no objecto
            docente.setSenha(senha);
            docente.setSenha_repetida(senha_repetida);

        // Onde a magica acontece!
        String mensagem = Utilitarios.Validar_Campus_Docente(docente);
        
        if (mensagem.equals("OK") && docente.getSenha() != null){
        return docente;
        }
        else{
            JOptionPane.showMessageDialog(null, mensagem);
        return null;
        }
    }
    
    public Funcionario obter_modelo_do_funcionario (){
        // Aqui buscamos os campos do nosso frame e armazenamos em variaveis "legiveis"
        String nome = view.getTxt_nome_do_funcionario().getText();
        String sexo = "";
        
        if (view.getRdb_sexo_masculino_do_funcionario().isSelected()){
            sexo = "Masculino";
        }
        if (view.getRdb_sexo_femenino_do_funcionario().isSelected()){
            sexo = "Femenino";
        }
        
        String numero_de_BI = view.getTxt_BI_do_funcionario().getText();
        int numero_de_NUIT = Utilitarios.converter_para_int(view.getTxt_NUIT_do_funcionario().getText());
        String data = view.getTxt_data_de_nascimento_do_funcionario().getText();
        String nacionalidade = view.getCbx_nacionalidade_do_funcionario().getSelectedItem() + "";
        int numero_de_celular = Utilitarios.converter_para_int(view.getTxt_numero_de_celular_do_funcionario().getText());
        String email = view.getTxt_email_do_funcionario().getText();
        String departamento = view.getCbx_departamento().getSelectedItem() + "";
        String nivel_academico = view.getCbx_nivel_academico_do_funcionario().getSelectedItem() + "";
        String horario_de_trabalho = view.getCbx_turno_do_funcionario().getSelectedItem() + "";
        Long conta_bancaria = Utilitarios.converter_para_Long(view.getTxt_conta_bancaria_do_funcionario().getText());
        char [] senha = view.getPwd_senha_do_funcionario().getPassword();
        char [] senha_repetida = view.getPwd_senha_repetida_do_funcionario().getPassword();
   
        
        // Aqui criamos o nosso objecto
        Funcionario funcionario = new Funcionario();

        funcionario.setNome(nome);
        funcionario.setSexo(sexo);
        funcionario.setNumero_de_BI(numero_de_BI);
        funcionario.setNumero_de_NUIT(numero_de_NUIT);
        funcionario.setNacionalidade(nacionalidade);
        funcionario.setData_de_nascimento(Utilitarios.obter_data_de_nascimento(data));
        funcionario.setNumero_de_celular(numero_de_celular);
        funcionario.setEmail(email);
        funcionario.setDepartamento(departamento);
        funcionario.setNivel_academico(nivel_academico);
        funcionario.setTurno(horario_de_trabalho);
        funcionario.setConta_bancaria(conta_bancaria);
        
        // Colocamos a senha e a senha repetida crua no objecto
            funcionario.setSenha(senha);
            funcionario.setSenha_repetida(senha_repetida);
        
        String mensagem = Utilitarios.Validar_Campus_Funcionario(funcionario);
        
        if (mensagem.equals("OK")){
        return funcionario;
        }
        else{
            JOptionPane.showMessageDialog(null, mensagem);
        return null;
        }
    }
//===============================================================================================================================================================================================================================
    
//===================================================================================== OBTER MODELO DO GESTAO ACADEMICA ========================================================================================================
 
    public Curso obter_modelo_curso() {
        Curso curso = new Curso();

        curso.setNome(view.getTxt_nome_do_curso().getText());
        curso.setGrau(view.getCbx_grau_do_curso().getSelectedItem() + ""); 
        curso.setDuracao((int) view.getSpn_duracao_do_curso().getValue());

        String mensagem = Utilitarios.Validar_Campus_Curso(curso);

        if (mensagem.equals("OK")) {
            curso.gerarCodigo();
            return curso;
        } else {
            JOptionPane.showMessageDialog(null, mensagem);
            return null;
        }
    }

    public Cadeira obter_modelo_cadeira() {
    Cadeira c = new Cadeira();
    c.setNome(view.getTxt_nome_da_cadeira().getText());
    
    // ... (lógica do curso mantém-se igual) ...
    Object itemCurso = view.getCbx_curso_associado_a_cadeira().getSelectedItem();
    if (itemCurso instanceof Curso) {
        c.setCurso_associado((Curso) itemCurso);
    } else {
        c.setCurso_associado(null);
    }

    // --- NOVA LÓGICA DA PRECEDÊNCIA ---
    Object itemPrecedencia = view.getCbx_precedencia_da_cadeira().getSelectedItem();

    if (itemPrecedencia.equals("Selecione:")) {
        // ERRO: O utilizador esqueceu-se de escolher
        JOptionPane.showMessageDialog(null, "Por favor, selecione a Precedência (ou escolha 'Nenhuma').");
        return null; // Interrompe o cadastro aqui mesmo
    } 
    else if (itemPrecedencia.equals("Nenhuma")) {
        // CORRETO: O utilizador disse explicitamente que não tem precedência
        c.setPrecedencia(null); 
    } 
    else if (itemPrecedencia instanceof Cadeira) {
        // CORRETO: É uma cadeira
        c.setPrecedencia((Cadeira) itemPrecedencia);
    }

    // ... restante do código (semestre, carga horaria, validação) ...
    c.setSemestre((int) view.getSpn_semestre_da_cadeira().getValue());
    c.setCarga_horaria(Utilitarios.converter_para_int(view.getTxt_carga_horaria().getText()));

    String mensagem = Utilitarios.Validar_Campus_Cadeira(c);
    if (mensagem.equals("OK")) return c;
    
    JOptionPane.showMessageDialog(null, mensagem);
    return null;
}

public Turma obter_modelo_turma() {
    Turma t = new Turma();
    
    // 1. Validar Curso
    Object itemCurso = view.getCbx_curso_da_turma().getSelectedItem();
    if (itemCurso instanceof Curso) {
        t.setCurso((Curso) itemCurso);
    } else {
        t.setCurso(null);
    }
    
    // 2. Validar Docente
    Object itemDocente = view.getCbx_docente_responsavel_pela_turma().getSelectedItem();
    if (itemDocente instanceof Docente) {
        t.setDocente_responsavel((Docente) itemDocente);
    } else {
        t.setDocente_responsavel(null);
    }

    // ... restante do código da turma ...
    t.setAno_letivo((int) view.getSpn_ano_lectivo_da_turma().getValue());
    t.setSemestre((int) view.getSpn_semestre_da_turma().getValue());
    t.setVagas((int) view.getSpn_vagas_para_turma().getValue());

    String mensagem = Utilitarios.Validar_Campus_Turma(t);
    if (mensagem.equals("OK")) {
        t.gerarCodigoAutomatico();
        return t;
    }
    
    JOptionPane.showMessageDialog(null, mensagem);
    return null;
}
public Horario obter_modelo_horario() {
        Horario h = new Horario();
        
        // 1. Ler ComboBoxes de Objetos
        try {
            // Cadeira
            Object itemCadeira = view.getCbx_cadeira_horario().getSelectedItem(); // Confirma o nome da var
            if (itemCadeira instanceof Cadeira) h.setCadeira((Cadeira) itemCadeira);
            else h.setCadeira(null);

            // Docente
            Object itemDocente = view.getCbx_docente_horario().getSelectedItem(); // Confirma o nome da var
            if (itemDocente instanceof Docente) h.setDocente((Docente) itemDocente);
            else h.setDocente(null);

            // Turma (SUGESTÃO: Usa ComboBox aqui também!)
            Object itemTurma = view.getCbx_turma_horario().getSelectedItem(); // Confirma o nome
            if (itemTurma instanceof Turma) h.setTurma((Turma) itemTurma);
            else h.setTurma(null);
            
        } catch (Exception e) {
            // Ignora erros de cast, a validação apanha a seguir
        }

        // 2. Ler Campos de Texto/Combos Simples
        h.setDia_semana(view.getCbx_dia_de_semana_horario().getSelectedItem() + "");
        h.setSala(view.getTxt_sala_horario().getText());
        
        // Dica: O getText() vai trazer "  :  " se estiver vazio.
        // O teu Utilitarios.Validar_Campus_Horario deve verificar isso.
        h.setHora_inicio(view.getFtf_horario_inicio().getText()); // Ou Spinner
        h.setHora_fim(view.getFtf_horario_fim().getText());

        // 3. Validar
        String msg = Utilitarios.Validar_Campus_Horario(h);
        if (msg.equals("OK")) {
            h.gerarID();
            return h;
        }
        
        JOptionPane.showMessageDialog(null, msg);
        return null;
    }
//===============================================================================================================================================================================================================================
    
//==================================================================================== LIMPAR OS CAMPOS DA VIEW =================================================================================================================
    
    public void limpar_campos_estudante (){
        
        view.getTxt_nome_do_estudante().setText("");
        view.getBtg_sexo_do_estudante().clearSelection();
        view.getTxt_BI_do_estudante().setText("");
        view.getTxt_NUIT_do_estudante().setText("");
        view.getTxt_data_de_nascimento_do_estudante().setText("");
        view.getCbx_nacionalidade_do_estudante().setSelectedIndex(0);
        view.getTxt_numero_de_celular_do_estudante().setText("");
        view.getTxt_email_do_estudante().setText("");
        view.getCbx_nivel_academico_do_estudante().setSelectedIndex(0);
        view.getTxt_instituicao_de_ensino().setText("");
        view.getCbx_curso().setSelectedIndex(0);
        view.getCbx_turno_do_estudante().setSelectedIndex(0);
        view.getTxt_semestre().setText("");
        view.getPwd_senha_do_estudante().setText("");
        view.getPwd_senha_repetida_do_estudante().setText("");
        JOptionPane.showMessageDialog(null, "Limpo!");
    }
    
    public void limpar_campos_docente (){
        
        view.getTxt_nome_do_docente().setText("");
        view.getBtg_sexo_do_docente().clearSelection();
        view.getTxt_BI_do_docente().setText("");
        view.getTxt_NUIT_do_docente().setText("");
        view.getTxt_data_de_nascimento_do_docente().setText("");
        view.getCbx_nacionalidade_do_docente().setSelectedIndex(0);
        view.getTxt_numero_de_celular_do_docente().setText("");
        view.getTxt_email_do_docente().setText("");
        view.getCbx_cadeira().setSelectedIndex(0);
        view.getCbx_nivel_academico_do_docente().setSelectedIndex(0);
        view.getCbx_turno_do_docente().setSelectedIndex(0);
        view.getTxt_conta_bancaria_do_docente().setText("");
        view.getPwd_senha_do_docente().setText("");
        view.getPwd_senha_repetida_do_docente().setText("");
        JOptionPane.showMessageDialog(null, "Limpo!");
    }
    
    public void limpar_campos_funcionario (){
        
        view.getTxt_nome_do_funcionario().setText("");
        view.getBtg_sexo_do_funcionario().clearSelection();
        view.getTxt_BI_do_funcionario().setText("");
        view.getTxt_NUIT_do_funcionario().setText("");
        view.getTxt_data_de_nascimento_do_funcionario().setText("");
        view.getCbx_nacionalidade_do_funcionario().setSelectedIndex(0);
        view.getTxt_numero_de_celular_do_funcionario().setText("");
        view.getTxt_email_do_funcionario().setText("");
        view.getCbx_departamento().setSelectedIndex(0);
        view.getCbx_nivel_academico_do_funcionario().setSelectedIndex(0);
        view.getCbx_turno_do_funcionario().setSelectedIndex(0);
        view.getTxt_conta_bancaria_do_funcionario().setText("");
        view.getPwd_senha_do_funcionario().setText("");
        view.getPwd_senha_repetida_do_funcionario().setText("");
        JOptionPane.showMessageDialog(null, "Limpo!");
    }
    
//==============================================================================================================================================================================================================================
    
//================================================================================== MOSTRAR O OBJECTO NA VIEW =================================================================================================================
    
    public void mostrar_estudante_na_view(Estudante estudante){
        
        view.getTxt_nome_do_estudante().setText(estudante.getNome());
        view.getTxt_BI_do_estudante().setText(estudante.getNumero_de_BI());
        view.getTxt_NUIT_do_estudante().setText(estudante.getNumero_de_NUIT() + "");
        
        // Agora uma conversao rapida do LocalDate para String
        LocalDate data = estudante.getData_de_nascimento();
        String data_convertida = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        // Agora podemos continuar a tirar os dados do objecto para a tela/view
        view.getTxt_data_de_nascimento_do_estudante().setText(data_convertida);
        view.getTxt_numero_de_celular_do_estudante().setText(estudante.getNumero_de_celular() + "");
        view.getTxt_email_do_estudante().setText(estudante.getEmail());
        
        // De novo, agora devemos converter as senhas "char []" para "String"
        
        String senha = new String(estudante.getSenha());
        String senha_repetida = new String(estudante.getSenha_repetida());
        
        //Agora podemos continuar
        view.getPwd_senha_do_estudante().setText(senha);
        view.getPwd_senha_repetida_do_estudante().setText(senha_repetida);
        
        // A validacao do Radio
        if (estudante.getSexo().equals("Masculino")){
            view.getRdb_sexo_masculino_do_estudante().setSelected(true);
        } 
        if (estudante.getSexo().equals("Femenino")){
            view.getRdb_sexo_femenino_do_estudante().setSelected(true);
        }
        
        view.getTxt_semestre().setText(estudante.getSemestre() + "");
        view.getTxt_instituicao_de_ensino().setText(estudante.getInstituicao_de_ensino());
        view.getCbx_nacionalidade_do_estudante().setSelectedItem(estudante.getNacionalidade());
        view.getCbx_curso().setSelectedItem(estudante.getCurso());
        view.getCbx_nivel_academico_do_estudante().setSelectedItem(estudante.getNivel_academico());
        view.getCbx_turno_do_estudante().setSelectedItem(estudante.getTurno());
    }
    
    public void mostrar_docente_na_view(Docente docente){
        
        view.getTxt_nome_do_docente().setText(docente.getNome());
        view.getTxt_BI_do_docente().setText(docente.getNumero_de_BI());
        view.getTxt_NUIT_do_docente().setText(docente.getNumero_de_NUIT() + "");
        
        // Agora uma conversao rapida do LocalDate para String
        LocalDate data = docente.getData_de_nascimento();
        String data_convertida = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        // Agora podemos continuar a tirar os dados do objecto para a tela/view
        view.getTxt_data_de_nascimento_do_docente().setText(data_convertida);
        view.getTxt_numero_de_celular_do_docente().setText(docente.getNumero_de_celular() + "");
        view.getTxt_email_do_docente().setText(docente.getEmail());
        
        // De novo, agora devemos converter as senhas "char []" para "String"
        
        String senha = new String(docente.getSenha());
        String senha_repetida = new String(docente.getSenha_repetida());
        
        //Agora podemos continuar
        view.getPwd_senha_do_docente().setText(senha);
        view.getPwd_senha_repetida_do_docente().setText(senha_repetida);
        
        // A validacao do Radio
        if (docente.getSexo().equals("Masculino")){
            view.getRdb_sexo_masculino_do_docente().setSelected(true);
        } 
        if (docente.getSexo().equals("Femenino")){
            view.getRdb_sexo_femenino_do_docente().setSelected(true);
        }
        
        view.getTxt_conta_bancaria_do_docente().setText(docente.getConta_bancaria() + "");
        view.getCbx_nacionalidade_do_docente().setSelectedItem(docente.getNacionalidade());
        view.getCbx_cadeira().setSelectedItem(docente.getCadeira());
        view.getCbx_nivel_academico_do_docente().setSelectedItem(docente.getNivel_academico());
        view.getCbx_turno_do_docente().setSelectedItem(docente.getTurno());
    }
    
    public void mostrar_funcionario_na_view(Funcionario funcionario){
        
        view.getTxt_nome_do_funcionario().setText(funcionario.getNome());
        view.getTxt_BI_do_funcionario().setText(funcionario.getNumero_de_BI());
        view.getTxt_NUIT_do_funcionario().setText(funcionario.getNumero_de_NUIT() + "");
        
        // Agora uma conversao rapida do LocalDate para String
        LocalDate data = funcionario.getData_de_nascimento();
        String data_convertida = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        // Agora podemos continuar a tirar os dados do objecto para a tela/view
        view.getTxt_data_de_nascimento_do_funcionario().setText(data_convertida);
        view.getTxt_numero_de_celular_do_funcionario().setText(funcionario.getNumero_de_celular() + "");
        view.getTxt_email_do_funcionario().setText(funcionario.getEmail());
        
        // De novo, agora devemos converter as senhas "char []" para "String"
        
        String senha = new String(funcionario.getSenha());
        String senha_repetida = new String(funcionario.getSenha_repetida());
        
        //Agora podemos continuar
        view.getPwd_senha_do_funcionario().setText(senha);
        view.getPwd_senha_repetida_do_funcionario().setText(senha_repetida);
        
        // A validacao do Radio
        if (funcionario.getSexo().equals("Masculino")){
            view.getRdb_sexo_masculino_do_funcionario().setSelected(true);
        } 
        if (funcionario.getSexo().equals("Femenino")){
            view.getRdb_sexo_femenino_do_funcionario().setSelected(true);
        }
        
        view.getTxt_conta_bancaria_do_funcionario().setText(funcionario.getConta_bancaria() + "");
        view.getCbx_nacionalidade_do_funcionario().setSelectedItem(funcionario.getNacionalidade());
        view.getCbx_departamento().setSelectedItem(funcionario.getDepartamento());
        view.getCbx_nivel_academico_do_funcionario().setSelectedItem(funcionario.getNivel_academico());
        view.getCbx_turno_do_funcionario().setSelectedItem(funcionario.getTurno());
    }
    
//===============================================================================================================================================================================================================================
    
    // ... Métodos obter_modelo anteriores ...

    // --- MÉTODOS PARA MOSTRAR NA TELA (Usado no Procurar) ---

    public void mostrar_curso_na_view(Curso c) {
        view.getTxt_nome_do_curso().setText(c.getNome());
        view.getCbx_grau_do_curso().setSelectedItem(c.getGrau());
        view.getSpn_duracao_do_curso().setValue(c.getDuracao());
    }

    public void mostrar_cadeira_na_view(Cadeira c) {
        view.getTxt_nome_da_cadeira().setText(c.getNome());
        view.getTxt_carga_horaria().setText(c.getCarga_horaria() + "");
        view.getSpn_semestre_da_cadeira().setValue(c.getSemestre());
        
        // Selecionar nas ComboBoxes (Funciona porque temos o equals/toString)
        view.getCbx_curso_associado_a_cadeira().setSelectedItem(c.getCurso_associado());
        
        if (c.getPrecedencia() != null) {
            view.getCbx_precedencia_da_cadeira().setSelectedItem(c.getPrecedencia());
        } else {
            view.getCbx_precedencia_da_cadeira().setSelectedIndex(0); // "Nenhuma"
        }
    }

    public void mostrar_turma_na_view(Turma t) {
        view.getSpn_ano_lectivo_da_turma().setValue(t.getAno_letivo());
        view.getSpn_semestre_da_turma().setValue(t.getSemestre());
        view.getSpn_vagas_para_turma().setValue(t.getVagas());
        
        view.getCbx_curso_da_turma().setSelectedItem(t.getCurso());
        view.getCbx_docente_responsavel_pela_turma().setSelectedItem(t.getDocente_responsavel());
    }
    public void mostrar_horario_na_view(Horario h) {
        view.getCbx_cadeira_horario().setSelectedItem(h.getCadeira());
        view.getCbx_docente_horario().setSelectedItem(h.getDocente());
        view.getCbx_turma_horario().setSelectedItem(h.getTurma());
        view.getCbx_dia_de_semana_horario().setSelectedItem(h.getDia_semana());
        view.getTxt_sala_horario().setText(h.getSala());
        view.getFtf_horario_inicio().setText(h.getHora_inicio());
        view.getFtf_horario_fim().setText(h.getHora_fim());
    }
    
}
