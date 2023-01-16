package com.rvrsmo.calc.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Teclado extends JPanel {
	
	private final Color COR_CINZA_ESCURO = new Color(68, 68, 68);
	private final Color COR_CINZA_CLARO = new Color(97, 100, 98); 
	private final Color COR_LARANJA = new Color(242, 163, 60); 
	
	public Teclado() {
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		setLayout(layout);
		
		adicionarBotao("AC", COR_CINZA_ESCURO, c, 0, 0);
		adicionarBotao("+/-", COR_CINZA_ESCURO, c, 1, 0);
		adicionarBotao("%", COR_CINZA_ESCURO, c, 2, 0);
		adicionarBotao("7", COR_LARANJA, c, 3, 0);
		
		
		add(new Botao("7", COR_CINZA_CLARO));
		add(new Botao("8", COR_CINZA_CLARO));
		add(new Botao("9", COR_CINZA_CLARO));
		add(new Botao("*", COR_LARANJA));
		
		add(new Botao("7", COR_CINZA_CLARO));
		add(new Botao("8", COR_CINZA_CLARO));
		add(new Botao("9", COR_CINZA_CLARO));
		add(new Botao("*", COR_LARANJA));
		
		add(new Botao("7", COR_CINZA_CLARO));
		add(new Botao("8", COR_CINZA_CLARO));
		add(new Botao("9", COR_CINZA_CLARO));
		add(new Botao("*", COR_LARANJA));
		
		add(new Botao("7", COR_CINZA_CLARO));
		add(new Botao("8", COR_CINZA_CLARO));
		add(new Botao("9", COR_CINZA_CLARO));
		add(new Botao("*", COR_LARANJA));
		
		
	}

	private void adicionarBotao(String texto, Color cor,
			GridBagConstraints c, int x, int y) {
		
		c.gridx = x;
		c.gridy = y; 
		Botao botao = new Botao(texto, cor);
		add(botao, c);
		
	}

}
