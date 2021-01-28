package package07;
// Склонение слов в зависимости от количества.
public class Declination {

    public static void main(String[] args) {
        System.out.println("1 " + getDeclination(1));
        System.out.println("2 " + getDeclination(2));
        System.out.println("5 " + getDeclination(5));
        System.out.println("21 " + getDeclination(21));
        System.out.println("52 " + getDeclination(52));
        System.out.println("105 " + getDeclination(105));
    }

    public static String getDeclination(int count) {
        String one = "день";
        String tow = "дня";
        String five = "дней";

        if (count > 100) count %= 100;
        if (count > 20) count %= 10;
        switch (count) {
            case 1:
                return one;
            case 2:
            case 3:
            case 4:
                return tow;
            default:
                return five;
        }
    }

}

/* ---------
1 день
2 дня
5 дней
21 день
52 дня
105 дней
 */