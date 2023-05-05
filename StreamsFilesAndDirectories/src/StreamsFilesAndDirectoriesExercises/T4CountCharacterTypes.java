package StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T4CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String path = "StreamsFilesAndDirectories/Resources Exercises/input.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        PrintWriter writer = new PrintWriter("output.txt");
        String line = reader.readLine();

        int vowels = 0;
        int otherSymbol = 0;
        int punctuation = 0;
        while (line != null) {

            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i'
                        || line.charAt(i) == 'o' || line.charAt(i) == 'u') {
                    vowels++;
                } else if (line.charAt(i)=='.'||line.charAt(i)==','
                ||line.charAt(i)=='!'||line.charAt(i)=='?') {
                    punctuation++;
                } else if (line.charAt(i)!=' '){
                    otherSymbol++;
                }
            }
            line = reader.readLine();
        }
        writer.println("Vowels: "+vowels);
        writer.println("Other symbols: "+otherSymbol);
        writer.println("Punctuation: "+punctuation);
        writer.close();
        reader.close();
        fileInputStream.close();
    }
}
