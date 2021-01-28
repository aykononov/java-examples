package package06;
/* Перебор строки в цикле по символам. */
class StringForEach {
    public static void main(String[] args) {
        String str = "Hello Java";
        System.out.print("Перебор строки в цикле: ");
        for (char c : str.toCharArray()) {
            System.out.print(c + " ");
        }
    }
}
/* ----------------------------------------
Перебор строки в цикле: H e l l o   J a v a
 */