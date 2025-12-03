/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.digital.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author simba
 */
public class Docente extends Usuarios implements Serializable{  
    
    private String ID;
    private String cadeira;
    private Long conta_bancaria;
    private char[] senha;
    private char[] senha_repetida;
    
    static int contador = 0;
    
    public Docente() {} 

    public Docente(String ID, String cadeira, Long conta_bancaria, char[] senha, char[] senha_repetida, String nome, String sexo, String numero_de_BI, int numero_de_NUIT, LocalDate data_de_nascimento, String nacionalidade,  int numero_de_celular, String email, String nivel_academico, String turno) {
        super(nome, sexo, numero_de_BI, numero_de_NUIT, data_de_nascimento, nacionalidade, numero_de_celular, email, nivel_academico, turno);
        this.ID = ID;
        this.cadeira = cadeira;
        this.conta_bancaria = conta_bancaria;
        this.senha = senha;
        this.senha_repetida = senha_repetida;
    }

    public static void setContador(int valor) {
    contador = valor;
}
    public String getID(){
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Long getConta_bancaria() {
        return conta_bancaria;
    }

    public void setConta_bancaria(Long conta_bancaria) {
        this.conta_bancaria = conta_bancaria;
    }
    
    public void gerarID() {
        contador++;
        this.ID = String.format("DOC%03d", contador);
    }
     /*
    O método String.format() formata uma string com base em um modelo (template), parecido com printf() em C.
    
    DOC  ->   Texto fixo — prefixo que sempre aparece antes do número (podes mudar para ALN, ADM, etc).
    %    ->   Indica que vem um valor formatado a seguir (é o marcador de posição).
    0    ->   Significa que os espaços vazios serão preenchidos com zeros à esquerda.
    3    ->   É a largura mínima — ou seja, o número terá 3 dígitos.
    d    ->   Diz que o valor é um inteiro (decimal).
    */
    
    public String getCadeira() {
        return cadeira;
    }

    public void setCadeira(String cadeira) {
        this.cadeira = cadeira;
    }

    public char[] getSenha() {
        return senha;
    }

    public void setSenha(char[] senha) {
        this.senha = senha;
    }
    
    public char[] getSenha_repetida() {
        return senha_repetida;
    }
    
    public void setSenha_repetida(char[] senha_repetida) {
        this.senha_repetida = senha_repetida;
    }
   
    @Override
    public String toString() {
        return this.nome; 
}
}
