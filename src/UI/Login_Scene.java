package UI;

import com.jfoenix.controls.JFXTabPane;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class Login_Scene extends Application {
    public static Stage primaryStage ;
    public static TabPane Login;
    public static JFXTabPane Main_Menu;
    public static AnchorPane payment;
    public static AnchorPane Clothes;
    public static AnchorPane Submit;


    public static AnchorPane Cash;
    public static AnchorPane Credit;
    public static Boolean flag;
    private Animation timer;
    public static boolean Restart=false;





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
        flag=false;
        this.timer = new Timeline(new KeyFrame(Duration.millis(5.0D), (e) -> {
            if(flag==false)
            {}
            else if(Restart==true)
            {
                primaryStage.close();
                Restart=false;
                try {
                    show_LoginScene();

                }catch (IOException e3)
                {
                    System.out.println("There is error");
                }            }

            else{
                try {
                    show_Scenes();
                    flag=false;

                } catch (IOException e2) {
                }
            }


        }));
        timer.setCycleCount(-1);
        timer.play();

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
        URL url5=  getClass().getClassLoader().getResource("UI_FXML/Credit_Scene.fxml");
        try {
            Credit= FXMLLoader.load(url5);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("error");
        }
        URL url6=  getClass().getClassLoader().getResource("UI_FXML/Clothes_Donation.fxml");
        try {
            Clothes= FXMLLoader.load(url6);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("error");
        }
        URL url7=  getClass().getClassLoader().getResource("UI_FXML/Submit.fxml");
        try {
            Submit= FXMLLoader.load(url7);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("error");
        }
        Scene scene=new Scene(Login);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    private void show_Scenes() throws IOException
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
        URL url5=  getClass().getClassLoader().getResource("UI_FXML/Credit_Scene.fxml");
        try {
            Credit= FXMLLoader.load(url5);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("error");
        }
        URL url6=  getClass().getClassLoader().getResource("UI_FXML/Clothes_Donation.fxml");
        try {
            Clothes= FXMLLoader.load(url6);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("error");
        }

        URL url7=  getClass().getClassLoader().getResource("UI_FXML/Submit.fxml");
        try {
            Submit= FXMLLoader.load(url7);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("error");
        }

    }




}
