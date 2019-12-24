package UI_FXML;

import UI.Login_Scene;
import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Main_Controller {
    Animation timer;
    static boolean flag;

    @FXML
    private JFXButton Money_Donation;
    @FXML
    private Tab Donate_tab;
    @FXML
    private AnchorPane Donate_Pane;
    public void Money_Donation_pressed()
    {
        flag=false;
        this.timer = new Timeline(new KeyFrame(Duration.millis(5.0D), (e) -> {
            if(flag==false)
            Donate_tab.setContent(Login_Scene.payment);
            else {
                Donate_tab.setContent(Donate_Pane);

                timer.stop();
            }


        }));
        timer.setCycleCount(-1);

        timer.play();
    }
}
