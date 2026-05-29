
import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class RSP extends JFrame {
    private final ImageIcon[] image = {
      new ImageIcon("images/assign/gawi.jpg"),
      new ImageIcon("images/assign/bawi.jpg"),
      new ImageIcon("images/assign/bo.jpg"),  
    };
    private final Random random = new Random();

    public RSP() {
        setTitle("가위 바위 보 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel RSPPanel = new JPanel();
        JPanel resultPanel = new JPanel();

        JButton btnGawi = new JButton(image[0]);
        JButton btnBawi = new JButton(image[1]);
        JButton btnBo = new JButton(image[2]);

        JLabel userLabel = new JLabel();
        JLabel comLabel = new JLabel();
        JLabel resultLabel = new JLabel();
        resultLabel.setForeground(Color.RED);

        btnGawi.addActionListener(e -> play(0, userLabel, comLabel, resultLabel));
        btnBawi.addActionListener(e -> play(1, userLabel, comLabel, resultLabel));
        btnBo.addActionListener(e -> play(2, userLabel, comLabel, resultLabel));

        // 상단 가위 바위 보 패널
        RSPPanel.setBackground(Color.GRAY);
        RSPPanel.add(btnGawi);
        RSPPanel.add(btnBawi);
        RSPPanel.add(btnBo);

        // 하단 결과 패널
        resultPanel.setBackground(Color.YELLOW);
        resultPanel.add(userLabel);
        resultPanel.add(new JLabel("me"));
        resultPanel.add(comLabel);
        resultPanel.add(new JLabel("com"));
        resultPanel.add(resultLabel);

        c.add(RSPPanel, BorderLayout.NORTH);
        c.add(resultPanel, BorderLayout.CENTER);

        setSize(500, 400);
        setVisible(true);
    }

    private void play(int user, JLabel userLabel, JLabel comLabel, JLabel resultLabel) {
        int com = random.nextInt(3);

        userLabel.setIcon(image[user]);
        comLabel.setIcon(image[com]);
        resultLabel.setText(getResult(user, com) + "!!");
    }

    private String getResult(int user, int com) {
        if (user == com) {
            return "무승부";
        }
        if ((user == 0 && com == 2) || (user == 1 && com == 0) || (user == 2 && com == 1)) {
            return "승리";
        }
        return "패배";
    }

    public static void main(String[] args) {
        new RSP();
    }
}
