package package02;
/* Простая база данных телефонных номеров, построенная на основе
   чтения и записи текстового файла со списком свойств.  */
import javax.imageio.IIOException;
import java.io.*;
import java.util.Properties;

class PhoneBookFromTextFile {
    public static void main(String[] args) throws IOException {
        Properties ht = new Properties();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name, number;
        FileInputStream fin = null;
        boolean changed = false;

        // Попытаться открыть файл phonebook.dat
        try {
            fin = new FileInputStream("src/main/java/package02/phonebook.dat");
        } catch (FileNotFoundException e) {
            // игнорировать отсутствующий файл
        }

        // Если телефонная книга уже существует, загрузить существующие телефонные номера.
        try {
            if (fin != null) {
                ht.load(fin);
                fin.close();
            }
        } catch (IIOException e) {
            System.out.println("Oшибкa чтения файла.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // разрешить пользователю вводить новые имена и номера телефонов абонентов
        do {
            System.out.println("Добавить контакт ('exit' для завершения).\n ввeдитe имя: ");
            name = br.readLine();
            if (name.equals("exit")) continue;
            System.out.println("Bвeдитe номер: ");
            number = br.readLine();
            ht.put(name, number);
            changed = true;
        } while (!name.equals("exit"));

        // сохранить телефонную книгу, если она изменилась
        if (changed) {
            FileOutputStream fout = new FileOutputStream("src/main/java/package02/phonebook.dat");
            ht.store(fout, "Телефонная книга");
            fout.close();
        }

        //искать номер по имени абонента
        do {
            System.out.println("Поиск контакта по имени ('exit' для завершения).\n ввeдитe имя: ");
            name = br.readLine();
            if (name.equals("exit")) continue;
            number = (String) ht.get(name);
            System.out.println("Контакт: " + name + ", " + number);
        } while (!name.equals("exit"));
    }
}
/* ----------------------------------------------
Добавить контакт ('exit' для завершения).
 ввeдитe имя:
alex
Bвeдитe номер:
111
Добавить контакт ('exit' для завершения).
 ввeдитe имя:
elen
Bвeдитe номер:
222
Добавить контакт ('exit' для завершения).
 ввeдитe имя:
exit
Поиск контакта по имени ('exit' для завершения).
 ввeдитe имя:
alex
Контакт: alex, 111
Поиск контакта по имени ('exit' для завершения).
 ввeдитe имя:
exit

 */