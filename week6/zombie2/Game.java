package week6.zombie2;

public class Game {
    public static void main(String[] args) {
        Hero hero = new Hero("Hero", 1);
        Zombie zombie1 = new Zombie("Zombie1", 7, hero);
        Zombie zombie2 = new Zombie("Zombie2", 15, hero);

        Thread t1 = new Thread(zombie1);
        Thread t2 = new Thread(zombie2);
        t1.start();
        t2.start();

        while (true) {
            hero.move();
            if (hero.pos == 20) {
                System.out.println("미션 클리어!!! 목적지에 도착했습니다.");
                t1.interrupt();
                t2.interrupt();
                break;
            }
        }
    }
}
