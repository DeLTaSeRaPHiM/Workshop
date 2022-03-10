package workshop.database;

public class Users {
    private String userID;
    private String login;
    private String password;
    private String accessKey;

    public Users(String userID, String login, String password, String accessKey) {
        this.userID = userID;
        this.login = login;
        this.password = password;
        this.accessKey = accessKey;
    }

    public Users() {

    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }
}
