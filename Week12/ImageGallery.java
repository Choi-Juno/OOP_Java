import java.awt.*;
import javax.swing.*;

public class ImageGallery extends JFrame {
    final private ImageIcon[] image = {
        new ImageIcon("images/assign/image0.jpg"),
        new ImageIcon("images/assign/image1.jpg"),
        new ImageIcon("images/assign/image2.jpg"),
        new ImageIcon("images/assign/image3.jpg"),
    };
    final private JLabel imageLabel = new JLabel();
    private int imageIndex = 0;

    public ImageGallery() {
        setTitle("이미지 갤러리");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();

        c.setLayout(new BorderLayout());

        // CENTER 이미지
        imageLabel.setIcon(image[imageIndex]);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // 하단 버튼 패널
        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Color.GRAY);
        JButton btnLeft = new JButton(new ImageIcon("images/assign/left.png"));
        JButton btnRight = new JButton(new ImageIcon("images/assign/right.png"));

        btnPanel.add(btnLeft);
        btnPanel.add(btnRight);

        btnLeft.addActionListener(e -> {
            imageIndex--;
            if (imageIndex < 0) {
                imageIndex = image.length - 1;
            }
            imageLabel.setIcon(image[imageIndex]);
        });

        btnRight.addActionListener(e -> {
            imageIndex++;
            if (imageIndex > image.length - 1) {
                imageIndex = 0;
            }
            imageLabel.setIcon(image[imageIndex]);
        });
        c.add(imageLabel, BorderLayout.CENTER);
        c.add(btnPanel, BorderLayout.SOUTH);

        setSize(350, 450);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ImageGallery();
    }
}
