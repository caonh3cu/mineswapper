package mineswapper;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.SwingUtilities;

public class Mines extends Container{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int row,col,minesNum;//������������
	F[] a;
	boolean[] hasMine;
	mineswapper m;
	//���캯��
	public Mines(mineswapper arg){
		//��ʼ����Ա
		m=arg;
		System.out.println("Mines:default mainArea");
		row = 15;
		col = 20;
		minesNum = 30;
		//��������
		Construct();
	}
	public Mines(mineswapper arg,int FeildsNum){
		//��ʼ����Ա
		System.out.println("Mines:"+FeildsNum+" feilds mainArea");
		m=arg;
		row = 3*FeildsNum/12;
		col = 4*FeildsNum/12;
		minesNum = row*col*17/100;
		System.out.println("Mines:"+row+"rows"+col+"cols  mainArea");
		//��������
		Construct();
	}
	public Mines(mineswapper arg,int Row,int Col){
		//��ʼ����Ա
		System.out.println("Mines:"+Row+"rows"+Col+"cols  mainArea");
		m=arg;
		row = Row;
		col = Col;
		minesNum = row*col*10/100;
		//��������
		Construct();
	}
	public Mines(mineswapper arg,int Row,int Col,int MinesNum){
		//��ʼ����Ա
		System.out.println("Mines:"+Row+"rows"+Col+"cols"+MinesNum+"mines  mainArea");
		m=arg;
		row = Row;
		col = Col;
		minesNum = MinesNum;
		//��������
		Construct();
	}
	private void Construct(){
		int i;//��ʱ����
		//������ť����
		a = new F[row*col];
		hasMine = new boolean[row*col];
		//��ʼ��
		for(i=0;i<row*col;i++)
		{
			hasMine[i] = false ;
		}
		//���������
		Random random = new Random();
		for(i=0;i<minesNum;){
			int r=random.nextInt()%(row*col);
			if(r<0){
				r += row*col;
			}
			if(hasMine[r]==false){
				hasMine[r] = true;
				i++;
			}
		}
		//�������������
		for(i=0;i<col*row;i++){
			int n=0;
			if(!hasMine[i]){
				if(i!=0 && i!=col-1 && i!=col*row-1 && i!=col*(row-1)){
					if(i>=col && i<(row-1)*col && i%col!=0 && i%col!=col-1){
						if(hasMine[i-1])
							n++;
						if(hasMine[i+1])
							n++;
						if(hasMine[i-col])
							n++;
						if(hasMine[i-col-1])
							n++;
						if(hasMine[i-col+1])
							n++;
						if(hasMine[i+col-1])
							n++;
						if(hasMine[i+col])
							n++;
						if(hasMine[i+col+1])
							n++;
					}else if(i<col){
						if(hasMine[i-1])
							n++;
						if(hasMine[i+1])
							n++;
						if(hasMine[i+col-1])
							n++;
						if(hasMine[i+col])
							n++;
						if(hasMine[i+col+1])
							n++;
					}else if(i>=(row-1)*col){
						if(hasMine[i-1])
							n++;
						if(hasMine[i+1])
							n++;
						if(hasMine[i-col])
							n++;
						if(hasMine[i-col-1])
							n++;
						if(hasMine[i-col+1])
							n++;
					}else if(i%col==0){
						if(hasMine[i+1])
							n++;
						if(hasMine[i-col])
							n++;
						if(hasMine[i-col+1])
							n++;
						if(hasMine[i+col])
							n++;
						if(hasMine[i+col+1])
							n++;
					}else if(i%col==col-1){
						if(hasMine[i-1])
							n++;
						if(hasMine[i-col-1])
							n++;
						if(hasMine[i+col-1])
							n++;
						if(hasMine[i+col])
							n++;
						if(hasMine[i-col])
							n++;
					}
				}else if(i==0){
					if(hasMine[1])
						n++;
					if(hasMine[1+col])
						n++;
					if(hasMine[col])
						n++;
				}else if(i==col-1){
					if(hasMine[col-2])
						n++;
					if(hasMine[col*2-1])
						n++;
					if(hasMine[col*2-2])
						n++;
				}else if(i==col*row-1){
					if(hasMine[col*row-2])
						n++;
					if(hasMine[col*(row-1)-1])
						n++;
					if(hasMine[col*(row-1)-2])
						n++;
				}else if(i==col*(row-1)){
					if(hasMine[i+1])
						n++;
					if(hasMine[i-col])
						n++;
					if(hasMine[i-col+1])
						n++;
				}
			}else
				n=-1;
			a[i] = new F(n,i,this);
		}
		//����
		setLayout(new GridLayout(row, col,0,0));
		for(i=0;i<row*col;i++)
			add(a[i]);
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				m.setSize(col*30, row*30+30);
			}
		});
	}
	public void Boom(){
		int i;
		for(i=0;i<row*col;i++)
			a[i].HasMine();
	}
	public int getW(){
		return col*30;
	}
	public int getH(){
		return row*30+30;
	}
	public void NoMine(int i){
		if(i!=0 && i!=col-1 && i!=col*row-1 && i!=col*(row-1)){
			if(i>=col && i<(row-1)*col && i%col!=0 && i%col!=col-1){
				a[i+1].NoMine();
				a[i-1].NoMine();
				a[i+col-1].NoMine();
				a[i+col].NoMine();
				a[i+col+1].NoMine();
				a[i-col-1].NoMine();
				a[i-col].NoMine();
				a[i-col+1].NoMine();
			}else if(i<col){
				a[i+1].NoMine();
				a[i-1].NoMine();
				a[i+col-1].NoMine();
				a[i+col].NoMine();
				a[i+col+1].NoMine();
			}else if(i>=(row-1)*col){
				a[i-col-1].NoMine();
				a[i-col].NoMine();
				a[i-col+1].NoMine();
				a[i+1].NoMine();
				a[i-1].NoMine();
			}else if(i%col==0){
				a[i+1].NoMine();
				a[i+col].NoMine();
				a[i+col+1].NoMine();
				a[i-col].NoMine();
				a[i-col+1].NoMine();
			}else if(i%col==col-1){
				a[i-1].NoMine();
				a[i+col-1].NoMine();
				a[i+col].NoMine();
				a[i-col-1].NoMine();
				a[i-col].NoMine();
			}
		}else if(i==0){
			a[i+1].NoMine();
			a[i+col].NoMine();
			a[i+col+1].NoMine();
		}else if(i==col-1){
			a[i-1].NoMine();
			a[i+col].NoMine();
			a[i+col-1].NoMine();
		}else if(i==col*row-1){
			a[i-1].NoMine();
			a[i-col].NoMine();
			a[i-col-1].NoMine();
		}else if(i==col*(row-1)){
			a[i+1].NoMine();
			a[i-col].NoMine();
			a[i-col+1].NoMine();
		}
	}
	public int getN(){
		return minesNum;
	}
	public void clear(){
		int i;
		for(i=0;i<row*col;i++){
			remove(a[i]);
		}
		Construct();
	}
}
