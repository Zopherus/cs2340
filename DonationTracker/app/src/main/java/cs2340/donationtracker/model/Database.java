package cs2340.donationtracker.model;

import java.util.ArrayList;

public class Database {
    public static ArrayList<Account> accounts = new ArrayList<Account>();
    public static ArrayList<Location> locations = new ArrayList<Location>();

    public static Location locationLookup(String name) {
        for (Location location : locations) {
            if (location.getName().equals(name))
                return location;
        }
        return null;
    }
}
