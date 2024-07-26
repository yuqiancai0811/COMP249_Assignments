// -----------------------------------------------------
// Comp 249
// Assignment 3
// Written by: Yuqian Cai
// -----------------------------------------------------
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * CellPhone class
 */
class CellPhone {
    /**
     * attribute serialNum
     */
    private long serialNum;
    /**
     * attribute brand
     */
    private String brand;
    /**
     * attribute year
     */
    private int year;
    /**
     * attribute price
     */
    private double price;

    /**
     *default constructor
     */
    public CellPhone() {
        this.serialNum = 0;
        this.brand = null;
        this.year = 0;
        this.price = 0;
    }

    /**
     * Parameterized constructor
     *
     * @param serialNum
     * @param brand
     * @param price
     * @param year
     */
    CellPhone(long serialNum, String brand, double price, int year) {
        this.serialNum = serialNum;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    /**
     * copy constructor
     *
     * @param c
     * @param newSerialNum
     */

    CellPhone(CellPhone c, long newSerialNum) {
        setBrand(c.getBrand());
        setPrice(c.getPrice());
        setYear(c.getYear());
        serialNum = newSerialNum;
    }

    /** serial number getter
     * @return serial number
     */
    public long getSerialNum() {
        return serialNum;
    }

    /**serial number setter
     * @param serialNum
     */
    public void setSerialNum(long serialNum) {
        this.serialNum = serialNum;
    }

    /**brand getter
     * @return String brand
     */
    public String getBrand() {
        return brand;
    }

    /** brand setter
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /** year getter
     * @return int year
     */
    public int getYear() {
        return year;
    }

    /** year setter
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**price getter
     * @return double price
     */
    public double getPrice() {
        return price;
    }

    /**price getter
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /** clone method
     * @return a new cellphone object with a new user input serial number
     */
    public CellPhone clone() {
        Scanner kb = new Scanner(System.in);
        long newSerialNum;
        CellPhone clonedPhone;
        System.out.println("Please enter a new serial number for this phone:");
        while (true) {
            try {
                newSerialNum = kb.nextLong();
                clonedPhone = new CellPhone(this, newSerialNum);
                System.out.println("Successfully cloned the phone: " + clonedPhone);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value:");
                kb.nextLine(); // Clear the invalid input
            } catch (NoSuchElementException e) {
                System.out.println("No input available. Defaulting to original serial number.");
            }
        }
        return clonedPhone;
    }

    /**toString method
     * @return the info of the cellphone include serial number, price, brand and creation year
     */
    @Override
    public String toString() {
        return " [" + serialNum + ": " + brand + " " + price + "$ " + year + "] ";
    }

    /** equals method to check 2 cellphones objects are same or not, exclude their serial numbers
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == null || obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        CellPhone c = (CellPhone) obj;
        return this.getBrand().equals(c.getBrand()) &&
                this.getPrice() == c.getPrice() &&
                this.getYear() == c.getYear();
    }
}
