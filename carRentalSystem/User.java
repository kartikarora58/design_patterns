package carRentalSystem;

public class User {
    int id;
    String name;
    String drivingLicense;
    Location location;
    public User(int id, String name, String drivingLicense, Location location) {
        this.id = id;
        this.name = name;
        this.drivingLicense = drivingLicense;
        this.location = location;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
