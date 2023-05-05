package StreamsFilesAndDirectoriesLab;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class T6SortLines {
    public static void main(String[] args) throws IOException {
        List<String> line = Files.readAllLines(Path.of("StreamsFilesAndDirectories/resources/input.txt"));
        Collections.sort(line);
        PrintWriter printWriter = new PrintWriter("StreamsFilesAndDirectories/resources/06.SortLinesOutput.txt");
        printWriter.print(String.join("\n",line));
        printWriter.close();
    }
}
