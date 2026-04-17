package week3.assign3_3;

import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Character ryu = new Character("Ryu", 20, 100);
        Character ken = new Character("Ken", 10, 200);

        while (true) {
            System.out.print("공격하려면 (1)을 누르세요: ");
            int command = sc.nextInt();

            if (command == 1) {
                ryu.attack(ken);
                if (ken.health == 0) {
                    System.out.println(ryu.name + " Win!");
                    break;
                }
                ken.attack(ryu);
                if (ryu.health == 0) {
                    System.out.println(ken.name + " Win!");
                    break;
                }
            }
        }
        sc.close();
    }
}
