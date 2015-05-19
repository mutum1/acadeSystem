
import java.util.ArrayList;
import static org.junit.Assert.*;

public class AlunoTest {

    Cliente cliente;
    Pedido venda1;
    Pedido venda2;
    
    @Before
    public void Inicializar_Variavel(){
        cliente = new Cliente("Guilherme","Rua 2","14412938760","3752-1337","12632656","guilhermeureis@gmail.com");
        venda1 = new Pedido();
        venda2 = new Pedido();
    }
    
    @Test
    public void TesteAluno(){
        assertEquals(true,cliente.adicionaPedido(venda1));
        assertEquals(true,cliente.adicionaPedido(venda2));
    }
    
}
