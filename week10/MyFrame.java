
import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("Configure Frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500, 400);
        setVisible(true);

        // 메인패널
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.gray);
        mainPanel.setLayout(null);
        add(mainPanel);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        leftPanel.setBackground(Color.yellow);
        leftPanel.setBounds(20, 20, 200, 250);
        leftPanel.add(new JLabel("TYPE ID"));
        leftPanel.add(new JTextField(15));

        mainPanel.add(leftPanel);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        rightPanel.setBackground(Color.green);
        rightPanel.setBounds(230, 20, 200, 250);
        rightPanel.add(new JLabel("Please Check!"));
        rightPanel.add(new JCheckBox());
        mainPanel.add(rightPanel);

        JButton ok = new JButton("OK");
        ok.setBounds(180, 300, 100, 30);
        mainPanel.add(ok);
        
    }
    public static void main(String[] args) {
        MyFrame MyFrame = new MyFrame();
    }
}
