package week4.fight;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        Character hero = new Character("Hero", 200, 15);
        Boss boss = new Boss("Boss", 300, 20);

        while (true) {
            System.out.print("공격하려면 1번을 누르시오: ");
            int command = sc.nextInt();

            if (command == 1) {
                hero.attack(boss);

                // 보스 공격
                // 20% 확률로 필살기
                if (random.nextFloat() > 0.8) {
                    boss.ultimate(hero);
                } else {
                    boss.attack(hero);
                }
            }

            if (hero.health <= 0) {
                System.out.println("패배했습니다.");
                break;
            } else if (boss.health <= 0) {
                System.out.println("승리했습니다.");
                break;
            }
        }
        sc.close();
    }
}
