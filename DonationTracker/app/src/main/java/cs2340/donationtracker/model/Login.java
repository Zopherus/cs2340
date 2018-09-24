package cs2340.donationtracker.model;

public class Login {

    private String username;
    private String password;

    public Login() {
        this("user", "pass");
    }

    public Login(String user, String pass) {
        username = user;
        password = pass;
    }

    public String getUsername() { return username; }
    public void setUsername(String newUser) { username = newUser; }

    public String getPassword() { return password; }
    public void setPassword(String newPass) { password = newPass; }

    public boolean checkValid(String user, String pass) {
        return user.equals(username) && pass.equals(password);
    }
}
