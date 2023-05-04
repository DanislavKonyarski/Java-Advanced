package StreamsFilesAndDirectoriesLab;

import java.io.*;

public class T5WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "StreamsFilesAndDirectories/resources/input.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        PrintWriter printWriter = new PrintWriter("StreamsFilesAndDirectories/resources/05.WriteEveryThirdLineOutput.txt");
        String line = bufferedReader.readLine();
        int count = 1;
        while (line!=null){
            if (count%3==0){
                printWriter.println(line);
            }
            line = bufferedReader.readLine();
            count++;
        }
        printWriter.close();
        bufferedReader.close();
        fileInputStream.close();
    }
}
