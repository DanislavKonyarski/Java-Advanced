package StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class T4ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "StreamsFilesAndDirectories/resources/input.txt";
        Scanner scanner = new Scanner(new FileInputStream(path));
        PrintWriter printWriter = new PrintWriter("StreamsFilesAndDirectories/resources/04.ExtractIntegersOutput.txt");
        while (scanner.hasNext()){
            if (scanner.hasNextInt()){
                printWriter.println(scanner.nextInt());
            }
            scanner.next();
        }
        scanner.close();
        printWriter.close();

    }
}
