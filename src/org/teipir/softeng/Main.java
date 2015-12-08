package org.teipir.softeng;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.teipir.softeng.views.AnakoinwseisFrame;
import org.teipir.softeng.views.LoginFrame;


public class Main {

	private static void ShowGUI() {
    	AnakoinwseisFrame frame = new AnakoinwseisFrame();
		frame.displayWindow();
    }
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	UIManager.put("swing.boldMetal", Boolean.FALSE);
            	ShowGUI();
            }
        });
	}

}
