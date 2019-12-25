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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class Login_Controller {
    Animation Text_disappearence;
    Login_Scene ui;
    @FXML
    private Tab tab1;
    @FXML
    private TabPane s;
    @FXML
    private Label registered;
    @FXML
    private JFXButton Login;
    @FXML
     public  JFXTextField userName;
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
    @FXML
    Label Warning;
    @FXML
    ImageView w1;
    @FXML
    ImageView w2;
    @FXML
    ImageView w3;
    @FXML
    ImageView w4;
    @FXML
    ImageView w5;
    @FXML
    ImageView w6;
    public void disable_image()
    {
        w1.setVisible(false);
        w2.setVisible(false);
        w3.setVisible(false);
        w4.setVisible(false);
        w5.setVisible(false);
        w6.setVisible(false);


    }


    public void RegisterButton_pressesed() {
     //   s.getSelectionModel().select(tab1);
        disable_image();

        if(FirstName.getText().isEmpty()||UserName.getText().isEmpty()||
                email.getText().isEmpty()||address.getText().isEmpty()||phoneNumber.getText().isEmpty()||
                pass.getText().isEmpty()||LastName.getText().isEmpty()){

            Warning.setVisible(true);
            if(FirstName.getText().isEmpty()||LastName.getText().isEmpty())
            {
                   w1.setVisible(true);
                      }

            if( UserName.getText().isEmpty())
            {
                w2.setVisible(true);
            }
            if( email.getText().isEmpty())
            {
                w3.setVisible(true);
            }
            if(passWord.getText().isEmpty())
                w4.setVisible(true);
            }
            if(address.getText().isEmpty())
            {
                w5.setVisible(true);
            }
        if(phoneNumber.getText().isEmpty())
        {
            w6.setVisible(true);
        }



        else {
            Donor donor = new Donor(1,UserName.getText(),pass.getText(),FirstName.getText()+ " " + LastName.getText(), email.getText(),address.getText(),phoneNumber.getText(),0);
            //DatabaseManager.getInstance().insertDonor(donor);
            AddDonorOperation addDonorOperation = new AddDonorOperation(donor);
            addDonorOperation.execute(donor);
            // s.getSelectionModel().select(tab1);
            ui.flag=true;
            //Scene scene =new Scene(Login_Scene.Login);
            //Login_Scene.Login.getSelectionModel().select(0);
            //Login_Scene.primaryStage.setScene(scene);
            ui.Restart=true;

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
    }
    public void LoginButton_pressed(){
        if(LoginForm.attempts>=2){
            Login.setDisable(true);

        }
        System.out.println(userName.getText());
        //System.out.println(DatabaseManager.getUser().get(0).getName());
        //System.out.println(DatabaseManager.getUser().get(0).getUsername());
        //System.out.println(DatabaseManager.getUser().get(0).getPassword());
        LoginForm user=new LoginForm(userName.getText(),passWord.getText());
       // Scene scene=new Scene(Login_Scene.Main_Menu);

        //Login_Scene.primaryStage.setScene(scene);
        //Login_Scene.primaryStage.show();

    }
}