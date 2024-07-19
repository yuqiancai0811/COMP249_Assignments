package wheeledTransportation;
import transportation.Transportation;

public class WheeledTransportation extends Transportation {
    /**
     * attributes
     */
    private int numOfWheels;
    private double maxSpeed;
    protected static long serialNumCtr = 0;
    protected long serialNum;

    protected String classStr = "WheeledTransportation";



    /**
     * default constructor
     */
    public WheeledTransportation() {
        super("WheeledTransportation");
        this.serialNum = serialNumCtr++;

    }

    /**
     * parameterized constructor
     * @param numOfWheels number of Wheels of a WheeledTransportation
     * @param maxSpeed max speed of a WheeledTransportation
     */
    public WheeledTransportation(int numOfWheels, double maxSpeed) {
        super("WheeledTransportation");
        this.numOfWheels = numOfWheels;
        this.maxSpeed=maxSpeed;
        this.serialNum = serialNumCtr++;
    }

    /**
     * copy constructor
     * @param copy copy all attributes except serial number for a new WheeledTransportation
     */
    public WheeledTransportation(WheeledTransportation copy) {
        super("WheeledTransportation");
        this.maxSpeed= copy.maxSpeed;
        this.numOfWheels = copy.numOfWheels;
        this.serialNum = WheeledTransportation.serialNumCtr++;
    }

    //setter and getter method
    /**
     * getter for the number of Wheels
     * @return int: the number of Wheels
     */
    public int getNumOfWheels() {
        return numOfWheels;
    }

    /**
     * Setter for the number of Wheels
     * @param numOfWheels the number of Wheels
     */
    public void setNumOfWheels(int numOfWheels) {
        this.numOfWheels = numOfWheels;
    }

    /**
     * Getter for the Max speed
     * @return double : the Max speed
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Setter for the max speed
     * @param maxSpeed the max speed
     */
    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getClassStr() {
        return classStr;
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
     * Overriding the default toString method
     * @return the class name and the WheelTransportation's serial number,
     * number of wheels and the max speed
     */
    public String toString() {
        return "This " + classStr + " - serial #" + getSerialNum() + " - has " + getNumOfWheels()
                + " wheels, has a maximum speed of " + getMaxSpeed() + " km/hr.";
    }

    /**
     * Overriding the default equal method
     * @param x the object
     * @return boolean: true if the object x is a WheeledTransportation and
     * has the same number of wheel and max speed.
     */
    public boolean equals(Object x) {
        if (x == null || this == null || x.getClass() != this.getClass())
            return false;
        else {
            // cast the passed object to a WheeledTransportation object
            WheeledTransportation w = (WheeledTransportation) x;
            return (this.getNumOfWheels() == w.getNumOfWheels()
                    && this.getMaxSpeed() == w.getMaxSpeed());
        }

    }

    /**
     * define abstract clone method
     * @return a new WheeledTransportation as same as this WheeledTransportation
     */
    public WheeledTransportation clone(){
        return new WheeledTransportation(this);
    }

}