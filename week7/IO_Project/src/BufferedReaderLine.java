import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
 
public class BufferedReaderLine {
    public static void main(String[] args) {
        File file = new File("c:\\temp\\zombie.ini");
        
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    String pos[] = line.split(" ");
                    System.out.println(pos[0]);
                    System.out.println(pos[1]);
                    System.out.println(pos[2]);
                    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}