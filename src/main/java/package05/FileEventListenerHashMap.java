package package05;

/* Мониторинг файлов с помощью пакета java.nio.file */
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class FileEventListenerHashMap {
    public static void main(String[] args) throws InterruptedException {

        try (WatchService service = FileSystems.getDefault().newWatchService()) {
            Map<WatchKey, Path> keyPathMap = new HashMap<>();
            Path path = Paths.get("src/main/java/package05");
            keyPathMap.put(path.register(service,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY),
                    path);
            WatchKey watchKey;
            do {
                watchKey = service.take();
                Path eventDir = keyPathMap.get(watchKey);
                for (WatchEvent<?> event : watchKey.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    Path eventPath = (Path)event.context();
                    System.out.println(eventDir + ": " + kind + ": " + eventPath);
                }
            } while (watchKey.reset());
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }
}
