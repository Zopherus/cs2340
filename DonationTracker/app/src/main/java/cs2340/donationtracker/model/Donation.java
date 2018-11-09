package cs2340.donationtracker.model;
/**
 * @author      Eric
 * @version     1.0
 * @since       1.2
 */
public class Donation {
    private double value;
    private Location location;
    private String date;
    private String name;
    private String type;

    /**
     * creates a donation without specifying anything about it
     */
    public Donation(){}

    /**
     * creates a donation with the passed in value, location, date, and name
     * @param value
     * @param location
     * @param date
     * @param name
     * @param type
     */
    public Donation(double value, Location location, String date, String name, String type){
        this.value = value;
        this.location = location;
        this.date = date;
        this.name = name;
        this.type = type;
    }

    /**
     * @return - the value of the donation
     */
    public double getValue() {
        return value;
    }

    /**
     * sets the value of the donation with the passed in parameter
     * @param value
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * @return - the location of the donation
     */
    public Location getLocation() {
        return location;
    }

    /**
     * sets the location of the donation to the location that is passed in
     * @param location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @return - the date of the donation
     */
    public String getDate() {
        return date;
    }

    /**
     * sets the date of the donation as the passed in string
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return - the name on the donation
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name on the donation to the string that is passed in
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * a way to print the donation information
     * @return - a string with the name and value of the donation
     */
    @Override
    public String toString() {
        return "Name:" + name + ", value: " + value;
    }
}