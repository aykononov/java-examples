package package01;

import java.io.File;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Пример выводит все файлы в указанной директории + фильтр.
// Фильтрация коллекций с использованием нескольких критериев.

class ListFiles {

    public Set<String> listFilesUsingJavaIO(String dir) {
        return Stream.of(new File(dir).listFiles())
                //.filter(file -> !file.isDirectory())
                .filter(file -> !file.isDirectory() &&  // фильтр: файл не является директорий
                        file.getName().startsWith("ListFilesDemo")) // фильтр: имя файла начинается с "..."
                .map(File::getName)
                .collect(Collectors.toSet());
    }
}

public class ListFilesDemo {

    public static void main(String[] args) {
        String dir ="src/main/java/ListFiles01/";
        ListFiles listFiles = new ListFiles();
        System.out.println("Перечислить файлы в директории: " + dir + "\n..");
        for (String checkFile : listFiles.listFilesUsingJavaIO(dir)) {
            System.out.println(checkFile);
        }
    }
}

/* -------------------------------------------
Перечислить файлы в директории: src/main/java/ListFiles01/
..
ListFilesDemo.java
 */