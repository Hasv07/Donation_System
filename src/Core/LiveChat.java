package Core;

public interface LiveChat {
    void sendMessage(String message,User user);
    void addUser(User user);
}
