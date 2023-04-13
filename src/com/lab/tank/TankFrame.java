package com.lab.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
//	int x = 200, y=200;
//	Dir dir = Dir.DOWN;
//	private static final int SPEED = 10;
	
	Tank myTank = new Tank(200,200,Dir.DOWN,this);
	List<Bullet>bullets = new ArrayList<>();
	
	//Bullet b = new Bullet(300,300,Dir.DOWN);
	public static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;


	public TankFrame() {
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
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
	
	
	Image offScreenImage = null;
	/**
	 * 双缓冲解决闪烁问题
	 */
	@Override
	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	@Override
	public void paint(Graphics g) {
		//System.out.println("paint "+x+" "+y);  //
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("bullet number: "+bullets.size(), 10, 60);
		g.setColor(c);
		myTank.paint(g);
		for(int i = 0; i < bullets.size();i++) {
			bullets.get(i).paint(g);
		}
//		for(Bullet b:bullets) {
//			b.paint(g);
//		}
		
		
//		g.fillRect(x, y, 50, 50);
//		switch(dir) {
//		case LEFT:
//			x -= SPEED;
//			break;
//		case UP:
//			y -= SPEED;
//			break;
//		case RIGHT:
//			x += SPEED;
//			break;
//		case DOWN:
//			y += SPEED;
//			break;	
//			
//		}
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
				//x -= 10;
				break;
			case KeyEvent.VK_UP:
				bU = true;
				//y -= 10;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				//x += 10;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				//y += 10;
				break;	
			default:
				break;
			}
			
			setMainTankDir();
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
				//x -= 10;
				break;
			case KeyEvent.VK_UP:
				bU = false;
				//y -= 10;
				break;
			case KeyEvent.VK_RIGHT:
				bR = false;
				//
				//x += 10;
				break;
			case KeyEvent.VK_DOWN:
				bD = false;
				//y += 10;
				break;
			case KeyEvent.VK_CONTROL:
				myTank.fire();
				break;		
				
			default:
				break;
			}
			
			setMainTankDir();
			
		}

		private void setMainTankDir() {
			   if(!bL&&!bU&&!bR&&!bD) {
	            	 myTank.setMoving(false);
	             }else {
	            	 myTank.setMoving(true); 
	             }
			
             if(bL) myTank.setDir(Dir.LEFT);
             if(bU) myTank.setDir(Dir.UP);
             if(bR) myTank.setDir(Dir.RIGHT);
             if(bD) myTank.setDir(Dir.DOWN);
             
             
          
		}
		
	}




}
