package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Login_Scene extends Application {
    private Stage primaryStage ;
    private TabPane Login;

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
        Scene scene=new Scene(Login);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
