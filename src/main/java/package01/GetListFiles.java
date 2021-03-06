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
                .filter(file -> !file.isDirectory() &&  // фильтр: файл не является директорий
                        file.getName().startsWith("Get")) // фильтр: имя файла начинается с "Get..."
                .map(File::getName)
                .collect(Collectors.toSet());
    }
}

class GetListFiles {

    public static void main(String[] args) {
        String dir ="src/main/java/package01/";
        ListFiles listFiles = new ListFiles();
        System.out.println("Получить список файлов в директории: " + dir + "\n..");
        for (String file : listFiles.listFilesUsingJavaIO(dir)) {
            System.out.println(file);
        }
    }
}

/* -------------------------------------------
Получить список файлов в директории: src/main/java/package01/
..
GetListFiles.java
 */