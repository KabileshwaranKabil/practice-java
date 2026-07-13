// package Java_Enums;
public class Enumeration{
    enum Level{
        EASY,
        MEDIUM,
        HARD
    }
    public static void main(String[] args) {
        Level myLevel = Level.MEDIUM;
        System.out.println(myLevel);
    }
}