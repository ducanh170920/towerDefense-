import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameStage extends JFrame {

    startPanel st = new startPanel(this);
    controlPanel cp = new controlPanel(this);
    endPanel ep = new endPanel(this);
    pausePanel pp = new pausePanel(this);
    information author = new information(this);
    win win = new win(this);

    Timer timer = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameField.time += timer.getDelay();
            if (GameField.time == 1000) GameField.time = 0;
            repaint();
        }
    });

    public GameStage() {
        try {
            GameField.playSoundTrack();
            initUI();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showAuthor() {
        author.setVisible(true);
        st.setVisible(false);
        cp.setVisible(false);
        ep.setVisible(false);
        pp.setVisible(false);
        win.setVisible(false);
    }

    public void showMenu() {
        st.setVisible(true);
        cp.setVisible(false);
        ep.setVisible(false);
        pp.setVisible(false);
        author.setVisible(false);
        win.setVisible(false);
    }

    public void showPlay() {
        cp.setVisible(true);
        st.setVisible(false);
        ep.setVisible(false);
        pp.setVisible(false);
        author.setVisible(false);
        win.setVisible(false);
    }

    public void showEnd() {
        ep.setVisible(true);
        cp.setVisible(false);
        st.setVisible(false);
        pp.setVisible(false);
        author.setVisible(false);
        win.setVisible(false);
    }

    public void showPause() {
        pp.setVisible(true);
        ep.setVisible(false);
        cp.setVisible(false);
        st.setVisible(false);
        author.setVisible(false);
        win.setVisible(false);
    }

    public void showWin() {
        win.setVisible(true);
        pp.setVisible(false);
        ep.setVisible(false);
        cp.setVisible(false);
        st.setVisible(false);
        author.setVisible(false);
    }

    public void x2() {
        if (GameField.x2 % 2 != 0) timer.setDelay(10);
        else timer.setDelay(20);
    }

    private void initUI() {
        add(st);
        add(cp);
        add(ep);
        add(pp);
        add(author);
        add(win);

        showMenu();

        setLayout(new CardLayout());
        setSize(1280, 744);
        setTitle("TowerDefense");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        GameField.playSoundTrack();
        timer.start();
    }
}

