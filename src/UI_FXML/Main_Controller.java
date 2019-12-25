package UI_FXML;

import Core.AddCharityOperation;
import Core.Charity;
import Core.DatabaseManager;
import UI.Login_Scene;
import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;

public class Main_Controller {
    @FXML
    private JFXButton Money_Donation;
    @FXML
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


    public void inistiate(){
        address.setText(DatabaseManager.getInstance().queryDonors().get(0).getAddress());
        phone.setText(DatabaseManager.getInstance().queryDonors().get(0).getPhoneNumber());
        email.setText(DatabaseManager.getInstance().queryDonors().get(0).getEmail());
        pas.setText(DatabaseManager.getInstance().queryDonors().get(0).getPassword());
        userN.setText(DatabaseManager.getInstance().queryDonors().get(0).getUsername());
        Category.setItems(Categoryopt);
    }
    public void Money_Donation_pressed()
    {
        Donate_tab.setContent(Login_Scene.payment);
    }
    public void Submit_Charity(){
        Charity charity = new Charity(chName.getText(),Category.getSelectionModel().selectedItemProperty().getValue().toString(),Desc.getText(),chWebsite.getText(),chEmail.getText());
        AddCharityOperation addCharityOperation = new AddCharityOperation(charity);
        addCharityOperation.excute(charity);
        System.out.println(charity.getCategory());
        ObservableList<String> MoneyCharity = FXCollections.observableArrayList();
        for (int i = 0 ; i<DatabaseManager.getInstance().queryCharities().size();i++){
            MoneyCharity.add(DatabaseManager.getInstance().queryCharities().get(i).getName());
        }
        combo1.setItems(MoneyCharity);
    }
}
