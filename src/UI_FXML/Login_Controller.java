package UI_FXML;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.util.Duration;

public class Login_Controller {
    Animation Text_disappearence;
    @FXML
    private Tab tab1;
    @FXML
    private TabPane s;
    @FXML
    private Label registered;
    @FXML

    public void RegisterButton_pressesed() {
        s.getSelectionModel().select(tab1);
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