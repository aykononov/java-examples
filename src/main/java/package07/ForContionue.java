package package07;

// Найти все числа кратные 9-ти.
public class ForContionue {
    public static void main(String[] args) {
        for (int i = 0; i < 82; i++) {
            // Оператор деления по модулю % - возвращает остаток от деления.
            if (i % 9 == 0) System.out.print(i + " ");
        }
    }
}
/* ------------------------
0 9 18 27 36 45 54 63 72 81
 */