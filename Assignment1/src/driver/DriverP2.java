package driver;

import aircraftWW2airplane.*;
import ferry.*;
import metro.*;
import monowheel.*;
import trainTram.*;
import transportation.Transportation;
import wheeledTransportation.*;

public class DriverP2 {
    /**
     * static method for copy all the types of objects in this project
     * @param x the array of Transportation
     * @return copyArr: a new copied array of Transportation
     */
    public static Transportation[] copyTheObjects(Transportation [] x){
        Transportation[] copyArr = new Transportation[x.length];
        for (int i = 0; i < x.length; i++) {
            //save the  current object to find belongs to which class
           copyArr[i]=x[i].clone();
    }
        return copyArr;
    }


    public static void main(String[] args) {
        //Create 16 objects from the 8 classes
        Transportation wheeledTransportation1 = new WheeledTransportation(4, 120);
        WheeledTransportation wheeledTransportation2 = new WheeledTransportation(2, 20);

        Transportation train1 = new Train(48, 100, 12, "Toronto", "Montreal");
        Train train2 = new Train(36, 130, 8, "Montreal", "Toronto");

        Transportation metro1 = new Metro(48, 70, 6, "Montreal west", "Montreal east", 18);
        Metro metro2 = new Metro(48, 70, 6, "Montreal north", "Montreal south", 16);

        Transportation tram1 = new Tram(60, 110, 12, "Kingston", "Montreal", 6, 1997);
        Tram tram2 = new Tram(18, 100, 10, "Quebec city", "Montreal", 2, 2000);


        Transportation monowheel1 = new Monowheel(1, 40, 100);
        Monowheel monowheel2 = new Monowheel(1, 40, 100);


        Transportation aircraft1 = new Aircraft(5, 7800);
        Aircraft aircraft2 = new Aircraft(15, 9000);

        Transportation ww2Airplane1 = new WW2Airplane(4, 800, true);
        WW2Airplane ww2Airplane2 = new WW2Airplane(5, 7800, false);


        Transportation ferry1 = new Ferry(80, 300);
        Ferry ferry2 = new Ferry(70, 500);

        //Create an array, allObjects have all 16 mixed objects
        Transportation[] allObjects = {wheeledTransportation1, wheeledTransportation2, train1, train2, 
        								metro1, metro2, tram1, tram2, monowheel1, monowheel2,
        								aircraft1, aircraft2, ww2Airplane1, ww2Airplane2, ferry1, ferry2};
        for (int i = 0; i < allObjects.length; i++) {
			System.out.println(i+1+". "+allObjects[i].toString());
		}
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("These are copied objects:");
        System.out.println();
        
        Transportation[] copiedObjects = copyTheObjects(allObjects);
        for (int i = 0; i < allObjects.length; i++) {
			System.out.println(i+1+". "+copiedObjects[i].toString());
		}
    }
}


