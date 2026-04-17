package week2;

import java.util.Scanner;

public class assign2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        System.out.print("Enter your birth: ");
        int birth = sc.nextInt();
        System.out.print("Enter your height: ");
        float height = sc.nextFloat();

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Birth: " + birth);
        System.out.println("Height: " + height);

        sc.close();
    }
}
