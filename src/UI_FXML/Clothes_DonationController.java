package UI_FXML;

import UI.Login_Scene;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;

public class Clothes_DonationController {
    Login_Scene ui;
    @FXML
    private JFXButton Back;
    public void Back_pressed()
    {
        ui.flag=true;

        Main_Controller.static_flag=true;
    }
}
