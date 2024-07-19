
package monowheel;

import wheeledTransportation.WheeledTransportation;

public class Monowheel extends WheeledTransportation {
    /**
     * attributes
     */
    private double maxWeight;
    private static long serialNumCtr = 55000;
    private long serialNum;


    /**
     * default constructor
     */
    public Monowheel() {
        classStr = "Monowheel";
        this.serialNum = serialNumCtr++;

    }


    /**
     * parameterized constructor
     * @param numOfWheels the number of wheels
     * @param maxSpeed the max speed
     * @param maxWeight the maximum of loading weight
     */
    public Monowheel(int numOfWheels, double maxSpeed, double maxWeight) {
        super(numOfWheels, maxSpeed);
        classStr = "Monowheel";
        this.maxWeight = maxWeight;
        this.serialNum = serialNumCtr++;
    }

    /**
     * copy constructor
     * @param copy copy all attributes except serial number for a new Mono wheel
     */
    public Monowheel(Monowheel copy) {
        super(copy);
        classStr = "Monowheel";
        this.maxWeight = copy.maxWeight;
        this.serialNum = Monowheel.serialNumCtr++;

    }

    /* setter and getter method */

    /**
     * getter for the maximum of loading weight
     * @return double: the maximum of loading weight
     */
    public double getMaxWeight() {
        return maxWeight;
    }

    /**
     * setter for the maximum of loading weight
     * @param maxWeight the maximum of loading weight
     */
    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
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
     * Overriding the toString method
     * @return the class name and the mono wheel's serial number,
     * number of wheels and the max speed and the maximum of loading weight
     */
    public String toString() {
        return "This " + classStr + " - serial #" + serialNum + " - has " + getNumOfWheels()
                + " wheels, has a maximum speed of " + getMaxSpeed() + " km/hr." + " The maximum weight is " + getMaxWeight() + "kg";
    }

    /**
     * Overriding the default equal method
     * @param x the object
     * @return boolean: true if the object x is a mono wheel and
     * has the same number of wheel and max speed.
     */
    public boolean equals(Object x) {
        if (x == null || this == null || x.getClass() != this.getClass())
            return false;
        else {
            // cast the passed object to a WheeledTransportation object
            Monowheel mw = (Monowheel) x;
            return (this.getNumOfWheels() == mw.getNumOfWheels()
                    && this.getMaxSpeed() == mw.getMaxSpeed() &&
                    this.getMaxWeight() == mw.getMaxWeight());
        }
    }

    /**
     *define abstract clone method
     * @return a new object Mono wheel by copy constructor
     */
    public Monowheel clone() {
        super.clone();
        return new Monowheel(this);
    }
}

