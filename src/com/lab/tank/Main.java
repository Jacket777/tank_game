package com.lab.tank;


/**
 * frist version
 * @author Jack
 * 2023-04-12
 *
 *
 */

public class Main {
	public static void main(String[] args) throws Exception{
		TankFrame tf = new TankFrame();
		
		
		//初始化敌方坦克
		for(int i  = 0; i <5; i++) {
			tf.tanks.add(new Tank(50+i*80,200,Dir.DOWN,Group.BAD,tf));
		}
		while(true) {
			Thread.sleep(50);
			tf.repaint();
		}
	}
}
