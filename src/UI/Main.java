package UI;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main  extends Application {

    static Stage primaryStage ;


    public void start(Stage primaryStage)  {
        Login_Scene Main_Programe=new Login_Scene();

        Main_Programe.start(primaryStage);
    }

}
