package cs2340.donationtracker.model;
/**
 * @author      Eric
 * @version     1.0
 * @since       1.2
 */

/**
 * types of accounts that can be created
 */
public enum AccountType {
    /**
     * administrator - can unlock other people's accounts
     */
    Admin,
    /**
     * location employee - someone who works at that location
     */
    LocationEmployee,
    /**
     * user - someone who is making a donation
     */
    User;
}
