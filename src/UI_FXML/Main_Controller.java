package UI_FXML;

import Core.*;
import UI.Login_Scene;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
/*
    Animation Donation_History;
    static boolean flag2=false;
*/




    @FXML
    private JFXButton Money_Donation;
    @FXML
    private JFXButton Clothes_Donation;
    ObservableList<String> Categoryopt = FXCollections.observableArrayList("Money Donations","Clothes Donations");

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
    @FXML
    JFXTextField chName;
    @FXML
    JFXTextField IL;
    @FXML
    JFXTextArea Desc;
    @FXML
    JFXTextField chEmail;
    @FXML
    JFXComboBox Category;
    @FXML
    JFXTextField chPhoneNumber;
    @FXML
    JFXTextField chWebsite;
    @FXML
    JFXComboBox combo1;
    @FXML
    JFXComboBox combo2;
    @FXML
    JFXTextField amountMoney;
    @FXML
    JFXTextField amountClothes;


/*    Main_Controller()
    {
        this.Donation_History = new Timeline(new KeyFrame(Duration.millis(5.0D), (e) -> {
          if (flag==true)
          {

          }

        }));
        Donation_History.setCycleCount(-1);

        Donation_History.play();
    }*/



    public void inistiate(){
        address.setText(DatabaseManager.getInstance().queryDonor(LoginForm.getLoggedin_doner().getUsername()).getAddress());
        phone.setText(DatabaseManager.getInstance().queryDonor(LoginForm.getLoggedin_doner().getUsername()).getPhoneNumber());
        email.setText(DatabaseManager.getInstance().queryDonor(LoginForm.getLoggedin_doner().getUsername()).getEmail());
        pas.setText(DatabaseManager.getInstance().queryDonor(LoginForm.getLoggedin_doner().getUsername()).getPassword());
        userN.setText(DatabaseManager.getInstance().queryDonor(LoginForm.getLoggedin_doner().getUsername()).getUsername());
        Category.setItems(Categoryopt);
        ObservableList<String> MoneyCharity = FXCollections.observableArrayList();
        ObservableList<String> ClothesCharity = FXCollections.observableArrayList();

        for (int i = 0 ; i<DatabaseManager.getInstance().queryCharities().size();i++){
            if(DatabaseManager.getInstance().queryCharities().get(i).getCategory().equals("Money Donations"))
            MoneyCharity.add(DatabaseManager.getInstance().queryCharities().get(i).getName());
            else
                ClothesCharity.add(DatabaseManager.getInstance().queryCharities().get(i).getName());

        }
        combo1.setItems(MoneyCharity);
        combo2.setItems(ClothesCharity);
    }

    public void Money_Donation_pressed()
    {
        flag=false;
        ui.flag=true;

        MoneyDonation moneyDonation = new MoneyDonation(1,Double.parseDouble(amountMoney.getText()),LoginForm.getLoggedin_doner().getId(),DatabaseManager.getInstance().queryCharity(combo1.getSelectionModel().selectedItemProperty().getValue().toString()).getId());
        moneyDonation.addDonation();

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
        try {
            Image image = new Image(selectedFile.toURI().toString());
            Profile_picture.setImage(image);
        }catch ( Exception e){
            System.out.println("you don't change your profile picture");
        }
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
    public void Submit_Charity(){
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
        Charity charity = new Charity(chName.getText(),Category.getSelectionModel().selectedItemProperty().getValue().toString(),Desc.getText(),chWebsite.getText(),chEmail.getText());
        AddCharityOperation addCharityOperation = new AddCharityOperation(charity);
        addCharityOperation.excute(charity);
        System.out.println(charity.getCategory());
        ObservableList<String> MoneyCharity = FXCollections.observableArrayList();
        ObservableList<String> ClothesCharity = FXCollections.observableArrayList();

        for (int i = 0 ; i<DatabaseManager.getInstance().queryCharities().size();i++){
            if(DatabaseManager.getInstance().queryCharities().get(i).getCategory().equals("Money Donations"))
                MoneyCharity.add(DatabaseManager.getInstance().queryCharities().get(i).getName());
            else
                ClothesCharity.add(DatabaseManager.getInstance().queryCharities().get(i).getName());

        }
        combo1.setItems(MoneyCharity);
        combo2.setItems(ClothesCharity);
    }


}
