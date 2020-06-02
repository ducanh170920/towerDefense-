import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class endPanel extends JPanel {
    GameStage gameStage;

    JButton JButtonPlayAgain = new JButton(new ImageIcon(getClass().getResource("/Defaultsize/playagain.png")));
    JButton JButtonExit = new JButton(new ImageIcon(getClass().getResource("/Defaultsize/exit2.png")));

    public endPanel(GameStage gameStage) {
        this.gameStage = gameStage;
        setLayout(null);

        add(JButtonPlayAgain);
        JButtonPlayAgain.setBounds(349, 200, 326, 62);
        add(JButtonExit);
        JButtonExit.setBounds(349, 300, 326, 62);

        JButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameField.playSoundClick();
                System.exit(0);
            }
        });

        JButtonPlayAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameField.playSoundClick();
                gameStage.showMenu();
                GameField.countTower = 0;
                GameField.countNumberOfNext = 0;
                GameField.Gold = 60;
                GameField.Alive = 10;
                GameField.listTank = new ArrayList<>();
                GameField.towers = new ArrayList<>();
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

        Font font = new Font("Kino MT", Font.BOLD, 60);
        g2d.setFont(font);
        g2d.drawString("Game Over", 350, 100);
    }
}
