package Core;

public class LoginForm extends Form {
    private int attempts;
    private boolean validation;
    private boolean attemptsValidation;
    // should have list of users from database

    public LoginForm() {
      validation=checkCredentials();  // check validation
        if (validation){             // name and pass is right
            // go to new screen
        }else {                     // name and pass is wrong
            attempts++;
           attemptsValidation=checkAttempt();
            if (attemptsValidation){
                //can try login again
            }else {
                // can not try login again
            }
        }
    }

    boolean checkCredentials(){
        String name =getUserName();
        String pass = getPassword();
        if (true){  //if name and pass equal on of users list
         return true;
        }else{    //if their wrong
            return false;
        }
    }

    Boolean checkAttempt(){
        if(attempts >= 3){
            return false;
        }
        return true;
    }
}
