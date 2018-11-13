package cs2340.donationtracker;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import cs2340.donationtracker.model.Database;
import cs2340.donationtracker.model.Location;
/**
 * Map Activity to show map of locations
 *
 * @author Eric Zhu
 * @version 1.0
 */
public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    /**
     * sets view to show the map when this screen is called
     *
     * @param savedInstanceState Bundle object
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_screen);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        for (Location location : Database.locations) {
            LatLng l = new LatLng(location.getLatitude(), location.getLongitude());
            googleMap.addMarker(new MarkerOptions().position(l).title(location.getName() + " " + location.getPhone()));
        }
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(averageLatLng(Database.locations), 10));
    }

    /**
     * Finds average latitude and longitude and places in a LatLng object
     *
     * @param locations, arrayList of locations
     * @return new LatLng() object
     */
    public static LatLng averageLatLng(ArrayList<Location> locations) {
        double avgLat = 0;
        double avgLong = 0;
        double count = 0;
        for (Location location : locations) {
            avgLat += location.getLatitude();
            avgLong += location.getLongitude();
            count++;
        }
        return new LatLng(avgLat/count, avgLong/count);
    }
}