
package driver;

import aircraftWW2airplane.*;
import ferry.*;
import metro.*;
import monowheel.*;
import trainTram.*;
import transportation.*;
import wheeledTransportation.*;

public class DriverP1 {
    
    /**
     * The method find Least And Most Expensive Aircraft,
     *  if the list only have one Aircraft the Max and Min will be the same,
     *  if the array is null, it will report error.
     * @param list the array of Transportation
     */
    public static void findLeastAndMostExpensiveAircraft(Transportation[] list) {
        Aircraft leastExpensive = null;
        Aircraft mostExpensive = null;

        for (Transportation o : list) {
            if (list.length != 0 && list[0].getClass() != null && (o instanceof Aircraft)) {
                Aircraft aircraft = (Aircraft) o;//for using the method from the Aircraft class
                if (leastExpensive == null || aircraft.getPrice() < leastExpensive.getPrice()) {
                    leastExpensive = aircraft;
                }

                if (mostExpensive == null || aircraft.getPrice() > mostExpensive.getPrice()) {
                    mostExpensive = aircraft;
                }
            }
        }
        if (leastExpensive != null|| mostExpensive!=null) {
            if (list.length == 1) {
                System.out.println("Only one Aircraft found (The Least Expensive and the Most Expensive) is: " + list[0].toString());

            } else {
                System.out.println("The Least Expensive Aircraft:");
                System.out.println(leastExpensive);
                System.out.println("The Most Expensive Aircraft:");
                System.out.println(mostExpensive);
            }
        } else {
            System.out.println("Error, the list of aircraft is null, please enter valid list.");
        }
    }

    public static void main(String[] args) {
        //Create 16 objects from the 8 classes
        WheeledTransportation wheeledTransportation1 = new WheeledTransportation();
        WheeledTransportation wheeledTransportation2 = new WheeledTransportation(2, 20);
        WheeledTransportation wheeledTransportation3 = new WheeledTransportation();


        Train train1 = new Train(48, 100, 12, "Toronto", "Montreal");
        Train train2 = new Train(36, 130, 8, "Montreal", "Toronto");


        Metro metro1 = new Metro(48, 70, 6, "Montreal west", "Montreal east", 18);
        Metro metro2 = new Metro(48, 70, 6, "Montreal north", "Montreal south", 16);
        Metro metro3 = new Metro(48, 70, 6, "Montreal north", "Montreal south", 16);
        Metro metro4 = new Metro();
        Train train3 = new Train();


        Tram tram1 = new Tram(60,110.2,12, "Kingston", "Montreal", 6, 1997);
        Tram tram2 = new Tram(18, 100, 10, "Quebec city", "Montreal", 2, 2000);
        Tram tram3 = new Tram(tram2);


        Monowheel monowheel1 = new Monowheel(1, 40, 100);
        Monowheel monowheel2 = new Monowheel(1, 40, 100);


        Aircraft aircraft1 = new Aircraft(5, 7800);
        Aircraft aircraft2 = new Aircraft(15, 9000);
        Aircraft aircraft3 = new Aircraft();


        WW2Airplane ww2Airplane1 = new WW2Airplane(4, 800, true);
        WW2Airplane ww2Airplane2 = new WW2Airplane(5, 800, false);


        Ferry ferry1 = new Ferry(80, 300);
        Ferry ferry2 = new Ferry(70, 500);


        // Display information using toString() method
        System.out.println(wheeledTransportation1);
        System.out.println(wheeledTransportation2);
        System.out.println(wheeledTransportation3);
        
        System.out.println("The next wheeled transportation serial number is #"+WheeledTransportation.getNextSerialNumber()+"\n");

        


        System.out.println(train1);
        System.out.println(train2);
        System.out.println(train3);
        
        System.out.println("The next train's serial number is #"+Train.getNextSerialNumber()+"\n");



        System.out.println(metro1);
        System.out.println(metro2);
        System.out.println(metro3);
        System.out.println(metro4);
        
        System.out.println("The next metro's serial number is #"+Metro.getNextSerialNumber()+"\n");


        System.out.println(tram1);
        System.out.println(tram2);
        System.out.println(tram3);
        
        System.out.println("The next tram's serial number is #"+Tram.getNextSerialNumber()+"\n");



        System.out.println(monowheel1);
        System.out.println(monowheel2);
        
        System.out.println("The next monowheel's serial number is #"+Monowheel.getNextSerialNumber()+"\n");


        System.out.println(aircraft1);
        System.out.println(aircraft2);
        
        System.out.println("The next aircraft's serial number is #"+Aircraft.getNextSerialNumber()+"\n");


        System.out.println(ww2Airplane1);
        System.out.println(ww2Airplane2);
        
        System.out.println("The next World War II airplane's serial number is #"+WW2Airplane.getNextSerialNumber()+"\n");


        System.out.println(ferry1);
        System.out.println(ferry2);
        
        System.out.println("The next ferry's serial number is #"+Ferry.getNextSerialNumber()+"\n");
        System.out.println("--------------------------------------------------------------------------------");



        //Testing equals method by  two objects from the same class with different values and two objects with similar values.
        System.out.println("\nTesting equals method by  two objects from the same class:");
        System.out.println("the two wheeledTransportation objects are equal:" + wheeledTransportation1.equals(wheeledTransportation2));
        System.out.println("the two train objects are equal:" + train1.equals(train2));
        System.out.println("the two metro objects are equal:" + metro1.equals(metro2));
        System.out.println("the two tram objects are equal:" + tram1.equals(tram2));
        System.out.println("the two monowheel objects are equal:" + monowheel1.equals(monowheel2));
        System.out.println("the two ferry objects are equal:" + ferry1.equals(ferry2));
        System.out.println("the two aircraft objects are equal:" + aircraft1.equals(aircraft2));
        System.out.println("the two ww2airplane objects are equal:" + ww2Airplane1.equals(ww2Airplane2));
        System.out.println("--------------------------------------------------------------------------------");

        // Testing objects from different classes
        //using the equals method from the class WheeledTransportation to compare
        System.out.println("\ntesting wheeledTransportation object with other objects are equal or not:");
        System.out.println(wheeledTransportation1.equals(train1));
        System.out.println(wheeledTransportation1.equals(metro1));
        System.out.println(wheeledTransportation1.equals(tram2));
        System.out.println(wheeledTransportation1.equals(monowheel2));
        System.out.println(wheeledTransportation2.equals(ferry1));
        System.out.println(wheeledTransportation2.equals(aircraft1));
        System.out.println(wheeledTransportation2.equals(ww2Airplane1));
        System.out.println("--------------------------------------------------------------------------------");


        //using the equals method from the class Train to compare
        System.out.println("testing the train object with other objects are equal or not:");
        System.out.println(train1.equals(wheeledTransportation1));
        System.out.println(train1.equals(metro2));
        System.out.println(train1.equals(tram1));
        System.out.println(train1.equals(monowheel1));
        System.out.println(train2.equals(ferry1));
        System.out.println(train2.equals(aircraft1));
        System.out.println(train2.equals(ww2Airplane1));
        System.out.println("--------------------------------------------------------------------------------");


        //using the equals method from the class Metro to compare
        System.out.println("testing the metro object with other objects are equal or not:");
        System.out.println(metro1.equals(wheeledTransportation1));
        System.out.println(metro1.equals(train1));
        System.out.println(metro1.equals(tram1));
        System.out.println(metro1.equals(monowheel2));
        System.out.println(metro2.equals(ferry1));
        System.out.println(metro2.equals(aircraft1));
        System.out.println(metro2.equals(ww2Airplane1));
        System.out.println("--------------------------------------------------------------------------------");


        //using the equals method from the class Tram to compare
        System.out.println("testing the tram object with other objects are equal or not:");
        System.out.println(tram1.equals(wheeledTransportation1));
        System.out.println(tram1.equals(train1));
        System.out.println(tram1.equals(metro1));
        System.out.println(tram1.equals(monowheel2));
        System.out.println(tram2.equals(ferry1));
        System.out.println(tram2.equals(aircraft1));
        System.out.println(tram2.equals(ww2Airplane2));
        System.out.println("--------------------------------------------------------------------------------");


        //using the equals method from the class Monowheel to compare
        System.out.println("testing the monowheel object with other objects are equal or not:");
        System.out.println(monowheel1.equals(wheeledTransportation1));
        System.out.println(monowheel1.equals(train1));
        System.out.println(monowheel1.equals(metro1));
        System.out.println(monowheel1.equals(tram2));
        System.out.println(monowheel2.equals(ferry2));
        System.out.println(monowheel2.equals(aircraft1));
        System.out.println(monowheel2.equals(ww2Airplane1));
        System.out.println("--------------------------------------------------------------------------------");


        //using the equals method from the class Ferry to compare
        System.out.println("testing the ferry object with other objects are equal or not:");
        System.out.println(ferry1.equals(wheeledTransportation1));
        System.out.println(ferry1.equals(train1));
        System.out.println(ferry1.equals(metro1));
        System.out.println(ferry1.equals(tram1));
        System.out.println(ferry2.equals(monowheel1));
        System.out.println(ferry2.equals(aircraft1));
        System.out.println(ferry2.equals(ww2Airplane2));
        System.out.println("--------------------------------------------------------------------------------");


        //using the equals method from the class Aircraft to compare
        System.out.println("testing the aircraft object with other objects are equal or not:");
        System.out.println(aircraft1.equals(wheeledTransportation1));
        System.out.println(aircraft1.equals(train2));
        System.out.println(aircraft1.equals(metro1));
        System.out.println(aircraft1.equals(tram1));
        System.out.println(aircraft2.equals(monowheel2));
        System.out.println(aircraft2.equals(ferry1));
        System.out.println(aircraft2.equals(ww2Airplane1));
        System.out.println("--------------------------------------------------------------------------------");


        //using the equals method from the class WW2Airplane to compare
        System.out.println("testing the ww2airplane object with other objects are equal or not:");
        System.out.println(ww2Airplane1.equals(wheeledTransportation1));
        System.out.println(ww2Airplane1.equals(train1));
        System.out.println(ww2Airplane1.equals(metro2));
        System.out.println(ww2Airplane1.equals(tram2));
        System.out.println(ww2Airplane2.equals(monowheel2));
        System.out.println(ww2Airplane2.equals(ferry1));
        System.out.println(ww2Airplane2.equals(aircraft1));
        System.out.println("--------------------------------------------------------------------------------");



        //Create two arrays,   allObjects have all 16 mixed objects, allWithoutAircraft have 12 objects excluding aircraft1, aircraft2, aircraft3, ww2Airplane1, ww2Airplane2,
        Transportation[] allObjects = {wheeledTransportation1, wheeledTransportation2, 
        		train1, train2, metro1, metro2, tram1, tram2, monowheel1, monowheel2,
        		aircraft1, aircraft2, aircraft3, ww2Airplane1, ww2Airplane2, ferry1, ferry2};
        Transportation[] allWithoutAircraft = {wheeledTransportation1, wheeledTransportation2, 
        		train1, train2, metro1, metro2, tram1, tram2, monowheel1, monowheel2, ferry1, ferry2};
        System.out.println("find Least And Most Expensive Aircraft from all objects:");
        findLeastAndMostExpensiveAircraft(allObjects);
        //output:
        //The Least Expensive Aircraft:
        //This WW2Airplane - 80000 price is 4.0 million,and it has a maximum elevation of 800.0km And it has twin Engines
        //Most Expensive Aircraft:
        //This Aircraft - 1price is 15.0 million, and it has a maximum elevation of 9000.0km

        System.out.println("\nfind Least And Most Expensive Aircraft from all objects without aircrafts:");
        findLeastAndMostExpensiveAircraft(allWithoutAircraft);
        //output: Error, the list of aircraft is null, please enter valid list.

    }
}
