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
        try {
            boolean hasTime = false;
            Scanner sc = new Scanner(file);
//            FileReader fr = new FileReader(file);

            while (sc.hasNextLine()) {
                if(sc.nextLine().contains("Current time in milliseconds:"))
                    hasTime = true;


            }
            if (!hasTime)
                System.out.println("Does not contain the timestamp");
            else
                System.out.println("The file has the timestamp");
        } catch (IOException e) {
            System.out.println("IO exception");
        }
    }
}
