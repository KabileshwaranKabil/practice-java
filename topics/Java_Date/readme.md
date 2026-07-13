# Java Date and Time API — Complete Beginner Guide

Date and time handling is one of the most common tasks in programming.

Real-world applications constantly deal with:

* User registration dates
* Birthdays
* Order creation time
* Payment timestamps
* Appointment scheduling
* Logging events
* Expiration dates

Java provides a powerful Date and Time API in the package:

```java
java.time
```

This API was introduced in **Java 8** and replaced the older `java.util.Date` and `Calendar` classes.

---

# 1. Why Do We Need Date and Time Classes?

A beginner might think:

> "Why not store dates as String?"

Example:

```java
String date = "14-07-2026";
```

Problems:

### 1. No validation

```java
String date = "99-99-9999";
```

Java accepts it.

---

### 2. Difficult calculations

Example:

```
How many days between two dates?
```

With String:

```java
"14-07-2026" - "20-07-2026"
```

Impossible.

---

### 3. Different formats

Countries represent dates differently:

```
Sri Lanka:
14-07-2026

USA:
07-14-2026

Japan:
2026-07-14
```

Java Date API solves these problems.

---

# 2. Java Date-Time Package

Main package:

```java
java.time
```

Important classes:

| Class             | Purpose                  |
| ----------------- | ------------------------ |
| LocalDate         | Date only                |
| LocalTime         | Time only                |
| LocalDateTime     | Date + Time              |
| ZonedDateTime     | Date + Time + Timezone   |
| Instant           | Machine timestamp        |
| Duration          | Difference between times |
| Period            | Difference between dates |
| DateTimeFormatter | Formatting dates         |

---

# 3. LocalDate (Date Only)

`LocalDate` represents:

```
Year - Month - Day
```

Example:

```java
import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();

        System.out.println(today);

    }
}
```

Output:

```
2026-07-14
```

Format:

```
YYYY-MM-DD
```

---

## Creating a Specific Date

```java
LocalDate birthday =
        LocalDate.of(2003, 5, 20);


System.out.println(birthday);
```

Output:

```
2003-05-20
```

---

# 4. Getting Date Information

Example:

```java
LocalDate date =
        LocalDate.of(2026,7,14);


System.out.println(date.getYear());

System.out.println(date.getMonth());

System.out.println(date.getDayOfMonth());
```

Output:

```
2026
JULY
14
```

---

# 5. Date Calculations

## Adding Days

```java
LocalDate today = LocalDate.now();

LocalDate nextWeek =
        today.plusDays(7);


System.out.println(nextWeek);
```

Example:

```
2026-07-21
```

---

## Adding Months

```java
LocalDate future =
        today.plusMonths(3);
```

---

## Subtracting Days

```java
LocalDate previous =
        today.minusDays(10);
```

---

# 6. Comparing Dates

Example:

```java
LocalDate date1 =
        LocalDate.of(2026,7,10);


LocalDate date2 =
        LocalDate.of(2026,7,20);


System.out.println(date1.isBefore(date2));

System.out.println(date1.isAfter(date2));
```

Output:

```
true
false
```

---

# 7. LocalTime (Time Only)

Represents:

```
Hour : Minute : Second
```

Example:

```java
import java.time.LocalTime;


public class Main {

    public static void main(String[] args){

        LocalTime now =
                LocalTime.now();


        System.out.println(now);

    }
}
```

Output:

```
10:35:45.123456
```

---

## Creating Time

```java
LocalTime time =
        LocalTime.of(10,30);


System.out.println(time);
```

Output:

```
10:30
```

---

# 8. Getting Time Values

```java
LocalTime time =
        LocalTime.now();


System.out.println(time.getHour());

System.out.println(time.getMinute());

System.out.println(time.getSecond());
```

Example output:

```
10
35
45
```

---

# 9. Time Calculations

Add hours:

```java
LocalTime later =
        time.plusHours(2);
```

Subtract minutes:

```java
LocalTime before =
        time.minusMinutes(30);
```

---

# 10. LocalDateTime (Date + Time)

Most commonly used class.

It contains:

```
Year
Month
Day
Hour
Minute
Second
```

Example:

```java
import java.time.LocalDateTime;


public class Main {

    public static void main(String[] args){

        LocalDateTime now =
                LocalDateTime.now();


        System.out.println(now);

    }
}
```

Output:

```
2026-07-14T10:35:20
```

---

Creating:

```java
LocalDateTime meeting =
        LocalDateTime.of(
            2026,
            8,
            1,
            14,
            30
        );


System.out.println(meeting);
```

Output:

```
2026-08-01T14:30
```

---

# 11. Formatting Dates

Usually applications don't show:

```
2026-07-14T10:35:20
```

Instead:

```
14 July 2026
```

We use:

```java
DateTimeFormatter
```

Example:

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Main {

    public static void main(String[] args){

        LocalDateTime now =
                LocalDateTime.now();


        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                    "dd-MM-yyyy HH:mm"
                );


        String formatted =
                now.format(formatter);


        System.out.println(formatted);

    }
}
```

Output:

```
14-07-2026 10:35
```

---

# 12. Common Date Formatting Patterns

| Pattern | Meaning | Example |
| ------- | ------- | ------- |
| dd      | Day     | 14      |
| MM      | Month   | 07      |
| yyyy    | Year    | 2026    |
| HH      | Hour    | 18      |
| mm      | Minute  | 30      |
| ss      | Second  | 45      |

Example:

```java
"dd/MM/yyyy"
```

Output:

```
14/07/2026
```

---

# 13. Converting String to Date

Real applications receive dates as strings.

Example:

Input:

```
"2026-07-14"
```

Convert:

```java
String input = "2026-07-14";


LocalDate date =
        LocalDate.parse(input);


System.out.println(date);
```

---

Custom format:

```java
DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("dd-MM-yyyy");


LocalDate date =
        LocalDate.parse(
            "14-07-2026",
            formatter
        );
```

---

# 14. Period (Difference Between Dates)

Example:

Calculate age:

```java
import java.time.Period;


LocalDate birth =
        LocalDate.of(2003,5,20);


LocalDate today =
        LocalDate.now();


Period age =
        Period.between(birth,today);


System.out.println(age.getYears());
```

Output:

```
23
```

---

# 15. Duration (Difference Between Times)

Used for time differences.

Example:

```java
import java.time.Duration;


LocalTime start =
        LocalTime.of(10,0);


LocalTime end =
        LocalTime.of(12,30);


Duration duration =
        Duration.between(start,end);


System.out.println(duration.toMinutes());
```

Output:

```
150
```

---

# 16. ZonedDateTime (Date + Time Zone)

Important for global applications.

Example:

A company has users:

```
Sri Lanka
USA
Japan
```

Each location has different time.

Example:

```java
import java.time.ZonedDateTime;


ZonedDateTime now =
        ZonedDateTime.now();


System.out.println(now);
```

Output:

```
2026-07-14T10:35+05:30[Asia/Colombo]
```

---

Specific timezone:

```java
import java.time.ZoneId;


ZonedDateTime japanTime =
        ZonedDateTime.now(
            ZoneId.of("Asia/Tokyo")
        );


System.out.println(japanTime);
```

---

# 17. Instant (Machine Timestamp)

Used internally by systems.

Example:

```java
import java.time.Instant;


Instant timestamp =
        Instant.now();


System.out.println(timestamp);
```

Output:

```
2026-07-14T05:05:20Z
```

Commonly used for:

* Logs
* Database timestamps
* API communication

---

# 18. Real Spring Boot Example

Imagine an Order entity:

```java
@Entity
public class Order {


    @Id
    private Long id;


    private LocalDate orderDate;


    private LocalDateTime createdAt;

}
```

Database:

| id | order_date | created_at       |
| -- | ---------- | ---------------- |
| 1  | 2026-07-14 | 2026-07-14 10:30 |

---

Automatically set creation time:

```java
@CreationTimestamp
private LocalDateTime createdAt;
```

Hibernate automatically fills it.

---

# 19. Old Date API (Avoid)

Old Java:

```java
java.util.Date
```

Example:

```java
Date date = new Date();
```

Problems:

* Mutable
* Poor design
* Difficult timezone handling

Modern Java:

```java
LocalDate
LocalDateTime
ZonedDateTime
```

are preferred.

---

# 20. Important Concept: Immutable Objects

Java Time classes are immutable.

Example:

```java
LocalDate date =
        LocalDate.now();


date.plusDays(5);


System.out.println(date);
```

The date does NOT change.

Why?

Because:

```java
plusDays()
```

creates a new object.

Correct:

```java
date = date.plusDays(5);
```

---

# 21. Real-World Usage Map

| Application Feature     | Java Class        |
| ----------------------- | ----------------- |
| Birthday                | LocalDate         |
| Student admission date  | LocalDate         |
| Order created time      | LocalDateTime     |
| Login timestamp         | Instant           |
| Meeting schedule        | ZonedDateTime     |
| Delivery duration       | Duration          |
| Age calculation         | Period            |
| Formatting API response | DateTimeFormatter |

---

# Summary

Java Date-Time API:

```
java.time
```

Main classes:

```
LocalDate
    ↓
Date only

LocalTime
    ↓
Time only

LocalDateTime
    ↓
Date + Time

ZonedDateTime
    ↓
Date + Time + Timezone

Instant
    ↓
Machine timestamp
```

For backend development (especially Spring Boot), you should be comfortable with:

1. `LocalDate`
2. `LocalDateTime`
3. `DateTimeFormatter`
4. `Period`
5. `Duration`
6. `ZonedDateTime`

These appear frequently in REST APIs, databases, authentication, logging, and enterprise applications.
