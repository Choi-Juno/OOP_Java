package week6.zombie2;

import java.util.Random;

public class Zombie extends Unit implements Runnable {
    private final Hero hero;
    public Zombie(String name, int pos, Hero hero) {
        super(name, pos);
        this.hero = hero;
    }
    @Override
    public void run() {

        Random random = new Random();
        try {
            while (true) {
                this.move();
                int sleep = random.nextInt(3) + 1;
                Thread.sleep(sleep * 1000);

                System.out.println(this.name + " 현재 위치는 " + this.pos + "입니다.");

                if (this.hero.pos == this.pos) {
                    System.out.println(this.hero.name + "가 좀비에게 죽었습니다.");
                    this.hero.pos = 1;
                }
            }
        } catch (InterruptedException e) {
            return;
        }
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
