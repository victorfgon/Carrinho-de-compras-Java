package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.Collection;

public class Main {
	public static void main(String[] args) {
		// Criando uma instância de CarrinhoComprasFactory
		CarrinhoComprasFactory carrinhoFactory = new CarrinhoComprasFactory();

		// Criando um carrinho de compras para o cliente "123"
		CarrinhoCompras carrinhoNovo = carrinhoFactory.criar("123");
		// Recuperando o carrinho de compras para o cliente "123"
		CarrinhoCompras carrinho = carrinhoFactory.criar("123");

		CarrinhoCompras carrinho2 = carrinhoFactory.criar("1234");
		// Criando produtos
		Produto produto1 = new Produto(1L, "Produto 1");
		Produto produto1Copia = new Produto(1L, "Copia do Produto 1");
		Produto produto2 = new Produto(2L, "Produto 2");
		Produto produto3 = new Produto(3L, "Produto 3");
		Produto produto4 = new Produto(4L, "Produto 4");

		// Testando o equals do produto
		System.out.println(produto1.equals(produto1Copia));
		System.out.println(produto1.equals(produto2));

		// Adicionando itens ao carrinho e testando função de acidionar item
		carrinho.adicionarItem(produto1, BigDecimal.valueOf(10.0), 2);
		carrinho.adicionarItem(produto1, BigDecimal.valueOf(10.0), 1);
		carrinho2.adicionarItem(produto1, BigDecimal.valueOf(5), 1);

		//Testando exceptions:
		//carrinho.adicionarItem(produto1, BigDecimal.valueOf(0.0), 1);
		//carrinho.adicionarItem(produto1, BigDecimal.valueOf(30.0), 0);

		carrinho.adicionarItem(produto2, BigDecimal.valueOf(5.0), 3);
		carrinho.adicionarItem(produto2, BigDecimal.valueOf(4.0), 3);
		carrinho.adicionarItem(produto3, BigDecimal.valueOf(1.0), 2);
		carrinho.adicionarItem(produto4, BigDecimal.valueOf(2.0), 2);

		// Obtendo a lista de itens do carrinho
		Collection<Item> itens = carrinho.getItens();

		// Imprimindo os itens do carrinho
		System.out.println("Itens do Carrinho:");
		for (Item item : itens) {
			System.out.println(item.getProduto().getDescricao() + " - " + item.getValorUnitario() + " - " + item.getQuantidade());
		}

		// Removendo um item pelo produto
		carrinho.removerItem(produto1);
		boolean itemRemovido = carrinho.removerItem(produto1);
		if (itemRemovido) {
			System.out.println("Item removido com sucesso!");
		} else {
			System.out.println("O item não foi encontrado no carrinho.");
		}

		// Removendo um item pela posição
		boolean itemRemovidoPorPosicao = carrinho.removerItem(0);
		if (itemRemovidoPorPosicao) {
			System.out.println("Item removido com sucesso!");
		} else {
			System.out.println("O item não foi encontrado no carrinho.");
		}

		// Obtendo o valor total do carrinho
		BigDecimal valorTotal = carrinho.getValorTotal();
		System.out.println("Valor Total: " + valorTotal);

		// Obtendo o valor do ticket médio
		BigDecimal valorTicketMedio = carrinhoFactory.getValorTicketMedio();
		System.out.println("Valor Ticket Médio: " + valorTicketMedio);

		// Invalidando o carrinho do cliente "123"
		boolean carrinhoInvalidado = carrinhoFactory.invalidar("123");
		if (carrinhoInvalidado) {
			System.out.println("Carrinho do cliente 123 invalidado com sucesso!");
		} else {
			System.out.println("O cliente 123 não possui um carrinho.");
		}

		BigDecimal valorTicketMedio2 = carrinhoFactory.getValorTicketMedio();
		System.out.println("Valor Ticket Médio: " + valorTicketMedio2);
	}
}
