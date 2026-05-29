import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WeekAssign9 extends JFrame {
    JLabel imageLabel = new JLabel();

    public WeekAssign9() {
        setTitle("Action 이벤트 리스너 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();

        HeroMouseAdapter adapter = new HeroMouseAdapter();
        c.addMouseListener(adapter);
        c.addMouseMotionListener(adapter);
        c.setLayout(null);

        ImageIcon image = new ImageIcon("images/paladog1.png");
        imageLabel.setIcon(image);
        imageLabel.setLocation(-10,-10);
        imageLabel.setSize(192, 156);
        c.add(imageLabel);

        setSize(500, 500);
        setVisible(true);
    }
    class HeroMouseAdapter extends MouseAdapter {
        int prevX = -1;
        int prevY = -1;

        @Override
        public void mousePressed(MouseEvent e) {
            int mouseX = e.getX();
            int mouseY = e.getY();

            if (mouseX == prevX && mouseY == prevY) {
                // 1. 같은 위치에서 클릭하면 이미지가 앞으로 1씩 이동
                imageLabel.setLocation(imageLabel.getX() + 10, imageLabel.getY());
            }else{
                // 2. 다른 위치에서 클릭하면 이미지가 마우스 위치로 이동
                // 이미지 크기 고려해 mouse - 20 으로 조정
                imageLabel.setLocation(mouseX - 20, mouseY - 20);
            }

            prevX = mouseX;
            prevY = mouseY;
        }
        
        @Override
        public void mouseDragged(MouseEvent e) {
            // 3. 드래그하면 이미지가 마우스를 따라 이동
            imageLabel.setLocation(e.getX(), e.getY());
        }
    }

    public static void main(String[] args) {
        new WeekAssign9();
    }
}
    
