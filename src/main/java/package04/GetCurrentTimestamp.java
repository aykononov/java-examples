package package04;

/* Получить текущую метку времени */

import java.sql.Timestamp;

class GetCurrentTimestamp {
    public static void main(String[] args) {
        System.out.println(new Timestamp(System.currentTimeMillis()));
    }
}

/*---------------------
2020-11-25 15:36:10.581
 */