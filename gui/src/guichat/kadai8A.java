package guichat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class kadai8A extends JPanel implements ActionListener {

	private Ellipse2D.Float ellipse = new Ellipse2D.Float();


	final int framespeed=50;
	final private double MAXCounter = 500;

	private boolean isResetProcess = true;
	private double counter;
	private Timer timer;

	private int ballnum = 2;
	private BallRim[] myBalls = new BallRim[ballnum];
    public static void main(String[] args){
		/* おまじない：開始 */
		kadai8A animation =new kadai8A();
		JFrame frame = new JFrame("SwingFaceObject");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(animation);
		frame.setSize(550, 550);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		/* おまじない：終了 */
	}// main end

	ActionListener updateProBar;

	public kadai8A() {

		timer = new Timer(framespeed, this);
		timer.setInitialDelay(500);
		timer.start();

	}

	public void paint(Graphics g) {
		/* おまじない：開始 */

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);

		g2.setRenderingHints(rh);
		Dimension windowSize = getSize();

		if (isResetProcess) {
			initProcess(windowSize.width, windowSize.height);
			isResetProcess = false;
		}

		this.doNextStep(windowSize.width, windowSize.height);
		paintProcess(windowSize.width, windowSize.height, g2);
		/* おまじない：終了 */

	}// paint end

	public void actionPerformed(ActionEvent e) {
		repaint();
	}


	public void setEllipseSize(double size, int w, int h) {
		counter = size;
		ellipse.setFrame(10, 10, size, size);
	}

	public void initProcess(int w, int h) {

		for(int i=0;i<myBalls.length;i++){
			myBalls[i] = new BallRim(w,h);
		}

		setEllipseSize(1, w, h);
	}

	public void doNextStep(int w, int h) {
		counter++;

		if (counter > MAXCounter) {
			initProcess(w, h);

		} else {

			for(int i=0;i<myBalls.length;i++){
				myBalls[i].move();
			}

			ellipse.setFrame(ellipse.getX(), ellipse.getY(), counter, counter);
		}
	}

	public void paintProcess(int w, int h, Graphics2D g2) {

		g2.setColor(Color.BLUE);
		g2.draw(ellipse);
		g2.drawString(counter+"Step経過", 10, 10);

		for(int i=0;i<myBalls.length;i++){
			myBalls[i].draw(g2);;
		}


	}

	class BallRim {

		FaceObj fobj;

		String str="";

		Random rdn;
		int w=500;
		int h=500;

		int x;
		int y;
		int radius; // 半径
		Color basicColor = Color.gray;

		double xDir = -1; // 1:+方向 -1: -方向
		double yDir = 1;
		private int strCounter;

		BallRim(int w, int h){

			rdn=new Random();
			xDir=rdn.nextDouble()*2-1;
			yDir=rdn.nextDouble()*2-1;
			this.w=w;
			this.h=h;


			setPosition(rdn.nextInt(w), rdn.nextInt(h));
			setRadius(rdn.nextInt(30)+30);//30-60のサイズの顔の輪郭

			Color bcolor= new Color(rdn.nextInt(255),rdn.nextInt(255),rdn.nextInt(255));
			setBasicColor(bcolor);

			fobj=new FaceObj();

		}

		void setBasicColor(Color bcolor) {
			this.basicColor = bcolor;
		}

		public void setCollisionText(String str,int strCounter){
			this.str=str;
			this.strCounter=strCounter;

		}

		void move() {


			if ((xDir >0) && (x+this.radius*2 >= w)) {
				xDir = -1*xDir;
				setCollisionText("右が痛いわぁ",3);
			}
			else if ((xDir <0) && (x <= 0)) {
				xDir = -1*xDir;
				setCollisionText("左の頬がめちゃ痛いわ！",6);
			}else if (xDir >0) {
				x = x + 10;
			} else {
				x = x - 10;
			}

			if ((yDir >0) && (y+this.radius*2 >= h)) {
				yDir = -1*yDir;
				setCollisionText("顎が痛いわぁ",3);
			}
			if ((yDir <0) && (y <= 0)) {
				yDir = -1*yDir;
				setCollisionText("頭がめちゃ痛いわ！",6);
			}

			if (yDir >0) {
				y = y + 10;
			} else {
				y = y - 10;
			}

		}

		void setPosition(int x, int y) {
			this.x = x;
			this.y = y;
		}

		void setRadius(int r) {
			this.radius = r;
		}

		void draw(Graphics g) {
			//g.setColor(basicColor);
			//g.fillOval(x, y, 2 * radius, 2 * radius); // rは半径なので2倍にする
			if(strCounter>0){
				g.drawString(str, x, y);
				strCounter--;
			}else{
				str="";
			}

			fobj.setXY(x, y);
			fobj.setSize(2*radius, 2*radius);
			fobj.makeFace(g);

		}

	}// ball end


	class FaceObj {
		// コンストラクタ

		int h=100;
		int w=100;

		int xStart = 0;
        int  yStart = 0;
        int    xMiddle = xStart + w / 2;
        int    yMiddle = yStart + h - 30;
        Color  faceColor = Color.YELLOW;

		public void setXY(int x, int y){
			this.xStart = x;
			this.yStart = y;
			this.xMiddle = xStart + w / 2;
            this.yMiddle = yStart + h - 30;
		}

		public void setSize(int h, int w){
			this.h = h;
			this.w = w;
		}

		public FaceObj() {

		}

		// 個々にメソッドを追加

		public void makeFace(Graphics g) {
			drawRim(g);
            drawhair(g);
            drawEye(g, w-70);
            drawNose(g, w/10);
            drawMouth(g, w-10);
		}

		public void drawRim(Graphics g) { // wが横幅、hが縦幅
            g.setColor(faceColor);
            g.fillOval(xStart, yStart, w+20, w+20);
        }

		public void drawhair(Graphics g) {
            g.setColor(Color.BLACK);
            g.fillArc(xStart, yStart, w, w - 60, 65, 50);
            g.fillArc(xStart - 50, yStart, w, w - 60, 65, 50);
            g.fillArc(xStart + 50, yStart, w, w - 60, 65, 50);
        }

		public void drawNose(Graphics g, int nx) { // xは鼻の長さ
            g.setColor(Color.BLACK);
            g.fillOval(xStart + w - 50, yStart + w - 40, nx, nx);
            g.fillOval(xStart + w - 30, yStart + w - 40, nx, nx);
        }

		public void drawEye(Graphics g, int r) { // rは目の半径
            g.setColor(Color.BLACK);
            g.fillOval(xStart-30, yStart + 25, r, r);
            g.fillOval(xStart + 20, yStart + 25, r, r);
            g.drawArc(xStart-30, yStart + 15, r +110, r+20, 90, 180);
            g.drawArc(xStart + 20, yStart + 15, r+110, r+20, 90, 180);

        }
		public void drawMouth(Graphics g, int mx) { // xは口の幅
            g.setColor(Color.RED);
            g.fillOval(xMiddle - mx / 2 - 5, yMiddle+10, mx, mx - 50);
        }
	}//FaceObj End

}