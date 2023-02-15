import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class WriterThread extends Thread {
    File file;

    WriterThread(File file) {
        this.file = file;


    }


    @Override
    public void run() {
        Date date = new Date();
        try (FileWriter fw = new FileWriter(file)) {
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < 5; i++) {
                fw.write(sc.nextLine() + "\n");
            }
            System.out.println("Would you like to add the current date to the file?");
            String response = sc.nextLine();
            fw.write("Created on: " + date.toString() + "\n");
            if (response.equalsIgnoreCase("yes"))
                fw.write("In millis: " + System.currentTimeMillis());


            sc.close();

        } catch (IOException e) {
            System.out.println("I/O error");
        }

    }
}
