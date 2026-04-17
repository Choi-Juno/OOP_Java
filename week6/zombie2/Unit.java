package week6.zombie2;

public abstract class Unit {
    String name;
    int pos;

    public Unit(String name, int pos) {
        this.name = name;
        this.pos = pos;
    }

    public void left() {
        if (pos > 1) {
            pos--;
        } else {
            return;
        }
    }

    public void right() {
        if (pos < 20) {
            pos++;
        } else {
            return;
        }
    }

    public abstract void move();
}
