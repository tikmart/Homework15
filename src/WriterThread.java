import java.io.*;
import java.util.Scanner;

public class WriterThread extends Thread{
    File file;
    WriterThread(File file){
        this.file = file;


    }


    @Override
    public void run() {
        try(FileWriter fw = new FileWriter(file)) {
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < 10; i++) {
                fw.write(sc.nextLine() + "\n");
            }
            fw.write("Current time in milliseconds: " + System.currentTimeMillis());


        } catch (IOException e){
            System.out.println("I/O error");
        }

    }
}
