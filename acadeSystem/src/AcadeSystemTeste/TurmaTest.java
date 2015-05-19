package br.ufes.ceunes.poo.model.pojo;

import br.ufes.ceunes.poo.model.pojo.Produto;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class TurmaTest {
    
     Produto produto;
    
    @Before
    public void incializar() {
        produto = new Produto("teste",1.0);
    }
    
    @Test
    public void testa_alteracao_de_preco() {
        assertEquals(1.0,(double)produto.getPreco(),0.01);
        produto.alterarPreco(10.0);
        assertEquals(10.0,produto.getPreco(),0.01);
    }
    
    @Test
    public void testa_valor_negativo_como_entrada() {
        produto.alterarPreco(-1.0);
        assertEquals(1.0,(double)produto.getPreco(),0.01);
    }
    
    @Test
    public void testa_zero_como_entrada() {
        produto.alterarPreco(0.0);
        assertEquals(1.0,(double)produto.getPreco(),0.01);
    }
    
    @Test
    public void teste_objetos_de_mesmo_nome() {
        
    }
}
