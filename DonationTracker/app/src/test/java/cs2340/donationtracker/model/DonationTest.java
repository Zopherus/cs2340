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
    private Donation donation3 = null;
    public ArrayList<Donation> donations = new ArrayList<>();

    @Test
    public void donationNull() {
        assertNull(donation3);
        assertEquals(null, donation3.getValue());
        assertEquals(null, donation3.getName());
        assertEquals(null, donation3.getType());
        assertEquals(null, donation3.getLocation());
    }

    @Test
    public void donationNotNull() {
        assertNotNull(donation1);
        assertNotNull(donation2);
        assertSame(donation1, donation2);
        assertNotNull(donation1.getLocation());
        assertNotNull(donation1.getValue());
        assertNotNull(donation1.getName());
        assertNotNull(donation1.getType());
    }

    @Test
    public void findDonation1() {
        donations.add(donation1);
        donations.add(donation2);
        donations.add(donation3);
        assertEquals(donation1, donations.get(0));
    }

    @Test
    public void findDonation2() {
        donations.add(donation1);
        donations.add(donation2);
        donations.add(donation3);
        assertEquals(donation2, donations.get(1));
    }

    @Test
    public void findNullDonation() {
        donations.add(donation1);
        donations.add(donation2);
        donations.add(donation3);
        assertNull(donations.get(2));
    }
}
