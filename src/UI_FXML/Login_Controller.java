package UI_FXML;
import UI.Login_Scene;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
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
    Login_Scene ui;
    @FXML
    private Tab tab1;
    @FXML
    private TabPane s;
    @FXML
    private Label registered;
    @FXML
    private JFXButton Login;

    public void RegisterButton_pressesed() {
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
    public void LoginButton_pressed(){
        Scene scene=new Scene(Login_Scene.Main_Menu);

        Login_Scene.primaryStage.setScene(scene);
        Login_Scene.primaryStage.show();

    }
}