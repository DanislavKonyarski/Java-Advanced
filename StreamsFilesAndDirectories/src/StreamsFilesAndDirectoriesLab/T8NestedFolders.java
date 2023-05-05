package StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class T8NestedFolders {
    public static void main(String[] args) {
        File file = new File("StreamsFilesAndDirectories/resources/Files-and-Streams");
        Deque<File> dir = new ArrayDeque<>();
        dir.offer(file);

        int count = 0;
        while (!dir.isEmpty()){
            File currentFile = dir.poll();
            File[] dirFiles = currentFile.listFiles();
            for (int i = 0; i < dirFiles.length; i++) {
                if (dirFiles[i].isDirectory()){
                    dir.offer(dirFiles[i]);
                    count++;
                    System.out.println(currentFile.getName());
                }
            }
        }
        System.out.println(count +" folders");
    }
}
