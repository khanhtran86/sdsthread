package javaio;

import javax.sound.sampled.Line;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class InputDemo {
    //De doc file Java 2 class
    //1. FileReader -> old
    //2. FileInputStream

    public static void main_fileReader(String[] args) throws IOException {
        //Read file C:\\javaio.txt
        FileReader fileReader = new FileReader("C:\\ESD\\javaio.txt");

        int i;
        while ((i = fileReader.read())!=-1)
        {
            System.out.print((char)i);
        }
    }

    public static void main_inputstream(String[] args) throws IOException {
        FileInputStream input = new FileInputStream("C:\\ESD\\javaio.txt");

        int i = input.read();
        while (i!=-1)
        {
            System.out.print((char)i);
            i = input.read();
        }
    }

    public static void main_buffer(String[] args) throws IOException {
        FileReader reader = new FileReader("C:\\ESD\\javaio.txt");
        BufferedReader buffer = new BufferedReader(reader, 16384); //16kb
        String line = "";
        while (true) {
            line = buffer.readLine();
            if(line==null) break;

            System.out.println(line);


        }
    }

    public static void main_NIO_Smalfile(String[] args) throws IOException {
        File file = new File("C:\\ESD\\javaio.txt");
        List<String> lstLines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        String fileContent = lstLines.stream().collect(Collectors.joining("\n"));
        System.out.println(fileContent);
    }

    //NIO Large file
    public static void main_NIO_LargeFIle(String[] args) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\ESD\\javaio.txt"));
        String line = "";
        while ((line = reader.readLine())!=null) {
            System.out.println(line);
        }
    }

    //File on internet
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://portal.vietcombank.com.vn/Usercontrols/TVPortal.TyGia/pXML.aspx");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line = "";
        while ((line = reader.readLine())!=null) {
            System.out.println(line);
        }
    }
}
