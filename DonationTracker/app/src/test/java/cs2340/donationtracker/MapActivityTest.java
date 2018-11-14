package cs2340.donationtracker;

import org.junit.Test;

import java.util.ArrayList;
import cs2340.donationtracker.MapActivity;
import cs2340.donationtracker.model.Location;

import static org.junit.Assert.*;

public class MapActivityTest {

    @Test
    public void onMapReady() {
        averageLatLng(new ArrayList<Location>());
    }
}