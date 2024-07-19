
package metro;
import trainTram.*;
public class Metro extends Train {
    /**
     * attributes
     */
    private int totalStops;
    private static long serialNumCtr = 25000;
    private long serialNum;


    /**
     * default constructor
     */
    public Metro() {
        classStr = "Metro";
        this.serialNum = serialNumCtr++;
    }

    /**
     * parameterized constructor
     * @param numOfWheels the number of wheels
     * @param maxSpeed the max speed
     * @param numOfVehicles the number of vehicles
     * @param startStationName the start station's name
     * @param destinationName the destination name
     * @param totalStops the number of total stops
     */
    public Metro(int numOfWheels, double maxSpeed, int numOfVehicles, String startStationName, String destinationName, int totalStops) {
        super(numOfWheels, maxSpeed, numOfVehicles, startStationName, destinationName);
        classStr = "Metro";
        this.totalStops = totalStops;
        this.serialNum = serialNumCtr++;
    }


    /**
     * copy constructor
     * @param copy copy all attributes except serial number for a new metro
     */
    public Metro(Metro copy) {
        super(copy);
        classStr = "Metro";
        this.totalStops = copy.getTotalStops();
        this.serialNum = Metro.serialNumCtr++;
    }
    //setter and getter method

    /**
     * getter for the number of total stops
     * @return int: the number of total stops
     */
    public int getTotalStops() {
        return totalStops;
    }

    /**
     * setter  for the number of total stops
     * @param totalStops the number of total stops
     */
    public void setTotalStops(int totalStops) {
        this.totalStops = totalStops;
    }

    public long getSerialNum(){
        return serialNum;}
    /**
     * getNextSerialNumber method
     * @return long:  the next serial number
     */
    public static long getNextSerialNumber() {
        return serialNumCtr++;
    }

    /**
     * Overriding the toString method
     * @return the class name, the tram's serial number, number of wheels
     *maximum speed, number of vehicles, start station name, destination name
     * and the total number of stops
     */
    public String toString() {
        return "This " + classStr + " - serial #" + this.serialNum + " - has " + getNumOfWheels()
                + " wheels, has a maximum speed of " + getMaxSpeed() + " km/hr." + " It has " + getNumOfVehicles() + " vehicles and its starting and destination stations are "
                + getStartStationName() + " and " + getDestinationName() + ". The total stops are " + getTotalStops() + " stops.";
    }

    /**
     *Overriding the default equals method
     * @param x the object
     * @return boolean: true if the object x is a train and
     * has the same serial number, number of wheels,maximum speed,
     * number of vehicles, start station name, destination name
     *  and the total number of stops.
     */
    public boolean equals(Object x) {
        if (x == null || this == null || x.getClass() != this.getClass())
            return false;
        else {
            // cast the passed object to a WheeledTransportation object
            Metro m = (Metro) x;
            return (this.getNumOfWheels() == m.getNumOfWheels() &&
                    this.getMaxSpeed() == m.getMaxSpeed()) &&
                    this.getStartStationName() == m.getStartStationName() &&
                    this.getNumOfVehicles() == m.getNumOfVehicles() &&
                    this.getDestinationName() == m.getDestinationName() &&
                    this.getTotalStops() == m.getTotalStops();
        }
    }

    /**
     *define abstract clone method
     * @return a new object metro by copy constructor
     */
    public Metro clone() {
        return new Metro(this);
    }
}


