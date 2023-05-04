package StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) throws IOException {
        String path = "StreamsFilesAndDirectories/resources/input.txt";
        Scanner scanner = new Scanner(new FileInputStream(path));
        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        InputStream inputStream = new FileInputStream(path);
        PrintWriter printWriter = new PrintWriter(path);
    }
}

