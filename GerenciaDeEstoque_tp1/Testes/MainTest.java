import GerenciaDeEstoque.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private ProdQuilo prodQuiloA = new ProdQuilo("Carne", "Bovina", 25, 50);
    private ProdQuilo prodQuiloB = new ProdQuilo("Arroz", "Integral", 10, 5);
    private ProdUnidade prodUnidadeA = new ProdUnidade("Smart TV", "50 polegadas", 1500, 10);
    private ProdUnidade prodUnidadeB = new ProdUnidade("Ventilador", "Gira muito", 100, 1);

    private NotaFiscal notaFiscal1 = new NotaFiscal("88/88/8888");
    private NotaFiscal notaFiscal2 = new NotaFiscal("55/55/5555");

    private Item item1 = new Item(prodUnidadeA, 1);
    private Item item2 = new Item(prodUnidadeB, 1);
    private Item item3 = new Item(prodQuiloA, 1);
    private Item item4 = new Item(prodQuiloB, 1);

    private ManipulaProduto produtos = new ManipulaProduto();
    private ManipulaNotaFiscal notasFiscais = new ManipulaNotaFiscal();

    @BeforeEach
    void setUp() {
        produtos.addProduto(prodUnidadeA);
        produtos.addProduto(prodUnidadeB);
        produtos.addProduto(prodQuiloA);
        produtos.addProduto(prodQuiloB);

        notaFiscal1.addItem(item1);
        notaFiscal1.addItem(item2);

        notaFiscal2 = notaFiscal1;
        notaFiscal2.removeItem(item1);

        notasFiscais.addNotaFiscal(notaFiscal1);
        notasFiscais.addNotaFiscal(notaFiscal2);
    }

    @Test
    void alterarNotaFiscal() {
        assertEquals(notaFiscal1.getRelacaoItens().size(), notaFiscal2.getRelacaoItens().size());
    }
}