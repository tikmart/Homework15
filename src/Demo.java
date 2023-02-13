import java.io.*;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Demo {
    public static void main(String[] args) throws FileNotFoundException {
        final String source = "C:\\Users\\Tigran\\Documents\\The Files\\HomeworkFile.txt";
        File file = new File(source);

        WriterThread writer = new WriterThread(file);
        ReaderThread reader = new ReaderThread(file);


        try {
            writer.start();
            writer.join();
            reader.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }








    }
}
