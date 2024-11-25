package Vendas;

import java.text.SimpleDateFormat;
import java.util.*;

public class Carrinho {
    private List<ItemVenda> itensVenda;  // Lista de itens vendidos

    public Carrinho() {
        itensVenda = new ArrayList<>();
    }

    void add(Produto produto, int qtd){
        boolean existe = false;
        for (ItemVenda item : itensVenda) {
            if (Objects.equals(item.getProduto().getId(), produto.getId())) {
                existe = true;
                item.setQuantidade(item.getQuantidade() + qtd);
            }
        }
        if(!existe) itensVenda.add(new ItemVenda(produto, qtd));
    }

    void remover(Produto produto, int qtd) {
        boolean existe = false;
        for (ItemVenda item : itensVenda) {
            if (Objects.equals(item.getProduto().getNome(), produto.getNome())) {
                existe = true;
                item.setQuantidade(item.getQuantidade() - qtd);
                if (item.getQuantidade() <= 0) itensVenda.remove(item);
            }
        }
        if (!existe) {
            System.out.println("Produto não existe no carrinho");
        }
    }

    public Venda fecharCarrinho(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataVenda = sdf.format(new Date());
        return new Venda(dataVenda, this.itensVenda);
    }
}
