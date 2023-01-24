package guiController;

import javafx.fxml.FXML;

import javafx.scene.control.*;
import logic.bean.UserBean;
import logic.exceptions.InvalidCredentialsException;


public class RegisterControllerG extends MainScreenController{
    @FXML private RadioButton buttonOwner;
  //  @FXML private Button signInButton2;
    @FXML private TextField emailText;
    @FXML private TextField nameText;
    @FXML private TextField surnameText;
    @FXML private PasswordField passwdText;
   @FXML
    public void onSignInClicked() {
        UserBean userBean;
        try{
            userBean = retrieveInfo();
            logic.control.RegisterController registerControl = new logic.control.RegisterController();
            registerControl.register(userBean);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "registration successful") ;
            alert.showAndWait() ;
            SwapToRegister();


        } catch (InvalidCredentialsException e )/* ?? */ {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.showAndWait();
        }
    }
    private UserBean retrieveInfo()throws InvalidCredentialsException{
        UserBean userBeanI = new UserBean();
        userBeanI.setUserEmail(emailText.getText());
        userBeanI.setName(nameText.getText());
        userBeanI.setPasswd(passwdText.getText());
        userBeanI.setSurname(surnameText.getText());
        userBeanI.setUserType(buttonOwner.isSelected());
        if(emailText.getText().isEmpty() || nameText.getText().isEmpty() || passwdText.getText().isEmpty() || surnameText.getText().isEmpty())
            throw new InvalidCredentialsException("Fields not valid!");
        return userBeanI;
    }

}

