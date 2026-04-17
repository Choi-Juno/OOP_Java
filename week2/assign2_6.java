package week2;

import java.util.Random;
import java.util.Scanner;

public class assign2_6 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.print("가위(1) 바위(2) 보(3) 중 하나를 입력하시오: ");
        int user = sc.nextInt();

        int computer = random.nextInt(3) + 1;

        switch (computer) {
            case 1:
                if (user == 1)
                    System.out.println("나는 가위, 컴퓨터는 가위를 냈습니다. 비겼습니다.");
                else if (user == 2)
                    System.out.println("나는 바위, 컴퓨터는 가위를 냈습니다. 내가 이겼습니다.");
                else
                    System.out.println("나는 보, 컴퓨터는 가위를 냈습니다. 컴퓨터가 이겼습니다.");
                break;
            case 2:
                if (user == 1)
                    System.out.println("나는 가위, 컴퓨터는 바위를 냈습니다. 컴퓨터가 이겼습니다.");
                else if (user == 2)
                    System.out.println("나는 바위, 컴퓨터는 바위를 냈습니다. 비겼습니다.");
                else
                    System.out.println("나는 보, 컴퓨터는 바위를 냈습니다. 내가 이겼습니다.");
                break;
            case 3:
                if (user == 1)
                    System.out.println("나는 가위, 컴퓨터는 보를 냈습니다. 내가 이겼습니다.");
                else if (user == 2)
                    System.out.println("나는 바위, 컴퓨터는 보를 냈습니다. 컴퓨터가 이겼습니다.");
                else
                    System.out.println("나는 보, 컴퓨터는 보를 냈습니다. 비겼습니다.");
                break;
            default:
                System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
                sc.close();
                break;
        }
    }
}
