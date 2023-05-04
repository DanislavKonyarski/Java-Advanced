package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class T2WriteToFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = "StreamsFilesAndDirectories/resources/input.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        int byteStream = fileInputStream.read();
        FileOutputStream fileOutputStream = new FileOutputStream("StreamsFilesAndDirectories/resources/02.WriteToFileOutput.txt");
        while (byteStream >= 0) {
            if (byteStream != '.' && byteStream != ',' && byteStream != '!' && byteStream != '?') {
                fileOutputStream.write(byteStream);
            }
            byteStream = fileInputStream.read();
        }
    }
}
