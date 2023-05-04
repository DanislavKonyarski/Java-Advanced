package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class T1ReadFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = "StreamsFilesAndDirectories/resources/input.txt";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            int byteStream = fileInputStream.read();
            while (byteStream>=0){
                System.out.print(Integer.toBinaryString(byteStream)+" ");
                byteStream = fileInputStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}
