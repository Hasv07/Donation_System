package UI_FXML;

import UI.Login_Scene;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Payment_Controller {
    ObservableList<String> Payment_methods = FXCollections.observableArrayList("Cash","Credit Card");
    Login_Scene ui;

    @FXML
    private ComboBox<String> Payment ;
    @FXML
    private AnchorPane Payment_scene ;
    @FXML

    private AnchorPane Pay_scene;
    @FXML
    private JFXButton Back;





    public void choicebOX()
    {
        Payment.setItems(Payment_methods);
        System.out.println(Payment.getValue());
    }

    public void choicebox_selected()
    {

        if(Payment.getValue().equals("Cash")==true)
        {
            System.out.println("hello");
            Payment_scene.getChildren().remove(Pay_scene);

            Pay_scene = Login_Scene.Cash;
           Pay_scene.setLayoutX(-2);
           Pay_scene.setLayoutY(95);

            Payment_scene.getChildren().add(Pay_scene);

        }
        else if(Payment.getValue().equals("Credit Card")==true)
        {
            System.out.println("hello2");
            Payment_scene.getChildren().remove(Pay_scene);

            Pay_scene = Login_Scene.Credit;
            Pay_scene.setLayoutX(-2);
            Pay_scene.setLayoutY(95);

            Payment_scene.getChildren().add(Pay_scene);

        }

    }
    public void Back_pressed()
    {
        ui.flag=true;

        Main_Controller.flag=true;
    }


}
