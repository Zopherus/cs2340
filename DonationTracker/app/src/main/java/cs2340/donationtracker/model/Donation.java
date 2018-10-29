package cs2340.donationtracker.model;

public class Donation {
    private double value;
    private Location location;
    private String date;
    private String name;

    public Donation(double value, Location location, String date, String name){
        this.value = value;
        this.location = location;
        this.date = date;
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name:" + name + ", value: " + value;
    }
}