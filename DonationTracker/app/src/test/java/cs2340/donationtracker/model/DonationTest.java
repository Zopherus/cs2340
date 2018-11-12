package cs2340.donationtracker.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author Jessie Tepper
 * @version 1.0
 */

public class DonationTest {
    private Location location = new Location("l1", "charity", 0, 0, "hello hello hello", "hello", "hello",
            "hello", 30000);
    private Donation donation1 = new Donation(1.0, location, "1/1/18", "items", "clothes");
    private Donation donation2 = new Donation(1.0, location, "1/1/18", "items", "clothes");
    private Donation donation3 = new Donation(1.0, location, "1/1/18", "items", "clothes");
    public ArrayList<Donation> donations = new ArrayList<>();
    Database data = new Database();

    @Test
    public void donationNull() {
        donations.add(donation1);
        donations.add(donation2);
        donations.add(donation3);
    }

    @Test
    public void donationAdded() {
        donations.add(donation1);
        donations.add(donation2);
        donations.add(donation3);
    }

    @Test
    public void findDonation1() {
        donations.add(donation1);
        donations.add(donation2);
        donations.add(donation3);
    }

    @Test
    public void findDonation2() {
        donations.add(donation1);
        donations.add(donation2);
        donations.add(donation3);
    }

    @Test
    public void findDonation3() {
        donations.add(donation1);
        donations.add(donation2);
        donations.add(donation3);
    }
}
