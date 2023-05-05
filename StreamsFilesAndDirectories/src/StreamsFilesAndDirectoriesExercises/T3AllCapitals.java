package StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class T3AllCapitals {
    public static void main(String[] args) throws IOException {
        String path = "StreamsFilesAndDirectories/Resources Exercises/input.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line = reader.readLine();
        PrintWriter writer = new PrintWriter("output.txt");
        while (line!=null){
                writer.println(line.toUpperCase());
            line = reader.readLine();
        }
        writer.close();
        fileInputStream.close();
        reader.close();
    }
}
