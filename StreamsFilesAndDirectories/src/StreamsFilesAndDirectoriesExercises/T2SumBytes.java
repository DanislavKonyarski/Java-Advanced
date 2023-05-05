package StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class T2SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "StreamsFilesAndDirectories/Resources Exercises/input.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line = reader.readLine();
        int sum = 0;
        while (line!=null){
            for (int i = 0; i < line.length(); i++) {
                sum+= line.charAt(i);
            }
            line = reader.readLine();
        }
        System.out.println(sum);
    }
}
