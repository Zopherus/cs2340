package cs2340.donationtracker.model;

import org.junit.*;
import java.util.ArrayList;
import static org.junit.Assert.*;
/**
 * @author Eric Zhu
 * @version 1.0
 */
public class RemoveDonationTest {
    private static Location location = new Location();
    private static Donation d1 = new Donation(10, location, "", "First", "");
    private static Donation d2 = new Donation(10, location, "", "Second", "");
    private static Donation d3 = new Donation(10, location, "", "Third", "");

    @Test
    public void DonationFirstItem() {
        location = new Location();
        location.donationArrayList.add(d1);
        location.donationArrayList.add(d2);
        location.donationArrayList.add(d3);
        assertTrue(location.removeDonation("First"));
        assertEquals(location.donationArrayList.size(), 2);
        assertEquals(location.donationArrayList.get(0).getName(), "Second");
    }

    @Test
    public void DonationLastItem() {
        location = new Location();
        location.donationArrayList.add(d1);
        location.donationArrayList.add(d2);
        location.donationArrayList.add(d3);
        assertTrue(location.removeDonation("Third"));
        assertEquals(location.donationArrayList.size(), 2);
        assertEquals(location.donationArrayList.get(0).getName(), "First");
    }

    @Test
    public void DonationNotExist() {
        location = new Location();
        location.donationArrayList.add(d1);
        location.donationArrayList.add(d2);
        location.donationArrayList.add(d3);
        assertFalse(location.removeDonation("Not a donation"));
        assertEquals(location.donationArrayList.size(), 3);
        assertEquals(location.donationArrayList.get(0).getName(), "First");
    }
}