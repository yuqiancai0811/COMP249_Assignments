/**
 *Name(s) and ID(s) Yuqian Cai (40187954)
 * COMP249
 * Assignment # 1
 * Part1
 * Due Date (Oct 15th)
 */

package aircraftWW2airplane;

public class WW2Airplane extends Aircraft {
    /**
     * attributes
     */
    private boolean twinEngine;
    private static  long serialNumCtr = 80000;

    private long serialNum;



    /**
     * default constructor
     */
    public WW2Airplane() {
        classStr="WW2Airplane";
        this.serialNum = serialNumCtr++;
    }


    /**
     * parameterized constructor
     * @param price the price of the World War II 's airplane
     * @param maxElevation the maximum of elevation
     * @param twinEngine whether the plane has twin engines
     */
    public WW2Airplane(double price, double maxElevation, boolean twinEngine) {
        super(price, maxElevation);
        classStr="WW2Airplane";
        this.twinEngine = twinEngine;
        this.serialNum = serialNumCtr++;
    }
    /**
     *copy constructor
     * @param copy copy all attributes except serial number for a new WW2Airplane
     */
    public WW2Airplane(WW2Airplane copy) {
        super(copy);
        classStr="WW2Airplane";
        this.twinEngine= copy.twinEngine;
        this.serialNum = WW2Airplane.serialNumCtr++;
    }

    //setter and getter method

    /**
     * getter for the plane is twin engine
     * @return boolean :the plane is twin engine or not
     */
    public boolean isTwinEngine() {
        return twinEngine;
    }

    /**
     * setter for the plane is twin engine
     * @param twinEngine the plane is twin engine
     */
    public void setTwinEngine(boolean twinEngine) {
        this.twinEngine = twinEngine;
    }
    public long getSerialNum(){
        return serialNum;}

    /**
     * getNextSerialNumber method
     * @return long: the next serial number
     */
    public static long getNextSerialNumber() {
        return serialNumCtr++;
    }


    /**
     * String method for considering twin engines or not
     * @return String
     */
    public String twoEngines() {
        if (!this.isTwinEngine())
            return "no twin Engines";
        else return "twin Engines";
    }

    /**
     *Overriding the ToString method
     * @return the class name and the plane's price, the maximum of elevation
     * and whether it has twin engines
     */
    public String toString() {
        return "This " + this.classStr+" - serial # "+getSerialNum() +
                " price is "+getPrice()+ " million and it has a maximum elevation of "
                +getMaxElevation()+"km " + " It has " + twoEngines();
    }


    /**
     * Overriding the default equal method
     * @param x the object
     * @return boolean: true if the object x is a WW2Airplane and
     * has the same price, the maximum of elevation and whether it has twin engines
     */
    public boolean equals(Object x) {
        if (x == null || this == null || x.getClass() != this.getClass())
            return false;
        else {
            // cast the passed object to w WheeledTransportation object
            WW2Airplane w = (WW2Airplane) x;
            return (this.getPrice() == w.getPrice() &&
                    this.getMaxElevation() == w.getMaxElevation() &&
                    this.isTwinEngine() == w.isTwinEngine());
        }
    }
    /**
     *define abstract clone method
     * @return a new object WW2Airplane by copy constructor
     */
    public WW2Airplane clone(){
        return new WW2Airplane(this);
    }

}
