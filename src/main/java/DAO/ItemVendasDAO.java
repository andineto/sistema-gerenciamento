package DAO;

import Vendas.ItemVenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemVendasDAO {

    public int adicionarItemVenda(ItemVenda item) {
        Connection conexao = ConexaoSQL.conectar();
        int idItemVenda = -1;
        try {
            String sql = "INSERT INTO ItensVenda (id_venda, id_produto, quantidade, valor_unitario, valor_total) VALUES (?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, item.getVenda().getId());
            stmt.setInt(2, item.getProduto().getId());
            stmt.setInt(2, item.getQuantidade());
            stmt.setDouble(2, item.getValorUnitario());
            stmt.setDouble(2, item.getValorTotal());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idItemVenda = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idItemVenda;
    }
    }

