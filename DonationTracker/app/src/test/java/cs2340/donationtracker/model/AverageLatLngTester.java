package cs2340.donationtracker.model;

import com.google.android.gms.maps.model.LatLng;

import org.junit.Test;

import java.util.ArrayList;

import static cs2340.donationtracker.MapActivity.averageLatLng;
import static org.junit.Assert.*;

public class AverageLatLngTester {
    @Test
    public void emptyLocationArrayLatTest() {
        ArrayList<Location> emptyLocations = new ArrayList<>();
        assertEquals(new IllegalArgumentException("ArrayList size 0 results in divide by 0.0, and"
                + "thus Infinity"), averageLatLng(emptyLocations));
    }


    @Test
    public void regularArrayTest() {
        ArrayList<Location> locations = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            locations.add(new Location("TestName", "TestType", i, i,
                    "testStreetAddress",
                    "testCity", "testState", "TestPhone", 30005));
        }
        assertEquals(new LatLng(50.5, 50.5), averageLatLng(locations));
    }


    @Test
    public void arrayLength1Test() {
        ArrayList<Location> list = new ArrayList<>();
        list.add(new Location("TestName", "TestType", 1, 1, "TestStreetAddress", "TestCity", "testState", "TestPhone", 30005));
        assertEquals(new LatLng(1, 1), averageLatLng(list));

    }

    @Test
    public void arrayListofZerosTest() {
        ArrayList<Location> zeros = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            zeros.add(new Location("TestName", "TestType", 0, 0,
                    "TestStreetAddress", "TestCity", "testState",
                    "TestPhone", 30005));

        }
        assertEquals(new LatLng(1, 1), averageLatLng(zeros));
    }

    @Test
    public void arrayWithNegativesTest() {
        ArrayList<Location> negLocations = new ArrayList<>();
        for (int i = -1; i >= -100; i--) {
            negLocations.add(new Location("TestName", "TestType", i, i,
                    "testStreetAddress",
                    "testCity", "testState", "TestPhone", 30005));
        }
        assertEquals(new LatLng(-50.5, -50.5), averageLatLng(negLocations));
    }

    @Test
    public void arrayWithPosAndNegTest() {
        ArrayList<Location> allLocations = new ArrayList<>();
        for (int i = -5; i >= 5; i++) {
            allLocations.add(new Location("TestName", "TestType", i, i,
                    "testStreetAddress",
                    "testCity", "testState", "TestPhone", 30005));
        }
        assertEquals(new LatLng(0, 0), averageLatLng(allLocations));
    }
}