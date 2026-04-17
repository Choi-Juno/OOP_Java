package week4.zombie2;

import java.util.Random;

public class Zombie extends Unit {
    public Zombie(String name, int pos) {
        super(name, pos);
    }

    public void move() {
        Random random = new Random();
        int move = random.nextInt(2) + 1;
        if (move == 1) {
            left();
        } else {
            right();
        }
    }
}
