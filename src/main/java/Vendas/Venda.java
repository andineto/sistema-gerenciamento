package Vendas;

import DAO.ItemVendasDAO;
import DAO.VendasDAO;

import java.sql.SQLException;
import java.util.List;

public class Venda {
    private int id;
    private String dataVenda;
    private double valorTotal;
    private List<ItemVenda> itensVenda;  // Lista de itens vendidos

    public Venda(String dataVenda, List<ItemVenda> itensVenda) {
        this.dataVenda = dataVenda;
        this.itensVenda = itensVenda;
        calcularValorTotal();
    }

    public Venda(int id, String dataVenda, double valorTotal){
        this.id = id;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
    }

    public int getId(){
        return this.id;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void registrarVenda(){
        VendasDAO dao = new VendasDAO();
        this.id = dao.adicionarVenda(this);
        for (ItemVenda item : this.itensVenda) {
            item.setVenda(this);
            item.registrarItemVenda();
        }
    }

    public void calcularValorTotal() {
        this.valorTotal = 0;
        for (ItemVenda item : itensVenda) {
            this.valorTotal += item.getValorTotal();
        }
    }
}
