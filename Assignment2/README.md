# Assignment 2 Java Programs

This folder contains a Java program for managing a retired bookstore employee's extensive book catalog, categorizing books by genre, and handling various CSV input files to organize, validate, and serialize book records.

## Programs

### Part 1: Syntax Validation and Categorization

**Description:**
Validates the syntax of book records and categorizes them based on genre. Handles input from multiple CSV files and logs syntax errors.

**Usage:**
1. Read book records from CSV-formatted text files.
2. Validate syntax and categorize books into appropriate genres.
3. Log syntax errors and generate output files for valid records.

### Part 2: Semantic Validation and Serialization

**Description:**
Checks the semantic validity of book records and serializes them into binary files for easy data manipulation and retrieval.

**Usage:**
1. Deserialize text files with syntactically valid book records.
2. Validate semantic details of each record.
3. Serialize semantically valid book records into binary files.

### Part 3: Interactive Navigation of Serialized Data

**Description:**
Provides an interactive interface to navigate through deserialized book records, allowing detailed viewing and navigation within the records.

**Usage:**
1. Deserialize binary files into arrays of Book objects.
2. Provide a menu-driven interface to navigate and view book details.
3. Enable navigation through records based on user input.

## File Structure

- **src**
    - **bookRecords**
    - **driver**
        - Main testing and navigation program.
    - **part1_input_file_names**
    - **part2_input_file_names**
    - **Exceptions Classes**
    - **P1OutputFiles**
      - Empty folder before run. Part 1 will output nine files, eight CSV-formatted text files and
        a regular text file. 
    - **P2OutputFiles**
      - Empty folder before run. All saved valid book records into binary files.

## IDE

- **IntelliJ IDEA Version:** 2022.3.1

## How to Run

1. Open `Driver.java` in IntelliJ IDEA.
2. Compile and run the `main` method.
3. Follow the on-screen instructions to navigate the book records.

## Authors

- Yuqian Cai (COMP249, Fall 2023)

---

**Note:** Ensure Java is installed and correctly configured in your IDE.
