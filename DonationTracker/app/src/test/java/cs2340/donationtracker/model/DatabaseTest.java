package cs2340.donationtracker.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DatabaseTest {
    private Location l1 = new Location("l1", "charity", 0, 0, "hello hello hello", "hello", "hello",
            "hello", 30000);
    private Location l2 = new Location("l2", "charity", 0, 0, "hello hello hello", "hello", "hello",
            "hello", 30000);
    private Location l3 = new Location("l3", "charity", 0, 0, "hello hello hello", "hello", "hello",
            "hello", 30000);
    public ArrayList<Location> locations = new ArrayList<>();
    Database data = new Database();

    @Test
    public void locationLookupNull() {
        locations.add(l1);
        locations.add(l2);
        locations.add(l3);
        data.locations = locations;
        assertNull(data.locationLookup(null));
    }

    @Test
    public void locationLookupExists1() {
        locations.add(l1);
        locations.add(l2);
        locations.add(l3);
        data.locations = locations;
        assertEquals(l1, data.locationLookup("l1"));
    }

    @Test
    public void locationLookupExists2() {
        locations.add(l1);
        locations.add(l2);
        locations.add(l3);
        data.locations = locations;
        assertEquals(l2, data.locationLookup("l2"));
    }

    @Test
    public void locationLookupExists3() {
        locations.add(l1);
        locations.add(l2);
        locations.add(l3);
        data.locations = locations;
        assertEquals(l3, data.locationLookup("l3"));
    }

    @Test
    public void locationLookupNotExist() {
        locations.add(l1);
        locations.add(l2);
        locations.add(l3);
        data.locations = locations;
        Location nonL = new Location("nonL", "charity", 0, 0, "hello hello hello", "hello", "hello",
                "hello", 30000);
        assertNull(data.locationLookup("nonL"));
    }
}