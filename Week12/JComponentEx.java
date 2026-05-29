
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComponentEx extends JFrame {
    public JComponentEx() {
        super("JComponent의 공통 메소드 예제");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JButton btn1 = new JButton("Magenta/Yellow Button");
        JButton btn2 = new JButton(" Disabled Button ");
        JButton btn3 = new JButton("getX(), getY()");

        btn1.setBackground(Color.YELLOW); // 배경색 설정
        btn1.setForeground(Color.MAGENTA);  // 글자색 설정
        btn1.setFont(new Font("AppleGothic", Font.ITALIC, 20));
        btn2.setEnabled(false);
        
        btn3.addActionListener((ActionEvent e) -> {
            JButton b = (JButton)e.getSource();
            JComponentEx frame = (JComponentEx)b.getTopLevelAncestor();
            frame.setTitle(b.getX() + ", " + b.getY());
        });

        // ContentPane에 버튼 부착
        c.add(btn1);
        c.add(btn2);
        c.add(btn3);  

        setVisible(true);
        setSize(260, 200);
    }

    public static void main(String[] args) {
        new JComponentEx();
    }
}
