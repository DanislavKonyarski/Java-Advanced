package StreamsFilesAndDirectoriesExercises;

import java.io.File;

public class T8GetFolderSize {
    public static void main(String[] args) {
        File file =new File("StreamsFilesAndDirectories/Resources Exercises");
        System.out.println(file.getTotalSpace());
    }
}
