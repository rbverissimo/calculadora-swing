package com.rvrsmo.calc.model;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
	
	private enum TipoComando {
			ZERAR, NUMERO, DIV, MULT, SUB, SOMA, IGUAL, VIRGULA;
	};
	
	private static final Memoria instancia = new Memoria();
	private final List<MemoriaObservador> observadores = new ArrayList<>();
	
	private TipoComando ultimaOperacao = null;
	private boolean substituir = false;
	private String textoAtual = "";
	private String textoBuffer = "";
	
	private Memoria() {
	
	}	
	
	public static Memoria getInstancia() {
		return instancia;
	}
	
	public void adicionarObservador(MemoriaObservador observador) {
		observadores.add(observador);
		
	}
	
	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0": textoAtual;
	}
	
	public void processarComando(String texto) {
		
		TipoComando tipoComando = detectarTipoComando(texto);
		
		if(tipoComando == null) {
			return; 
		} else if (tipoComando == TipoComando.ZERAR) {
			textoAtual = "";
			textoBuffer = "";
			substituir = false;
			ultimaOperacao = null;
		} else if(tipoComando == TipoComando.NUMERO || 
				tipoComando == TipoComando.VIRGULA) {
			textoAtual = substituir ? texto : textoAtual + texto;
			substituir = false; 
		} else {
			//o tratamento acontece na definição da variável no else de cima
			substituir = true;
			textoAtual = obterResultadoOperacao();
			textoBuffer = textoAtual;
			ultimaOperacao = tipoComando;
		}
		
		
		observadores.forEach(o -> o.valorAlterado(getTextoAtual()));
		
	}

	private String obterResultadoOperacao() {
		return null; 
	}

	private TipoComando detectarTipoComando(String texto) {
		if(textoAtual.isEmpty() && texto == "0") {
			return null; 
		}
		
		try {
			Integer.parseInt(texto);
			return TipoComando.NUMERO;
		} catch (NumberFormatException e) {
			if("AC".equals(texto)) {
				return TipoComando.ZERAR;
			} else if("/".equals(texto)) {
				return TipoComando.DIV;
			} else if("*".equals(texto)) {
				return TipoComando.MULT;
			} else if("+".equals(texto)) {
				return TipoComando.SOMA;
			} else if("-".equals(texto)) {
				return TipoComando.SUB;
			} else if(",".equals(texto) 
					&& !textoAtual.contains(",")) 
			{
				return TipoComando.VIRGULA;
			} else if("=".equals(texto)) {
				return TipoComando.IGUAL;
			}
			
		}
		
		return null;
	}

}
