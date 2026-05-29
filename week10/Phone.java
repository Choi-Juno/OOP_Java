
import java.awt.*;
import javax.swing.*;

public class Phone extends JFrame {
    public Phone() {
        setTitle("최준오의 전화");
        setSize(400, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        this.setLayout(new BorderLayout(10, 10));
        
        // Top - JTextField
        add(new JTextField(15), BorderLayout.NORTH);

        // Center - GridLayout
        JPanel dial = new JPanel();
        dial.setLayout(new GridLayout(4, 3, 5, 5));
        dial.add(new JButton("1"));
        dial.add(new JButton("2"));
        dial.add(new JButton("3"));
        dial.add(new JButton("4"));
        dial.add(new JButton("5"));
        dial.add(new JButton("6"));
        dial.add(new JButton("7"));
        dial.add(new JButton("8"));
        dial.add(new JButton("9"));
        dial.add(new JButton("*"));
        dial.add(new JButton("0"));
        dial.add(new JButton("#"));
        add(dial, BorderLayout.CENTER);

        // Bottom
        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bottom.add(new JLabel("키패드"));
        bottom.add(new JLabel("최근 기록"));
        bottom.add(new JLabel("연락처"));
        add(bottom, BorderLayout.SOUTH);
    }
    
    public static void main(String[] args) {
        new Phone();
    }
}
