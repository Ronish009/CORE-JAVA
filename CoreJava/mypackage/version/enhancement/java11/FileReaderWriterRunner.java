package mypackage.version.enhancement.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderWriterRunner {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./resources/java11.txt");
        String fileconetxt = Files.readString(path);
        System.out.println(fileconetxt);
        String newFileContent = fileconetxt.replace("Salman","Sharukh");
        Path newpath = Paths.get("./resources/java11-new.txt");
        Files.writeString(newpath,newFileContent);
        System.out.println("Completed !!!");
    }
}
