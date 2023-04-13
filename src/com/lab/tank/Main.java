package com.lab.tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * frist version
 * @author Jack
 * 2023-04-12
 *
 */

public class Main {
	public static void main(String[] args) throws Exception{
		TankFrame f = new TankFrame();
		while(true) {
			Thread.sleep(50);
			f.repaint();
		}
	}
}
