import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class win extends JPanel {
    GameStage gameStage;

    JButton JButonPlayAgain = new JButton(new ImageIcon(getClass().getResource("/Defaultsize/playagain.png")));
    JButton JButtonExit = new JButton(new ImageIcon(getClass().getResource("/Defaultsize/exit2.png")));

    public win(GameStage gameStage) {
        this.gameStage = gameStage;
        setLayout(null);
        add(JButonPlayAgain);
        JButonPlayAgain.setBounds(350, 200, 326, 62);
        JButonPlayAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameStage.showMenu();
            }
        });
        add(JButtonExit);
        JButtonExit.setBounds(350, 312, 326, 62);
        JButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
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

        Font font = new Font("Kino MT", Font.BOLD, 100);
        g2d.setFont(font);
        g2d.drawString("You Win", 350, 100);
    }
}
