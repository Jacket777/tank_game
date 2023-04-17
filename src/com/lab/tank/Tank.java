package com.lab.tank;


import java.awt.Graphics;
import java.util.Random;

public class Tank {
	private int x, y;
	private Dir dir = Dir.DOWN;
	private boolean living = true;
	private static int SPEED = 1;
	private boolean moving = true;
	private TankFrame tf;
	public static final int WIDTH = ResourceMgr.goodtankU.getWidth();
	public static final int HEIGHT = ResourceMgr.goodtankU.getHeight();
	private Group group;
	private Random random = new Random();
	

	public Tank(int x, int y, Dir dir,Group group,TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.tf = tf;
	}


	public Group getGroup() {
		return group;
	}


	public void setGroup(Group group) {
		this.group = group;
	}

	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}



	
	
	public boolean isMoving() {
		return moving;
	}


	public void setMoving(boolean moving) {
		this.moving = moving;
	}


	public void paint(Graphics g) {
//		Color  c = g.getColor();
//		g.setColor(Color.YELLOW);
//		g.fillRect(x, y, 50, 50);
//		g.setColor(c);
		
		if(!living) {
			tf.tanks.remove(this);
		}
		
		switch (dir) {
		case LEFT:
			g.drawImage(this.group == Group.GOOD?ResourceMgr.goodtankL:ResourceMgr.badtankL, x, y, null);
			break;
		case UP:
			g.drawImage(this.group == Group.GOOD?ResourceMgr.goodtankU:ResourceMgr.badtankU, x, y, null);
			break;
		case RIGHT:
			g.drawImage(this.group == Group.GOOD?ResourceMgr.goodtankR:ResourceMgr.badtankR, x, y, null);
			break;
		case DOWN:
			g.drawImage(this.group == Group.GOOD?ResourceMgr.goodtankD:ResourceMgr.badtankD, x, y, null);
			break;
		}
		
		move();

	}


	private void move() {
		if(!moving)return;
		switch(dir) {
		case LEFT:
			x -= SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;		
		}
		
		
		if(this.group == Group.BAD && random.nextInt(100) > 95) {
			this.fire();
		}

		if(this.group ==Group.BAD && random.nextInt(100) > 95) {
			randomDir();
		}
		
		boundsCheck();
	}


	private void boundsCheck() {
		if(this.x < 2) x = 2;
		if(this.y < 28) y = 28;
		if(this.x > TankFrame.GAME_WIDTH - Tank.WIDTH) x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
		
		if(this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT -2;
		
		
	}


	private void randomDir() {
		 this.dir = Dir.values()[random.nextInt(4)];
	}


	public Dir getDir() {
		return dir;
	}


	public void setDir(Dir dir) {
		this.dir = dir;
	}


	/**
	 * send bullet
	 */
	public void fire() {
		//
		int bx = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
		int by = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
		tf.bullets.add(new Bullet(bx, by,this.dir,this.group,this.tf));
		
		if(this.group == Group.GOOD) {
			new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
		}
		
		
	}


	public void die() {
		this.living = false;
		
	}
	
	

}
