package com.lab.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	int x = 200, y=200;



	public TankFrame() {
		this.setSize(800, 600);
		this.setResizable(false);
		this.setTitle("TANK WAR");
		this.setVisible(true);
		
		//添加键盘监听
		this.addKeyListener(new MyKeyListener());
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
	}
	
	
	@Override
	public void paint(Graphics g) {
		System.out.println("paint "+x+" "+y);  //
		g.fillRect(x, y, 50, 50);
		//x += 10;
		//y += 10;
		
	}
	
	

	/**
	 * 键盘监听
	 * @author n'n
	 *
	 */
	class MyKeyListener extends KeyAdapter{
		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;
		
		@Override
		public void keyPressed(KeyEvent e) {
			//x += 200;
			//System.out.println("key pressed");
			//repaint();//会掉paint方法
			int key = e.getKeyCode();
			switch(key) {
			case KeyEvent.VK_LEFT:
				bL = true;
				x -= 10;
				break;
			case KeyEvent.VK_UP:
				bU = true;
				y -= 10;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				x += 10;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				y += 10;
				break;	
			default:
				break;
			}
			

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyReleased(e);
			int key = e.getKeyCode();
			System.out.println("key released");
			switch(key) {
			case KeyEvent.VK_LEFT:
				bL = false;
				x -= 10;
				break;
			case KeyEvent.VK_UP:
				bU = false;
				
				y -= 10;
				break;
			case KeyEvent.VK_RIGHT:
				bR = false;
				x += 10;
				break;
			case KeyEvent.VK_DOWN:
				bD = false;
				y += 10;
				break;	
			default:
				break;
			}
			
			
		}
		
	}
}
