package assign3_4;

import java.util.Random;

public class Hero {
    private String name;
    private int currentPosition;
    private int health;

    public Hero(String name, int currentPosition, int health) {
        this.name = name;
        this.currentPosition = currentPosition;
        this.health = health;
    }

    public void jump() {
        Random random = new Random();

        int jump = random.nextInt(3) + 1;
        this.currentPosition += jump;
        System.out.println(name + " 현재 위치는 " + this.currentPosition + "입니다.");
    }

    public void moveLeft() {
        if (currentPosition > 1) {
            currentPosition--;
            System.out.println(name + " 현재 위치는 " + this.currentPosition + "입니다.");
        } else {
            System.out.println(name + " 왼쪽으로 움직일 수 없습니다. 현재 위치는 " + this.currentPosition + "입니다.");
        }
    }

    public void moveRight() {
        if (currentPosition < 20) {
            currentPosition++;
            System.out.println(name + " 현재 위치는 " + this.currentPosition + "입니다.");
        } else {
            System.out.println(name + " 오른쪽으로 움직일 수 없습니다. 현재 위치는 " + this.currentPosition + "입니다.");
        }
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public int getHealth() {
        return this.health;
    }
}
