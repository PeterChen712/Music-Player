import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Main {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {

        Scanner input = new Scanner(System.in);

        File file = new File("Passenger _ Let Her Go (Official Video).wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        int response;
        System.out.printf("%s%n", "=".repeat(100));
        System.out.println("Music Player by PeterChen712");
        System.out.printf("%s%n", "=".repeat(100));


        while (true) {
            System.out.print("Choice :\n1. Play\n2. Pause\n3. -10 sec\n4. +10 sec\n5. Exit\n= ");
            response = input.nextInt();

            switch (response) {
                case 1:
                    clip.start();
                    break;
                case 2:
                    clip.stop();
                    System.out.println("Press any key to resume...");
                    input.nextLine();
                    input.nextLine(); 
                    clip.start(); 
                    break;
                case 3:
                    clip.setMicrosecondPosition(clip.getMicrosecondPosition() - 10_000_000); 
                    break;
                case 4:
                    clip.setMicrosecondPosition(clip.getMicrosecondPosition() + 10_000_000); 
                    break;
                case 5:
                    System.out.println("Exiting...");
                    clip.close(); 
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
            }

        }
    }
}
