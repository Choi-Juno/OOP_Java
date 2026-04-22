package week7.Zombie;

import java.util.Random;
import java.util.Scanner;

public class Hero extends Unit {
    private final Scanner sc = new Scanner(System.in);

    int hp;

    public Hero(String name, int pos, int hp) {
        super(name, pos, 50);
        this.hp = hp;

    }

    public void move() {
        System.out.print("(1) 왼쪽, (2) 오른쪽 (3) 점프 :");
        int command = sc.nextInt();

        switch (command) {
            case 1:
                left();
                System.out.println(name + " 현재 위치는 " + pos + "입니다.");
                break;
            case 2:
                right();
                System.out.println(name + " 현재 위치는 " + pos + "입니다.");
                break;
            case 3:
                Random random = new Random();
                int jump = random.nextInt(3) + 1;
                pos += jump;
                if (pos > maxPos)
                    pos = maxPos;
                System.out.println(name + " 현재 위치는 " + pos + "입니다.");
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                break;
        }
    }
}
