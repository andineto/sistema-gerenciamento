package Vendas;

import DAO.ItemVendasDAO;
import DAO.ProdutosDAO;
import DAO.VendasDAO;

import java.sql.SQLException;

public class ItemVenda {
    int id;
    private Produto produto;
    private int quantidade;
    private Venda venda;
    private double valorUnitario;
    private double valorTotal;

    // Construtor
    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = produto.getPreco();
        this.valorTotal = valorUnitario * quantidade;
    }

    // Getters e Setters
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.valorTotal = valorUnitario * quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    public void registrarItemVenda(){
        this.id = new ItemVendasDAO().adicionarItemVenda(this);
    }
}
