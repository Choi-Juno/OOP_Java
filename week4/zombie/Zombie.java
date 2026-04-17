package week4.zombie;

import java.util.Random;

public class Zombie {
    String name;
    int position;

    public Zombie(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        Random random = new Random();

        int move = random.nextInt(3) + 1;
        if (move == 1) {
            if (this.position > 1) {
                this.position--;
                System.out.println(this.name + "이(가) 왼쪽으로 움직였습니다. 현재 위치는 " + this.position + "입니다");
            } else {
                System.out.println(this.name + "이(가) 왼쪽으로 움직일 수 없습니다. 현재 위치는 " + this.position + "입니다");
            }
        } else if (move == 3) {
            if (this.position < 20) {
                this.position++;
                System.out.println(this.name + "이(가) 오른쪽으로 움직였습니다. 현재 위치는 " + this.position + "입니다");
            } else {
                System.out.println(this.name + "이(가) 오른쪽으로 움직일 수 없습니다. 현재 위치는 " + this.position + "입니다");
            }
        } else {
            System.out.println(this.name + "이(가) 제자리에 있습니다. 현재 위치는 " + this.position + "입니다");
        }
    }
}