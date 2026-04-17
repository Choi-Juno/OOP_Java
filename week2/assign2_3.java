package week2;

import java.util.Random;
import java.util.Scanner;

public class assign2_3 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;

        int sum = dice1 + dice2;
        double avg = (double) sum / 2;

        System.out.print("Enter your birth: ");
        int birth = sc.nextInt();

        System.out.print("Enter your height: ");
        double height = sc.nextDouble();

        System.out.println("주사위 두개 합: " + sum);
        System.out.println("주사위 두개 평균: " + avg);
        System.out.println("당신의 생년월일: " + birth);
        System.out.println("당신의 키: " + height);

        sc.close();
    }
}
