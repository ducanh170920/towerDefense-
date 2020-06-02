import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pausePanel extends JPanel {
    GameStage gameStage;
    JButton JButtonResume = new JButton(new ImageIcon(getClass().getResource("/Defaultsize/resume.png")));
    JButton JButtonExit = new JButton(new ImageIcon(getClass().getResource("/Defaultsize/exit2.png")));

    public pausePanel(GameStage gameStage) {
        setLayout(null);

        add(JButtonResume);
        add(JButtonExit);

        JButtonResume.setBounds(349, 200, 326, 52);
        JButtonExit.setBounds(349, 300, 326, 62);

        JButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameField.playSoundClick();
                System.exit(0);
            }
        });

        JButtonResume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameField.playSoundClick();
                gameStage.showPlay();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 11; j++) {
                Image img = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile024.png")).getImage();
                g2d.drawImage(img, i * 64, j * 64, null);
            }
        }
        Image bkg = new ImageIcon(getClass().getResource("/Defaultsize/bkg.png")).getImage();
        g2d.drawImage(bkg, 1024, 0, null);
    }
}
