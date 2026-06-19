import java.awt.*;
import java.util.*;
import javax.swing.*;

public class GraphicZombie extends JPanel {
    final int MOVE_STEP = 5;
    final int MAX_X = 500;
    final int MAX_Y = 300;

    int x;
    int y;
    int imgWidth = 20;
    int imgHeight = 20;
    int direction = 0; // 0: right, 1: left

    Random random = new Random();
    boolean toggle;

    ImageIcon batImgIcon[] = new ImageIcon[2];
    Image img[] = new Image[2];

    public GraphicZombie(int x, int y) {
        this.x = x;
        this.y = y;

        for(int i = 0; i < batImgIcon.length; i++) {
            batImgIcon[i] = new ImageIcon("zombieGame/images/enemy" + (i+1) + ".png");
            img[i] = batImgIcon[i].getImage();
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

    public void randomMove() {
        direction = random.nextInt(3);
        if (direction == 0);
        else if (direction == 1) moveLeft();
        else if (direction == 2) moveRight();
        toggle = !toggle;
    }
    
    public void paint(Graphics g) {
        if (toggle) g.drawImage(img[0], x, y, null);
        else g.drawImage(img[1], x, y, null);
    }

    public boolean crush(GraphicHero hero) {
        int cx = x + 10;
        int cy = y + 13;
        int zx = hero.x + 10;
        int zy = hero.y + 13;
        
        double distance = Math.sqrt(Math.pow(cx-zx, 2) + Math.pow(cy-zy,2));

        if(distance<20) return true;
        else return false;
    }
}
