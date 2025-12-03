/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.digital.controller;

import campus.digital.controller.helper.AdministradorHelper;
import campus.digital.model.Cadeira;
import campus.digital.model.Curso;
import campus.digital.model.Estudante;
import campus.digital.model.Docente;
import campus.digital.model.Funcionario;
import campus.digital.model.Horario;
import campus.digital.model.Turma;
import campus.digital.model.VectorAcademico;
import campus.digital.model.VectorUsuarios;
import campus.digital.view.AdministradorFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author simba
 */

public class AdministradorController {
    
    private final AdministradorFrame view;
    private final AdministradorHelper helper;
    
    public AdministradorController(AdministradorFrame view) {
        this.view = view;
        this.helper = new AdministradorHelper(view);
        
        VectorAcademico.atualizar_contadores(); 
        VectorUsuarios.atualizar_contadores();
        
        // 2. Carregar dados visuais
        actualizar_comboboxes_academicas();
        actualizar_todas_tabelas();
        actualizar_comboboxes_usuarios();
    }

//===============================================================================================================================================================================================================================
    
//================================================================================== CADASTRO DE USUARIOS =======================================================================================================================

    public void cadastrar_estudante() {
        try {
            AdministradorHelper helper = new AdministradorHelper(view);
            Estudante estudante = helper.obter_modelo_do_estudante();

            if (estudante != null) {
                estudante.gerarID();
                VectorUsuarios.adicionar_estudantes(estudante);
                JOptionPane.showMessageDialog(null, "Estudante cadastrado com sucesso!\nID: " + estudante.getID());
                helper.limpar_campos_estudante();
                actualizar_comboboxes_usuarios(); 
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e.getMessage());
        }
    }

    public void procurar_estudante() {
        String id = pedir_codigo_usuario("Estudante", "ALN001");
        if (id == null) 
            return;

        Estudante e = VectorUsuarios.procurar_por_ID_do_estudante(id);
        
        if (e != null) {
            new AdministradorHelper(view).mostrar_estudante_na_view(e);
            JOptionPane.showMessageDialog(null, "Estudante encontrado: " + e.getNome());
        } else {
            JOptionPane.showMessageDialog(null, "Estudante não encontrado.");
        }
    }

    public void actualizar_estudante() { 
        String id = pedir_codigo_usuario("Estudante a alterar", "ALN001");
        if (id == null) return;

        if (VectorUsuarios.procurar_por_ID_do_estudante(id) == null) {
            JOptionPane.showMessageDialog(null, "Estudante não encontrado.");
            return;
        }

        AdministradorHelper helper = new AdministradorHelper(view);
        Estudante novosDados = helper.obter_modelo_do_estudante(); 

        if (novosDados != null) {
            if (VectorUsuarios.actualizar_estudante(id, novosDados)) {
                JOptionPane.showMessageDialog(null, "Dados do estudante atualizados!");
                helper.limpar_campos_estudante();
            }
        }
    }

    public void eliminar_estudante() {
        String id = pedir_codigo("Estudante a eliminar (ou 'TODOS')", "ALN001");
        if (id == null) return;

        if (id.equalsIgnoreCase("TODOS")) {
            if (confirmar("TEM CERTEZA? Isso apagará TODOS os estudantes do sistema!")) {
                VectorUsuarios.limpar_todos_estudantes();
                sucesso("Todos os estudantes foram removidos.");
                helper.limpar_campos_estudante();
                
            }
            return;
        }

        Estudante e = VectorUsuarios.procurar_por_ID_do_estudante(id);
        if (e != null) {
            if (confirmar("Eliminar o estudante " + e.getNome() + "?")) {
                VectorUsuarios.remover_estudante(id);
                sucesso("Estudante eliminado.");
                helper.limpar_campos_estudante();
            }
        } else {
            erro("Estudante não encontrado.");
        }
    }
    
    public void limpar_campos_do_estudante(){
        new AdministradorHelper(view).limpar_campos_estudante();
    }

    
    public void cadastrar_docente() {
        try {
            AdministradorHelper helper = new AdministradorHelper(view);
            Docente docente = helper.obter_modelo_do_docente();

            if (docente != null) {
                docente.gerarID(); 
                VectorUsuarios.adicionar_docentes(docente);
                JOptionPane.showMessageDialog(null, "Docente cadastrado com sucesso!\nID: " + docente.getID());
                
                helper.limpar_campos_docente();
                
                actualizar_comboboxes_academicas(); 
                actualizar_comboboxes_usuarios();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar.");
        }
    }

    public void procurar_docente() {
        String id = pedir_codigo_usuario("Docente", "DOC001");
        if (id == null) return;

        Docente d = VectorUsuarios.procurar_por_ID_do_docente(id);
        
        if (d != null) {
            new AdministradorHelper(view).mostrar_docente_na_view(d);
            JOptionPane.showMessageDialog(null, "Docente encontrado: " + d.getNome());
        } else {
            JOptionPane.showMessageDialog(null, "Docente não encontrado.");
        }
    }

    public void actualizar_docente() {
        String id = pedir_codigo_usuario("Docente a alterar", "DOC001");
        if (id == null) return;

        if (VectorUsuarios.procurar_por_ID_do_docente(id) == null) {
            JOptionPane.showMessageDialog(null, "Docente não encontrado.");
            return;
        }

        Docente novosDados = new AdministradorHelper(view).obter_modelo_do_docente();

        if (novosDados != null) {
            if (VectorUsuarios.actualizar_docente(id, novosDados)) {
                JOptionPane.showMessageDialog(null, "Dados do docente atualizados!");
                new AdministradorHelper(view).limpar_campos_docente();
                actualizar_comboboxes_academicas(); 
            }
        }
    }

    public void eliminar_docente() {
        String id = pedir_codigo("Docente a eliminar (ou 'TODOS')", "DOC001");
        if (id == null) return;

        if (id.equalsIgnoreCase("TODOS")) {
            if (confirmar("TEM CERTEZA? Isso apagará TODOS os docentes!")) {
                VectorUsuarios.limpar_todos_docentes();
                sucesso("Todos os docentes foram removidos.");
                helper.limpar_campos_docente();
                actualizar_comboboxes_academicas(); 
            }
            return;
        }

        Docente d = VectorUsuarios.procurar_por_ID_do_docente(id);
        if (d != null) {
            if (confirmar("Eliminar o docente " + d.getNome() + "?")) {
                VectorUsuarios.remover_docente(id);
                sucesso("Docente eliminado.");
                helper.limpar_campos_docente();
                actualizar_comboboxes_academicas(); 
            }
        } else {
            erro("Docente não encontrado.");
        }
    }
    
    public void limpar_campos_do_docente(){
        new AdministradorHelper(view).limpar_campos_docente();
    }

    
    public void cadastrar_funcionario() {
        try {
            AdministradorHelper helper = new AdministradorHelper(view);
            Funcionario funcionario = helper.obter_modelo_do_funcionario();

            if (funcionario != null) {
                funcionario.gerarID(); 
                VectorUsuarios.adicionar_funcionarios(funcionario);
                JOptionPane.showMessageDialog(null, "Funcionário cadastrado!\nID: " + funcionario.getID());
                helper.limpar_campos_funcionario();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar.");
        }
    }

    public void procurar_funcionario() {
        String id = pedir_codigo_usuario("Funcionário", "FUN001");
        if (id == null) return;

        Funcionario f = VectorUsuarios.procurar_por_ID_do_funcionario(id);
        
        if (f != null) {
            new AdministradorHelper(view).mostrar_funcionario_na_view(f);
            JOptionPane.showMessageDialog(null, "Funcionário encontrado: " + f.getNome());
        } else {
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado.");
        }
    }

    public void actualizar_funcionario() {
        String id = pedir_codigo_usuario("Funcionário a alterar", "FUN001");
        if (id == null) return;

        if (VectorUsuarios.procurar_por_ID_do_funcionario(id) == null) {
            JOptionPane.showMessageDialog(null, "Não encontrado.");
            return;
        }

        Funcionario novosDados = new AdministradorHelper(view).obter_modelo_do_funcionario();

        if (novosDados != null) {
            if (VectorUsuarios.actualizar_funcionario(id, novosDados)) {
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
                new AdministradorHelper(view).limpar_campos_funcionario();
            }
        }
    }

    public void eliminar_funcionario() {
        String id = pedir_codigo("Funcionário a eliminar (ou 'TODOS')", "FUN001");
        if (id == null) return;

        if (id.equalsIgnoreCase("TODOS")) {
            if (confirmar("Apagar TODOS os funcionários?")) {
                VectorUsuarios.limpar_todos_funcionarios();
                sucesso("Lista limpa.");
                helper.limpar_campos_funcionario();
            }
            return;
        }

        Funcionario f = VectorUsuarios.procurar_por_ID_do_funcionario(id);
        if (f != null && confirmar("Eliminar " + f.getNome() + "?")) {
            VectorUsuarios.remover_funcionario(id);
            sucesso("Eliminado.");
            helper.limpar_campos_funcionario();
        } else if (f == null) {
            erro("Não encontrado.");
        }
    }
    
    public void limpar_campos_do_funcionario(){
        new AdministradorHelper(view).limpar_campos_funcionario();
    }
    
//===============================================================================================================================================================================================================================
    
    public void recarregar_sistema_academico() {
        actualizar_comboboxes_academicas();
        actualizar_todas_tabelas();
        JOptionPane.showMessageDialog(null, "Sistema sincronizado!");
    }

    public void actualizar_comboboxes_usuarios() {
        
        view.getCbx_curso().removeAllItems();   
        view.getCbx_cadeira().removeAllItems(); 
        
        
        view.getCbx_curso().addItem("Selecione:");
        view.getCbx_cadeira().addItem("Selecione:");
        
        
        for (Curso c : VectorAcademico.listar_cursos()) {
            view.getCbx_curso().addItem(c); 
        }
        
        
        for (Cadeira cad : VectorAcademico.listar_cadeiras()) {
            view.getCbx_cadeira().addItem(cad);
        }
    }
    
    public void actualizar_comboboxes_academicas() {
    
    view.getCbx_curso_associado_a_cadeira().removeAllItems();
    view.getCbx_curso_da_turma().removeAllItems();
    view.getCbx_docente_responsavel_pela_turma().removeAllItems();
    view.getCbx_precedencia_da_cadeira().removeAllItems();
    view.getCbx_turma_horario().removeAllItems();
    
    view.getCbx_curso_associado_a_cadeira().addItem("Selecione:");
    view.getCbx_curso_da_turma().addItem("Selecione:");
    view.getCbx_docente_responsavel_pela_turma().addItem("Selecione:");
    view.getCbx_precedencia_da_cadeira().addItem("Selecione:"); 
    view.getCbx_precedencia_da_cadeira().addItem("Nenhuma");
    view.getCbx_turma_horario().addItem("Selecione:");
    

    for (Curso c : VectorAcademico.listar_cursos()) {
        view.getCbx_curso_associado_a_cadeira().addItem(c); 
        view.getCbx_curso_da_turma().addItem(c);   
    }

    for (Docente d : VectorUsuarios.listar_docentes()) {
        view.getCbx_docente_responsavel_pela_turma().addItem(d);
    }
    
    for (Cadeira cad : VectorAcademico.listar_cadeiras()) {
        view.getCbx_precedencia_da_cadeira().addItem(cad);
    }
    
    for (Turma t : VectorAcademico.listar_turmas()) 
        view.getCbx_turma_horario().addItem(t);
}
    public void actualizar_todas_tabelas(){
        preencher_tabela_cursos();
        preencher_tabela_cadeiras();
        preencher_tabela_turmas();
    }

//===============================================================================================================================================================================================================================

// ==================================================================================== GESTÃO DE CURSOS ========================================================================================================================

    public void cadastrar_curso() {
        AdministradorHelper helper = new AdministradorHelper(view);
        Curso curso = helper.obter_modelo_curso(); 

        if (curso != null) {
            VectorAcademico.adicionar_curso(curso);
            JOptionPane.showMessageDialog(null, "Curso criado: " + curso.getNome());
            
            limpar_campos_curso(); 
            actualizar_comboboxes_academicas(); 
            actualizar_comboboxes_usuarios();
            preencher_tabela_cursos(); 
        }
    }

    public void procurar_curso() {
        String codigo = JOptionPane.showInputDialog(view, "Digite o código do curso (Ex: CUR001):");
        if (codigo != null && !codigo.isBlank()) {
            Curso c = VectorAcademico.procurar_curso(codigo);
            if (c != null) {
                new AdministradorHelper(view).mostrar_curso_na_view(c);
                JOptionPane.showMessageDialog(null, "Curso encontrado! Pode editar agora.");
            } else {
                JOptionPane.showMessageDialog(null, "Curso não encontrado.");
            }
        }
    }

    public void editar_curso() {
        String codigo = JOptionPane.showInputDialog(view, "Confirme o código do curso a alterar:");
        if (codigo == null || codigo.isBlank()) return;

        Curso novosDados = new AdministradorHelper(view).obter_modelo_curso();
        if (novosDados != null) {
            if (VectorAcademico.actualizar_curso(codigo, novosDados)) {
                JOptionPane.showMessageDialog(null, "Curso atualizado!");
                limpar_campos_curso();
                preencher_tabela_cursos();
                actualizar_comboboxes_academicas();
            } else {
                JOptionPane.showMessageDialog(null, "Erro: Curso não encontrado.");
            }
        }
    }

    public void remover_curso() {
        String codigo = pedir_codigo("Curso a eliminar (ou 'TODOS')", "CUR001");
        if (codigo == null) return;

        if (codigo.equalsIgnoreCase("TODOS")) {
            if (confirmar("ATENÇÃO: Apagar TODOS os cursos?")) {
                VectorAcademico.limpar_todos_cursos();
                sucesso("Todos os cursos removidos.");
                limpar_campos_curso();
                preencher_tabela_cursos();
                actualizar_comboboxes_academicas();
            }
            return;
        }

        Curso c = VectorAcademico.procurar_curso(codigo);
        if (c != null) {
            if (confirmar("Eliminar " + c.getNome() + "?")) {
                VectorAcademico.remover_curso(codigo);
                sucesso("Eliminado.");
                limpar_campos_curso();
                preencher_tabela_cursos(); 
                actualizar_comboboxes_academicas();
            }
        } else {
            erro("Curso não encontrado.");
        }
    }

    public void limpar_campos_curso() {
        view.getTxt_nome_do_curso().setText("");
        view.getCbx_grau_do_curso().setSelectedIndex(0);
        view.getSpn_duracao_do_curso().setValue(0); 
        ((DefaultTableModel) view.getTbl_curso().getModel()).setNumRows(0);
    }

    public void preencher_tabela_cursos() {
        DefaultTableModel modelo = (DefaultTableModel) view.getTbl_curso().getModel();
        modelo.setNumRows(0);
        for (Curso c : VectorAcademico.listar_cursos()) {
            modelo.addRow(new Object[]{ c.getCodigo(), c.getNome(), c.getGrau(), c.getDuracao() + " Anos" });
        }
    }

    
    public void cadastrar_cadeira() {
        try {
            
            AdministradorHelper helper = new AdministradorHelper(view);
            Cadeira cadeira = helper.obter_modelo_cadeira(); 

            if (cadeira != null) {

                cadeira.gerarCodigo(); 
                VectorAcademico.adicionar_cadeira(cadeira);
                
                JOptionPane.showMessageDialog(null, "Cadeira salva com sucesso: " + cadeira.getNome());

                limpar_campos_cadeira();
                preencher_tabela_cadeiras();
                actualizar_comboboxes_academicas();
                actualizar_comboboxes_usuarios();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro crítico ao salvar cadeira: " + e.getMessage());
        }
    }
    
    public void procurar_cadeira() {
        String codigo = JOptionPane.showInputDialog(view, "Digite o código da Cadeira (Ex: CAD001):");
        if (codigo != null && !codigo.isBlank()) {
            Cadeira c = VectorAcademico.procurar_cadeira(codigo);
            if (c != null) {
                new AdministradorHelper(view).mostrar_cadeira_na_view(c);
                JOptionPane.showMessageDialog(null, "Cadeira encontrada.");
            } else {
                JOptionPane.showMessageDialog(null, "Cadeira não encontrada.");
            }
        }
    }

    public void editar_cadeira() {
        String codigo = JOptionPane.showInputDialog(view, "Confirme o código da Cadeira a alterar:");
        if (codigo == null || codigo.isBlank()) return;

        if (VectorAcademico.procurar_cadeira(codigo) == null) {
            JOptionPane.showMessageDialog(null, "Cadeira não encontrada.");
            return;
        }

        Cadeira novosDados = new AdministradorHelper(view).obter_modelo_cadeira();
        
        if (novosDados != null) {
            if (VectorAcademico.actualizar_cadeira(codigo, novosDados)) {
                JOptionPane.showMessageDialog(null, "Cadeira atualizada!");
                limpar_campos_cadeira();
                preencher_tabela_cadeiras();
                actualizar_comboboxes_academicas();
            }
        }
    }
    
    public void remover_cadeira() {
        String codigo = pedir_codigo("Cadeira a eliminar (ou 'TODOS')", "CAD001");
        if (codigo == null) return;
        
        if (codigo.equalsIgnoreCase("TODOS")) {
            if (confirmar("Apagar TODAS as cadeiras?")) {
                VectorAcademico.limpar_todas_cadeiras();
                sucesso("Cadeiras limpas.");
                limpar_campos_cadeira();
                preencher_tabela_cadeiras(); 
                actualizar_comboboxes_academicas();
            }
            return;
        }
        
        Cadeira c = VectorAcademico.procurar_cadeira(codigo);
        if (c != null && confirmar("Eliminar " + c.getNome() + "?")) {
            VectorAcademico.remover_cadeira(codigo);
            sucesso("Eliminada.");
            limpar_campos_cadeira();
            preencher_tabela_cadeiras(); 
            actualizar_comboboxes_academicas();
        } else if (c == null) {
            erro("Não encontrada.");
        }
    }
    public void limpar_campos_cadeira() {
        view.getTxt_nome_da_cadeira().setText("");
        view.getTxt_carga_horaria().setText("");
        view.getSpn_semestre_da_cadeira().setValue(0);
        
        if (view.getCbx_curso_associado_a_cadeira().getItemCount() > 0) 
            view.getCbx_curso_associado_a_cadeira().setSelectedIndex(0);
            
        if (view.getCbx_precedencia_da_cadeira().getItemCount() > 0) 
            view.getCbx_precedencia_da_cadeira().setSelectedIndex(0);
            
    }

    public void preencher_tabela_cadeiras() {
        DefaultTableModel modelo = (DefaultTableModel) view.getTbl_cadeira().getModel();
        modelo.setNumRows(0);
        
        for (Cadeira c : VectorAcademico.listar_cadeiras()) {
            
            String nomeCurso = (c.getCurso_associado() != null) ? c.getCurso_associado().getNome() : "---";
            
            modelo.addRow(new Object[]{
                c.getCodigo(), 
                c.getNome(),
                c.getPrecedencia(),
                nomeCurso, 
                c.getSemestre() + "º", 
                c.getCarga_horaria() + "h"
            });
        }
    }

    public void cadastrar_turma() {
        AdministradorHelper helper = new AdministradorHelper(view);
        Turma turma = helper.obter_modelo_turma();

        if (turma != null) {
            VectorAcademico.adicionar_turma(turma);
            JOptionPane.showMessageDialog(null, "Turma criada: " + turma.getCodigo());
            limpar_campos_turma();
            preencher_tabela_turmas();
        }
    }
    
    public void procurar_turma() {
        String codigo = JOptionPane.showInputDialog(view, "Digite o código da Turma (Ex: LEI-2025-S1):");
        if (codigo != null && !codigo.isBlank()) {
            Turma t = VectorAcademico.procurar_turma(codigo);
            if (t != null) {
                new AdministradorHelper(view).mostrar_turma_na_view(t);
                JOptionPane.showMessageDialog(null, "Turma encontrada.");
            } else {
                JOptionPane.showMessageDialog(null, "Turma não encontrada.");
            }
        }
    }

    public void editar_turma() {
        String codigo = JOptionPane.showInputDialog(view, "Confirme o código da Turma a alterar:");
        if (codigo == null || codigo.isBlank()) return;

        Turma novosDados = new AdministradorHelper(view).obter_modelo_turma();
        if (novosDados != null) {
            if (VectorAcademico.actualizar_turma(codigo, novosDados)) {
                JOptionPane.showMessageDialog(null, "Turma atualizada!");
                limpar_campos_turma();
                preencher_tabela_turmas();
            } else {
                JOptionPane.showMessageDialog(null, "Erro: Turma não encontrada.");
            }
        }
    }
    
    public void remover_turma() {
        // 1. Pede o código (O utilizador consulta na tabela antes de clicar)
        String codigo = pedir_codigo("Turma a eliminar (ou 'TODOS')", "TIC-2025-S1");
        
        if (codigo == null) return; // Cancelou

        // --- OPÇÃO: ELIMINAR TODAS ---
        if (codigo.equalsIgnoreCase("TODOS")) {
            if (confirmar("ATENÇÃO: Tem a certeza que deseja apagar TODAS as turmas?")) {
                VectorAcademico.limpar_todas_turmas();
                sucesso("Todas as turmas foram removidas.");
                
                limpar_campos_turma();
                preencher_tabela_turmas(); // Tabela fica vazia
            }
            return;
        }
        
        // --- ELIMINAR UMA TURMA ESPECÍFICA ---
        Turma t = VectorAcademico.procurar_turma(codigo);
        
        if (t != null) {
            // Mostra detalhes para confirmar se é a turma certa
            String nomeCurso = (t.getCurso() != null) ? t.getCurso().getNome() : "Sem Curso";
            
            String mensagem = "Eliminar a Turma " + t.getCodigo() + "?\n" +
                              "Curso: " + nomeCurso + "\n" +
                              "Ano: " + t.getAno_letivo();
            
            if (confirmar(mensagem)) {
                VectorAcademico.remover_turma(codigo);
                sucesso("Turma removida com sucesso.");
                
                limpar_campos_turma();
                preencher_tabela_turmas(); // Atualiza a tabela removendo a linha
            }
        } else {
            erro("Turma com o código '" + codigo + "' não encontrada.\nVerifique o código na tabela e tente novamente.");
        }
    }

    public void limpar_campos_turma() {
        view.getSpn_ano_lectivo_da_turma().setValue(2025);
        view.getSpn_semestre_da_turma().setValue(0);
        view.getSpn_vagas_para_turma().setValue(0);
        if (view.getCbx_curso_da_turma().getItemCount() > 0) view.getCbx_curso_da_turma().setSelectedIndex(0);
        if (view.getCbx_docente_responsavel_pela_turma().getItemCount() > 0) view.getCbx_docente_responsavel_pela_turma().setSelectedIndex(0);
        ((DefaultTableModel) view.getTbl_turma().getModel()).setNumRows(0);
    }

    public void preencher_tabela_turmas() {
        DefaultTableModel modelo = (DefaultTableModel) view.getTbl_turma().getModel();
        modelo.setNumRows(0);
        for (Turma t : VectorAcademico.listar_turmas()) {
            String nomeCurso = (t.getCurso() != null) ? t.getCurso().getNome() : "---";
            String nomeDocente = (t.getDocente_responsavel() != null) ? t.getDocente_responsavel().getNome() : "---";
            
            modelo.addRow(new Object[]{
                t.getCodigo(), nomeCurso, t.getAno_letivo(),
                t.getSemestre() + "º", nomeDocente, t.getVagas()
            });
        }
    }
    
    
    public void cadastrar_horario() {
        Horario h = helper.obter_modelo_horario();
        if (h != null) {
            VectorAcademico.adicionar_horario(h);
            sucesso("Horário agendado!\nID: " + h.getID());
            limpar_campos_horario();
            preencher_tabela_horarios();
        }
    }

    public void remover_horario() {
        String ID = pedir_codigo("Horário a eliminar", "HOR001");
        if (ID == null) return;

        // Como Horario não tem método procurar no VectorAcademico ainda, 
        // podes usar o removeIf direto ou criar o procurar lá.
        // Aqui mostro com lógica direta:
        
        boolean existe = VectorAcademico.listar_horarios().stream().anyMatch(h -> h.getID().equalsIgnoreCase(ID));
        
        if (existe) {
            if (confirmar("Eliminar este horário?")) {
                VectorAcademico.listar_horarios().removeIf(h -> h.getID().equalsIgnoreCase(ID));
                
                sucesso("Removido.");
                preencher_tabela_horarios();
            }
        } else {
            erro("Horário não encontrado.");
        }
    }
    
    public void limpar_campos_horario() {
        if (view.getCbx_cadeira_horario().getItemCount() > 0) view.getCbx_cadeira_horario().setSelectedIndex(0);
        if (view.getCbx_docente_horario().getItemCount() > 0) view.getCbx_docente_horario().setSelectedIndex(0);
        if (view.getCbx_turma_horario().getItemCount() > 0) view.getCbx_turma_horario().setSelectedIndex(0);
        view.getCbx_dia_de_semana_horario().setSelectedIndex(0);
        view.getTxt_sala_horario().setText("");
        view.getFtf_horario_inicio().setText("");
        view.getFtf_horario_fim().setText("");
        
        ((DefaultTableModel) view.getTabela_horario().getModel()).setNumRows(0);
    }

    public void preencher_tabela_horarios() {
        DefaultTableModel modelo = (DefaultTableModel) view.getTabela_horario().getModel();
        modelo.setNumRows(0);
        
        for (Horario h : VectorAcademico.listar_horarios()) {
            modelo.addRow(new Object[]{
                h.getDia_semana(),
                h.getHora_inicio(),
                h.getHora_fim(),
                h.getCadeira().getNome(),
                h.getTurma().getCodigo(),
                h.getSala(),
                h.getDocente().getNome()
            });
        }
    }
//===============================================================================================================================================================================================================================
    
//======================================================================== UTILITÁRIOS INTERNOS (Necessários para os métodos acima funcionarem) =================================================================================
   
    
    private String pedir_codigo_usuario(String tipo, String exemplo) {
        String codigo = JOptionPane.showInputDialog(view, 
            "Digite o ID do " + tipo + " (Ex: " + exemplo + "):");
        return (codigo != null && !codigo.isBlank()) ? codigo : null;
    }
        
    private String pedir_codigo(String mensagem, String exemplo) {
        String cod = JOptionPane.showInputDialog(view, "Digite o código: " + mensagem + "\nExemplo: " + exemplo);
        return (cod != null && !cod.isBlank()) ? cod : null;
    }
    
    // Sobrecarga para o método antigo que usava apenas "Entidade"
    private String pedir_codigo(String entidade) {
        return pedir_codigo(entidade, "");
    }
    
    private boolean confirmar(String msg) {
        return JOptionPane.showConfirmDialog(view, msg, "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION;
    }
    
    private void sucesso(String msg) { 
        JOptionPane.showMessageDialog(null, msg); 
    }
    
    private void erro(String msg) { 
        JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE); 
    }
    
    private void aviso(String msg) { 
        JOptionPane.showMessageDialog(null, msg, "Aviso", JOptionPane.INFORMATION_MESSAGE); 
    }
}
