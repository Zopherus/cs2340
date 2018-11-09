package cs2340.donationtracker.model;
/**
 * @author      Eric
 * @version     1.0
 * @since       1.2
 */
public class Account {

    private String name;
    private String username;
    private String password;


    private AccountType accountType;

    /**
     * creates an account with the default values
     * default username: user
     * default password: pass
     */
    public Account() {
        this("user", "pass");
    }

    /**
     * creates an account with the given username and password
     * sets default name to empty string
     * @param username the username
     * @param password the password
     */
    public Account(String username, String password) {
        this("", username, password, AccountType.User);
    }

    /**
     * makes an account with the given name, username, password, and account type
     * @param name the name of the person
     * @param username the username of the account
     * @param password the password of the account
     * @param accountType the account type of the account
     */
    public Account(String name, String username, String password, AccountType accountType ) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    }

    /**
     * @return - the name in the account
     */
    public String getName() { return name; }

    /**
     * sets the name on the account to the provided name
     * @param name
     */
    public void setName(String name) { this.name = name; }
    /**
     * @return - the username in the account
     */
    public String getUsername() { return username; }

    /**
     * sets the username to the string passed in
     * @param newUser
     */
    public void setUsername(String newUser) { username = newUser; }

    /**
     * @return - the password for the account
     */
    public String getPassword() { return password; }

    /**
     * sets the password to the string passed in
     * @param newPass
     */
    public void setPassword(String newPass) { password = newPass; }

    /**
     * @return - what type of account it is
     */
    public AccountType getAccountType() { return accountType; }

    /**
     * sets the account type to the account type that is passed in
     * @param accountType
     */
    public void setAccountType(AccountType accountType) { this.accountType = accountType; }

    /**
     * checks if the username and password passed in are correct and valid
     * @param user
     * @param pass
     * @return true if they are correct/valid, false if they are not
     */
    public boolean checkValid(String user, String pass) {
        return user.equals(username) && pass.equals(password);
    }
}
