# Java Enum (Enumeration)

## 1. What is an Enum?

An **enum** (short for **enumeration**) is a special type in Java that represents a **fixed set of constant values**.

In simple terms:

> An enum is used when you have a variable that can only have a limited number of possible values.

### Real-world examples:

A day of the week can only be:

```
MONDAY
TUESDAY
WEDNESDAY
THURSDAY
FRIDAY
SATURDAY
SUNDAY
```

A traffic light can only be:

```
RED
YELLOW
GREEN
```

A user role can only be:

```
ADMIN
USER
GUEST
```

Instead of using strings or numbers, enums provide a safer and cleaner way.

---

# 2. The Problem Without Enum

Imagine creating a traffic light system.

Without enum:

```java
public class TrafficLight {

    public static void main(String[] args) {

        String color = "RED";

        if(color.equals("RED")) {
            System.out.println("Stop");
        }
        else if(color.equals("GREEN")) {
            System.out.println("Go");
        }
    }
}
```

This works, but there are problems.

### Problem 1: Typing mistakes

```java
String color = "REDD";
```

Java accepts this because it is just a String.

The program fails logically.

---

### Problem 2: Invalid values

```java
String color = "BLUE";
```

A traffic light cannot be blue.

But Java allows it.

---

### Problem 3: Hard to maintain

What if hundreds of places use:

```java
"ADMIN"
"USER"
"GUEST"
```

A typo anywhere can create bugs.

---

# 3. Creating an Enum

Syntax:

```java
enum EnumName {
    CONSTANT1,
    CONSTANT2,
    CONSTANT3
}
```

Example:

```java
enum TrafficLight {
    RED,
    YELLOW,
    GREEN
}
```

Now Java knows that `TrafficLight` has only three possible values.

---

# 4. Using Enum Variables

Example:

```java
public class Main {

    public static void main(String[] args) {

        TrafficLight light = TrafficLight.RED;

        System.out.println(light);

    }
}
```

Output:

```
RED
```

Notice:

```java
TrafficLight light
```

is the data type.

Not:

```java
String light
```

---

# 5. Enum is Actually a Class

Many beginners think enum is just a list.

But internally:

> Every enum in Java is a class.

This:

```java
enum TrafficLight {
    RED,
    YELLOW,
    GREEN
}
```

is similar to creating objects:

```
TrafficLight
      |
      |
 -----------------
 |       |       |
RED   YELLOW  GREEN
```

Each constant is an object of the enum class.

---

# 6. Comparing Enum Values

## Using ==

For enums, use:

```java
==
```

Example:

```java
TrafficLight light = TrafficLight.RED;


if(light == TrafficLight.RED){
    System.out.println("Stop");
}
```

Output:

```
Stop
```

---

You can also use:

```java
.equals()
```

but `==` is preferred.

Example:

```java
if(light.equals(TrafficLight.RED)){
    System.out.println("Stop");
}
```

---

# 7. Enum with Switch Statement

Enums work very well with switch.

Example:

```java
enum TrafficLight {
    RED,
    YELLOW,
    GREEN
}


public class Main {

    public static void main(String[] args) {

        TrafficLight light = TrafficLight.GREEN;


        switch(light){

            case RED:
                System.out.println("Stop");
                break;

            case YELLOW:
                System.out.println("Slow down");
                break;

            case GREEN:
                System.out.println("Go");
                break;
        }
    }
}
```

Output:

```
Go
```

---

# 8. Enum Methods

Because enum is a class, it has built-in methods.

## 1. values()

Returns all enum constants.

Example:

```java
enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY
}


public class Main {

    public static void main(String[] args){

        for(Day d : Day.values()){

            System.out.println(d);

        }
    }
}
```

Output:

```
MONDAY
TUESDAY
WEDNESDAY
```

---

## 2. ordinal()

Returns the position of enum constant.

Example:

```java
enum Level {
    LOW,
    MEDIUM,
    HIGH
}


public class Main {

    public static void main(String[] args){

        System.out.println(Level.LOW.ordinal());
        System.out.println(Level.HIGH.ordinal());

    }
}
```

Output:

```
0
2
```

Important:

Index starts from 0.

```
LOW       -> 0
MEDIUM    -> 1
HIGH      -> 2
```

Do not use ordinal for storing database values because changing order can break your application.

---

## 3. valueOf()

Converts String into enum.

Example:

```java
enum Status {
    SUCCESS,
    FAILED,
    PENDING
}


public class Main {

    public static void main(String[] args){

        Status s = Status.valueOf("SUCCESS");

        System.out.println(s);

    }
}
```

Output:

```
SUCCESS
```

---

# 9. Enum with Fields and Constructors

Enums can store data.

Example:

A payment system:

```java
enum PaymentStatus {

    SUCCESS(200),
    FAILED(500),
    PENDING(100);


    private int code;


    PaymentStatus(int code){
        this.code = code;
    }


    public int getCode(){
        return code;
    }

}
```

Usage:

```java
public class Main {

    public static void main(String[] args){

        PaymentStatus status = PaymentStatus.SUCCESS;


        System.out.println(status);
        System.out.println(status.getCode());

    }
}
```

Output:

```
SUCCESS
200
```

---

## How does this work internally?

When Java creates the enum:

```java
SUCCESS(200)
```

it calls:

```java
PaymentStatus(200)
```

constructor.

Similar to objects:

```java
new PaymentStatus(200);
```

---

# 10. Enum with Methods

Enums can have behavior.

Example:

```java
enum Operation {

    ADD{

        public int calculate(int a,int b){
            return a+b;
        }

    },

    SUBTRACT{

        public int calculate(int a,int b){
            return a-b;
        }

    };


    public abstract int calculate(int a,int b);
}
```

Usage:

```java
public class Main {

    public static void main(String[] args){

        System.out.println(
            Operation.ADD.calculate(5,3)
        );

    }
}
```

Output:

```
8
```

---

# 11. Common Real-World Use Cases

## 1. User Roles

Instead of:

```java
String role="ADMIN";
```

Use:

```java
enum Role {
    ADMIN,
    CUSTOMER,
    STAFF
}
```

Example:

```java
Role userRole = Role.ADMIN;


if(userRole == Role.ADMIN){
    System.out.println("Access granted");
}
```

Used in:

* Authentication systems
* Spring Security
* Permission management

---

# 2. Order Status

E-commerce system:

```java
enum OrderStatus {

    CREATED,
    PAID,
    SHIPPED,
    DELIVERED,
    CANCELLED

}
```

Flow:

```
CREATED
   |
   v
PAID
   |
   v
SHIPPED
   |
   v
DELIVERED
```

Used in:

* Amazon-like systems
* Food delivery apps
* Hotel booking systems

---

# 3. Days

```java
enum Day {

    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY

}
```

Used for:

* Scheduling systems
* Calendar applications

---

# 4. Database Status Fields

Example:

Student attendance:

```java
enum Attendance {

    PRESENT,
    ABSENT,
    LATE

}
```

Database:

| student | status  |
| ------- | ------- |
| John    | PRESENT |
| Alex    | ABSENT  |

---

# 12. Enum vs String

## String approach

```java
String status="PAID";
```

Problems:

* Typing mistakes
* Invalid values
* No compile-time checking

---

## Enum approach

```java
OrderStatus status = OrderStatus.PAID;
```

Advantages:

* Type safety
* Cleaner code
* IDE autocomplete
* Prevents invalid values

---

# 13. Enum vs Constant Variables

Old approach:

```java
class Direction {

    public static final int NORTH=1;
    public static final int SOUTH=2;
    public static final int EAST=3;
    public static final int WEST=4;

}
```

Problems:

```java
int direction = 100;
```

Allowed.

---

Enum:

```java
enum Direction {

    NORTH,
    SOUTH,
    EAST,
    WEST

}
```

Now:

```java
Direction d = Direction.NORTH;
```

Only valid values are accepted.

---

# 14. Enum in Collections

Enums work with collections.

Example:

```java
import java.util.*;

enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY
}


public class Main {

    public static void main(String[] args){

        List<Day> days = Arrays.asList(
                Day.MONDAY,
                Day.TUESDAY
        );


        System.out.println(days);

    }
}
```

Output:

```
[MONDAY, TUESDAY]
```

---

# 15. EnumSet (Special Collection)

Java provides a special collection for enums.

Example:

```java
import java.util.EnumSet;


enum Permission {

    READ,
    WRITE,
    DELETE

}


public class Main {

    public static void main(String[] args){

        EnumSet<Permission> permissions =
                EnumSet.of(
                    Permission.READ,
                    Permission.WRITE
                );


        System.out.println(permissions);

    }
}
```

Output:

```
[READ, WRITE]
```

Used in:

* Security permissions
* Access control

---

# 16. Enum in Spring Boot (Real Example)

Suppose you create a student management system.

Student entity:

```java
@Entity
class Student {


    @Enumerated(EnumType.STRING)
    private Gender gender;


}
```

Enum:

```java
enum Gender {

    MALE,
    FEMALE,
    OTHER

}
```

Database stores:

```
gender
-------
MALE
FEMALE
OTHER
```

Instead of:

```
1
2
3
```

This is easier to understand.

---

# 17. Important Rules About Enum

### Rule 1:

Enum constants are usually uppercase.

Good:

```java
MONDAY
ADMIN
SUCCESS
```

---

### Rule 2:

Enum cannot extend another class.

Because internally:

```java
enum extends java.lang.Enum
```

Java does not allow multiple inheritance.

---

### Rule 3:

Enum can implement interfaces.

Example:

```java
interface Printable{
    void print();
}


enum Color implements Printable{

    RED,
    BLUE;


    public void print(){
        System.out.println(this);
    }
}
```

---

# 18. When Should You Use Enum?

Use enum when:

✅ Values are fixed
✅ Values are known beforehand
✅ Invalid values should be prevented
✅ The values represent a concept/state/type

Examples:

| Situation     | Enum              |
| ------------- | ----------------- |
| User role     | ADMIN, USER       |
| Order state   | CREATED, SHIPPED  |
| Payment state | SUCCESS, FAILED   |
| Direction     | NORTH, SOUTH      |
| Months        | JANUARY, FEBRUARY |
| Days          | MONDAY, TUESDAY   |

---

# Quick Summary

```
Enum = A type-safe collection of fixed constants
```

Instead of:

```java
String status="DELIVERED";
```

Use:

```java
OrderStatus status = OrderStatus.DELIVERED;
```

Advantages:

* Prevents invalid values
* Cleaner code
* Better readability
* Works with switch
* Can contain fields, constructors, and methods
* Widely used in enterprise applications like Spring Boot

For backend development, especially Spring Boot, enums are essential because real systems are full of states: order status, roles, permissions, payment states, account states, and more.
