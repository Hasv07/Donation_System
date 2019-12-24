package UI_FXML;

import UI.Login_Scene;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Payment_Controller {
    ObservableList<String> Payment_methods = FXCollections.observableArrayList("Cash","Payment");

    @FXML
    private ChoiceBox<String> Payment ;
    @FXML
    private AnchorPane Payment_scene ;
    @FXML

    private AnchorPane Pay_scene;





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
          Pay_scene = Login_Scene.Cash;
          Payment_scene.getChildren().remove(Pay_scene);
           Pay_scene.setLayoutX(-2);
           Pay_scene.setLayoutY(95);

            Payment_scene.getChildren().add(Pay_scene);

        }

    }



}