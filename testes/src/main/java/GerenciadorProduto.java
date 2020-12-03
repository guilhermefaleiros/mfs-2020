import java.util.ArrayList;
import java.util.List;

public class GerenciadorProduto {

    private List<Produto> produtos = new ArrayList<>();

    public List<Produto> lista() {
        return produtos;
    }

    public void adicionar(String codigo, String nome) {
        produtos.add(new Produto(codigo, nome));
    }

    public void deletar(String codigo) {
        Produto encontrado =
                produtos.stream().filter(produto -> produto.getCodigo().equals(codigo)).findFirst().get();
        if(encontrado == null ){
            throw new RuntimeException("Este produto não existe");
        }
        produtos.remove(encontrado);
    }

    public Produto procuraPorCodigo(String codigo) {
        Produto encontrado =
                produtos.stream().filter(produto -> produto.getCodigo().equals(codigo)).findFirst().get();
        if(encontrado == null ){
            throw new RuntimeException("Este produto não existe");
        }
        return encontrado;
    }


}
