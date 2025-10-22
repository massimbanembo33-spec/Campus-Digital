
package campus.digital.controller.helper;

import campus.digital.view.LoginFrame;
import campus.digital.model.Administrador;

public class LoginHelper {
    
    private final LoginFrame view;

    public LoginHelper(LoginFrame view) {
        this.view = view;
    }

    public Administrador obtercredenciais (){
        
        String username = view.getTxtusuario().getText();
        String password = view.getTxtsenha().getText();
        
        Administrador modelo = new Administrador(username, password, 0);
        return modelo;
    }
    
}
