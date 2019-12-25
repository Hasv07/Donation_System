package UI_FXML;

import UI.Login_Scene;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class Cash_Controller {
    Login_Scene ui;
    int counter=0;
    @FXML
    private ImageView party1;
    @FXML
    private ImageView party2;
    @FXML
    private ImageView party3;
    @FXML
    private ImageView party4;
    @FXML
    private JFXButton Fawry;
    @FXML
    private JFXButton cash;
    @FXML
    private JFXButton Generator;
    @FXML
    private Label thank;
    @FXML
    private Label Fawry_Code;

    public void cash_Button_pressed()
    {
        party3.setVisible(true);
        party4.setVisible(true);
        thank.setVisible(true);

        party1.setVisible(false);
        party2.setVisible(false);
        Fawry_Code.setVisible(false);
        Generator.setVisible(false);
        if(counter==1) {
            ui.flag = true;
            counter--;
        }

    }

    public void Fawry_Button_pressed()
    {
        party3.setVisible(false);
        party4.setVisible(false);
        thank.setVisible(false);

      /*  party1.setVisible(false);
        party2.setVisible(false);
        Fawry_Code.setVisible(false);*/
        Generator.setVisible(true);

        if(counter==1) {
            ui.flag = true;
            counter--;
        }

    }
    public void Generator_Button_pressed()
    {


        party1.setVisible(true);
        party2.setVisible(true);
        int x= (int)(Math.random()*9000000+10000000);
        Fawry_Code.setText("Your Fawry code is "+x);
        Fawry_Code.setVisible(true);


    }

}
