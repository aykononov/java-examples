package package05;

/* Мониторинг файлов с использованием службы наблюдения.
*  WatchService - Служба наблюдения, которая отслеживает зарегистрированные объекты на предмет изменений и событий. */
import java.io.IOException;
import java.nio.file.*;

class WatcherServiceExample {
    public static void main(String[] args) {

        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            Path path = Paths.get("src/main/java/package05");
            path.register(watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);
            WatchKey key;
            while ((key = watchService.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    System.out.println(path + ": " + event.kind() + ": " + event.context());
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
/* -----------------------------------------
src\main\java\package05: ENTRY_CREATE: a.txt
src\main\java\package05: ENTRY_MODIFY: a.txt
src\main\java\package05: ENTRY_DELETE: a.txt

 */