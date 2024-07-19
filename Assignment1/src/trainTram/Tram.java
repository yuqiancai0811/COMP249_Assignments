
package trainTram;

import metro.Metro;

public class Tram extends Metro {
    /**
     * attributes
     */
    private int creationYear;
    private static long serialNumCtr = 30000;
    private long serialNum;

    /**
     * default constructor
     */
    public Tram() {
        classStr = "Tram";
        this.serialNum = serialNumCtr++;
    }

    /**
     * parameterized constructor
     *
     * @param numOfWheels      the number of wheels
     * @param maxSpeed         the max speed
     * @param numOfVehicles    the number of vehicles
     * @param startStationName the start station's name
     * @param destinationName  the destination name
     * @param totalStops       the number of total stops
     * @param creationYear     the creation year of the tram
     */
    public Tram(int numOfWheels, double maxSpeed, int numOfVehicles, String startStationName, String destinationName, int totalStops, int creationYear) {
        super(numOfWheels, maxSpeed, numOfVehicles, startStationName, destinationName, totalStops);
        classStr = "Tram";
        this.creationYear = creationYear;
        this.serialNum = serialNumCtr++;
    }

    /**
     * copy constructor
     *
     * @param copy copy all attributes except serial number for a new Tram
     */
    public Tram(Tram copy) {
        super(copy);
        classStr = "Tram";
        this.creationYear = copy.creationYear;
        this.serialNum = Tram.serialNumCtr++;
    }

    //setter and getter method

    /**
     * getter for the creation year
     *
     * @return int: the creation year
     */
    public int getCreationYear() {
        return creationYear;
    }

    /**
     * setter for the creation year
     *
     * @param creationYear the creation year
     */
    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public long getSerialNum(){
        return serialNum;}
    /**
     * static getNextSerialNumber method
     * @return long: the next serial number
     */
    public static long getNextSerialNumber() {
        return serialNumCtr++;
    }
    /**
     * Overriding the toString method
     *
     * @return the class name, the tram's serial number, number of wheels
     * maximum speed, number of vehicles, start station name, destination name
     * creation year and total stops
     */
    public String toString() {
        return "This " + classStr + " - serial #" + getSerialNum() + " - has " + getNumOfWheels()
                + " wheels, has a maximum speed of " + getMaxSpeed() + " km/hr." + " It has " + getNumOfVehicles() + " vehicles and its starting and destination stations are "
                + getStartStationName() + " and " + getDestinationName() + ". The total stops are " + getTotalStops() + " stops. The year of creation is " + getCreationYear();
    }


    /**
     * Overriding the default equals method
     *
     * @param x the object
     * @return boolean: true if the object x is a tram and
     * has the same serial number, number of wheels,maximum speed,
     * number of vehicles, start station name, destination name
     * creation year and total stops.
     */

    public boolean equals(Object x) {
        if (x == null || this == null || x.getClass() != this.getClass())
            return false;
        else {
            // cast the passed object to a WheeledTransportation object
            Tram tm = (Tram) x;
            return (this.getNumOfWheels() == tm.getNumOfWheels() &&
                    this.getMaxSpeed() == tm.getMaxSpeed()) &&
                    this.getStartStationName() == tm.getStartStationName() &&
                    this.getNumOfVehicles() == tm.getNumOfVehicles() &&
                    this.getDestinationName() == tm.getDestinationName() &&
                    this.getTotalStops() == tm.getTotalStops() &&
                    this.getCreationYear() == tm.getCreationYear();
        }
    }

    /**
     * define abstract clone method
     *
     * @return a new object tram by copy constructor
     */
    public Tram clone() {
        return new Tram(this);
    }
}
