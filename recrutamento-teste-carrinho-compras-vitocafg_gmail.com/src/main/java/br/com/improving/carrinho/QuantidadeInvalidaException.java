package br.com.improving.carrinho;

public class QuantidadeInvalidaException extends RuntimeException {
	public QuantidadeInvalidaException(String mensagem) {
		super(mensagem);
	}
}
