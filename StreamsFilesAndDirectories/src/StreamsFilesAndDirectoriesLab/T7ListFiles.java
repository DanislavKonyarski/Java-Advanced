package StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class T7ListFiles {
    public static void main(String[] args) {
        File file = new File("StreamsFilesAndDirectories/resources/Files-and-Streams");
        File[] fileRoot = file.listFiles();
        for (int i = 0; i < fileRoot.length; i++) {
            if (!fileRoot[i].isDirectory()){
            System.out.println(fileRoot[i].getName() +": ["+fileRoot[i].length()+"]" );
            }
        }
    }
}
