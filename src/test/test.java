package test;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.UIManager;

import model.tinhModel;
import view.dangNhapView;

public class test {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
     		dangNhapView dangNhapView = new dangNhapView();
     		dangNhapView.setLocationRelativeTo(null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


