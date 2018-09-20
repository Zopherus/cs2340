package cs2340.donationtracker.model;

public class Model {
    private static final Model instance = new Model();
    public static Model getInstance() { return instance; }

    private Login login;

    private Model() {
        login = new Login();
    }

    public Login getLogin() { return login; }
    public void setLogin(Login login) { this.login = login; }
}
