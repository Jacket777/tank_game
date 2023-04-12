package com.lab.tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Frame f = new Frame();
         f.setSize(800, 600);
         f.setResizable(false);
         f.setTitle("TANK WAR");
         f.setVisible(true);
         
         f.addWindowListener(new WindowAdapter() {
        	 @Override
        	 public void windowClosing(WindowEvent e) {
        		 System.exit(0);
        	 }
        	 
         });
         
	}

}
