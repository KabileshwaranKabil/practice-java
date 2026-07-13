package Java_Date;
import java.time.LocalDate; // for date
import java.time.LocalTime; // for time
import java.time.LocalDateTime; // for both date and time
public class CurrentDate{
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalDateTime todayNow = LocalDateTime.now();
        System.out.println(todayNow);
    }
}
    
