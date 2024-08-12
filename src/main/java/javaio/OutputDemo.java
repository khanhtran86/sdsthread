package javaio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;

public class OutputDemo {
    public static void main_filewriter(String[] args) throws IOException {
        String content = "Hehe, hôm nay thật mát, không nóng như hôm qua, ngồi đây thật thích quá đi\nĐây là dòng mới";
        FileWriter fileWriter = new FileWriter("C:\\ESD\\javaout.txt", true);
        fileWriter.write(content);

        fileWriter.close();
    }

    public static void main_outputstream(String[] args) throws IOException {
        String fileName = "C:\\ESD\\javaout.txt";
        String content = "Hello Samsung SDS, welcome to java.";
        FileOutputStream outputStream = new FileOutputStream(fileName, true);
        byte[] strToByte = content.getBytes();

        outputStream.write(strToByte);
        outputStream.close();
    }

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\ESD\\javaout.txt";
        String content = "Files.write: Hello Samsung SDS, welcome to java. ";

        Path path = Paths.get(fileName);
        byte[] strToByte = content.getBytes();
        Files.write(path, strToByte, StandardOpenOption.APPEND);

    }
}
