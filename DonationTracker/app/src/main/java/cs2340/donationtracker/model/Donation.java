package cs2340.donationtracker.model;

public class Donation {
    private double value;
    private Location location;
    private String date;
    private String name;
    private String type;

    public Donation(){}

    public Donation(double value, Location location, String date, String name, String type){
        this.value = value;
        this.location = location;
        this.date = date;
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Name:" + name + ", value: " + value;
    }
}