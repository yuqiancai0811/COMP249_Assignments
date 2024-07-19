
package trainTram;
import wheeledTransportation.WheeledTransportation;

public class Train extends WheeledTransportation {
    /**
     * attributes
     */
    private int numOfVehicles;
    private String startStationName;
    private String destinationName;
    private  static long serialNumCtr = 10000;
    private long serialNum;

    /**
     * default constructor
     */
    public Train() {
        classStr = "Train";
        this.serialNum = serialNumCtr ++;
    }


    /**
     * parameterized constructor
     * @param numOfWheels the number of wheels
     * @param maxSpeed the max speed
     * @param numOfVehicles the number of vehicles
     * @param startStationName the start station's name
     * @param destinationName the destination name
     */
    public Train(int numOfWheels, double maxSpeed, int numOfVehicles, String startStationName, String destinationName) {
        super(numOfWheels, maxSpeed);
        classStr = "Train";
        this.numOfVehicles = numOfVehicles;
        this.startStationName = startStationName;
        this.destinationName = destinationName;
        this.serialNum = serialNumCtr ++;
    }

    /**
     * copy constructor
     * @param copy copy all attributes except serial number for a new Train
     */
    public Train(Train copy) {
        super(copy);
        classStr = "Train";
        this.numOfVehicles = copy.numOfVehicles;
        this.startStationName = copy.startStationName;
        this.destinationName = copy.destinationName;
        this.serialNum = Train.serialNumCtr ++;

    }

    //setter and getter method

    /**
     * getter for the number of vehicles
     * @return int :the number of vehicles
     */
    public int getNumOfVehicles() {
        return numOfVehicles;
    }

    /**
     * setter for the number of vehicles
     * @param numOfVehicles the number of vehicles
     */
    public void setNumOfVehicles(int numOfVehicles) {
        this.numOfVehicles = numOfVehicles;
    }

    /**
     * getter for the start station's name
     * @return String: the start station's name
     */
    public String getStartStationName() {
        return startStationName;
    }

    /**
     * setter for the start station's name
     * @param startStationName the start station's name
     */
    public void setStartStationName(String startStationName) {
        this.startStationName = startStationName;
    }

    /**
     * getter for the destination name
     * @return String: the destination name
     */
    public String getDestinationName() {
        return destinationName;
    }

    /**
     * setter for the destination name
     * @param destinationName the destination name
     */
    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }
    
    public long getSerialNum(){
        return serialNum;}

    // getNextSerialNumber method

    /**
     * method for getting the Next Serial Number
     * @return long : the Next Serial Number
     */
    public static long getNextSerialNumber() {
        return serialNumCtr++;
    }

    //toString method

    /**
     * Overriding the ToString method
     * @return the class name, the tram's serial number, number of wheels
     * maximum speed, number of vehicles, start station name, destination name
     */
    @Override
    public String toString() {
        return "This " + classStr + " - serial #" + getSerialNum() + " - has " + getNumOfWheels()
                + " wheels, has a maximum speed of " + getMaxSpeed() + " km/hr." + " It has " + getNumOfVehicles() + " vehicles and its starting and destination stations are "
                + getStartStationName() + " and " + getDestinationName();
    }



    /**
     *Overriding the default equals method
     * @param x the object
     * @return boolean: true if the object x is a train and
     * has the same serial number, number of wheels,maximum speed,
     * number of vehicles, start station name, destination name.
     */
    public boolean equals(Object x) {
        if (x == null || this == null || x.getClass() != this.getClass())
            return false;
        else {
            // cast the passed object to a WheeledTransportation object
            Train t = (Train) x;
            return (this.getNumOfWheels() == t.getNumOfWheels() &&
                    this.getMaxSpeed() == t.getMaxSpeed()) &&
                    this.getStartStationName() == t.getStartStationName() &&
                    this.getNumOfVehicles() == t.getNumOfVehicles() &&
                    this.getDestinationName() == t.getDestinationName();
        }
    }
    /**
     *define abstract clone method
     * @return a new object train by copy constructor
     */
    public Train clone(){
        return new Train(this);
    }
}
