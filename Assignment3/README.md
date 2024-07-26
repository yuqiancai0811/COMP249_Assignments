# Assignment 3 Java Programs

This folder contains Java programs for managing cell phone records using custom linked lists. The project utilizes object-oriented programming principles to manipulate and perform operations on records of cell phones without using any built-in types like Lists or Collections.

## Programs

### Part 1: CellPhone and CellNode Classes

**Description:**
Implements the `CellPhone` class with attributes such as serial number, brand, year, and price, along with essential methods like constructors, `clone()`, `equals()`, and `toString()`. The `CellNode` class serves as the building block for the linked list, containing cell phone objects and pointers to other nodes.

**Usage:**
1. Define and instantiate `CellPhone` objects.
2. Utilize `CellNode` for linked list operations.
3. Implement deep copy mechanisms and data integrity checks.

### Part 2: CellList Class Management

**Description:**
Manages a linked list of `CellNode` objects to perform complex operations like insertion, deletion, searching, and traversal.

**Usage:**
1. Insert and delete cell phones in the linked list at specified indices.
2. Search for cell phones by serial number.
3. Display the contents of the list in a formatted manner.
4. Ensure all operations handle edge cases and maintain list integrity.

## File Structure

- **src**
    - **models**
        - `CellPhone.java` - Defines the cell phone data structure.
        - `CellNode.java` - Node class for linked list.
        - `CellList.java` - Linked list management.
    - **utils**
        - `FileHandler.java` - Handles file operations for cell phone data.
    - **main**
        - `CellListUtilization.java` - Main class to demonstrate functionalities.

## IDE

- **IntelliJ IDEA Version:** 2022.3.1

## How to Run

1. Open `CellListUtilization.java` in IntelliJ IDEA.
2. Compile and execute the `main` method.
3. Follow the interactive prompts to manipulate the cell phone records.

## Authors

- Yuqian cai (COMP249, Fall 2023)

---

**Note:** This project is strictly for academic use. Redistribution or publication of this project or its parts, by any means, is strictly prohibited.
