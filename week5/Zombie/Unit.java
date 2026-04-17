package week5.Zombie;

public abstract class Unit {
    String name;
    int pos;
    int maxPos;

    public Unit(String name, int pos, int maxPos) {
        this.name = name;
        this.pos = pos;
        this.maxPos = maxPos;
    }

    public void left() {
        if (pos > 1) {
            pos--;
        } else {
            return;
        }
    }

    public void right() {
        if (pos < maxPos) {
            pos++;
        } else {
            return;
        }
    }

    public abstract void move();
}
