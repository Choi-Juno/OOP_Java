package week4.zombie;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hero hero = new Hero("Juno", 1, 3);
        Zombie zombie1 = new Zombie("좀비1", 7);
        Zombie zombie2 = new Zombie("좀비2", 15);

        while (true) {
            System.out.print("(1) 왼쪽, (2) 오른쪽 (3) 점프 :");
            int command = sc.nextInt();

            zombie1.move();
            zombie2.move();

            switch (command) {
                case 1:
                    hero.moveLeft();
                    if (zombie1.position == hero.position || zombie2.position == hero.position) {
                        System.out.println("좀비에게 잡혔습니다.");
                        hero.health -= 1;
                        hero.position = 1;
                        break;
                    }
                    break;
                case 2:
                    hero.moveRight();
                    if (zombie1.position == hero.position || zombie2.position == hero.position) {
                        System.out.println("좀비에게 잡혔습니다.");
                        hero.health -= 1;
                        hero.position = 1;
                        break;
                    }
                    break;
                case 3:
                    hero.jump();
                    if (zombie1.position == hero.position || zombie2.position == hero.position) {
                        System.out.println("좀비에게 잡혔습니다.");
                        hero.health -= 1;
                        hero.position = 1;
                        break;
                    }
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
            if (hero.health <= 0) {
                System.out.println("주인공이 죽었습니다.");
                hero.health -= 1;
                if (hero.health <= 0) {
                    System.out.println(hero.name + "이(가) 죽었습니다.");
                    break;
                }
                hero.position = 1;
            }

            if (hero.position == 20) {
                System.out.println("미션 클리어!!! 목적지에 도착했습니다.");
                break;
            }

            System.out.println("--------------------------------");
            System.out.println("좀비1 위치: " + zombie1.position);
            System.out.println("좀비2 위치: " + zombie2.position);
            System.out.println("플레이어 위치: " + hero.position);
            System.out.println("플레이어 체력: " + hero.health);
            System.out.println("--------------------------------");
        }
        sc.close();
    }
}
