package DAO;

import Vendas.Venda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendasDao {

    public void adicionarVenda(Venda venda) {
        Connection conexao = ConexaoSQL.conectar();
        try {
            String sql = "INSERT INTO Vendas (data_venda, valor_total) VALUES (?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, venda.getDataVenda());
            stmt.setDouble(2, venda.getValorTotal());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
