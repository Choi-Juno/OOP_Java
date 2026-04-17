package week4.fight;

import java.util.Random;

public class Character {
    String name;
    int health;
    int atk;

    public Character(String name, int health, int atk) {
        this.name = name;
        this.health = health;
        this.atk = atk;
    }

    public void attack(Boss enemy) {
        Random random = new Random();
        int atk = random.nextInt(this.atk) + 1;
        System.out.println(name + "이(가) " + enemy.name + "에게" + atk + "의 데미지를 입혔습니다.");
        enemy.health -= atk;
        System.out.println(enemy.name + "의 체력이 " + atk + "만큼 감소했습니다. 남은 체력: " + enemy.health);
    }
}
