package package06;
/* Переворот строки. */
class StringReverse {
    public static void main(String[] args) {
        String str = "Hello Java";
        System.out.print("Переворот строки: ");
        for (int i =  str.length()-1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
    }
}
/* -------------------------
Переворот строки: avaJ olleH
 */