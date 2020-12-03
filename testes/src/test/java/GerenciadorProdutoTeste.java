import org.junit.jupiter.api.*;

class GerenciadorProdutoTeste {

    @Test
    public void testeAdicionarEListarProdutos(){
        GerenciadorProduto gerenciadorProduto = new GerenciadorProduto();
        gerenciadorProduto.adicionar("1", "Manteiga");
        gerenciadorProduto.adicionar("2", "Leite");

        Assertions.assertTrue (gerenciadorProduto.lista().get(0).getCodigo().equals("1"));
        Assertions.assertTrue (gerenciadorProduto.lista().get(1).getCodigo().equals("2"));
    }

    @Test
    public void testeDeletarProduto(){
        GerenciadorProduto gerenciadorProduto = new GerenciadorProduto();
        gerenciadorProduto.adicionar("1", "Manteiga");
        gerenciadorProduto.deletar("1");

        Assertions.assertTrue (gerenciadorProduto.lista().size() == 0);
    }

    @Test
    public void testeProcuraPorCodigo(){
        GerenciadorProduto gerenciadorProduto = new GerenciadorProduto();
        gerenciadorProduto.adicionar("1", "Manteiga");

        Produto produto = gerenciadorProduto.procuraPorCodigo("1");

        Assertions.assertTrue (produto.getCodigo().equals("1"));
    }

}
