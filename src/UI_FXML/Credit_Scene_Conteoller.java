package UI_FXML;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

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
    }


}
