
package aircraftWW2airplane;
import transportation.Transportation;

/**
 * child class Aircraft which extends the abstract class Transportation
 */
public class Aircraft extends Transportation {
    /**
     * attributes
     */
    private double price;
    private double maxElevation;
    private static long serialNumCtr = 0;
    private long serialNum;

    protected String classStr = "Aircraft";


    /**
     * default constructor
     */
    public Aircraft() {
        super("Aircraft");
        this.serialNum = serialNumCtr++;
    }
    /**
     * parameterized constructor
     * @param price the price of the aircraft
     * @param maxElevation  the maximum elevation of aircraft
     */
    public Aircraft(double price, double maxElevation) {
        super("Aircraft");
        this.price = price;
        this.maxElevation = maxElevation;
        this.serialNum = serialNumCtr++;

    }

    /**
     *copy constructor
     * @param copy copy all attributes except serial number for a new Aircraft
     */    public Aircraft(Aircraft copy) {
        super("Aircraft");
        this.price = copy.price;
        this.maxElevation = copy.maxElevation;
        this.serialNum = Aircraft.serialNumCtr++;
    }

    //setter and getter method

    /**
     * getter for the price
     * @return double the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * setter for the price
     * @param price: the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * getter for the maximum of elevation
     * @return double: the maximum of elevation
     */
    public double getMaxElevation() {
        return maxElevation;
    }

    /**
     * setter for the maximum of elevation
     * @param maxElevation the maximum of elevation
     */
    public void setMaxElevation(double maxElevation) {
        this.maxElevation = maxElevation;
    }
    
    public long getSerialNum(){
        return serialNum;}

    /**
     * getNextSerialNumber method
     * @return long: the next mono wheel's serial number
     */
    public static long getNextSerialNumber() {
        return serialNumCtr++;
    }

    /**
     *Overriding the ToString method
     * @return the class name and the plane's price, the maximum of elevation
     */
    public String toString() {
        return "This " + this.classStr + " - serial # " + getSerialNum() + " price is " + getPrice() + " million and it has a maximum elevation of " + getMaxElevation() + "km ";
    }

    /**
     * Overriding the default equal method
     * @param x the object
     * @return boolean: true if the object x is an aircraft and
     * has the same price, the maximum of elevation
     */
    public boolean equals(Object x) {
        if (x == null || this == null || x.getClass() != this.getClass())
            return false;
        else {
            // cast the passed object to a WheeledTransportation object
            Aircraft a = (Aircraft) x;
            return (this.getPrice() == a.getPrice()
                    && this.getMaxElevation() == a.getMaxElevation());
        }
    }
    /**
     *define abstract clone method
     * @return a new object WW2Airplane by copy constructor
     */
    public Aircraft clone(){
        return new Aircraft(this);
    }

}
