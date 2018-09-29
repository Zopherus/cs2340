package cs2340.donationtracker.model;

public class Account {

    private String name;
    private String username;
    private String password;


    private AccountType accountType;


    public Account() {
        this("user", "pass");
    }

    public Account(String username, String password) {
        this("", username, password, AccountType.User);
    }

    public Account(String name, String username, String password, AccountType accountType ) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUsername() { return username; }
    public void setUsername(String newUser) { username = newUser; }

    public String getPassword() { return password; }
    public void setPassword(String newPass) { password = newPass; }

    public AccountType getAccountType() { return accountType; }
    public void setAccountType(AccountType accountType) { this.accountType = accountType; }

    public boolean checkValid(String user, String pass) {
        return user.equals(username) && pass.equals(password);
    }
}
