/**
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package campus.digital;

import campus.digital.model.Aluno;
import campus.digital.model.Docente;
import campus.digital.model.Funcionario;

/**
 *
 * @author simba
 */
public class Main {
    
    /*
    
    MVC e um padrao de arquitetura de softwares, separando uma aplicacao em 3 camadas.
    
    A camada de interacao do usuario (view), a camada de manipulacao de dados (model), e a camada de controle (controller).
    
    O ano do seu nascimento foi em 1979 tendo sido formulado por Trygve Reenskaug um cientista da computacao noruegues, que escreveu esse padrao para o projecto de software
    Grafic User Interface (GUI).
    
    Esse padrao traz nos varias vantagens como por exemplo:
    -A reutilizacao de codigo, principalmentes em projectos diferentes;
    -A facilidade na coomprensao e manutencao das aplicacoes;
    -A facilidade de criar multiplas interfaces do sistema com os usuarios;
    
    Por conta dessas vantagens e mais, foi esse padrao que decidimos usar no presente projecto
    
    A estrotura do nosso projecto sera simples:
     Usuario -> View -> Controller -> Model
    
    */
    // Essa classe foi criada pura e unicamente para a execucao de testes, (todo modelo que for feito, sera testado aqui), posteriormente sera excluida
    public static void main (String [] args){
        // Primeiro teste "Aluno"
        Aluno aluno = new Aluno("Massimba", 1, 'M', "131434830F", "Mocambicana", null, 851544433);
        
        System.out.println(aluno.getNome());
        System.out.println(aluno.getID());
        
        System.out.println("");
        
        Docente docente = new Docente("Haider", 1, 'M', "2491412441N", "Mocambicana", null, 842331324);
        
        System.out.println(docente.getNome());
        System.out.println(docente.getID());
        
        System.out.println("");
        
        Funcionario funcionario = new Funcionario("Joana", 1, 'F', null, 872343133);
        
        System.out.println(funcionario.getNome());
        System.out.print(funcionario.getID());
    }
    
}
