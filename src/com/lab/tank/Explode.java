package com.lab.tank;


import java.awt.Graphics;

public class Explode {
	private int x, y;
	private TankFrame tf = null;
	public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
	public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();
	private int step = 0;//控制画的次数
	



	
	
	
	public Explode(int x, int y, TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.tf = tf;
		new Thread(()->new Audio("audio/explode.wav").play()).start();
	}
	
	
	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.explodes[step++], x, y,null);
		if(step >= ResourceMgr.explodes.length) {
			tf.explodes.remove(this);
		}
	}









	
	

}
