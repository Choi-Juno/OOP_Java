package week3.assign3_3;

import java.util.Random;

public class Character {
    public String name;
    public int attackPower;
    public int health;

    public Character(String name, int attackPower, int health) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void attack(Character enemy) {
        Random random = new Random();
        int atk = random.nextInt(attackPower) + 1;
        System.out.println(name + "이(가) " + atk + "의 데미지를 입혔습니다.");
        enemy.health -= atk;
        if (enemy.health <= 0) {
            enemy.health = 0;
        }
        System.out.println(enemy.name + "의 체력이 " + atk + "만큼 감소했습니다. 남은 체력: " + enemy.health);
    }
}
