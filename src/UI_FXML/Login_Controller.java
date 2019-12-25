package UI_FXML;
import Core.*;
import UI.Login_Scene;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class Login_Controller {
    Animation Text_disappearence;
    //Login_Scene UI;
    @FXML
    private Tab tab1;
    @FXML
    private TabPane s;
    @FXML
    private Label registered;
    @FXML
    private JFXButton Login;
    @FXML
    JFXTextField userName;
    @FXML
    JFXPasswordField passWord;
    @FXML
    JFXTextField UserName;
    @FXML
    JFXTextField FirstName;
    @FXML
    JFXTextField email;
    @FXML
    JFXTextField address;
    @FXML
    JFXTextField phoneNumber;
    @FXML
    JFXPasswordField pass;
    @FXML
    JFXTextField LastName;


    public void RegisterButton_pressesed() {
        s.getSelectionModel().select(tab1);
        Donor donor = new Donor(1,UserName.getText(),pass.getText(),FirstName.getText()+ " " + LastName.getText(), email.getText(),address.getText(),phoneNumber.getText(),0);
        DatabaseManager.getInstance().insertDonor(donor);
        registered.setText("You have been registered successfully");
        registered.setOpacity(1);
        this.Text_disappearence = new Timeline(new KeyFrame(Duration.millis(5.0D), (e) -> {
            registered.setOpacity(registered.getOpacity()-0.001);
            if(registered.getOpacity()==0)
            {
                Text_disappearence.stop();
            }


        }));
        Text_disappearence.setCycleCount(-1);

        Text_disappearence.play();



    }
    public void LoginButton_pressed(){
        if(LoginForm.attempts>=2){
            Login.setDisable(true);

        }
        //System.out.println(DatabaseManager.getUser().get(0).getName());
        //System.out.println(DatabaseManager.getUser().get(0).getUsername());
        //System.out.println(DatabaseManager.getUser().get(0).getPassword());
        LoginForm user=new LoginForm(userName.getText(),passWord.getText());

    }
}