package StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class T5LineNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream
                ("StreamsFilesAndDirectories/Resources Exercises/inputLineNumbers.txt")));
        PrintWriter writer = new PrintWriter("output.txt");
        String line = reader.readLine();
        int countLine = 1;
        while (line!=null){
            writer.println(countLine+". "+line);
            line=reader.readLine();
            countLine++;
        }
        reader.close();
        writer.close();
    }
}
