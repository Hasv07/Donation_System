package Core;

public abstract class Form {
   private String userName;
    private String passWord;

    public Form() {
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.passWord = password;
    }
}
