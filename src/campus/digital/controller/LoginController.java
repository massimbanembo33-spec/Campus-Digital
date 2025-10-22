
package campus.digital.controller;

import campus.digital.view.LoginFrame;

public class LoginController {

    // Todo controlador tem que controlar uma view "no nosso sistema"
    // Primeiro iremos gerar um construtor (do nosso controller)
    // Que daremos o nome de "LoginController" porque sera o responsavel por gerenciar e "controlar" a tela/view de login
    
    // Fazemos isso para que seja acessivel de qualquer lugar da classe, como se fosse os (getters e setters)
    // "Final" e uma constante!
    private final LoginFrame view;
    
    // Para criarmos a "LoginController" precisaremos passar como parametro uma "view" que sera do tipo "Login"
    public LoginController(LoginFrame view) {
        this.view = view;
    }
    
    // Vamos comecar criando uma funcao para exibir uma mensagem
    public void mensagem_login (){
    // Exibe mensagem no console
        System.out.print("Busquei algo no banco de dados...");
        
    // Agora chamaremos a view do login, para que ela exiba uma mensagem
        this.view.exibir_mensagem("Executei o MensagemLogin");
    }
    
    public void sair_login (){
        this.view.getBtnSair().addActionListener(e -> {
        System.exit(0); // fecha tudo
    });

    }
    
}
