package book.chap9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {
    public static void main(String[] args) throws IOException{
        String oneLine = processFile((BufferedReader br) -> br.readLine());
        String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());
    }

    private static String processFile(BufferedReaderProcessor bfp) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return bfp.process(br);
        }
    }

    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }
}
