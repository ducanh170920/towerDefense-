import ObjectsGame.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startPanel extends JPanel {
    GameStage gameStage;
    Image imgStart = new ImageIcon(getClass().getResource("/Defaultsize/BackGround.png")).getImage();

    JButton jButtonPlay = new JButton(new ImageIcon(getClass().getResource("/Defaultsize/play.png")));
    JButton JButtonExit = new JButton(new ImageIcon(getClass().getResource("/Defaultsize/exit.png")));
    JButton JButtonMap1 = new JButton(new ImageIcon(getClass().getResource("/Defaultsize/Map1.png")));
    JButton JButtonMap2 = new JButton(new ImageIcon(getClass().getResource("/Defaultsize/Map2.png")));
    JButton JButtonAuthor = new JButton(new ImageIcon(getClass().getResource("/Defaultsize/author.png")));

    public startPanel(GameStage gameStage) {

        setLayout(null);

        this.gameStage = gameStage;
        add(jButtonPlay);
        add(JButtonExit);
        add(JButtonMap1);
        add(JButtonMap2);
        add(JButtonAuthor);

        jButtonPlay.setBounds(515, 200, 250, 50);

        jButtonPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameField.playSoundClick();
                JButtonMap1.setBounds(455, 300, 200, 150);
                JButtonMap1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        gameStage.cp.setMap(new Map(1));
                        gameStage.showPlay();
                    }
                });

                JButtonMap2.setBounds(665, 300, 200, 150);
                JButtonMap2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GameField.playSoundClick();
                        gameStage.cp.setMap(new Map(2));
                        gameStage.showPlay();
                    }
                });
            }
        });

        JButtonExit.setBounds(560, 580, 162, 40);
        JButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameField.playSoundClick();
                System.exit(0);
            }
        });

        JButtonAuthor.setBounds(560, 500, 162, 40);
        JButtonAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameField.playSoundClick();
                gameStage.showAuthor();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(imgStart, 0, 0, null);
    }
}
