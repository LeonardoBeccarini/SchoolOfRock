package guiController;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import logic.bean.AccessInfoBean;
import logic.control.LoginController;
import logic.exceptions.NotExistentUserException;

import java.io.IOException;


public class LoginControllerG extends MainScreenController{
    @FXML
    private Button loginButton;
    @FXML
    private Button signInButton;
    @FXML
    private TextField LoginEmail;
    @FXML
    private TextField LoginPass;
    @FXML
    private RadioButton ButtonOwner2;

    @FXML
    protected void onButtonClicked(ActionEvent event) throws IOException {
        Node eventSource = (Node) event.getSource();

        if (eventSource == loginButton) {
            if (LoginEmail.getText().isEmpty() || LoginPass.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Complete the field before!") ;
                alert.showAndWait() ;
                return ;
            }
            if(login())
                SwapToHome();
        }
        else if (eventSource == signInButton) {
            SwapToRegister();

        }
    }
     public AccessInfoBean retrieveAccessInfo() {
        AccessInfoBean accessInfoBean = new AccessInfoBean();
        accessInfoBean.setEmail(LoginEmail.getText());
        accessInfoBean.setPasswd(LoginPass.getText());
       if(ButtonOwner2.isSelected())
           accessInfoBean.setUser_type("owner");
       else   accessInfoBean.setUser_type("student");
       return accessInfoBean;
    }
     public boolean login() {
        AccessInfoBean accessBean = retrieveAccessInfo();
        boolean b = false;
        LoginController loginController = new LoginController();
        try {
             b = loginController.verifyUser(accessBean);
         } catch (NotExistentUserException e) {
             Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
             alert.showAndWait();
         }
         return b;
     }
}
