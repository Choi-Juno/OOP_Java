package week2;

import java.util.Random;
import java.util.Scanner;

public class assign2_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int wizardHP = 100;
        int warriorHP = 200;

        while (wizardHP > 0 && warriorHP > 0) {
            System.out.print("공격하려면 1을 누르세요 (종료: 0): ");
            int ifAttack = sc.nextInt();

            if (ifAttack == 0) {
                System.out.println("게임을 종료합니다.");
                break;
            }

            if (ifAttack != 1) {
                System.out.println("잘못된 입력입니다. 1 또는 0만 입력하세요.");
                continue;
            }

            int wizardAttack = random.nextInt(10) + 15;
            int warriorAttack = random.nextInt(10) + 5;

            wizardHP -= warriorAttack;
            warriorHP -= wizardAttack;

            if (wizardHP < 0) {
                wizardHP = 0;
            }
            if (warriorHP < 0) {
                warriorHP = 0;
            }

            System.out.println("내 마법사가 " + warriorAttack + "의 데미지를 입었습니다.");
            System.out.println("적 전사가 " + wizardAttack + "의 데미지를 입었습니다.");
            System.out.println("내 마법사의 체력: " + wizardHP);
            System.out.println("적 전사의 체력: " + warriorHP);
        }

        if (wizardHP == 0 && warriorHP == 0) {
            System.out.println("무승부입니다.");
        } else if (wizardHP == 0) {
            System.out.println("적 전사가 이겼습니다.");
        } else if (warriorHP == 0) {
            System.out.println("내 마법사가 이겼습니다.");
        }

    }
}
