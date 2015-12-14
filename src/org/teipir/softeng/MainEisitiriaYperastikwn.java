package org.teipir.softeng;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.teipir.softeng.views.AnakoinwseisFrame;


public class MainEisitiriaYperastikwn {

	private static void showGUI() {
		new AnakoinwseisFrame();
    }
	
	public static void main() {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	UIManager.put("swing.boldMetal", Boolean.FALSE);
            	showGUI();
            }
        });
	}

}
