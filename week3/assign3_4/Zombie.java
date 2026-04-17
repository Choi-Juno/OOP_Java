package assign3_4;

import java.util.Random;

public class Zombie {
    private String name;
    private int currentPosition;

    public Zombie(String name, int currentPosition) {
        this.name = name;
        this.currentPosition = currentPosition;
    }

    public void move() {
        Random random = new Random();

        int move = random.nextInt(3) + 1;

        if (move == 1) {
            if (this.currentPosition > 1) {
                this.currentPosition--;
                System.out.println(name + " 현재 위치는 " + this.currentPosition + "입니다.");
            }
        } else if (move == 2) {
            System.out.println(name + " 현재 위치는 " + this.currentPosition + "입니다.");
        } else if (move == 3) {
            if (this.currentPosition < 20) {
                this.currentPosition++;
                System.out.println(name + " 현재 위치는 " + this.currentPosition + "입니다.");
            }
        }
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }
}
