package transportation;


//package transportation;

/**
 * an abstract class, being a parent class but cannot for
 * creating new an object as transportation
 */
public abstract class Transportation {
    /**
     * attributes
     */
    protected static long serialNumCtr;
    protected long serialNum;
    protected String classStr;


    /**
     * parameterized constructor
     * @param classStr the class name of a transportation
     */
    public Transportation(String classStr){
        this.classStr=classStr;
        this.serialNum=serialNumCtr++;}

    /**
     * copy constructor
     * @param copy copy all attributes except serial number for a Transportation
     */
    public Transportation(Transportation copy){
        this.classStr= copy.classStr;
        this.serialNum=serialNumCtr++;}

    //getter and setter method

    /**
     * getter for the serial number
     * @return long: the serial number
     */
    public long getSerialNum(){
    return serialNum;}

    /**
     * setter for the serial number
     * @param serialNum the serial number
     */
    public void setSerialNum(long serialNum){
        this.serialNum = serialNum+serialNumCtr++;
    }

    /**
     * getter for the class name
     * @return String: the class name
     */

    public String getClassStr(){
        return classStr;
    }

    /**
     *setter for the class name
     * @param classStr the class name
     */
    public void setClassStr(String classStr){
        this.classStr=classStr;
    }

    /**
     * static getNextSerialNumber method
     * @return long: the next serial number
     */
    public static long getNextSerialNumber() {
        return serialNumCtr++;
    }
    /**
     *abstract method for deep copy
     * @return will be writing in the child classes
     */
    abstract public Transportation clone();
    abstract public String toString();

}

