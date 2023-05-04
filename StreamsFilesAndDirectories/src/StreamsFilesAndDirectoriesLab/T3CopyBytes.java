package StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.Scanner;

public class T3CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "StreamsFilesAndDirectories/resources/input.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        int bytStream = bufferedInputStream.read();
        PrintWriter printWriter = new PrintWriter("StreamsFilesAndDirectories/resources/03.CopyBytesOutput.txt");
        while (bytStream>=0){
            if (bytStream==' '){
                printWriter.print(" ");
            } else if (bytStream=='\n') {
                printWriter.println();
            }else {
            printWriter.print(bytStream);
            }
            bytStream= bufferedInputStream.read();
        }
    }
}
