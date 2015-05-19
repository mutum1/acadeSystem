package br.ufes.ceunes.poo.model.pojo;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class DisciplinaTest {

    private Pedido venda;

    @Before
    public void inicializa() {
        venda = new Pedido();
    }

    @Test
    public void verifica_status_antes_de_alterar() {
        assertEquals(false, venda.getStatus());
    }

    @Test
    public void verifica_status_apos_alterar_para_true() {
        venda.alterarStatus(true);
        assertEquals(true, venda.getStatus());
    }

    @Test
    public void adiciona_produto_e_verifico_quantidade() {
        Produto p1 = new Produto();
        p1.setId(5);
        venda.adicionarProduto(p1);
        assertEquals(1,(int) venda.getQuantidade(p1));
        venda.adicionarProduto(p1);
        assertEquals(2,(int) venda.getQuantidade(p1));
    }

    @Test
    public void verifica_quantidade_de_produto_inexistente() {
        assertEquals(0, (int) venda.getQuantidade(new Produto("ProdutoN", 0.0)));
    }

    @Test
    public void adicionando_item_unico() {
        venda.adicionarProduto(new Produto("ProdutoX"));
        assertEquals(1, (int) venda.getQuantidade(new Produto("ProdutoX")));
    }
    
    /*@Test
    public void removendo_item_por_quantidades() {
        Produto pY = new Produto();
        int quantidadeAntiga = venda.getQuantidade(new Produto("ProdutoY"));
        venda.removerQuantidade(new Produto("ProdutoY"),55);
        assertEquals(quantidadeAntiga - 55, (int) venda.getQuantidade(new Produto("ProdutoY")));
    }
    
    @Test
    public void remover_mais_que_quantidade_disponivel() {
        venda.adicionarProduto(new Produto("51"),50);
        venda.removerQuantidade(new Produto("51"),100);
        assertEquals(0,(int) venda.getQuantidade(new Produto("51")));
    }*/
}
