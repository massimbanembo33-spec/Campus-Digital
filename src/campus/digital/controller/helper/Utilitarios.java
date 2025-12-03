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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author simba
 */
public class Utilitarios {
    
    public static LocalDate obter_data_de_nascimento(String data){
        if (data == null || data.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo de data de nascimento esta vazio!");
            return null;
        }
        else {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
          
          try {
              return LocalDate.parse(data.trim(), formato);
          }
          catch (DateTimeParseException e){
              JOptionPane.showMessageDialog(null, "Data de nascimento invalida! Use o formato dd/MM/yyyy");
              return null;
              /*
              DateTimeFormatter.ofPattern("dd/MM/yyyy") → define o formato esperado.
                LocalDate.parse(data, formato) → converte a String para LocalDate.
                  O try/catch impede que o programa pare caso o utilizador digite algo errado.
                    Depois disso, data_de_nascimento será um objeto LocalDate (não mais texto "data").
              */
          }
      
/*
            Resumo
            .isEmpty()	Verifica se uma String está vazia ("")	
            .trim()	Remove espaços antes e depois do texto	
            return null	Indica que algo deu errado (ex: data inválida)
            boolean	Retorna verdadeiro ou falso	
            */
        }
    }
    
//==============================================================================================================================================================================================================================
    
//======================================================================================= CONVERSOES ===========================================================================================================================
    
    public static int converter_para_int(String valor) {
    try {
        if (valor == null || valor.trim().isEmpty()) {
            return 0;
        }
        return Integer.parseInt(valor.trim());
    } catch (NumberFormatException e) {
        return 0; // Se o usuário digitar letras "ABC", retorna 0 e não trava o sistema
    }
}
        public static Long converter_para_Long(String valor) {
    try {
        if (valor == null || valor.trim().isEmpty()) {
            return 0L;
        }
        return Long.parseLong(valor.trim());
    } catch (NumberFormatException e) {
        return 0L; 
    }
}

//===============================================================================================================================================================================================================================

//=================================================================================== VALIDACOES DE GESTAO USUARIOS =============================================================================================================

private static String validarRegrasBI(String bi) {
        if (bi.isBlank()) return "Preencha o campo do BI";
        // Verifica se o último caracter é Letra e se é Maiúscula
        char ultimaLetra = bi.charAt(bi.length() - 1);
        if (!Character.isLetter(ultimaLetra) || !Character.isUpperCase(ultimaLetra)) {
            return "O BI deve terminar com uma letra Maiúscula (Ex: ...123B)";
        }
        return "OK";
    }

    private static String validarRegrasCelular(int numero) {
        if (numero == 0) return "Preencha o campo de Numero de celular";
        
        String numStr = String.valueOf(numero);
        // Validar prefixos de Moçambique (82, 83, 84, 85, 86, 87)
        if (!numStr.startsWith("82") && !numStr.startsWith("83") && 
            !numStr.startsWith("84") && !numStr.startsWith("85") && 
            !numStr.startsWith("86") && !numStr.startsWith("87")) {
            return "O número deve começar com 82, 83, 84, 85, 86 ou 87.";
        }
        // Validar tamanho (geralmente 9 dígitos)
        if (numStr.length() != 9) {
            return "O número de celular deve ter 9 dígitos.";
        }
        return "OK";
    }

    private static String validarRegrasEmail(String email) {
        if (email.isBlank()) return "Preencha o campo de Email";
        if (!email.endsWith("@gmail.com")) {
            return "O Email deve ser do Google (@gmail.com)";
        }
        return "OK";
    }

    // =========================================================================
    // VALIDAÇÕES PRINCIPAIS (Atualizadas com as novas regras)
    // =========================================================================

    public static String Validar_Campus_Estudante(Estudante estudante){
        if (estudante.getNome().isBlank()) 
            return "Preencha o campo do nome";
        if (estudante.getSexo().isBlank()) 
            return "Selecione o sexo";
        
        // Validação BI
        String msgBI = validarRegrasBI(estudante.getNumero_de_BI());
        if (!msgBI.equals("OK")) 
            return msgBI;

        if (estudante.getNumero_de_NUIT() == 0) 
            return "Preencha o campo do NUIT";
        if (estudante.getData_de_nascimento() == null) 
            return "Preencha o campo de Data de Nascimento";
        if (estudante.getNacionalidade().equals("null") || estudante.getNacionalidade().equals("Selecione:")) 
            return "Selecione a nacionalidade";
        
        // Validação Celular
        String msgCel = validarRegrasCelular(estudante.getNumero_de_celular());
        if (!msgCel.equals("OK")) return msgCel;

        // Validação Email
        String msgEmail = validarRegrasEmail(estudante.getEmail());
        if (!msgEmail.equals("OK")) return msgEmail;

        if (estudante.getNivel_academico().equals("null") || estudante.getNivel_academico().equals("Selecione:")) return "Selecione o Nivel Academico";
        if (estudante.getInstituicao_de_ensino().isBlank()) return "Preencha a Instituição de Ensino";
        if (estudante.getCurso().equals("null") || estudante.getCurso().equals("Selecione:")) return "Selecione o Curso";
        if (estudante.getTurno().equals("null") || estudante.getTurno().equals("Selecione:")) return "Selecione o Turno";
        if (estudante.getSemestre() == 0) return "Preencha o campo do Semestre";
        
        if (estudante.getSenha() == null || estudante.getSenha().length == 0) return "Preencha a Senha";
        if (estudante.getSenha_repetida() == null || estudante.getSenha_repetida().length == 0) return "Confirme a sua senha";
        if (!Arrays.equals(estudante.getSenha(), estudante.getSenha_repetida())) return "As senhas não coincidem!";
        
        return "OK"; 
    }

    public static String Validar_Campus_Docente(Docente docente){
        if (docente.getNome().isBlank()) return "Preencha o campo do nome";
        if (docente.getSexo().isBlank()) return "Selecione o sexo";
        
        // Validação BI
        String msgBI = validarRegrasBI(docente.getNumero_de_BI());
        if (!msgBI.equals("OK")) return msgBI;

        if (docente.getNumero_de_NUIT() == 0) return "Preencha o campo do NUIT";
        if (docente.getData_de_nascimento() == null) return "Preencha o campo de Data de Nascimento";
        if (docente.getNacionalidade().equals("null") || docente.getNacionalidade().equals("Selecione:")) return "Selecione a nacionalidade";
        
        // Validação Celular
        String msgCel = validarRegrasCelular(docente.getNumero_de_celular());
        if (!msgCel.equals("OK")) return msgCel;

        // Validação Email
        String msgEmail = validarRegrasEmail(docente.getEmail());
        if (!msgEmail.equals("OK")) return msgEmail;

        if (docente.getCadeira().equals("null") || docente.getCadeira().equals("Selecione:")) return "Selecione a Caderia";
        if (docente.getNivel_academico().equals("null") || docente.getNivel_academico().equals("Selecione:")) return "Selecione o Nivel Academico";
        if (docente.getTurno().equals("null") || docente.getTurno().equals("Selecione:")) return "Selecione o Horario de trabalho";
        if (docente.getConta_bancaria() == 0) return "Informe o numero da sua conta bancaria";
        
        if (docente.getSenha() == null || docente.getSenha().length == 0) return "Preencha a Senha";
        if (docente.getSenha_repetida() == null || docente.getSenha_repetida().length == 0) return "Confirme a sua senha";
        if (!Arrays.equals(docente.getSenha(), docente.getSenha_repetida())) return "As senhas não coincidem!";
        
        return "OK"; 
    }

    public static String Validar_Campus_Funcionario(Funcionario funcionario){
        if (funcionario.getNome().isBlank()) return "Preencha o campo do nome";
        if (funcionario.getSexo().isBlank()) return "Selecione o sexo";
        
        // Validação BI
        String msgBI = validarRegrasBI(funcionario.getNumero_de_BI());
        if (!msgBI.equals("OK")) return msgBI;

        if (funcionario.getNumero_de_NUIT() == 0) return "Preencha o campo de NUIT";
        if (funcionario.getData_de_nascimento() == null) return "Preencha o campo de Data de Nascimento";
        if (funcionario.getNacionalidade().equals("null") || funcionario.getNacionalidade().equals("Selecione:")) return "Selecione a nacionalidade";
        
        // Validação Celular
        String msgCel = validarRegrasCelular(funcionario.getNumero_de_celular());
        if (!msgCel.equals("OK")) return msgCel;

        // Validação Email
        String msgEmail = validarRegrasEmail(funcionario.getEmail());
        if (!msgEmail.equals("OK")) return msgEmail;

        if (funcionario.getDepartamento().equals("null") || funcionario.getDepartamento().equals("Selecione:")) return "Selecione a Caderia";
        if (funcionario.getNivel_academico().equals("null") || funcionario.getNivel_academico().equals("Selecione:")) return "Selecione o Nivel Academico";
        if (funcionario.getTurno().equals("null") || funcionario.getTurno().equals("Selecione:")) return "Selecione o Horario de trabalho";
        if (funcionario.getConta_bancaria() == 0) return "Informe o numero da sua conta bancaria";
        
        if (funcionario.getSenha() == null || funcionario.getSenha().length == 0) return "Preencha a Senha";
        if (funcionario.getSenha_repetida() == null || funcionario.getSenha_repetida().length == 0) return "Confirme a sua senha";
        if (!Arrays.equals(funcionario.getSenha(), funcionario.getSenha_repetida())) return "As senhas não coincidem!";
        
        return "OK";
    }

//===============================================================================================================================================================================================================================

//=================================================================================== VALIDACOES DA GESTAO ACADEMICA ============================================================================================================


public static String Validar_Campus_Curso(Curso curso) {
    if (curso.getNome() == null || curso.getNome().isBlank()) {
        return "Preencha o Nome do Curso";
    }
    if (curso.getGrau().equals("Selecione:") || curso.getGrau().equals("null")) {
        return "Selecione o Grau Académico";
    }
    if (curso.getDuracao() <= 0) {
        return "A Duração deve ser de pelo menos 1 ano";
    }
    return "OK";
}

public static String Validar_Campus_Cadeira(Cadeira cadeira) {
    if (cadeira.getNome() == null || cadeira.getNome().isBlank()) {
        return "Preencha o Nome da Cadeira";
    }
    // Como agora usamos Objetos, verificamos se é null
    if (cadeira.getCurso_associado() == null) {
        return "Selecione o Curso associado";
    }
    if (cadeira.getSemestre() <= 0) {
        return "Informe um semestre válido";
    }
    if (cadeira.getCarga_horaria() <= 0) {
        return "Informe a Carga Horária";
    }
    return "OK";
}

public static String Validar_Campus_Turma(Turma turma) {

    if (turma.getAno_letivo() <= 0) {
        return "Informe o Ano Letivo";
    }
    if (turma.getSemestre() <= 0) {
        return "Informe o Semestre";
    }
    if (turma.getVagas() <= 0) {
        return "A turma deve ter pelo menos 1 vaga";
    }
    return "OK";
}

public static String Validar_Campus_Horario(Horario h) {
    if (h.getCadeira() == null) return "Selecione a Cadeira";
    if (h.getDocente() == null) return "Selecione o Docente";
    if (h.getTurma() == null) return "Selecione a Turma";
    
    if (h.getDia_semana().equals("Selecione:") || h.getDia_semana().equals("null")) {
        return "Selecione o Dia da Semana";
    }
    
    if (h.getSala() == null || h.getSala().isBlank()) return "Informe a Sala";
    if (h.getHora_inicio().trim().equals(":")) {
        return "Informe a Hora de Início";
    }
    if (h.getHora_fim().trim().equals(":")) {
        return "Informe a Hora de Fim";
    }
    
    return "OK";
}
    
}
