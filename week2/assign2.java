package week2;

import java.util.Scanner;
import java.util.Random;

public class assign2 {
    static final int MAP_MIN = 1;
    static final int MAP_MAX = 20;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int playerPos = 1;
        int zombie1Pos = 7;
        int zombie2Pos = 15;
        while (true) {
            System.out.print("1~3 사이의 숫자 입력하세요: ");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    if (playerPos > MAP_MIN) {
                        playerPos--;
                        System.out.println("왼쪽으로 움직였습니다. 현재 위치는 " + playerPos + "입니다.");
                    } else {
                        System.out.println("왼쪽으로 움직일 수 없습니다. 현재 위치는 " + playerPos + "입니다.");
                    }
                    break;
                case 2:
                    if (playerPos < MAP_MAX) {
                        playerPos++;
                        System.out.println("오른쪽으로 움직였습니다. 현재 위치는 " + playerPos + "입니다.");
                    } else {
                        System.out.println("오른쪽으로 움직일 수 없습니다. 현재 위치는 " + playerPos + "입니다.");
                    }
                    break;
                case 3:
                    int randLoc = random.nextInt(3) + 1;
                    if (playerPos + randLoc <= MAP_MAX) {
                        playerPos += randLoc;
                        System.out.println("점프했습니다. 현재 위치는 " + playerPos + "입니다.");
                    } else
                        System.out.println("점프할 수 없습니다. 현재 위치는 " + playerPos + "입니다.");
                    break;
                default:
                    System.out.println("잘못된 입력입니다 프로그램을 종료합니다.");
                    sc.close();
                    return;
            }
            int zombie1Sign = random.nextInt(2) * 2 - 1;
            int zombie2Sign = random.nextInt(2) * 2 - 1;
            if (zombie1Pos + zombie1Sign >= MAP_MIN && zombie1Pos + zombie1Sign <= MAP_MAX)
                zombie1Pos += zombie1Sign;
            if (zombie2Pos + zombie2Sign >= MAP_MIN && zombie2Pos + zombie2Sign <= MAP_MAX)
                zombie2Pos += zombie2Sign;

            System.out.println("좀비1 위치: " + zombie1Pos);
            System.out.println("좀비2 위치: " + zombie2Pos);
            System.out.println("플레이어 위치: " + playerPos);
            System.out.println("--------------------------------");

            if (playerPos == zombie1Pos || playerPos == zombie2Pos) {
                System.out.println("좀비에게 잡혔습니다. 처음 위치에서 다시 시작합니다.");
                playerPos = 1;
                zombie1Pos = 7;
                zombie2Pos = 15;
            }

            if (playerPos == 20) {
                System.out.println("미션 클리어!!! 목적지에 도착했습니다.");
                sc.close();
                return;
            }
        }
    }
}
