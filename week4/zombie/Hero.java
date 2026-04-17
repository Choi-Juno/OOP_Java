package week4.zombie;

import java.util.Random;

public class Hero {
    String name;
    int position;
    int health;

    public Hero(String name, int position, int health) {
        this.name = name;
        this.position = position;
        this.health = health;
    }

    public void moveLeft() {
        if (this.position > 1) {
            this.position--;
            System.out.println(this.name + "이(가) 왼쪽으로 움직였습니다. 현재 위치는 " + this.position + "입니다");
        } else {
            System.out.println(this.name + "이(가) 왼쪽으로 움직일 수 없습니다. 현재 위치는 " + this.position + "입니다");
        }
    }

    public void moveRight() {
        if (this.position < 20) {
            this.position++;
            System.out.println(this.name + "이(가) 오른쪽으로 움직였습니다. 현재 위치는 " + this.position + "입니다");
        } else {
            System.out.println(this.name + "이(가) 오른쪽으로 움직일 수 없습니다. 현재 위치는 " + this.position + "입니다");
        }
    }

    public void jump() {
        Random random = new Random();
        int jump = random.nextInt(3) + 1;
        this.position += jump;
        if (this.position > 20) {
            this.position = 20;
        }
        System.out.println(this.name + "이(가) 점프했습니다. 현재 위치는 " + this.position + "입니다");
    }

}
