package week4.zombie2;

public class Game {
    public static void main(String[] args) {
        Hero hero = new Hero("Hero", 1);
        Zombie zombie1 = new Zombie("Zombie1", 7);
        Zombie zombie2 = new Zombie("Zombie2", 15);
        Zombieking zombieking = new Zombieking("Zombieking", 20);

        while (true) {
            hero.move();
            zombie1.move();
            zombie2.move();
            zombieking.move();

            System.out.println("Zombie1 현재 위치는 " + zombie1.pos + "입니다.");
            System.out.println("Zombie2 현재 위치는 " + zombie2.pos + "입니다.");
            System.out.println("Zombieking 현재 위치는 " + zombieking.pos + "입니다.");

            if (hero.pos == zombie1.pos || hero.pos == zombie2.pos || hero.pos == zombieking.pos) {
                System.out.println("좀비에게 잡혔습니다.");
                break;
            }

            if (hero.pos == 20) {
                System.out.println("미션 클리어!!! 목적지에 도착했습니다.");
                break;
            }
        }
    }
}
