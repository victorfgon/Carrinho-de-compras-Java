package br.com.improving.carrinho;

/**
 * Classe que representa um produto que pode ser adicionado
 * como item ao carrinho de compras.
 *
 * Importante: Dois produtos são considerados iguais quando ambos possuem o
 * mesmo código.
 */
public class Produto {
	private Long codigo;
	private String descricao;

	/**
	 * Construtor da classe Produto.
	 *
	 * @param codigo
	 * @param descricao
	 */
	public Produto(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	/**
	 * Retorna o código da produto.
	 *
	 * @return Long
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * Retorna a descrição do produto.
	 *
	 * @return String
	 */
	public String getDescricao() {
		return descricao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Produto produto = (Produto) obj;
		return codigo.equals(produto.codigo);
	}

	@Override
	public int hashCode() {
		return codigo.hashCode();
	}
}