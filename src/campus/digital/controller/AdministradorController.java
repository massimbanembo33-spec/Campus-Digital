/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.digital.controller;

import campus.digital.model.Aluno;
import campus.digital.model.Docente;
import campus.digital.model.Funcionario;
import campus.digital.model.VectorUsuarios;
import campus.digital.view.AdministradorFrame;

/**
 *
 * @author simba
 */
public class AdministradorController {
    
    private final AdministradorFrame view;

    public AdministradorController(AdministradorFrame view) {
        this.view = null;
    }
    
    public void cadastrar_aluno (Aluno a){
        VectorUsuarios.adicionar_aluno(a);
        }
    
    public void cadastrar_docente (Docente d){
        VectorUsuarios.adicionar_docente(d);
    }
    
    public void cadastrar_funcionario (Funcionario f){
        VectorUsuarios.adicionar_funcionarios(f);
    }
}
