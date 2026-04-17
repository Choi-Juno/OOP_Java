import java.util.Random;

public class Dice extends Thread {
    
    Random random = new Random();

    public Dice(String name) {
        super(name);
    }

    @Override
    public void run() {
        int number = random.nextInt(6) + 1;
        System.out.println(getName() + ":" + number);
    }
}
