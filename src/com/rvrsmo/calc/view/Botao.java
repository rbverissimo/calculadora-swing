package com.rvrsmo.calc.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Botao extends JButton{
	
	public Botao(String texto, Color cor) {
		
		setText(texto);
		setFont(new Font("courier", Font.PLAIN, 22));
		setForeground(Color.WHITE);
		setOpaque(true);
		setBackground(cor);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));

		
	}

}
