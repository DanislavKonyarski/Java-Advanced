package StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class T1SumLines {
    public static void main(String[] args) throws IOException {
        String path = "StreamsFilesAndDirectories/Resources Exercises/input.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line = reader.readLine();
        while (line!=null){
            int sum = 0;
            for (int i = 0; i < line.length(); i++) {
                sum+= line.charAt(i);
            }
            System.out.println(sum);
            line = reader.readLine();
        }
    }
}
