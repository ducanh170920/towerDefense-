import ObjectsGame.*;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class GameField {
    static int countTower = 0;
    static int countNumberOfNext = 0;
    static int Gold = 100;
    static int Alive = 10;
    static int x2 = 0;
    static int time = 0;
    static Image imageNormal = new ImageIcon(GameField.class.getResource("/Defaultsize/" + "NomalTower1" + ".png")).getImage();
    static Image imageMenu = new ImageIcon(GameField.class.getResource("/Defaultsize/" + "menu" + ".png")).getImage();
    static Image imageSniper = new ImageIcon(GameField.class.getResource("/Defaultsize/" + "SniperTower 2" + ".png")).getImage();
    static Image imageMachine = new ImageIcon(GameField.class.getResource("/Defaultsize/" + "MachineGunTower2" + ".png")).getImage();
    static Image imageTowerDetail = new ImageIcon(GameField.class.getResource("/Defaultsize/" + "TowerDetailt" + ".png")).getImage();
    static ArrayList<Enemy> listTank = new ArrayList<>();

    static ArrayList<Tower> towers = new ArrayList<>();

    static void setupObject() {
        switch (countNumberOfNext) {
            case 1:
                for (int i = 0; i < 3; i++) {
                    listTank.add(new NormalEnemy(32, 672 + i * 64));
                }
                break;

            case 2:
                for (int i = 0; i < 7; i++) {
                    listTank.add(new NormalEnemy(32, 672 + i * 64));
                }
                for (int i = 7; i < 10; i++) {
                    listTank.add(new TankerEnemy(32, 672 + i * 96));
                    listTank.get(listTank.size() - 1).setSpeed(1);
                }
                break;
            case 3:
                for (int i = 0; i < 10; i++) {
                    listTank.add(new NormalEnemy(32, 672 + i * 64));
                    listTank.get(listTank.size() - 1).setSpeed(1);
                }
                for (int i = 7; i < 15; i++) {
                    listTank.add(new TankerEnemy(32, 672 + i * 96));
                    listTank.get(listTank.size() - 1).setSpeed(1);
                }
                listTank.add(new planesEnemy(0));
                break;
            case 4:
                for (int i = 0; i < 5; i++) {
                    listTank.add(new NormalEnemy(32, 672 + i * 64));
                    listTank.get(i).setSpeed(2);
                }
                for (int i = 5; i < 15; i++) {
                    listTank.add(new TankerEnemy(32, 672 + i * 96));
                    listTank.get(i).setSpeed(2);
                }
                Image imgTank = new ImageIcon(GameField.class.getResource("/Defaultsize/towerDefense_tile269.png")).getImage();
                Image img = new ImageIcon(GameField.class.getResource("/Defaultsize/towerDefense_tile292.png")).getImage();
                for (int i = 15; i < 20; i++) {
                    listTank.add(new TankerEnemy(32, 672 + i * 96));
                    listTank.get(i).setImg(imgTank);
                    listTank.get(i).setImgTank(img);
                    listTank.get(i).setSpeed(2);
                }
                Image imgTankplane = new ImageIcon(GameField.class.getResource("/Defaultsize/towerDefense_tile294.png")).getImage();
                Image imgplane = new ImageIcon(GameField.class.getResource("/Defaultsize/towerDefense_tile271.png")).getImage();
                for (int i = 0; i < 4; i++) {
                    if (i % 2 == 0) {
                        planesEnemy planesEnemy = new planesEnemy(-i * 64);
                        planesEnemy.setImg(imgplane);
                        planesEnemy.setImgTank(imgTankplane);
                        listTank.add(planesEnemy);
                    } else {
                        listTank.add(new planesEnemy(-i * 64));
                    }
                }
                break;
            case 5:
                listTank.add(new BossEnemy(32, 672));
                break;
        }
    }

    public static void playSoundTrack() {
        try {

            AudioData data = new AudioStream(new FileInputStream("src/sounds/8_music.au")).getData();
            ContinuousAudioDataStream sound = new ContinuousAudioDataStream(data);
            AudioPlayer.player.start(sound);
        } catch (Exception e) {
            System.err.println("Error playing background music");
        }
    }

    public static void playSoundFire() {
        try {
            InputStream music = new FileInputStream("src/sounds/4_t1shot.au");
            AudioStream audio = new AudioStream(music);
            AudioPlayer.player.start(audio);
        } catch (Exception e) {
            System.err.println("Error playing music shot");
        }
    }

    public static void playSoundClick() {
        try {
            InputStream music = new FileInputStream("src/sounds/7_click.au");
            AudioStream audio = new AudioStream(music);
            AudioPlayer.player.start(audio);
        } catch (Exception e) {
            System.err.println("Error playing music click");
        }
    }

    public static void playTurretBuild() {
        try {
            InputStream music = new FileInputStream("src/sounds/3_turretbuild.au");
            AudioStream audio = new AudioStream(music);
            AudioPlayer.player.start(audio);
        } catch (Exception e) {
            System.err.println("Error playing music turret build");
        }
    }
}
