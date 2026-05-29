import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class zombieGame extends JFrame{
    private final gamePanel panel = new gamePanel();

    public zombieGame() {
        setTitle("Zombie Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(500, 300);
        setVisible(true);
        panel.requestFocusInWindow();
    }

    class gamePanel extends JPanel implements KeyListener{

        private final ImageIcon icon1 = new ImageIcon("zombieGame/images/hero01.png");
        private final ImageIcon icon4 = new ImageIcon("zombieGame/images/hero04.png");
        private final Image right = icon1.getImage();
        private final Image left = icon4.getImage();

        int x = 0;
        int y = 171;
        int direction = 0; // 주인공 방향, 0=right, 1=left

        public gamePanel() {
            this.addKeyListener(this);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.ORANGE);
            g.fillRect(0, 200, getWidth(), getHeight() );
            
            if(direction == 0) {
                g.drawImage(right, x, y, this);
            } else {
                g.drawImage(left, x, y, this);
            }

        }

        @Override
        public void keyTyped(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                x += 5;
                direction = 0;
                repaint();
            } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                x -= 5;
                direction = 1;
                repaint();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    public static void main(String[] args) {
        new zombieGame();
    }
}
