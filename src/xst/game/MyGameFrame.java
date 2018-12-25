package xst.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;



public class MyGameFrame extends JFrame{
	//Image ball = GameUtil.getImage("images/ball.png");
	Image plane = GameUtil.getImage("images/plane.png");
	Image bg = GameUtil.getImage("images/bg.jpg");
	
	int planeX = 250, planeY = 250;
	
	
	
	
	
	@Override
	public void paint(Graphics g) {//自动被调用，g变量相当于一只画笔
//		Color color = g.getColor();
//		Font font = g.getFont();
//		g.setColor(Color.blue);
//		
//		g.drawLine(100, 100, 300, 300);
//		g.drawRect(100, 100, 300, 300);
//		g.drawOval(100, 100, 300, 300);
//		g.fillRect(100, 100, 40, 40);
//		g.setColor(Color.red);
//		g.setFont(new Font("楷体", Font.BOLD, 50));
//		g.drawString("啊啊啊", 100, 100);
//		g.drawImage(ball, 250, 250, null);
//		
//		g.setColor(color);
//		g.setFont(font);
		
		g.drawImage(bg, 0, 0, null);
		g.drawImage(plane, planeX, planeY, null);
		planeX++;
		
	}
/*	private Image offScreenImage = null;//创建缓冲区
	public void update(Graphics g){
		if (offScreenImage == null){
			offScreenImage = this.createImage(500,500);
		Graphics gOff = offScreenImage.getGraphics();//创建离线图片的实例，在图片缓冲区绘图
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);//将缓冲图片绘制到窗口目标
		}
	}*/
 
	
	
	
	
	//反复重画窗口
	class PaintThread extends Thread{//内部类，可以直接使用外部类的属性
		@Override
		public void run() {
			while(true){
				//System.out.println("窗口画一次");
				repaint();//重画
				try {
					Thread.sleep(40);//40ms,1s=1000ms,25次
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	/*
	* 初始化窗口
	*/
	public void launchFrame(){
		this.setTitle("小飞机");
		this.setSize(500, 500);
		this.setLocation(300, 300);
		this.setVisible(true);	
		
		this.addWindowListener(new WindowAdapter() {//匿名内部类
			@Override
			public void windowClosing(WindowEvent e) {//重写父类方法
				System.exit(0);//结束虚拟机运行  0代表正常结束
			}			
		});
	new PaintThread().start();//启动重画窗口的线程	
		
		
		
	}
	public static void main(String[] args) {
		MyGameFrame f = new MyGameFrame();
		f.launchFrame();
	}
}
