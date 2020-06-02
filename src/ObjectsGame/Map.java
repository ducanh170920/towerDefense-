package ObjectsGame;

import javax.swing.*;
import java.awt.*;

public class Map extends GameEntity {

    public static Rectangle rectangles[][] = new Rectangle[11][16];
    public static boolean check_potision[][] = new boolean[11][16];
    public int numberOfMap;

    public Map(int numberOfMap){
        this.numberOfMap = numberOfMap;
        if (this.numberOfMap == 1) {
            for(int i = 0 ; i  <  MAP_SPRITES1.length ; i ++){
                for(int j = 0 ; j < MAP_SPRITES1[0].length ; j++){
                    rectangles[i][j] = new Rectangle(j*64,i*64,64,64);
                    if(MAP_SPRITES1[i][j].equals("024")){
                        check_potision[i][j] = true;
                    }
                }
            }
            check_potision[0][1] = false;
        }
        else {
            for(int i = 0 ; i  <  MAP_SPRITES2.length ; i ++){
                for(int j = 0 ; j < MAP_SPRITES2[0].length ; j++){
                    rectangles[i][j] = new Rectangle(j*64,i*64,64,64);
                    if(MAP_SPRITES2[i][j].equals("024")){
                        check_potision[i][j] = true;
                    }
                }
            }
        }
    }

    public String[][] MAP_SPRITES1 = new String[][] {
            { "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024"},
            { "003", "047", "047", "047", "047", "047", "004", "024", "024", "024", "024", "024", "024", "024", "024", "024"},
            { "025", "299", "001", "001", "001", "002", "023", "024", "024", "024", "210", "254", "254", "254", "185", "185"},
            { "025", "023", "024", "024", "024", "025", "023", "024", "024", "024", "232", "207", "208", "208", "139", "139"},
            { "025", "023", "024", "024", "024", "025", "023", "024", "024", "024", "232", "230", "024", "024", "024", "024"},
            { "025", "023", "024", "024", "024", "025", "023", "024", "024", "024", "232", "230", "024", "024", "024", "024"},
            { "025", "023", "024", "024", "024", "025", "046", "047", "047", "047", "048", "023", "024", "024", "024", "024"},
            { "025", "023", "024", "024", "024", "026", "001", "001", "001", "001", "001", "027", "024", "024", "024", "024"},
            { "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024"},
            { "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024"},
            { "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024"},
    };

    public String[][] MAP_SPRITES2 = new String[][] {
            { "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "232", "230", "024"},
            { "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "232", "230", "024"},
            { "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "232", "230", "024"},
            { "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "232", "230", "024"},
            { "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "232", "230", "024"},
            { "003", "047", "047", "047", "047", "047", "047", "047", "047", "047", "047", "047", "047", "048", "023", "024"},
            { "025", "299", "001", "001", "001", "001", "001", "001", "001", "001", "001", "001", "001", "001", "027", "024"},
            { "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024"},
            { "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024"},
            { "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024"},
            { "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024"},
    };

    @Override
    public void update(){

    }

    @Override
    public void render(Graphics2D g2d) {
       if (this.numberOfMap == 1) {
           for (int i = 0; i < MAP_SPRITES1.length; i++) {
               for (int j = 0; j < MAP_SPRITES1[i].length; j++) {
                   Image img = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile" + MAP_SPRITES1[i][j] + ".png")).getImage();
                   g2d.drawImage(img, j * 64, i * 64, null);
               }
           }
           Image tree1 = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile130.png")).getImage();
           Image tree2 = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile134.png")).getImage();
           Image tree3 = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile132.png")).getImage();
           Image stone1 = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile135.png")).getImage();
           Image stone2 = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile136.png")).getImage();
           Image stone3 = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile137.png")).getImage();
           g2d.drawImage(tree1,64*2, 64*10, null);
           check_potision[10][2] = false;
           g2d.drawImage(stone1,64*2, 64*9, null);
           check_potision[9][2] = false;
           g2d.drawImage(tree3,64*2, 64*9, null);
           g2d.drawImage(tree2,64*3, 64*3, null);
           check_potision[3][3] = false;
           g2d.drawImage(tree3,64*7, 64*5, null);
           check_potision[5][7] = false;
           g2d.drawImage(stone3,64*2, 64*5, null);
           check_potision[5][2] = false;
           g2d.drawImage(stone2,64*15, 64, null);
           check_potision[1][15] = false;
           g2d.drawImage(stone2,64*13, 64*5, null);
           check_potision[5][13] = false;
           g2d.drawImage(stone2,64*13, 64*4, null);
           check_potision[4][13] = false;
           g2d.drawImage(stone1,64*6, 64*10, null);
           check_potision[10][6] = false;
           g2d.drawImage(tree1,64*8, 64*3, null);
           check_potision[3][8] = false;
           g2d.drawImage(tree2,64*14, 64, null);
           check_potision[1][14] = false;
           g2d.drawImage(stone3,64*12, 64*7, null);
           check_potision[7][12] = false;
           g2d.drawImage(tree2,64*9, 64*8, null);
           check_potision[8][9] = false;
           g2d.drawImage(tree3,64*6, 64*8, null);
           check_potision[8][6] = false;
           g2d.drawImage(tree1,64*13, 64*9, null);
           check_potision[9][13] = false;
           g2d.drawImage(tree1,64*11, 0, null);
           check_potision[0][11] = false;
           g2d.drawImage(stone2,64*4, 0, null);
           check_potision[0][4] = false;
       }
       else {
           for (int i = 0; i < MAP_SPRITES2.length; i++) {
               for (int j = 0; j < MAP_SPRITES2[i].length; j++) {
                   Image img = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile" + MAP_SPRITES2[i][j] + ".png")).getImage();
                   g2d.drawImage(img, j * 64, i * 64, null);

               }
           }
           Image tree1 = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile130.png")).getImage();
           Image tree2 = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile134.png")).getImage();
           Image tree3 = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile132.png")).getImage();
           Image stone1 = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile135.png")).getImage();
           Image stone2 = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile136.png")).getImage();
           Image stone3 = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile137.png")).getImage();
           g2d.drawImage(tree1,64*15, 0, null);
           check_potision[0][15] = false;
           g2d.drawImage(tree2,64*0, 64*0, null);
           check_potision[0][0] = false;
           g2d.drawImage(tree3,64*1, 64*1, null);
           check_potision[1][1] = false;
           g2d.drawImage(tree1,64*2, 64*2, null);
           check_potision[2][2] = false;
           g2d.drawImage(stone1,64*3, 64*3, null);
           check_potision[3][3] = false;
           g2d.drawImage(stone2,64*4, 64*4, null);
           check_potision[4][4] = false;
           g2d.drawImage(stone3,64*5, 64*4, null);
           check_potision[4][5] = false;
           g2d.drawImage(tree1,64*6, 64*4, null);
           check_potision[4][6] = false;
           g2d.drawImage(tree2,64*7, 64*3, null);
           check_potision[3][7] = false;
           g2d.drawImage(tree3,64*8, 64*2, null);
           check_potision[2][8] = false;
           g2d.drawImage(stone3,64*9, 64*1, null);
           check_potision[1][8] = false;
           g2d.drawImage(stone2,64*10, 64*0, null);
           check_potision[0][10] = false;
           g2d.drawImage(tree2,64*2, 64*10, null);
           check_potision[10][2] = false;
           g2d.drawImage(stone2,64*15, 64*4, null);
           check_potision[4][15] = false;
           g2d.drawImage(stone1,64*15, 64*8, null);
           check_potision[8][15] = false;
           g2d.drawImage(stone2,64*5, 64*9, null);
           check_potision[9][5] = false;
           g2d.drawImage(stone2,64*8, 64*7, null);
           check_potision[7][8] = false;
           g2d.drawImage(stone2,64*12, 64*8, null);
           check_potision[8][12] = false;
       }

        Image bkg = new ImageIcon(getClass().getResource("/Defaultsize/bkg.png")).getImage();
        g2d.drawImage(bkg,1024, 0, null);

    }
}