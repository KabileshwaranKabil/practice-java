# Java Exception Handling — Complete Beginner Guide

Exception handling is one of the most important concepts in Java because real applications **will encounter errors**.

Examples:

* User enters invalid input
* File does not exist
* Database connection fails
* Network request fails
* Division by zero happens

Instead of crashing the program, Java allows us to **handle these problems gracefully**.

---

# 1. What is an Exception?

An **exception** is an unexpected event that occurs during program execution and interrupts the normal flow of the program.

Example:

```java
public class Main {

    public static void main(String[] args) {

        int result = 10 / 0;

        System.out.println(result);

    }
}
```

Output:

```
Exception in thread "main" java.lang.ArithmeticException: / by zero
```

The program stops.

Why?

Because dividing by zero is not a valid operation.

---

# 2. Error vs Exception

Java has two major problems:

```
Throwable
    |
    |
    +-------------+
    |             |
 Error        Exception
```

---

## Error

Errors are serious problems usually not handled by programmers.

Examples:

```text
OutOfMemoryError
StackOverflowError
```

Example:

```java
int[] arr = new int[999999999];
```

Memory may run out.

---

## Exception

Exceptions are problems that applications can handle.

Examples:

```
ArithmeticException
NullPointerException
IOException
SQLException
```

---

# 3. Common Exceptions in Java

## 1. ArithmeticException

Mathematical errors.

Example:

```java
int x = 10 / 0;
```

---

## 2. NullPointerException

Trying to use an object that is null.

Example:

```java
String name = null;

System.out.println(name.length());
```

---

## 3. ArrayIndexOutOfBoundsException

Accessing invalid array index.

Example:

```java
int[] numbers = {10,20,30};

System.out.println(numbers[5]);
```

---

## 4. NumberFormatException

Invalid number conversion.

Example:

```java
String value = "abc";

int number = Integer.parseInt(value);
```

---

# 4. Why Do We Need Exception Handling?

Without exception handling:

```java
public class Main {

    public static void main(String[] args) {

        int a = 10;
        int b = 0;

        int result = a / b;

        System.out.println("Finished");

    }
}
```

Output:

```
ArithmeticException
```

The line:

```java
System.out.println("Finished");
```

never executes.

---

With exception handling:

```java
public class Main {

    public static void main(String[] args) {


        try {

            int result = 10 / 0;

            System.out.println(result);

        }
        catch(Exception e){

            System.out.println("Something went wrong");

        }


        System.out.println("Program finished");

    }
}
```

Output:

```
Something went wrong
Program finished
```

The program continues.

---

# 5. try-catch Block

Basic structure:

```java
try {

    // risky code

}
catch(ExceptionType e) {

    // handling code

}
```

Example:

```java
public class Main {

    public static void main(String[] args) {


        try {

            int number = 10 / 0;

        }
        catch(ArithmeticException e){

            System.out.println(
                "Cannot divide by zero"
            );

        }

    }
}
```

Output:

```
Cannot divide by zero
```

---

# 6. Understanding the Exception Object

Inside catch:

```java
catch(Exception e)
```

`e` contains information about the error.

Example:

```java
try {

    int x = 10/0;

}
catch(Exception e){

    System.out.println(e);

}
```

Output:

```
java.lang.ArithmeticException: / by zero
```

---

## getMessage()

```java
catch(Exception e){

    System.out.println(
        e.getMessage()
    );

}
```

Output:

```
/ by zero
```

---

## printStackTrace()

```java
catch(Exception e){

    e.printStackTrace();

}
```

Shows detailed error location.

Useful during development.

---

# 7. Multiple Catch Blocks

Different exceptions can have different handling.

Example:

```java
public class Main {


    public static void main(String[] args) {


        try {

            int[] arr = new int[3];

            arr[5] = 10;


        }
        catch(ArrayIndexOutOfBoundsException e){

            System.out.println(
                "Invalid array index"
            );

        }
        catch(Exception e){

            System.out.println(
                "Something went wrong"
            );

        }

    }

}
```

Output:

```
Invalid array index
```

---

# Important Rule

Specific exceptions must come before general exceptions.

Correct:

```java
catch(IOException e)

catch(Exception e)
```

Wrong:

```java
catch(Exception e)

catch(IOException e)
```

Because `Exception` catches everything.

---

# 8. finally Block

`finally` always executes.

Syntax:

```java
try {

}
catch(Exception e){

}
finally {

}
```

Example:

```java
public class Main {


    public static void main(String[] args){


        try{

            int x = 10/0;

        }
        catch(Exception e){

            System.out.println("Error");

        }
        finally{

            System.out.println("Cleanup completed");

        }

    }

}
```

Output:

```
Error
Cleanup completed
```

---

## Why use finally?

Common uses:

* Closing files
* Closing database connections
* Releasing resources

Example:

```
Open database connection

      |
      v

Execute query

      |
      v

Close connection
```

Even if an error happens, closing should happen.

---

# 9. Checked vs Unchecked Exceptions

Java exceptions are divided into two categories.

## 1. Checked Exceptions

Checked during compilation.

You MUST handle them.

Example:

```java
FileReader file =
    new FileReader("data.txt");
```

Java says:

```
File may not exist
Handle this exception
```

Examples:

```
IOException
SQLException
FileNotFoundException
```

---

## 2. Unchecked Exceptions

Happen during runtime.

Examples:

```
ArithmeticException
NullPointerException
ArrayIndexOutOfBoundsException
```

Example:

```java
int x = 10/0;
```

Compiler does not complain.

---

# 10. throws Keyword

Used to tell Java:

> "This method might create an exception. The caller must handle it."

Example:

```java
import java.io.FileReader;
import java.io.IOException;


public class Main {


    static void readFile() throws IOException {


        FileReader file =
            new FileReader("data.txt");


    }


}
```

Now whoever calls:

```java
readFile();
```

must handle IOException.

---

# 11. throw Keyword

Used to manually create an exception.

Example:

```java
public class Main {


    static void checkAge(int age){


        if(age < 18){

            throw new IllegalArgumentException(
                "Age must be 18 or above"
            );

        }


        System.out.println("Allowed");

    }


    public static void main(String[] args){

        checkAge(15);

    }

}
```

Output:

```
Age must be 18 or above
```

---

# 12. Custom Exceptions

In real projects, we create our own exceptions.

Example:

Bank application:

```java
class InsufficientBalanceException 
extends Exception {


    public InsufficientBalanceException(
        String message
    ){

        super(message);

    }

}
```

Use:

```java
public class Bank {


    static void withdraw(double amount)
    throws InsufficientBalanceException {


        double balance = 500;


        if(amount > balance){

            throw new InsufficientBalanceException(
                "Not enough balance"
            );

        }

    }

}
```

---

# 13. Try-With-Resources

Now the important part.

## The Problem

Imagine reading a file:

```java
FileReader file = new FileReader("data.txt");


// use file

file.close();
```

Problem:

What if an exception happens before:

```java
file.close();
```

The file remains open.

This causes:

* Resource leaks
* Memory problems
* Locked files

---

# Try-With-Resources Solution

Java automatically closes resources.

Syntax:

```java
try(Resource declaration){

    // use resource

}
catch(Exception e){

}
```

---

Example:

```java
import java.io.FileReader;
import java.io.IOException;


public class Main {


    public static void main(String[] args) {


        try(
            FileReader file =
            new FileReader("data.txt")
        ){

            System.out.println(
                "File opened"
            );


        }
        catch(IOException e){

            System.out.println(
                "File error"
            );

        }


    }

}
```

When the try block finishes:

Java automatically executes:

```java
file.close();
```

---

# 14. Multiple Resources

Example:

```java
try(
    FileReader reader =
        new FileReader("input.txt");

    FileWriter writer =
        new FileWriter("output.txt")
){

    // use both resources

}
catch(IOException e){

    e.printStackTrace();

}
```

Both are automatically closed.

---

# 15. Try-With-Resources Under the Hood

This:

```java
try(FileReader file = new FileReader("a.txt")){

}
```

is similar to:

```java
FileReader file = null;

try{

    file = new FileReader("a.txt");

}
finally{

    if(file != null){

        file.close();

    }

}
```

Java writes the cleanup code automatically.

---

# 16. AutoCloseable Interface

For try-with-resources, the object must implement:

```java
AutoCloseable
```

Example:

```java
class MyResource implements AutoCloseable {


    public void close(){

        System.out.println(
            "Resource closed"
        );

    }

}
```

Use:

```java
try(MyResource r = new MyResource()){

    System.out.println("Using resource");

}
```

Output:

```
Using resource
Resource closed
```

---

# Real Spring Boot Examples

## 1. Handling API Errors

Controller:

```java
@GetMapping("/students/{id}")
public Student getStudent(
        @PathVariable Long id
){

    return service.findById(id);

}
```

If student does not exist:

Create:

```java
StudentNotFoundException
```

Return:

```json
{
 "message":"Student not found"
}
```

using:

```java
@RestControllerAdvice
```

---

## 2. Database Exceptions

Example:

```java
try{

    studentRepository.save(student);

}
catch(DataIntegrityViolationException e){

    System.out.println(
        "Duplicate data"
    );

}
```

---

# Practice Problems

## Beginner Level

### Problem 1: Division Calculator

Create a program that:

* Takes two numbers
* Divides them
* Handles division by zero

Example:

Input:

```
10
0
```

Output:

```
Cannot divide by zero
```

---

### Problem 2: Array Access

Create an array:

```java
int[] numbers = {10,20,30};
```

Ask user for index.

Handle:

```
ArrayIndexOutOfBoundsException
```

---

### Problem 3: Number Converter

Input:

```
"123"
```

Convert to integer.

Handle:

```
NumberFormatException
```

---

# Intermediate Problems

## Problem 4: Bank Withdrawal System

Requirements:

Create:

```java
InsufficientBalanceException
```

Rules:

```
Balance = 10000

withdraw(5000)
Success

withdraw(15000)
Exception
```

---

## Problem 5: Student Registration

Create:

```java
InvalidAgeException
```

Rules:

```
Age < 5
throw exception
```

---

## Problem 6: File Copy Program

Using:

```
try-with-resources
```

Read:

```
input.txt
```

Write:

```
output.txt
```

Handle:

```
IOException
```

---

# Summary

Exception handling:

```
try
 |
 |---- risky code
 |
catch
 |
 |---- handle problem
 |
finally
 |
 |---- cleanup
```

Important keywords:

| Keyword            | Purpose                       |
| ------------------ | ----------------------------- |
| try                | Code that may fail            |
| catch              | Handle exception              |
| finally            | Always execute cleanup        |
| throw              | Create exception manually     |
| throws             | Declare possible exception    |
| try-with-resources | Automatically close resources |

For Spring Boot development, master:

1. try-catch-finally
2. Checked vs unchecked exceptions
3. Custom exceptions
4. `throw` and `throws`
5. Try-with-resources
6. Global exception handling with `@RestControllerAdvice`

These concepts are used constantly in production backend applications.
