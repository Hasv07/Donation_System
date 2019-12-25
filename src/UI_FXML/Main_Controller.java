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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;

public class Main_Controller {
    Animation timer;
    Login_Scene ui;
    static boolean flag;

    Animation Donation_History;
    static boolean flag2=false;



int  i=0;
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
    @FXML
    TableView table;
    @FXML
    TableColumn id;
    @FXML
    TableColumn Donation_Type;
    @FXML
    TableColumn Charity;
    @FXML
    TableColumn DonorID;

    @FXML
    TableColumn Amount;


    public void animation()
    {
        this.Donation_History = new Timeline(new KeyFrame(Duration.millis(5.0D), (e) -> {
            if (flag==true)
            {

            }

        }));
        Donation_History.setCycleCount(-1);

        Donation_History.play();
    }



    public void inistiate(){
        address.setText(DatabaseManager.getInstance().queryDonor(LoginForm.getLoggedin_doner().getUsername()).getAddress());
        address.setEditable(false);
        address.setFocusColor(Color.GRAY);

        phone.setText(DatabaseManager.getInstance().queryDonor(LoginForm.getLoggedin_doner().getUsername()).getPhoneNumber());
        phone.setEditable(false);
        phone.setFocusColor(Color.GRAY);

        email.setText(DatabaseManager.getInstance().queryDonor(LoginForm.getLoggedin_doner().getUsername()).getEmail());
        email.setEditable(false);
        email.setFocusColor(Color.GRAY);

        pas.setText(DatabaseManager.getInstance().queryDonor(LoginForm.getLoggedin_doner().getUsername()).getPassword());
        pas.setEditable(false);
        pas.setFocusColor(Color.GRAY);

        userN.setText(DatabaseManager.getInstance().queryDonor(LoginForm.getLoggedin_doner().getUsername()).getUsername());
        userN.setEditable(false);
        userN.setFocusColor(Color.GRAY);

        Category.setItems(Categoryopt);
        address.setFocusColor(Color.GRAY);

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
        //animation();
        ArrayList<Donation> donations=DatabaseManager.getInstance().queryDonorDonations(LoginForm.getLoggedin_doner());
        ObservableList<Donation> Donations = FXCollections.observableArrayList();
        Donations.addAll(donations);
        System.out.println(donations.get(0).getId());
        id.setCellValueFactory(new PropertyValueFactory<Donation,Integer>("id"));
        Amount.setCellValueFactory(new PropertyValueFactory<Donation,Double>("amount"));
        table.setItems(Donations);
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
        ArrayList<Donation> donations=DatabaseManager.getInstance().queryDonorDonations(LoginForm.getLoggedin_doner());
        ObservableList<Donation> Donations = FXCollections.observableArrayList(new MoneyDonation(0,0,0,0));
        Donations.addAll(donations);
        System.out.println(donations.get(0).getId());
        id.setCellValueFactory(new PropertyValueFactory<Donation,Integer>("id"));
        Amount.setCellValueFactory(new PropertyValueFactory<Donation,Double>("amount"));
       table.setItems(Donations);
       // table.getItems().setAll(donations);



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
    public void Submit_Charity() {
        flag = false;
        ui.flag = true;
        System.out.println("Hello");

        this.timer = new Timeline(new KeyFrame(Duration.millis(5.0D), (e) -> {

            if (flag == false)
                Submit_tab.setContent(Login_Scene.Submit);
            else {

                //Donate_tab.setContent(Donate_Pane);

                Scene scene = new Scene(Login_Scene.Main_Menu);
                Login_Scene.Main_Menu.getSelectionModel().select(3);

                Login_Scene.primaryStage.setScene(scene);


                timer.stop();
            }


        }));
        timer.setCycleCount(-1);

        timer.play();
        Charity charity = new Charity(chName.getText(), Category.getSelectionModel().selectedItemProperty().getValue().toString(), Desc.getText(), chWebsite.getText(), chEmail.getText());
        AddCharityOperation addCharityOperation = new AddCharityOperation(charity);
        addCharityOperation.excute(charity);
        System.out.println(charity.getCategory());
        ObservableList<String> MoneyCharity = FXCollections.observableArrayList();
        ObservableList<String> ClothesCharity = FXCollections.observableArrayList();

        for (int i = 0; i < DatabaseManager.getInstance().queryCharities().size(); i++) {
            if (DatabaseManager.getInstance().queryCharities().get(i).getCategory().equals("Money Donations"))
                MoneyCharity.add(DatabaseManager.getInstance().queryCharities().get(i).getName());
            else
                ClothesCharity.add(DatabaseManager.getInstance().queryCharities().get(i).getName());

        }
        combo1.setItems(MoneyCharity);
        combo2.setItems(ClothesCharity);
    }
    public void address_Edit() {
        if (i == 0) {
            address.setEditable(true);
            address.setFocusColor(Color.BLUE);
            i++;
        }
            address.setOnKeyPressed(e -> {
                if (e.getCode().equals(KeyCode.ENTER)) {
                    DatabaseManager.getInstance().queryDonor(LoginForm.getLoggedin_doner().getUsername()).setAddress(address.getText());
                    address.setEditable(false);
                    address.setFocusColor(Color.GRAY);
                    i = 0;

                }
            });


        
    }

    public void phone_Edit()
    {

        if(i==0) {
            phone.setEditable(true);
            phone.setFocusColor(Color.BLUE);
            i++;
        }
        else if(i==1)
        {
            DatabaseManager.getInstance().queryDonor(LoginForm.getLoggedin_doner().getUsername()).setPhoneNumber(phone.getText());
            phone.setEditable(false);
            phone.setFocusColor(Color.GRAY);
           i=0;

        }

    }

  public void email_Edit() {

      if(i==0) {
          email.setEditable(true);
          email.setFocusColor(Color.BLUE);
          i++;
      }
      else if(i==1)
      {
          DatabaseManager.getInstance().queryDonor(LoginForm.getLoggedin_doner().getUsername()).setEmail(email.getText());
          email.setEditable(false);
          email.setFocusColor(Color.GRAY);

     i=0;
      }
}
    public void pas_Edit()
    {

        if(i==0) {
            pas.setEditable(true);
            pas.setFocusColor(Color.BLUE);
            i++;
        }
        else if(i==1)
        {
            DatabaseManager.getInstance().queryDonor(LoginForm.getLoggedin_doner().getUsername()).setPassword(pas.getText());
            pas.setEditable(false);
            pas.setFocusColor(Color.GRAY);

            i=0;
        }


    }
    public void userN_Edit()
    {

        if(i==0) {
            userN.setEditable(true);
            userN.setFocusColor(Color.BLUE);
            i++;
        }
        else if(i==1)
        {
            DatabaseManager.getInstance().queryDonor(LoginForm.getLoggedin_doner().getUsername()).setName(userN.getText());
            userN.setEditable(false);
            userN.setFocusColor(Color.GRAY);

               i=0;
        }
    }
}

