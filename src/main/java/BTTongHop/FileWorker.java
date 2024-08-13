package BTTongHop;

import java.nio.file.Path;
import java.util.Queue;

public class FileWorker implements Runnable{
    Queue<String> store;
    Path filePath;
    public FileWorker(Queue<String>store, Path filePath)
    {
        this.store = store;
        this.filePath = filePath;
    }
    @Override
    public void run() {
        String content = FileManager.getInstance().readFile(filePath);

        store.add(content);
    }
}
