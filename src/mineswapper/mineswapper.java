package mineswapper;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class mineswapper extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Console c;
	public mineswapper(String agr1){
		//���ô�������
		super(agr1);
		System.out.println("mineswapper:make window");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		//������������ת������Ȩ
		c = new Console(this);
	}
	public static void main(String args[]){
		System.out.println("mineswapper_main:opened successfully");//�ɹ���
		//�½�������
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new mineswapper("mineswapper_main:MinesWapper");
			}
		});
		System.out.println("mineswapper_main:main window drawed");//���ڴ����ɹ�
	}
}
