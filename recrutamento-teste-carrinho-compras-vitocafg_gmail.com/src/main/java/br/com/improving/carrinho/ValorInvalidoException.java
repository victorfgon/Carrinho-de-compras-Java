package br.com.improving.carrinho;

public class ValorInvalidoException extends RuntimeException {
	public ValorInvalidoException(String mensagem) {
		super(mensagem);
	}
}