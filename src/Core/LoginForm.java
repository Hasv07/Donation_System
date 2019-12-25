package Core;

import UI.Login_Scene;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.Scene;

import java.util.ArrayList;


public class LoginForm extends Form {
    public static int attempts;
    private boolean validation;
    private boolean attemptsValidation;
    //private ArrayList<User> myUsers = DatabaseManager.getUser();// should have list of users from database

    public LoginForm(String username,String password) {
        setUserName(username);
        setPassword(password);

      validation=checkCredentials();  // check validation
        if (validation){             // name and pass is right
            // go to new screen
            Scene scene=new Scene(Login_Scene.Main_Menu);
            Login_Scene.primaryStage.setScene(scene);
            Login_Scene.primaryStage.show();
            setLoggedInDonor(DatabaseManager.getInstance().queryDonor(username));
        }else {                     // name and pass is wrong
            attempts++;
            System.out.println(attempts);
           attemptsValidation=checkAttempt();
            if (attemptsValidation){
                //can try login again
            }else {
                // can not try login again
                if (attempts==3){
                    System.out.println("you can not login again close NOW");


                }
            }
        }
            }

    boolean checkCredentials(){

            if (DatabaseManager.getInstance().queryDonor(getUserName()) != null){//if name and pass equal on of users list
                User user=DatabaseManager.getInstance().queryDonor(getUserName());
                if(user.getUsername().equals(getUserName()) && user.getPassword().equals(getPassword())){
                    System.out.println("Checked");
                    return true;
                }

            }

        //if name and pass wrong
        return false;
    }

    Boolean checkAttempt(){ // check number of attempts
        if(attempts >= 3){
            return false;
        }
        return true;
    }
    private static Donor loggedin_doner;
    public static void setLoggedInDonor(Donor donor){
        loggedin_doner=donor;
    }
    public static Donor getLoggedin_doner(){
        return loggedin_doner;
    }
}
