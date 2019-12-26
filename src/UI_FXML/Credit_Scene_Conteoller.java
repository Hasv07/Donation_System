package UI_FXML;

import UI.Login_Scene;
import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Credit_Scene_Conteoller {
    @FXML
    private ImageView party1;
    @FXML
    private ImageView party2;
    @FXML
    private JFXButton Credit_brn;
    @FXML
    private Label verify;
    @FXML
    private Label thank;
    public void verify_pressed()
    {


        thank.setVisible(true);
        verify.setVisible(true);
        party1.setVisible(true);
        party2.setVisible(true);
        Main_Controller.flag2=true;

    }


}
