
import java.awt.*;
import javax.swing.*;

public class GraphicsDrawImageEx3 extends JFrame {
    private final MyPanel panel = new MyPanel();

    public GraphicsDrawImageEx3() {
        setTitle("원본 크기로 원하는 위치에 이미지 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(300, 420);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        private final ImageIcon icon = new ImageIcon("Week13/images/apple.jpg");
        private final Image img = icon.getImage();

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 20, 20, 250, 100, 100, 50, 200, 200, this);
        }
    }

    public static void main(String[] args) {
        new GraphicsDrawImageEx2();
    }
}
