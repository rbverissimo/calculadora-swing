package com.rvrsmo.calc.view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calculadora extends JFrame{
	
	public Calculadora() {
		
		organizarLayout();
		
		setSize(232, 322);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	private void organizarLayout() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new Calculadora();
	}

}
