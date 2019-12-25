package UI_FXML;

import Core.DatabaseManager;
import UI.Login_Scene;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;

public class Main_Controller {
    Animation timer;
    Login_Scene ui;
    static boolean flag;

    @FXML
    private JFXButton Money_Donation;
    @FXML
    private JFXButton Clothes_Donation;
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
    @FXML
    private Tab Submit_tab;
    @FXML
    private AnchorPane Donate_Pane;
    @FXML
    private ImageView Profile_picture;
    @FXML
    private JFXButton Browse;
    @FXML
    private JFXButton Submit;


    public void inistiate(){
        address.setText(DatabaseManager.getInstance().queryDonors().get(0).getAddress());
        phone.setText(DatabaseManager.getInstance().queryDonors().get(0).getPhoneNumber());
        email.setText(DatabaseManager.getInstance().queryDonors().get(0).getEmail());
        pas.setText(DatabaseManager.getInstance().queryDonors().get(0).getPassword());
        userN.setText(DatabaseManager.getInstance().queryDonors().get(0).getUsername());
    }

    public void Money_Donation_pressed()
    {
        flag=false;
        ui.flag=true;

        this.timer = new Timeline(new KeyFrame(Duration.millis(5.0D), (e) -> {
            if(flag==false)
            Donate_tab.setContent(Login_Scene.payment);
            else {

                //Donate_tab.setContent(Donate_Pane);

                Scene scene =new Scene(Login_Scene.Main_Menu);
                Login_Scene.Main_Menu.getSelectionModel().select(2);

                Login_Scene.primaryStage.setScene(scene);



                timer.stop();
            }


        }));
        timer.setCycleCount(-1);

        timer.play();
    }
    public void Browse()
    {

         FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(Login_Scene.primaryStage);
        Image image = new Image(selectedFile.toURI().toString());
        Profile_picture.setImage(image);
    }
    public void Clothes_Donation_pressed()
    {
        flag=false;
        ui.flag=true;

        this.timer = new Timeline(new KeyFrame(Duration.millis(5.0D), (e) -> {
            if(flag==false)
                Donate_tab.setContent(Login_Scene.Clothes);
            else {

                //Donate_tab.setContent(Donate_Pane);

                Scene scene =new Scene(Login_Scene.Main_Menu);
                Login_Scene.Main_Menu.getSelectionModel().select(2);

                Login_Scene.primaryStage.setScene(scene);



                timer.stop();
            }


        }));
        timer.setCycleCount(-1);

        timer.play();
    }
    public void submit()
    {
        flag=false;
        ui.flag=true;
        System.out.println("Hello");

        this.timer = new Timeline(new KeyFrame(Duration.millis(5.0D), (e) -> {
            if(flag==false)
                Submit_tab.setContent(Login_Scene.Submit);
            else {

                //Donate_tab.setContent(Donate_Pane);

                Scene scene =new Scene(Login_Scene.Main_Menu);
                Login_Scene.Main_Menu.getSelectionModel().select(3);

                Login_Scene.primaryStage.setScene(scene);



                timer.stop();
            }


        }));
        timer.setCycleCount(-1);

        timer.play();
    }
}
