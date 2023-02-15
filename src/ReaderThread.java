import java.io.*;
import java.sql.Time;
import java.util.Scanner;

public class ReaderThread extends Thread {
    File file;


    ReaderThread(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        boolean hasTime = false;
        try {

            Scanner sc = new Scanner(file);


            while (sc.hasNextLine()) {
                if(sc.nextLine().contains("In millis: "))
                    hasTime = true;
            }

            sc.close();

        } catch (IOException e) {
            System.out.println("IO exception");
        }

        try {
        if (!hasTime)
                throw new TimeNotFoundException("Does not contain the timestamp in milliseconds");
        else
            System.out.println("The file has the timestamp in milliseconds");
            } catch (TimeNotFoundException e) {
                throw new RuntimeException(e);
            }

    }
}
