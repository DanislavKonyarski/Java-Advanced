package StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class T6WordCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream
                ("StreamsFilesAndDirectories/Resources Exercises/text.txt")));
        PrintWriter writer = new PrintWriter("output.txt");
        String line = reader.readLine();
        int ofCount = 0;
        int whichCount = 0;
        int theCount = 0;
        while (line != null) {
            String[] words = line.split("\\s+");
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals("of")){
                    ofCount++;
                } else if (words[i].equals("which")) {
                    whichCount++;
                } else if (words[i].equals("The")) {
                    theCount++;
                }
            }
            line = reader.readLine();
        }
        writer.println("of - "+ofCount);
        writer.println("which - "+whichCount);
        writer.println("The - "+theCount);
        writer.close();
        reader.close();
    }
}
