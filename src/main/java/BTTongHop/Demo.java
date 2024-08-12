package BTTongHop;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) throws IOException {
        Stream<Path> stream = Files.list(Paths.get("C:\\ESD"));
        List<Path> lstPath = stream.map(
                (s)->s.toAbsolutePath()
        ).collect(Collectors.toList());

        for (Path p: lstPath)
        {
            System.out.println(p.toAbsolutePath());
        }
    }
}
