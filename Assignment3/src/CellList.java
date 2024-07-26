// -----------------------------------------------------
// Comp 249
// Assignment 3
// Written by: Yuqian Cai
// -----------------------------------------------------

import java.util.NoSuchElementException;
import java.util.InputMismatchException;
import java.io.*;
import java.util.Scanner;


public class CellList {

    /**
     * An inner class called CellNode
     */
    private class CellNode {
        /**
         * attribute an object of cellphone
         */
        private CellPhone cellphone;
        /**
         * attribute apointer to a CellNode object
         */
        private CellNode next; // A link to the next node, which is of type CellNode


        /**
         * default constructor
         */
        private CellNode() {
            cellphone = null;
            next = null;
        }

        /**
         * Parameterized constructor
         *
         * @param cellphone
         * @param next
         */

        private CellNode(CellPhone cellphone, CellNode next) {
            this.cellphone = cellphone;
            this.next = next;
        }

        /**
         * copy constructor
         *
         * @param cn
         */
        private CellNode(CellNode cn) {
            cellphone = cn.cellphone.clone();//call cellphone's clone method to clone a new cellphone
            next = cn.next;
        }

        /**
         * clone() method
         *
         * @return a new CellNode points to a new cellphone object with a new user input serial number
         */
        public CellNode clone() {
            return new CellNode(this);
        }

        /**
         * Cellphone getter
         *
         * @return cellphone
         */
        private CellPhone getCellphone() {
            return cellphone;
        }

        /**
         * cellphone setter
         *
         * @param cellphone
         */
        private void setCellphone(CellPhone cellphone) {
            this.cellphone = cellphone;
        }

        /**
         * next getter (point to the next node)
         *
         * @return cell node
         */
        private CellNode getNext() {
            return next;
        }

        /**
         * next setter
         *
         * @param next
         */
        private void setNext(CellNode next) {
            this.next = next;
        }
    }

    /**
     * attribute in CellList head point to the first node in this list object;
     */
    private CellNode head;
    /**
     * attribute size of the list (how many nodes are in the list)
     */
    private int size;

    /**
     * default constructor
     */
    public CellList() {
        head = null;
        size = 0;
    }

    /**
     * copy constructor (deep copy a list to a new list)
     * @param List1
     */

    public CellList(CellList List1) {
        if (List1.head == null)
            head = null;
        else {
            head = null;
            CellNode t1, t2;    // create 2 temporary pointers
            t1 = List1.head;
            t2 = null; //this new list's pointer
            while (t1 != null) {
                if (head == null)    // this happens only once
                {
                    t2 = new CellNode(t1.cellphone.clone(), null); //point to the cloned first node from List1
                    head = t2;//link the head to the new node
                } else {
                    t2.next = new CellNode(t1.cellphone.clone(), null);//next point to the cloned next node from List1
                    t2 = t2.next; //move the pinter to point next node
                }
                size++;
                t1 = t1.next;//move the pinter to point next node
            }
            t2 = null;    // t1 is already null by now
        }
    }

    /**
     * size getter
     *
     * @return integer the size of the list
     */
    public int getSize() {
        return size;
    }

    /**
     * size setter (update size of the cell list object)
     *
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }


    /**
     * addToStart method :  A method that adds a cell node to the start of the list
     *
     * @param cellPhone
     */

    public void addToStart(CellPhone cellPhone) {
        head = new CellNode(cellPhone, head);
        size++;
    }


    /**
     * insertAtIndex() method : substitute the cellphone at the specific index to another cellphone
     *
     * @param cellPhone
     * @param index
     */
    public void insertAtIndex(CellPhone cellPhone, int index) {
        if (cellPhone == null)
            throw new NoSuchElementException("this cellPhone is null, please check again.");
        if (index < 0 || index > size - 1)
            throw new NoSuchElementException("this cell list only have " + getSize() + " numbers of Cell phone, can not insert at index " + index);

        if (head == null)    // cellphone is the first value at head
        {
            head = new CellNode(cellPhone, null);
            System.out.println("the cell list is an empty list, the cell phone has been insert at the first index.");
        } else {
            CellNode t = head;
            for (int i = 0; i < index - 1; i++) {
                t = t.next;//keep the t pointer always point to the [index-1] node
            }
            t.next = new CellNode(cellPhone, t.next);
            System.out.println("The cellphone " + cellPhone + " has been inserted at index [" + index + "].");
        }
        size++;

    }

    /**
     * deleteFromIndex() method
     *
     * @param index
     */
    public void deleteFromIndex(int index) {
        if (index < 0 || index > size - 1)
            throw new NoSuchElementException("this cell list only have " + getSize() + " numbers of Cell phone, can not delete at index " + index);
        if (head == null) { // Check if the list is empty
            System.out.println("The cell list is an empty list, no cell phone needs to be deleted.");
            return;
        }

        if (index == 0) { // Special case: deleting the first element
            System.out.println("The cellphone: " + head.cellphone.toString() + " has been deleted from the start of the list.");
            head = head.next;
            size = 0;
            return;
        }

        CellNode t = head;
        for (int i = 0; i < index - 1; i++) {
            t = t.next;
        }
        System.out.println("The cellphone: " + t.next.cellphone.toString() + " has been deleted from index [" + index + "].");
        t.next = t.next.next; // Skip the current node at the index
        size--;
    }

    /**
     * deleteFromStart() method
     *
     * @return a boolean, true if cellphone can be deleted, false if the list is null
     */
    public boolean deleteFromStart() {
        if (head == null) {
            System.out.println("the cell list is an empty list, no cell phone need to be deleted.");
            return false;
        }

        System.out.println("the first cellphone: " + head.cellphone.toString() + "has deleted from the list");
        head = head.next;
        size--;
        return true;
    }

    /**
     * replaceAtIndex() method may have the privacy leak when call the setCellphone() method
     * solution: may setCellphone(newPhone.clone()) to fix it, it will point to a new cloned phone
     *
     * @param newPhone
     * @param index
     */

    public void replaceAtIndex(CellPhone newPhone, int index) {

        if (index < 0 || index > size - 1)
            throw new NoSuchElementException("This cell list only have " + getSize() + " numbers of Cell phone, can not insert at index " + index);

        if (head == null)    // new phone will be the first value at head
        {
            head = new CellNode(newPhone, null);
            System.out.println("the cell list is an empty list, the cell phone has been replaced to the first index.");
        }

        CellNode t = head;
        int indexInList = 0;
        while (t != null) {
            if (indexInList == index) {
                t.setCellphone(newPhone);
                System.out.println("the cellPhone in index [" + index + "] has been replaced by the new phone" + newPhone.toString());
            }
            t = t.next;
            indexInList++;
        }
    }

    /**
     * find() method
     * may have privacy leak because the method will return the pointer which point to the node from the original list, and
     * it will be accessed by the user if they call the method from the cell node class
     * solution: may return a cloned node, t.clone().
     *
     * @param serialNum
     * @return
     */
    public CellNode find(long serialNum) {
        if (head == null) {
            return null;
        }
        CellNode t = head;
        for (int i = 0; i < size; i++) {
            if (t != null && t.cellphone.getSerialNum() == serialNum) {
                System.out.println("Find the cell phone has the serial number: " + serialNum + " by " + i + " iterations");
                //display the number of iterations performed
                return t;
            }
            t = t.next;
        }
        System.out.println("Can not find the cell phone has the serial number: " + serialNum);
        return null;
    }

    /**
     * contains() method A method that indicates whether a cell phone is in the list
     *
     * @param serialNum
     * @return
     */
    public boolean contains(long serialNum) {
        return find(serialNum) != null;
    }

    /**
     * showContents() method
     */
    public void showContents() {
        System.out.println("\nThe current size of the list is " + getSize() + ". Here are the contents of the list");
        System.out.println("=================================================================================");
        CellNode t = head;
        int ctr = 0;
        while (t != null) {
            System.out.print(t.cellphone.toString());
            System.out.print("--->");
            ctr++;
            if (ctr == 3) {
                System.out.println();
                ctr = 0;
            }
            t = t.next;
        }
        System.out.println("X");
    }

    /**
     * equals() methods
     *
     * @param list
     * @return
     */
    public boolean equals(CellList list) {
        if (list == null || this.getSize() != list.getSize()) return false;
        CellNode t = this.head;
        CellNode o = list.head;
        while (t != null) {
            if (!(t.getCellphone().equals(o.getCellphone())))
                return false;
            t = t.next;
            o = o.next;
        }
        return true;
    }

    /** driver class
     * @param args
     */
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Scanner sc ;
        //create two empty lists
        CellList list1 = new CellList();
        CellList list2 = new CellList();
        CellList list3 = new CellList();
        CellList list4 ;

        //create cellphones
        CellPhone c1 = new CellPhone(2512231, "BlackBerry", 1564.22, 2014);
        CellPhone c2 = new CellPhone(3322211, "Samsung", 899.99, 2020);
        CellPhone c3 = new CellPhone(4455166, "Apple", 1200.50, 2021);
        CellPhone c4 = new CellPhone(7748899, "Google", 750.30, 2019);
        CellPhone c5 = new CellPhone(1122033, "Huawei", 680.00, 2018);
        CellPhone c6 = new CellPhone(9983877, "Sony", 599.99, 2017);
        CellPhone c7 = new CellPhone(5544933, "Nokia", 450.25, 2016);
        CellPhone c8 = new CellPhone(2211733, "LG", 529.99, 2015);
        CellPhone c9 = new CellPhone(6677388, "Motorola", 499.49, 2013);
        CellPhone c10 = new CellPhone(1238456, "Xiaomi", 400.00, 2012);

        //b) open file
        try {
            sc = new Scanner(new File("src/Cell_Info.txt"));
            String input ;
            String[] parts;
            while (sc.hasNextLine()) {
                CellPhone cellphone = new CellPhone();
                input = sc.nextLine();
                parts = input.split("\\s+");
                cellphone.setSerialNum(Long.parseLong(parts[0]));
                cellphone.setBrand(parts[1]);
                cellphone.setPrice(Double.parseDouble(parts[2]));
                cellphone.setYear(Integer.parseInt(parts[3]));
                if (!isDuplicate(list1, cellphone)) {
                    list1.addToStart(cellphone);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Can not find the file");
        }

        list2.addToStart(c1);
        list2.addToStart(c2);
        list2.addToStart(c3);
        list2.addToStart(c4);
        list2.addToStart(c5);
        list2.addToStart(c6);
        list2.addToStart(c7);
        list2.addToStart(c8);
        list2.addToStart(c9);
        list2.addToStart(c10);

        //c)Show the contents of the list
        list1.showContents();
        list2.showContents();
        //d) user to enter a few serial numbers and search the list
        System.out.println("which list you want to check the cell phone(1 or 2):");
        CellList listChoose = null;
        try {
            int userInput = kb.nextInt();
            if (userInput == 1) {
                listChoose = list1;
            } else if (userInput == 2) {
                listChoose = list2;
            } else {
                System.out.println("Wrong number, automatically checking in the first list");
                listChoose = list1;
            }
            System.out.println("Please insert a cellphone's serial number to search for in the list(x to exit):");
        } catch (InputMismatchException e) {
            System.out.println("Wrong type insert");
        }
        while (kb.hasNextLong()) {
            long userInput = kb.nextLong();
            if (listChoose != null) {
                CellNode x = listChoose.find(userInput);
            }
            System.out.println("Please insert a cellphone's serial number to search for in the list(x to exit):");
        }
        kb.nextLine();
        System.out.println("Thank you for using cellphone inventory checking system");

        while (true) {

            System.out.println("Choose an option:");
            System.out.println("1. Test clone() method from CellPhone class");
            System.out.println("2. Test insertAtIndex method");
            System.out.println("3. Test deleteFromIndex method");
            System.out.println("4. Test deleteFromStart method");
            System.out.println("5. Test replaceAtIndex method");
            System.out.println("6. Test find and contains methods");
            System.out.println("7. Test privacy leak");
            System.out.println("8. Test equals() method and copy constructor");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            try {
                int choice = kb.nextInt();
                switch (choice) {
                    case 1 -> {
                        //clone() method from Cellphone class
                        System.out.println("=================================================================================");
                        System.out.println("Checking clone() method from Cellphone class");
                        CellPhone newiPhone = c3.clone();
                    }
                    case 2 -> {
                        //insertAtIndex() method
                        System.out.println("=================================================================================");
                        System.out.println("Checking insertAtIndex method in list1:");
                        try {
                            list1.insertAtIndex(c8, 1);
                            list1.insertAtIndex(new CellPhone(2868186, "Apple", 1749.12, 2023), 11);
                            list1.insertAtIndex(new CellPhone(), list1.size);
                        } catch (NoSuchElementException e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("After insert cell phones at indexes, list 1:");
                        list1.showContents();
                        System.out.println("=================================================================================");
                        System.out.println("Checking insertAtIndex method in list2:");
                        try {
                            list2.insertAtIndex(new CellPhone(2868186, "Apple", 1749.12, 2023), 7);
                            list2.insertAtIndex(new CellPhone(), 18);
                        } catch (NoSuchElementException e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("After insert cell phones at indexes, list 2:");
                        list2.showContents();
                    }
                    case 3 -> {
                        //deleteFromIndex() method check
                        System.out.println("=================================================================================");
                        System.out.println("Checking deleteFromIndex method:");
                        System.out.println("\nBefore delete cell phones at indexes, list 1:");
                        list1.showContents();
                        System.out.println("\nBefore delete cell phones at indexes, list 2:");
                        list2.showContents();
                        try {
                            list1.deleteFromIndex(7);
                            list1.deleteFromIndex(18);
                            list2.deleteFromIndex(9);
                            list2.deleteFromIndex(19);
                        } catch (NoSuchElementException e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("\nAfter delete cell phones at indexes, list 1:");
                        list1.showContents();
                        System.out.println("\nAfter delete cell phones at indexes, list 2:");
                        list2.showContents();
                    }
                    case 4 -> {
                        //deleteFromStart() method check
                        System.out.println("=================================================================================");
                        System.out.println("Checking deleteFromStart method:");
                        System.out.println("\nBefore delete cell phones from start, list 1:");
                        list1.showContents();
                        System.out.println("\nBefore delete cell phones from start, list 2:");
                        list2.showContents();
                        try {
                            list1.deleteFromStart();
                            list2.deleteFromStart();
                        } catch (NoSuchElementException e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("\nAfter delete cell phone from start, list 1:");
                        list1.showContents();
                        System.out.println("\nAfter delete cell phones from start, list 2:");
                        list2.showContents();
                    }
                    case 5 -> {
                        //replaceAtIndex() method check
                        System.out.println("=================================================================================");
                        System.out.println("Checking replaceAtIndex method:");
                        System.out.println("\nBefore replace cell phones, list 2:");
                        list2.showContents();
                        try {
                            list2.replaceAtIndex(c8, 8);
                        } catch (NoSuchElementException e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("\nAfter replace the cell phone from list 2:");
                        list2.showContents();
                        System.out.println("\nBefore replace cell phones, list 1:");
                        list1.showContents();
                        try {
                            list1.replaceAtIndex(c7, 29);
                        } catch (NoSuchElementException e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("\nAfter replace the cell phone from list 1:");
                        list1.showContents();
                    }
                    case 6 -> {
                        //find method check
                        System.out.println("=================================================================================");
                        System.out.println("Checking contains() method");
                        list1.find(8989989);
                        list1.find(2389076);
                        list2.find(5555902);
                        //contains() method check
                        System.out.println("=================================================================================");
                        System.out.println("Checking find method");
                        System.out.println(list1.contains(8989989));
                        System.out.println(list1.contains(2389076));
                        System.out.println(list2.contains(5555902));
                    }
                    case 7 -> {
                        //privacy leak check (solution: make getCellphone(),setSerialNum()and setNext() method all private )
                        list1.head.getCellphone().setSerialNum(89318912);// set serial number of the head's phone
                        if (list1.contains(89318912))
                            System.out.println("privacy leak check: list has been changed" + list1.head.cellphone.toString());
                        else
                            System.out.println("list has not been changed, the first cellphone is" + list1.head.cellphone.toString());
                        System.out.println("Before finding the node and setting the rest of nodes is null, the list is ");
                        list2.showContents();
                        CellNode x = list2.find(9983877);
                        x.setNext(null);
                        System.out.println("After finding the node and setting the rest of nodes is null, the list is ");
                        list2.showContents();
                    }
                    case 8 -> {
                        //equals() method from the CellList class check
                        //copy constructor from CellList class
                        list3.addToStart(c1);
                        list3.addToStart(c4);
                        list3.addToStart(c9);
                        list3.insertAtIndex(c7,1);
                        list3.insertAtIndex(c3,3);
                        list4 = new CellList(list3);
                        list3.showContents();
                        list4.showContents();
                        if (list3.equals(list4)) {
                            System.out.println("List 4 has all same cellphones like which are in list 3 excepted the serial number.");
                        } else System.out.println("cellphones from list3 and list4 are not same.");
                    }
                    case 9 -> {
                        System.out.println("Exiting...");
                        kb.close(); // Close scanner only when exiting
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                kb.nextLine(); // clear the invalid input
            }
        }
    }

    /**
     * Method to check if the list already contains a cellphone with the same serial number
     *
     * @param list
     * @param newCellPhone
     * @return
     */

    // (kind of same like find() method, but I print info in that method)
    private static boolean isDuplicate(CellList list, CellPhone newCellPhone) {
        CellNode t = list.head;
        while (t != null) {
            if (t.getCellphone().getSerialNum() == newCellPhone.getSerialNum()) {
                return true;
            }
            t = t.next;
        }
        return false;
    }
}
