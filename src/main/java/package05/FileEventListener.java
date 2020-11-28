package package05;

import java.nio.file.*;

public class FileEventListener {
    public static void main(String[] args) throws InterruptedException {

        try (WatchService service = FileSystems.getDefault().newWatchService()) {
            Path path = Paths.get("src/main/java/demo");
            path.register(service,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);
            boolean poll = true;
            while (poll) {
                WatchKey key = service.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    System.out.println(path + ": " + event.kind() + ": " + event.context());
                }
                poll = key.reset();
            }
         } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
