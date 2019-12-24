package UI;

import com.jfoenix.controls.JFXTabPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Login_Scene extends Application {
    public static Stage primaryStage ;
    public static TabPane Login;
    public static JFXTabPane Main_Menu;
    public static AnchorPane payment;
    public static AnchorPane Cash;




    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage=primaryStage;
        primaryStage.setTitle("Donation System");
        try {
            show_LoginScene();

        }catch (IOException e)
        {
            System.out.println("There is error");
        }

    }
    private void show_LoginScene() throws IOException
    {
        FXMLLoader loader=new FXMLLoader();
        URL url = getClass().getClassLoader().getResource("UI_FXML/Login.fxml");
        try {
            this.Login = FXMLLoader.load(url);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //loader.setLocation(Login_Scene.class.getResource("UI_FXML/Login.fxml"));
        //Login=loader.load();
        URL url2=  getClass().getClassLoader().getResource("UI_FXML/Main_Menu.fxml");
        try {
            Main_Menu= FXMLLoader.load(url2);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("error");
        }
        URL url3=  getClass().getClassLoader().getResource("UI_FXML/payment.fxml");
        try {
            payment= FXMLLoader.load(url3);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("error");
        }
        URL url4=  getClass().getClassLoader().getResource("UI_FXML/Cash Scene.fxml");
        try {
            Cash= FXMLLoader.load(url4);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("error");
        }
        Scene scene=new Scene(Login);
        primaryStage.setScene(scene);
        primaryStage.show();

    }



}
