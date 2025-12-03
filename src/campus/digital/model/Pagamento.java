/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.digital.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author simba
 */
public class Pagamento implements Serializable{
    
    private String ID_pagamento;
    private Estudante estudante; // Quem pagou
    private String tipo; //"Propinas", "Inscricao", "Declaracao", "Atrazo na execucao de teste", "Recorencia"...
    private double valor;
    private LocalDate data_de_pagamento;
    private String mes_referencia; // Ex.: Novembro
    
}
