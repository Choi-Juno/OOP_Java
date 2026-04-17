package week2;

import java.util.Random;
import java.util.Scanner;

public class assgin2_5 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int location = 1;
        while (true) {
            System.out.print("1~3 사이의 숫자 입력하세요: ");
            int command = sc.nextInt();

            switch (command) {
                case 1:
                    location++;
                    System.out.println("왼쪽으로 움직였습니다. 현재 위치는 " + location + "입니다.");
                    break;
                case 2:
                    location--;
                    System.out.println("오른쪽으로 움직였습니다. 현재 위치는 " + location + "입니다.");
                    break;
                case 3:
                    int randLoc = random.nextInt(3) + 1;
                    location += randLoc;
                    System.out.println("점프했습니다. 현재 위치는 " + location + "입니다.");
                    break;
                default:
                    System.out.println("잘못된 입력입니다 프로그램을 종료합니다.");
                    sc.close();
                    return;
            }
        }
    }
}
