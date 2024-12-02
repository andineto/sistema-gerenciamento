package DAO;

import Vendas.Produto;
import Vendas.Venda;

import java.sql.*;
import java.util.*;

public class VendasDAO{

    public int adicionarVenda(Venda venda) {
        Connection conexao = ConexaoSQL.conectar();
        int idVenda = -1;
        try {
            String sql = "INSERT INTO Vendas (data_venda, valor_total) VALUES (?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, venda.getDataVenda());
            stmt.setDouble(2, venda.getValorTotal());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idVenda = rs.getInt(1);
            }
            ConexaoSQL.FecharConexao(conexao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idVenda;
    }

    public List<Object[]> consultarVendas() {
        List<Object[]> vendas = new ArrayList<>();
        Connection conexao = ConexaoSQL.conectar();
        try {
            String sql = """
                         SELECT Vendas.id, Vendas.data_venda, Produtos.nome, ItensVenda.quantidade, ItensVenda.valor_total
                         FROM Vendas INNER JOIN ItensVenda ON id_venda = Vendas.id INNER JOIN Produtos ON ItensVenda.id_produto = Produtos.id
                         ORDER BY Vendas.id;""";
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String dataVenda = rs.getString("data_venda");
                String nomeProduto = rs.getString("nome");
                int quantidade = rs.getInt("quantidade");
                double valorTotal = rs.getDouble("valor_total");
                vendas.add(new Object[] {id, dataVenda, nomeProduto, quantidade, valorTotal});
            }
            ConexaoSQL.FecharConexao(conexao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendas;
    }


public void atualizarVendaById(Venda venda, int id) {
    Connection conexao = ConexaoSQL.conectar();
    try {
        String sql = "UPDATE Vendas SET data_venda = ?, valor_total = ? WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, venda.getDataVenda());
        stmt.setDouble(2, venda.getValorTotal());
        stmt.setInt(3, id);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void excluirVendaById(int id) {
    Connection conexao = ConexaoSQL.conectar();
    try {
        String sql = "DELETE FROM Vendas WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        sql = "DELETE FROM ItensVenda WHERE id_venda = ?";
        stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
 }
}