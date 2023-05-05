package StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class T7MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(
                "StreamsFilesAndDirectories/Resources Exercises/inputOne.txt")));
        PrintWriter writer = new PrintWriter("output.txt");
        String line = reader.readLine();
        while (line != null) {
            writer.println(line);
            line = reader.readLine();
        }
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(
                "StreamsFilesAndDirectories/Resources Exercises/inputTwo.txt")));
        line = reader.readLine();
        while (line != null) {
            writer.println(line);
            line = reader.readLine();
        }
        writer.close();
        reader.close();
    }
}
