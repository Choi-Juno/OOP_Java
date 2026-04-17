package week5.Zombie;

import java.util.HashMap;

public class Game {
    public static void main(String[] args) {
        Hero hero = new Hero("Hero", 1);
        HashMap<String, Zombie> zombies = new HashMap<>();
        zombies.put("Zombie1", new Zombie("Zombie1", 10));
        zombies.put("Zombie2", new Zombie("Zombie2", 20));
        zombies.put("Zombie3", new Zombie("Zombie3", 30));
        zombies.put("Zombie4", new Zombie("Zombie4", 40));
        zombies.put("Zombie5", new Zombie("Zombie5", 50));

        while (true) {
            hero.move();
            for (Zombie zombie : zombies.values()) {
                zombie.move();
            }

            for (Zombie zombie : zombies.values()) {
                System.out.println(zombie.name + " 현재 위치는 " + zombie.pos + "입니다.");
            }

            if (zombies.values().stream().anyMatch(zombie -> zombie.pos == hero.pos)) {
                System.out.println("좀비에게 잡혔습니다.");
                break;
            }

            if (hero.pos == hero.maxPos) {
                System.out.println("미션 클리어!!! 목적지에 도착했습니다.");
                return;
            }
        }
    }
}
