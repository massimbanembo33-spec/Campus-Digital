/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.digital.controller.helper;

import campus.digital.model.Docente;
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
        }
    }
    
    public static boolean validar_senha (char[] senha, char[] senha_repetida){
        if (senha == null || senha.length == 0){
            JOptionPane.showMessageDialog(null, "O campo da senha esta vazio!");
            return false;
        }
        else if (senha_repetida == null || senha_repetida.length == 0){
            JOptionPane.showMessageDialog(null, "O campo da senha repetida esta vazio!");
            return false;
        }
        else if (Arrays.equals(senha, senha_repetida)){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "A senha deve ser igual a senha repetida!");
            return true;
            
            /*
            Aqui a validacao e a seguinte 
            
                for (int i = 0; i < senha1.length; i++) {
                    if (senha[i] != senha_repetida[i]) {
                        System.out.println("Diferença na posição " + i + ": " + senha[i] + " ≠ " + senha_repetida[i]);
            }
        }

            */
            
            /*
            Por que boolean na validação da senha?
            Porque o objetivo da função validarSenha() é responder sim ou não à pergunta:

            “As senhas são válidas?”
            Se forem válidas → retorna true
            Se não forem válidas → retorna false
            Assim, quem chama o método pode decidir o que fazer.
            
            Resumo
            .isEmpty()	Verifica se uma String está vazia ("")	
            .trim()	Remove espaços antes e depois do texto	
            return null	Indica que algo deu errado (ex: data inválida)
            boolean	Retorna verdadeiro ou falso	
            */
        }
    }
    
public static String ID_docente(){
    int contador_docente = 0;
    
    contador_docente ++;
    
    return String.format("DOC%03d", contador_docente);
}

public static String ID_aluno(){
    int contador_aluno = 0;
    
    contador_aluno ++;
    
    return String.format("ALN%03D", contador_aluno);
}

public static String ID_funcionario(){
    int contador_funcionario = 0;
    
    contador_funcionario ++;
    
    return String.format("FUN%03D", contador_funcionario);
    
    /*
    O método String.format() formata uma string com base em um modelo (template), parecido com printf() em C.
    
    DOC  ->   Texto fixo — prefixo que sempre aparece antes do número (podes mudar para ALN, ADM, etc).
    %    ->   Indica que vem um valor formatado a seguir (é o marcador de posição).
    0    ->   Significa que os espaços vazios serão preenchidos com zeros à esquerda.
    3    ->   É a largura mínima — ou seja, o número terá 3 dígitos.
    d    ->   Diz que o valor é um inteiro (decimal).
    */
}

public static String Validar_Campus(Docente docente){
    if (docente.getNome() == null || docente.getNome().isEmpty()){
        return "Preencha o campo do nome";
    }
    if (docente.getSexo() == '\u0000'){
        return "Selecione o sexo";
    }
    if (docente.getNumero_de_BI() == null || docente.getNumero_de_BI().isEmpty()){
        return "Preencha o campo da data de nascimento";
    }
    if (docente.getNacionalidade() == null){
        return "Selecione a nacionalidade";
    }
    if (docente.getData_de_nascimento() == null){
        return "Preencha o campo de Data de Nascimento";
    }
    if (docente.getNumero_de_celular() == 0){
        return "Preencha o campo de Numero de celular";
    }
    if (docente.getEmail_do_docente() == null){
        return "Preencha o campo de Email";
    }
    if (docente.getSenha() == null){
        return "Preencha o campo da Senha";
    }
    if (docente.getSenha_repetida() == null){
        return "Preencha o campo da Confirmacao da Senha";
    }
    if (docente.getCadeira() == null){
        return "Selecione a Caderia";
    }
    if (docente.getNivel_academico() == null){
        return "Selecione o Nivel Academico";
    }
    if (docente.getHorario_de_trabalho() == null){
        return "Selecione o Horario de trabalho";
    }
    return "OK"; 
    }

    
}
