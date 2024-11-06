package Vendas;

import java.text.SimpleDateFormat;
import java.util.*;

public class Carrinho {
    private List<ItemVenda> itensVenda;  // Lista de itens vendidos

    public Carrinho() {
        itensVenda = new ArrayList<>();
    }

    void add(Produto produto, int qtd){
        itensVenda.add(new ItemVenda(produto, qtd));
    }

    void remover(Produto produto, int qtd) {
        Boolean existe = false;
        for (int i = 0; i <= itensVenda.size(); i++) {
            if (itensVenda.get(i).getProduto().getNome() == produto.getNome()) {
                existe = true;
                itensVenda.get(i).setQuantidade(itensVenda.get(i).getQuantidade() - qtd);
                if (itensVenda.get(i).getQuantidade() <= 0) {
                    itensVenda.remove(i);
                }
            }
        }
        if (!existe) {
            System.out.println("Produto não existe no carrinho");
        }
    }

    public Venda fecharCarrinho(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataVenda = sdf.format(new Date());
        return new Venda(0, dataVenda, this.itensVenda);
    }
}
