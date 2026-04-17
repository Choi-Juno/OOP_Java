package week2;

import java.util.Random;
import java.util.Scanner;

public class assign2_4 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.print("이름: ");
        String player1 = sc.nextLine();
        int dice1 = random.nextInt(6) + 1;
        System.out.println("던진 주사위 숫자는 " + dice1);

        System.out.print("이름: ");
        String player2 = sc.nextLine();
        int dice2 = random.nextInt(6) + 1;
        System.out.println("던진 주사위 숫자는 " + dice2);

        if (dice1 > dice2)
            System.out.println("이긴 사람은 " + player1);
        else if (dice1 < dice2)
            System.out.println("이긴 사람은 " + player2);
        else
            System.out.println("비겼습니다.");

        sc.close();
    }
}
