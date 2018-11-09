package cs2340.donationtracker.model;

import java.util.ArrayList;
/**
 * @author      Eric
 * @version     1.0
 * @since       1.2
 */
public class Database {
    public static ArrayList<Account> accounts = new ArrayList<>();
    public static ArrayList<Location> locations = new ArrayList<Location>();

    /**
     * looks up if there is a location with the passed in name
     * @param name - the name of the location you want to find
     * @return - the location if there is a location with that name, else null
     */
    public static Location locationLookup(String name) {
        if (name == null) {
            return null;
        }
        for (Location location : locations) {
            if (location.getName().equals(name))
                return location;
        }
        return null;
    }
}
