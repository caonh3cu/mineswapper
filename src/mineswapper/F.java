package mineswapper;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class F extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//图标
	ImageIcon lei = new ImageIcon("img/lei.jpg"),
			boom = new ImageIcon("img/boom.jpg"),
			caodi = new ImageIcon("img/caodi.jpg"),
			di = new ImageIcon("img/di.jpg"),
			flag = new ImageIcon("img/flag.jpg");
	private int mineSurround;
	private int num;
	private Mines m;
	private boolean hasFlag;
	public boolean isClicked;
	//构造函数
	public F(int arg,int n,Mines arg3) {
		// TODO Auto-generated constructor stub
		mineSurround = arg;
		num = n;
		m = arg3;
		isClicked = false;
		hasFlag = false;
		setIcon(caodi);
		setSize(30, 30);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getModifiers()==InputEvent.BUTTON3_MASK){
					flag();
					return;
				}
				if(isClicked)
					return;
				try {
					FileInputStream fileau=new  FileInputStream("img/cao.au");
					AudioStream as=new AudioStream(fileau);
					AudioPlayer.player.start(as);
				}catch (Exception abc) {
					
				}
				if(mineSurround==-1){
					try {
						FileInputStream fileau=new  FileInputStream("img/boom.au");
						AudioStream as=new AudioStream(fileau);
						AudioPlayer.player.start(as);
					}catch (Exception abc) {
						
					}
					Boom();
					m.Boom();
				}else{
					NoMine();
				}
				isClicked = true;
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
	}
	//改变图标
	public void NoMine(){
		if(isClicked)
			return;
		switch (mineSurround){
		case -1:return;
		case 0:{
			setIcon(di);
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					m.NoMine(num);
					
				}
			});
			break;
		}
		case 1:setIcon(new ImageIcon("img/di1.jpg"));break;
		case 2:setIcon(new ImageIcon("img/di2.jpg"));break;
		case 3:setIcon(new ImageIcon("img/di3.jpg"));break;
		case 4:setIcon(new ImageIcon("img/di4.jpg"));break;
		case 5:setIcon(new ImageIcon("img/di5.jpg"));break;
		case 6:setIcon(new ImageIcon("img/di6.jpg"));break;
		case 7:setIcon(new ImageIcon("img/di7.jpg"));break;
		case 8:setIcon(new ImageIcon("img/di8.jpg"));break;
		}
		isClicked = true;
	}
	public void HasMine(){
		if(mineSurround==-1){
			setIcon(lei);
			setText("");
			isClicked = true;
		}else{
			NoMine();
		}
	}
	public void Boom(){
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				setIcon(boom);
			}
		});
		setText("");
		isClicked = true;
		JDialog d = new JDialog();
		d.add(new JLabel("you lose"));
		d.setLocation(700,400);
		d.setSize(200,100);
		d.setVisible(true);
	}
	public void fresh(){
		setIcon(caodi);
		setText("");
		isClicked = false;
	}
	public void flag(){
		if(hasFlag){
			setIcon(caodi);
			hasFlag = false;
		}else{
			hasFlag = true;
			setIcon(flag);
		}
	}
}
