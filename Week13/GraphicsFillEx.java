import java.awt.*;
import javax.swing.*;

public class GraphicsFillEx extends JFrame {
    

    class MyPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.fillRect(10, 10, 50, 50);
            g.setColor(Color.BLUE);
            g.fillOval(10, 70, 50, 50);
            g.setColor(Color.GREEN);
            g.fillRoundRect(10, 130, 50, 50, 20, 20);
            g.setColor(Color.MAGENTA);
            g.fillArc(10, 190, 50, 50, 0, 270);
            g.setColor(Color.ORANGE);
            int[] x = {30, 10, 30, 60};
            int[] y = {250, 275, 300, 275};
            g.fillPolygon(x, y, 4);
        }
    }

    
}
