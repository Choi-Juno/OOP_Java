import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        File file = new File("c:\\temp\\zombie.ini");
        int pos = 1;
        int zom1 = 10;
        int zom2 = 15;
        try {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                String line = pos + " " + zom1 + " " + zom2 +"\n";
                for(int i=0; i<10; i++)
                bw.write(line);
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
	}
}
