package week4.zombie2;

import java.util.Random;

public class Zombieking extends Unit {
    public Zombieking(String name, int pos) {
        super(name, pos);
    }

    public void move() {
        Random random = new Random();
        int move = random.nextInt(20) + 1;
        this.pos = move;
    }
}
