package Vendas;

import DAO.VendasDao;

import java.util.List;

public class Venda {
    private int id;
    private String dataVenda;
    private double valorTotal;
    private List<ItemVenda> itensVenda;  // Lista de itens vendidos

    public Venda(int id, String dataVenda, List<ItemVenda> itensVenda) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.itensVenda = itensVenda;
        calcularValorTotal();
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
        VendasDao dao = new VendasDao();
        dao.adicionarVenda(this);
    }

    public void calcularValorTotal() {
        this.valorTotal = 0;
        for (ItemVenda item : itensVenda) {
            this.valorTotal += item.getValorTotal();
        }
    }
}
