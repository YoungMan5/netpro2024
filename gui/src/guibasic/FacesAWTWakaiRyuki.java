//FacesAWTMain.java
//FacesAWTMain 目標 インナークラスのFaceObjクラスを作ってみよう。描画処理を移譲してください。
//3x3の顔を描画してください。色などもぬってオリジナルな楽しい顔にしてください。

package guibasic;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FacesAWTWakaiRyuki {

    public static void main(String[] args) {
        new FacesAWTWakaiRyuki();
    }

    FacesAWTWakaiRyuki() {
        FaceFrame f = new FaceFrame();
        f.setSize(800, 800);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    // インナークラスを定義
    class FaceFrame extends Frame {

        private FaceObj fobj1;

        FaceFrame() {
            fobj1 = new FaceObj();
        }

        public void paint(Graphics g) {
            // この中には、g.drawLine というのは入ってこない
            // Graphicsクラス(型のようなもの---今は--)のgという変数はメソッドに渡す

            FaceObj[] fobjs = new FaceObj[9];

            for (int j = 0; j < 3; j++) {

                for (int i = 0; i < 3; i++) {

                    fobjs[i + 3 * j] = new FaceObj();
                    fobjs[i + 3 * j].setPosition(200 * i + 50, 200 * j + 50);
                    fobjs[i + 3 * j].setEmotionLevel(i, j);
                    fobjs[i + 3 * j].drawFace(g);
                }
            }

            // fobj.drawRim();

        }

    }// FaceFrame end

    // Faceクラスを作ってみよう。
    private class FaceObj {
        private int w;
        private int h;
        private int xStart;
        private int yStart;
        private int xMiddle;
        private int yMiddle;
        private Color faceColor;

        FaceObj() {
            w = 200;
            h = 200;
            xStart = 50;
            yStart = 50;
            xMiddle = 50 + w / 2;
            yMiddle = 50 + h - 30;
            faceColor = Color.YELLOW;
        }

        public void setPosition(int i, int j) {
            w = 200;
            h = 200;
            xStart = 50 + i;
            yStart = 50 + j;
            xMiddle = 50 + w / 2 + i;
            yMiddle = 50 + h - 30 + j;

        }

        public void setEmotionLevel(int i, int j) {
            int emotionLevel = (i + 3 * j); // デモ用のシンプルなロジック：位置に基づいて感情を変化
            switch (emotionLevel) {
                case 0:
                    faceColor = Color.YELLOW;
                    break;
                case 1:
                    faceColor = Color.GREEN;
                    break;
                case 2:
                    faceColor = Color.BLUE;
                    break;
                case 3:
                    faceColor = Color.PINK;
                    break;
                case 4:
                    faceColor = Color.CYAN;
                    break;
                case 5:
                    faceColor = Color.LIGHT_GRAY;
                    break;
                case 6:
                    faceColor = Color.MAGENTA;
                    break;
                case 7:
                    faceColor = Color.ORANGE;
                    break;
                case 8:
                    faceColor = Color.WHITE;
                    break;
                default:
                    faceColor = Color.YELLOW; // デフォルト
                    break;
            }
        }

        public void drawFace(Graphics g) {
            drawRim(g);
            drawhair(g);
            drawEye(g, 30);
            drawNose(g, 10);
            drawMouth(g, 90);
        }

        public void drawRim(Graphics g) { // wが横幅、hが縦幅
            g.setColor(faceColor);
            g.fillOval(xStart, yStart, w, w);
        }

        public void drawhair(Graphics g) {
            g.setColor(Color.BLACK);
            g.fillArc(xStart, yStart, w, w - 60, 65, 50);
            g.fillArc(xStart - 50, yStart, w, w - 60, 65, 50);
            g.fillArc(xStart + 50, yStart, w, w - 60, 65, 50);
        }

        public void drawNose(Graphics g, int nx) { // xは鼻の長さ
            g.setColor(Color.BLACK);
            g.fillOval(xStart + 75, yStart + 125, nx, nx);
            g.fillOval(xStart + 95, yStart + 125, nx, nx);
        }

        public void drawEye(Graphics g, int r) { // rは目の半径
            g.setColor(Color.BLACK);
            g.fillOval(xStart - 20, yStart + 75, r, r);
            g.fillOval(xStart + 70, yStart + 75, r, r);
            g.drawArc(xStart - 20, yStart + 65, 140, 50, 90, 180);
            g.drawArc(xStart + 70, yStart + 65, 140, 50, 90, 180);

        }

        public void drawMouth(Graphics g, int mx) { // xは口の幅
            g.setColor(Color.RED);
            g.fillOval(xMiddle - mx / 2 - 5, yMiddle - 15, mx, mx - 50);
        }
    }

}// Faces class end
