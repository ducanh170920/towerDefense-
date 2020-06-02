import ObjectsGame.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class controlPanel extends JPanel implements ActionListener {

    GameStage gameStage;

    NormalTower normalTower = new NormalTower(-100, -100);
    SniperTower sniperTower = new SniperTower(-100, -100);
    MachineGunTower machineGunTower = new MachineGunTower(-100, -100);
    Map map;


    public void setMap(Map map) {
        this.map = map;
    }

    boolean flagTower = false;
    int click = 0;
    int towerNumber = -1;
    int countClickObj = 0;
    boolean clickNext = false;

    Graphics2D g2d;

    JButton JButtonNormalTower = new JButton(new ImageIcon(getClass().getResource("/Defaultsize/NormalTower.png")));
    JButton JButtonSniperTower = new JButton(new ImageIcon(getClass().getResource("/Defaultsize/SniperTower.png")));
    JButton JButtonMachineGunTower = new JButton(new ImageIcon(getClass().getResource("/Defaultsize/MachineGunTower.png")));
    JButton JButtonNextLevel = new JButton(new ImageIcon(getClass().getResource("/Defaultsize/nextlevel.png")));
    JButton JButtonPause = new JButton(new ImageIcon(getClass().getResource("/Defaultsize/pause.png")));
    JButton JButtonX2 = new JButton(new ImageIcon(getClass().getResource("/Defaultsize/x2.png")));
    JButton upgrade = new JButton(new ImageIcon(getClass().getResource("/Defaultsize/upgrade.png")));
    JButton sell = new JButton(new ImageIcon(getClass().getResource("/Defaultsize/sell.png")));

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()== JButtonX2) {
            GameField.playSoundClick();
            GameField.x2++;
            gameStage.x2();
        }

        if (e.getSource() == upgrade) {
            if(GameField.towers.get(towerNumber).getLevel() < 3 && GameField.Gold >= GameField.towers.get(towerNumber).price) {
                GameField.playSoundClick();
                int level =  GameField.towers.get(towerNumber).getLevel();
                GameField.towers.get(towerNumber).update();
                GameField.Gold -= GameField.towers.get(towerNumber).price;
                GameField.towers.get(towerNumber).setLevel(level + 1);
            }
        }

        if (e.getSource() == sell) {
            GameField.playSoundClick();
            Map.check_potision[(int) GameField.towers.get(towerNumber).getY() / 64][(int) GameField.towers.get(towerNumber).getX() / 64] = true;
            GameField.Gold += GameField.towers.get(towerNumber).price / 2 + GameField.towers.get(towerNumber).price * GameField.towers.get(towerNumber).level / 3;
            GameField.towers.remove(towerNumber);
            GameField.countTower--;
            towerNumber = -1;
        }

        if (e.getSource() == JButtonNextLevel && clickNext == true) {
            GameField.playSoundClick();
            GameField.countNumberOfNext++;
            GameField.setupObject();
            clickNext = false;
        }

        if (e.getSource() == JButtonPause) {
            GameField.playSoundClick();
            gameStage.showPause();
        }

        if (e.getSource() == JButtonNormalTower && click == 0) {

            click = 1;

            GameField.playSoundClick();

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    if (click == 1) {
                        flagTower = true;
                        normalTower = new NormalTower(e.getX() - 32, e.getY() - 32);
                    }
                }
            });

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (click == 1 && e.getX() < 1024) {

                        GameField.playTurretBuild();

                        int x = e.getX() / 64;
                        int y = e.getY() / 64;

                        if (Map.check_potision[y][x] == true) {
                            Map.check_potision[y][x] = false;
                            if (GameField.Gold >= normalTower.price) {
                                GameField.Gold -= normalTower.price;
                                GameField.towers.add(new NormalTower(x * 64, y * 64));
                                GameField.countTower++;
                            }
                        }
                    }
                }
            });
        } else if (e.getSource() == JButtonSniperTower && click == 0) {
            click = 2;

            GameField.playSoundClick();

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    if (click == 2) {
                        flagTower = true;
                        sniperTower = new SniperTower(e.getX() - 32, e.getY() - 32);
                    }
                }
            });

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (click == 2 && e.getX() < 1024) {

                        GameField.playTurretBuild();

                        int x = e.getX() / 64;
                        int y = e.getY() / 64;

                        if (Map.check_potision[y][x] == true) {
                            Map.check_potision[y][x] = false;
                            if (GameField.Gold >= sniperTower.price) {
                                GameField.Gold -= sniperTower.price;
                                GameField.towers.add(new SniperTower(x * 64, y * 64));
                                GameField.countTower++;
                            }
                        }
                    }
                }
            });
        } else if (e.getSource() == JButtonMachineGunTower && click == 0) {
            click = 3;

            GameField.playSoundClick();

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    if (click == 3) {
                        flagTower = true;
                        machineGunTower = new MachineGunTower(e.getX() - 32, e.getY() - 32);
                    }
                }
            });

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (click == 3 && e.getX() < 1024) {

                        GameField.playTurretBuild();

                        int x = e.getX() / 64;
                        int y = e.getY() / 64;

                        if (Map.check_potision[y][x] == true) {
                            Map.check_potision[y][x] = false;
                            if (GameField.Gold >= machineGunTower.price) {
                                GameField.Gold -= machineGunTower.price;
                                GameField.towers.add(new MachineGunTower(x * 64, y * 64));
                                GameField.countTower++;
                            }
                        }
                    }
                }
            });
        } else if ((e.getSource() == JButtonNormalTower || e.getSource() == JButtonSniperTower || e.getSource() == JButtonMachineGunTower) && click != 0) {
            flagTower = false;
            click = 0;
        }
    }


    public controlPanel(GameStage gameStage) {
        this.gameStage = gameStage;
        normalTower = new NormalTower(1056, 60);
        GameField.towers = new ArrayList<>();
        setLayout(null);
        MenuOfItem();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                GameField.playSoundClick();

                for (int i = 0; i < GameField.countTower; i++) {
                    if (GameField.towers.get(i).getX() < e.getX() && e.getX() < GameField.towers.get(i).getX() + 64 && e.getY() > GameField.towers.get(i).getY() && e.getY() < GameField.towers.get(i).getY() + 64) {
                        towerNumber = i;
                        countClickObj++;
                    }
                }
            }
        });

    }

    private void checkWin() {
        if (GameField.countNumberOfNext ==5 && GameField.listTank.size() == 0) {
            gameStage.showWin();
        }
    }

    private void MenuOfItem() {
        /*JButtonNormalTower.setBounds(1056, 60, 64, 64);
        JButtonSniperTower.setBounds(1056, 150, 64, 64);
        JButtonMachineGunTower.setBounds(1146, 60, 64, 64);
        JButtonNextLevel.setBounds(1146, 150, 64, 64);
        JButtonPause.setBounds(1056, 240, 154, 32);
        JButtonX2.setBounds(1056,20,154,32);*/

        JButtonNormalTower.setBounds(1056, 6, 64, 64);
        JButtonSniperTower.setBounds(1056, 96, 64, 64);
        JButtonMachineGunTower.setBounds(1146, 6, 64, 64);
        JButtonNextLevel.setBounds(1146, 96, 64, 64);
        JButtonPause.setBounds(1056, 240, 154, 32);
        JButtonX2.setBounds(1056,180,154,32);

        add(JButtonNormalTower);
        add(JButtonSniperTower);
        add(JButtonMachineGunTower);
        add(JButtonNextLevel);
        add(JButtonPause);
        add(JButtonX2);

        JButtonNormalTower.addActionListener(this);
        JButtonSniperTower.addActionListener(this);
        JButtonMachineGunTower.addActionListener(this);
        JButtonNextLevel.addActionListener(this);
        JButtonPause.addActionListener(this);
        upgrade.addActionListener(this);
        sell.addActionListener(this);
        JButtonX2.addActionListener(this);
    }

    private void checkLose() {
        if (GameField.Alive <= 0) gameStage.showEnd();
    }

    public void printRectangle(Graphics2D g2d) {
        for (int i = 0; i < Map.check_potision.length; i++) {
            for (int j = 0; j < Map.check_potision[i].length; j++) {
                g2d.draw(Map.rectangles[i][j]);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        map.render(g2d);
        Font font = new Font("Kino MT", Font.BOLD, 30);
        g2d.setFont(font);
        g2d.drawRect(1024, 0, 256, 744);
        checkNext();

        switch (click) {
            case 1:
                g2d.drawImage(GameField.imageNormal, 1025, 300, null);
                break;
            case 2:
                g2d.drawImage(GameField.imageSniper, 1025, 300, null);
                break;
            case 3:
                g2d.drawImage(GameField.imageMachine, 1025, 300, null);
                break;
        }

        if (flagTower == true) {
            switch (click) {
                case 1:
                    g2d.drawOval((int) normalTower.getX() - (int) (normalTower.getShootRange() - 32), (int) normalTower.getY() - (int) (normalTower.getShootRange() - 32), (int) normalTower.getShootRange() * 2, (int) normalTower.getShootRange() * 2);
                    normalTower.render(g2d);
                    break;
                case 2:
                    g2d.drawOval((int) sniperTower.getX() - (int) (sniperTower.getShootRange() - 32), (int) sniperTower.getY() - (int) (sniperTower.getShootRange() - 32), (int) sniperTower.getShootRange() * 2, (int) sniperTower.getShootRange() * 2);
                    sniperTower.render(g2d);
                    break;
                case 3:

                    g2d.drawOval((int) machineGunTower.getX() - (int) (machineGunTower.getShootRange() - 32), (int) machineGunTower.getY() - (int) (machineGunTower.getShootRange() - 32), (int) machineGunTower.getShootRange() * 2, (int) machineGunTower.getShootRange() * 2);
                    machineGunTower.render(g2d);
                    break;
            }

        }

        if (click != 0) {
            printRectangle(g2d);
        }

        for (int j = 0; j < GameField.countTower; j++) {
            if (GameField.countTower > 0) {
                for (int i = 0; i < GameField.listTank.size(); i++) {

                    if ((GameField.towers.get(j).contains(GameField.listTank.get(i)) == true && !(GameField.listTank.get(i) instanceof planesEnemy)) || (GameField.towers.get(j).contains(GameField.listTank.get(i)) == true && GameField.listTank.get(i) instanceof planesEnemy && GameField.towers.get(j) instanceof SniperTower)) {
                        GameField.towers.get(j).setRadian(GameField.listTank.get(i));
                        break;
                    }
                }

            }
        }

        for (int j = 0; j < GameField.listTank.size(); j++) {
            if (GameField.countTower > 0) {
                for (int i = 0; i < GameField.countTower; i++) {
                    if (GameField.towers.get(i).contains(GameField.listTank.get(j)) == true && !(GameField.listTank.get(j) instanceof planesEnemy) || GameField.towers.get(i).contains(GameField.listTank.get(j)) == true && GameField.listTank.get(j) instanceof planesEnemy && GameField.towers.get(i) instanceof SniperTower) {

                        GameField.towers.get(i).shoot(GameField.listTank.get(j));
                        if (GameField.time % 500 == 0) {
                            GameField.playSoundFire();
                        }
                    }
                }
            }
        }

        for (int i = 0; i < GameField.countTower; i++) {
            GameField.towers.get(i).render(g2d);
        }

        for (int a = 0; a < GameField.listTank.size(); a++) {
            GameField.listTank.get(a).setMap(this.map);
            GameField.listTank.get(a).render(g2d);
        }


        for (int a = 0; a < GameField.listTank.size(); a++) {
            if (GameField.listTank.get(a).getX() > 960 || GameField.listTank.get(a).getY() < 0 || GameField.listTank.get(a).invisible == false) {
                if (GameField.listTank.get(a).invisible == false && GameField.listTank.get(a) instanceof BossEnemy == false)
                    GameField.Gold += GameField.listTank.get(a).getReward();
                else if (GameField.listTank.get(a) instanceof BossEnemy == true) {
                    gameStage.showEnd();
                }
                else GameField.Alive--;
                checkLose();
                GameField.listTank.remove(a);
            }
        }

        if (click == 0) {
            g2d.drawImage(GameField.imageMenu, 1025, 300, null);
            UpdateMenu(g2d);
        }

        if (towerNumber != -1 && countClickObj % 2 != 0) {
            g2d.drawOval((int) GameField.towers.get(towerNumber).getX() - (int) (GameField.towers.get(towerNumber).getShootRange() - 32), (int) GameField.towers.get(towerNumber).getY() - (int) (GameField.towers.get(towerNumber).getShootRange() - 32), (int) GameField.towers.get(towerNumber).getShootRange() * 2, (int) GameField.towers.get(towerNumber).getShootRange() * 2);
            g2d.drawImage(GameField.imageTowerDetail, 1025, 300, null);
            UpdateTower(GameField.towers.get(towerNumber), g2d);
            add(upgrade);
            add(sell);
            upgrade.setBounds(1045, 645, 100, 32);
            sell.setBounds(1155, 645, 100, 32);
            setBackground(Color.GRAY);
        }
        else {
            remove(upgrade);
            remove(sell);
        }

        checkWin();
    }

    private void UpdateTower(Tower tower, Graphics2D g2d) {
        g2d.drawString(String.valueOf(tower.getDame()), 1159, 413);
        g2d.drawString(String.valueOf(tower.level), 1126, 381);
        g2d.setColor(Color.RED);
        g2d.drawString(String.valueOf(1), 1148, 516);
        g2d.drawString(String.valueOf(10), 1149, 545);
        g2d.setColor(Color.black);
        g2d.drawString(String.valueOf(tower.price / 3), 1197, 620);
    }


    private void UpdateMenu(Graphics2D g2d) {
        g2d.drawString(String.valueOf(GameField.Alive), 1160, 447);
        g2d.drawString(String.valueOf(GameField.Gold), 1166, 520);
        g2d.drawString(String.valueOf(GameField.countNumberOfNext), 1166, 599);
    }


    private void checkNext() {
        if (GameField.listTank.size() == 0)
            clickNext = true;
    }
}