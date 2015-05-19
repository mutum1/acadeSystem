package br.ufes.ceunes.poo.model.pojo;

import br.ufes.ceunes.poo.model.pojo.Produto;
import br.ufes.ceunes.poo.model.pojo.Fornecedor;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ProfessorTest {

    Fornecedor f1;
    Fornecedor f2;

    @Before
    public void inicializador() {
        f1 = new Fornecedor();
        f2 = new Fornecedor();
    }

    @Test
    public void verifica_se_fornecedores_recem_inicializados_possuem_id_null() {
        assertNull(f1.getId());
        assertNull(f2.getId());
    }

    public void atribuiId(int fator) {
        int f1_id = 1 + fator;
        int f2_id = 2 + fator;
        f1.setId(f1_id);
        f2.setId(f2_id);
    }

    @Test
    public void atribui_um_id_e_confirma() {
        atribuiId(0);
        assertEquals(1, (int) f1.getId());
        assertEquals(2, (int) f2.getId());
    }

    @Test
    public void verifica_a_possibilidade_de_reatribuir_id() {
        atribuiId(0);
        int f1IdOld = f1.getId();
        int f2IdOld = f2.getId();
        int fator = 20;
        atribuiId(fator);
        assertNotSame(f1IdOld + fator,(int) f1.getId());
        assertNotSame(f2IdOld + fator, (int) f2.getId());
    }

}
