package package04;

import java.sql.Timestamp;

public class GetCurrentTimestamp {
    public static void main(String[] args) {
        System.out.println(new Timestamp(System.currentTimeMillis()));
    }
}
