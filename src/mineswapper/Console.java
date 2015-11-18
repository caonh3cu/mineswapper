package mineswapper;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Console extends Container{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jl;
	private mineswapper m;
	private Mines mines;
	private tt t;
	public Console(mineswapper arg) {
		// TODO Auto-generated constructor stub
		//获取窗口引用
		m = arg;
		//新建默认雷区
		mines = new Mines(m,19,25);
		System.out.println("Console:mine area made");
		//构造自己
		construct();
		System.out.println("Console:console bar made");
		//布局并显示窗口
		redraw();
		System.out.println("Console:window drawed");
	}
	private void setCenter(JFrame arg){
		System.out.println("Console_setCenter:let window to be at center");
		int ww,wh,sw,sh;
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize();
		sw = screenSize.width;
		sh = screenSize.height;
		ww = mines.getW();
		wh = mines.getH();
		m.setLocation((sw-ww)/2, (sh-wh)/2);
	}
	private void construct(){
		System.out.println("Console_construct:making console bar");
		setSize(mines.getW(),30);
		setLayout(new GridLayout(1, 11, 0, 0));
		JButton b;
		b= new JButton("初级");
		b.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				newM(1);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(b);
		b= new JButton("中级");
		b.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				newM(2);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(b);
		b= new JButton("高级");
		b.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				newM(3);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(b);
		JLabel jt = new JLabel();
		add(jt);
		jl = new JLabel("总雷数:"+mines.getN());
		add(jl);
		t = new tt(jt);
		t.start();
		b = new JButton("关闭");
		b.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				m.dispose();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(b);
	}
	private void redraw(){
		System.out.println("Console_redraw:drawing window");
		//布局
		System.out.println("Console_redraw:set layout");
		m.setLayout(new BorderLayout());
		m.add(this,BorderLayout.NORTH);
		m.add(mines,BorderLayout.CENTER);
		//显示
		System.out.println("Console_redraw:draw the window");
		m.setUndecorated(true);
		m.setSize(600, 450);
		setCenter(m);
		m.setVisible(true);
	}
	private void newM(int i){
		m.remove(mines);
		m.setVisible(false);
		switch (i){
		case 1:mines = new Mines(m,9,9,10);break;
		case 2:mines = new Mines(m,15,20,80);break;
		case 3:mines = new Mines(m, 20, 30,99);break;
		}
		m.add(mines);
		jl.setText("总雷数:"+mines.getN());
		m.setVisible(true);
		t.update();
	}
	class tt extends Thread{
		final long s = 100;
		JLabel j;
		long n;
		Long temp;
		public tt(JLabel arg){
			j = arg;
			n = new Date().getTime();
		}
		public void run(){
			while(true){
				temp = (new Date().getTime()-n)/1000;
				System.out.println(temp);
				j.setText("Time: "+temp+"s");
				try {
					sleep(s);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public void update(){
			n = new Date().getTime();
		}
	}
}
