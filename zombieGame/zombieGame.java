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

    class gamePanel extends JPanel implements KeyListener, Runnable{

        // private final ImageIcon icon1 = new ImageIcon("zombieGame/images/hero01.png");
        // private final ImageIcon icon4 = new ImageIcon("zombieGame/images/hero04.png");
        // private final Image right = icon1.getImage();
        // private final Image left = icon4.getImage();

        GraphicZombie zombie1 = new GraphicZombie(150, 171);
        GraphicZombie zombie2 = new GraphicZombie(350, 171);

        GraphicHero hero = new GraphicHero(0, 171);

        int x = 0;
        int y = 171;
        boolean gameOver = false;
        boolean playgame = true;

        boolean heroDead1, heroDead2;

        public gamePanel() {
            this.addKeyListener(this);

            new Thread(this).start();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.ORANGE);
            g.fillRect(0, 200, getWidth(), getHeight() );
            
            zombie1.paint(g);
            zombie2.paint(g);
            hero.paint(g);

            if (gameOver == true) {
                g.drawString("목적지에 도착했습니다.", 200, 100);
                playgame = false;
            }

            if (heroDead1 || heroDead2) {
                g.setColor(Color.red);
                g.drawString("좀비에게 잡혔습니다.", 200, 150);
                playgame = false;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                hero.moveRight();
                repaint();
            } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                hero.moveLeft();
                repaint();
            } else if(e.getKeyCode() == KeyEvent.VK_UP) { // 점프
                hero.isJump = true;
                repaint();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void run() {
            while (true) {
                zombie1.randomMove();
                zombie2.randomMove();
                gameOver = hero.heroMove();

                heroDead1 = zombie1.crush(hero);
                heroDead2 = zombie2.crush(hero);
                
                if (gameOver) {
                    repaint();
                    break;
                }
                repaint();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.getStackTrace();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        new zombieGame();
    }
}
