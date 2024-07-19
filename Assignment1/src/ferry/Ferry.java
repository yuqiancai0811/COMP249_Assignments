

package ferry;

import transportation.Transportation;
public class Ferry extends Transportation {
    /**
     * attributes
     */
    private double maxSpeed;
    private double maxLoad;
    private static long serialNumCtr = 70000;
    private long serialNum;
    private String classStr="Ferry";


    /**
     * default constructor
     */
    public Ferry() {
        super("Ferry");
        this.serialNum = serialNumCtr++;
    }


    /**
     * parameterized constructor
     * @param maxSpeed the max speed of ferry
     * @param maxLoad the maxmium loading weight of ferry
     */
    public Ferry(double maxSpeed, double maxLoad) {
        super("Ferry");
        this.maxSpeed=maxSpeed;
        this.maxLoad = maxLoad;
        this.serialNum = serialNumCtr++;
    }

    /**
     *copy constructor
     * @param copy copy all attributes except serial number for a new ferry
     */
    public Ferry(Ferry copy) {
        super("Ferry");
        this.maxSpeed=copy.maxSpeed;
        this.maxLoad = copy.maxLoad;
        this.serialNum = Ferry.serialNumCtr++;
    }

    //setter and getter method

    /**
     * getter for the maximum of speed
     * @return double: the maximum of speed
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * setter for the maximum of speed
     * @param maxSpeed the maximum of speed
     */
    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    /**
     * getter for the maximum load
     * @return double the maximum load
     */
    public double getMaxLoad() {
        return maxLoad;
    }

    /**
     * setter for the maximum load
     * @param maxLoad the maximum load
     */
    public void setMaxLoad(double maxLoad) {
        this.maxLoad = maxLoad;
    }

    public long getSerialNum(){
        return serialNum;}

    /**
     * getNextSerialNumber method
     * @return long the next serial number
     */
    public static long getNextSerialNumber() {
        return serialNumCtr++;
    }

    //ToString method

    /**
     * overriding the toString method
     * @return the class name and the ferry's serial number, max speed
     * and maximum load
     */
    public String toString() {
        return "This " + classStr + " - serial #" + getSerialNum() + "- has a maximum load of " + this.maxLoad
                + " kg, has a maximum speed of " + this.getMaxSpeed() + " km/hr.";
    }

    /**
     * Overriding the default equal method
     * @param x the object
     * @return boolean: true if the object x is a ferry and
     * has the same max load and max speed.
     */
    public boolean equals(Object x) {
        if (x == null || this == null || x.getClass() != this.getClass())
            return false;
        else {
            // cast the passed object to a ferry object
            Ferry f = (Ferry) x;
            return (this.getMaxLoad() == f.getMaxLoad()
                    && this.getMaxSpeed() == f.getMaxSpeed());
        }
    }
    /**
     *define abstract clone method
     * @return a new object ferry by copy constructor
     */
    public Ferry clone(){
        return new Ferry(this);
    }
}
