import java.awt.*;
import java.util.*;
import javax.swing.*;

public class GraphicHero extends JPanel {
    final int MOVE_STEP = 5;
    final int MAX_X = 500;
    final int MAX_Y = 300;

    int x;
    int y;
    int imgWidth = 20;
    int imgHeight = 20;
    int direction = 0; // 0: right, 1: left
    int count;
    int jumpCount = 1;

    Random random = new Random();
    boolean toggle;
    boolean isJump = false;

    ImageIcon heroImgIcon[] = new ImageIcon[6];
    Image img[] = new Image[6];

    public GraphicHero(int x, int y) {
        this.x = x;
        this.y = y;

        for(int i = 0; i < heroImgIcon.length; i++) {
            heroImgIcon[i] = new ImageIcon(
                    String.format("zombieGame/images/hero%02d.png", i + 1));
            img[i] = heroImgIcon[i].getImage();
        }
    }

    public void moveLeft() {
        direction = 1;
        x -= MOVE_STEP;
        if (x < 0) x = 0;
    }
    public void moveRight() {
        direction = 0;
        x += MOVE_STEP;
        if (x > MAX_X - imgWidth) x = MAX_X - imgWidth;
    }

    public boolean heroMove() {
        count++;


        if (isJump) {
            if (jumpCount <= 5) y -= 10;
            else if (jumpCount <= 10) y += 10;
            if (jumpCount == 10) {
                jumpCount = 1;
                isJump = false;
            }
            else jumpCount++;
        }

        if (x >= MAX_X - imgWidth) return true;
        else return false;
    }

    public void paint(Graphics g) {
        if (direction == 1) {
            if (isJump) {
                g.drawImage(img[5], x, y, null);
            } else {
                g.drawImage(img[count % 2 + 3], x, y, null);
            }
        }
        else if (direction == 0) {
            if (isJump) {
                g.drawImage(img[2], x, y, null);
            } else {
                g.drawImage(img[count % 2], x, y, null);
            }
        }
    }

    public boolean crush(GraphicZombie zombie) {
        int cx = x + 10;
        int cy = y + 13;
        int zx = zombie.x + 10;
        int zy = zombie.y + 13;

        double distance = Math.sqrt(Math.pow(cx - zx, 2) + Math.pow(cy - zy, 2));

        if (distance < 20)
            return true;
        else
            return false;
    }
}
