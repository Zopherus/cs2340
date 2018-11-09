package cs2340.donationtracker.model;

<<<<<<< HEAD
public class jLocation {
=======
import java.util.ArrayList;
import java.util.HashMap;
/**
 * @author      Eric
 * @version     1.0
 * @since       1.2
 */
public class Location {
>>>>>>> 814e76885da791ad176487316363fd0e9858bfd2

    private String name;
    private String type;
    private double latitude;
    private double longitude;
    private String streetAddress;
    private String city;
    private String state;
    private int zip;
    private String phone;
    public HashMap<String, Object> donations = new HashMap<>(); //For firebase
    public ArrayList<Donation>  donationArrayList = new ArrayList<>();

    /**
     * creates a new location without setting any of the attributes
     */
    public Location(){}

    /**
     * creates a location with the parameters passed in
     * @param name
     * @param type
     * @param latitude
     * @param longitude
     * @param streetAddress
     * @param city
     * @param state
     * @param phone
     * @param zip
     */
    public Location(String name, String type, double latitude, double longitude, String streetAddress,
                    String city, String state, String phone, int zip) {
        this.name = name;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }


    /**
     * @return the type of the location
     */
    public String getType() {
        return type;
    }

    /**
     * sets the location's type to the parameter passed in
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the street address of the location
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * sets the street address to the passed in string
     * @param streetAddress
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * @return the city of the location
     */
    public String getCity() {
        return city;
    }

    /**
     * sets the city of the location to the city that is passed in
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state that the location is in
     */
    public String getState() {
        return state;
    }

    /**
     * sets the state of the location to the passed in string
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the zipcode of the location
     */
    public int getZip() {
        return zip;
    }

    /**
     * set the zipcode of the location to the passed in int
     * @param zip
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    /**
     * @return the phone number of the location
     */
    public String getPhone() {
        return phone;
    }

    /**
     * sets the phone number of the location to the string passed in
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the name of the location
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the location to the passed in string
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the latitude of the location
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * sets the latitude of the location with the passed in double
     * @param latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude of the location
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * sets the longitude of the location to the passed in
     * @param longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
