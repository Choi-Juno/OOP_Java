
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class GraphicsClipEx extends JFrame {
    private final MyPanel panel = new MyPanel();

    public GraphicsClipEx() {
        setTitle("클리핑 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(300, 420);
        setVisible(true);
    }

    class MyPanel extends JPanel implements MouseMotionListener {
        private final ImageIcon icon = new ImageIcon("Week13/images/apple.jpg");
        private final Image img = icon.getImage();

        int x = 0;
        int y = 0;

        public MyPanel() {
            this.addMouseMotionListener(this);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setClip(x, y, 150, 150);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Arial", Font.ITALIC, 40));
            g.drawString("GO APPLE!!", 10, 150);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            x = e.getX();
            y = e.getY();

            repaint();
        }
    }

    public static void main(String[] args) {
        new GraphicsClipEx();
    }
}
