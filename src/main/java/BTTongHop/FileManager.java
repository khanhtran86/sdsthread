package BTTongHop;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileManager {
    private static FileManager instance;
    public static FileManager getInstance()
    {
        if(instance==null)
            instance = new FileManager();
        return instance;
    }

    public List<Path> getAllFilePath(String folderPath)
    {
        List<Path> lstPath = new ArrayList<>();
        try {
            Stream<Path> stream = Files.list(Paths.get(folderPath));
            lstPath = stream.map(Path::toAbsolutePath).collect(Collectors.toList());
        }
        catch (IOException ex)
        {

        }
        return lstPath;
    }

    public String readFile(Path filePath)
    {
        String content="";
        try {
            BufferedReader reader = Files.newBufferedReader(filePath);
            String line = "";
            while ((line = reader.readLine()) != null) {
                content += line +"\n";
            }
        }
        catch (IOException ex)
        {

        }
        return content;
    }
}
