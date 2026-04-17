package week4.fight;

import java.util.Random;

public class Boss extends Character {
    public Boss(String name, int health, int atk) {
        super(name, health, atk);
    }

    public void attack(Character enemy) {
        Random random = new Random();
        int atk = random.nextInt(this.atk) + 1;

        System.out.println(name + "이(가) " + enemy.name + "에게" + atk + "의 데미지를 입혔습니다.");
        enemy.health -= atk;
        System.out.println(enemy.name + "의 체력이 " + atk + "만큼 감소했습니다. 남은 체력: " + enemy.health);
    }

    public void ultimate(Character enemy) {
        System.out.println(name + "이(가) " + enemy.name + "에게 필살기를 사용합니다." + this.atk + "의 데미지를 입혔습니다.");
        enemy.health -= this.atk;
        this.health -= 10;
        System.out.println(enemy.name + "의 체력이 " + this.atk + "만큼 감소했습니다. 남은 체력: " + enemy.health);
        System.out.println(name + "의 체력이 10만큼 감소했습니다. 남은 체력: " + this.health);
    }
}
