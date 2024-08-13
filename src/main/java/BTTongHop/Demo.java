package BTTongHop;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) throws IOException {
        Queue<String> store = new LinkedList<>();
        String folderPath = "C:\\ESD";
        List<Path> lstFiles = FileManager.getInstance().getAllFilePath(folderPath);
        ExecutorService fileExecutor = Executors.newSingleThreadExecutor();
        for (Path filePath: lstFiles)
        {
            fileExecutor.execute(new FileWorker(store, filePath));
        }


        ExecutorService contentExecutor = Executors.newSingleThreadExecutor();
        contentExecutor.execute(new ContentWorker(store));

    }
}
