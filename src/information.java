import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class information extends JPanel {
    GameStage gameStage;

    JButton JButtonBack = new JButton(new ImageIcon(getClass().getResource("/Defaultsize/back.png")));

    public information(GameStage gameStage) {
        this.gameStage = gameStage;
        setLayout(null);
        add(JButtonBack);
        JButtonBack.setBounds(20, 634, 100, 50);
        JButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameField.playSoundClick();
                gameStage.showMenu();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 11; j++) {
                Image img = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile024.png")).getImage();
                g2d.drawImage(img, i * 64, j * 64, null);
            }
        }

        Font font = new Font("Kino MT", Font.BOLD, 60);
        g2d.setFont(font);
        g2d.drawString("Author:", 250, 100);
        font = new Font("Kino MT", Font.BOLD, 40);
        g2d.setFont(font);
        g2d.drawString("Hoàng Đức Anh (18020138)", 350, 180);
        g2d.drawString("Nguyễn Đức Công (18020245)", 350, 260);
        g2d.drawString("Nguyễn Tiến Đạt (18020290)", 350, 340);
    }
}
