package UI_FXML;

import Core.DatabaseManager;
import UI.Login_Scene;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;

public class Main_Controller {
    @FXML
    private JFXButton Money_Donation;
    @FXML

    private Tab Donate_tab;

    @FXML
    JFXTextField userN;
    @FXML
    JFXPasswordField pas;
    @FXML
    JFXTextField email;
    @FXML
    JFXTextField phone;
    @FXML
    JFXTextField address;



    public void inistiate(){
        address.setText(DatabaseManager.getInstance().queryDonors().get(0).getAddress());
        phone.setText(DatabaseManager.getInstance().queryDonors().get(0).getPhoneNumber());
        email.setText(DatabaseManager.getInstance().queryDonors().get(0).getEmail());
        pas.setText(DatabaseManager.getInstance().queryDonors().get(0).getPassword());
        userN.setText(DatabaseManager.getInstance().queryDonors().get(0).getUsername());
    }
    public void Money_Donation_pressed()
    {
        Donate_tab.setContent(Login_Scene.payment);
    }
}
