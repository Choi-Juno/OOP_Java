package assign3_4;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Hero hero = new Hero("Hero", 1, 3);
        Zombie zombie1 = new Zombie("좀비1", 7);
        Zombie zombie2 = new Zombie("좀비2", 15);

        while (true) {
            System.out.print("(1) 왼쪽, (2) 오른쪽 (3) 점프 :");
            int command = sc.nextInt();

            switch (command) {
                case 1:
                    hero.moveLeft();
                    if (zombie1.getCurrentPosition() == hero.getCurrentPosition()
                            || zombie2.getCurrentPosition() == hero.getCurrentPosition()) {
                        System.out.println("좀비에게 잡혔습니다.");
                        break;
                    }
                    break;
                case 2:
                    hero.moveRight();
                    if (zombie1.getCurrentPosition() == hero.getCurrentPosition()
                            || zombie2.getCurrentPosition() == hero.getCurrentPosition()) {
                        System.out.println("좀비에게 잡혔습니다.");
                        break;
                    }
                    break;
                case 3:
                    hero.jump();
                    if (zombie1.getCurrentPosition() == hero.getCurrentPosition()
                            || zombie2.getCurrentPosition() == hero.getCurrentPosition()) {
                        System.out.println("좀비에게 잡혔습니다.");
                        break;
                    }
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
            if (hero.getHealth() <= 0) {
                System.out.println("주인공이 죽었습니다.");
                break;
            }
        }
    }
}
