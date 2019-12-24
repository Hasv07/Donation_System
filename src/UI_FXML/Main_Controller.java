package UI_FXML;

import UI.Login_Scene;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;

public class Main_Controller {
    @FXML
    private JFXButton Money_Donation;
    @FXML

    private Tab Donate_tab;

    public void Money_Donation_pressed()
    {
        Donate_tab.setContent(Login_Scene.payment);
    }
}
