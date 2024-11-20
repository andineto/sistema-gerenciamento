package DAO;

import Vendas.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

    public void adicionarProduto(Produto produto) {
        Connection conexao = ConexaoSQL.conectar();
        try {
            String sql = "INSERT INTO Produtos (nome, preco, descricao) VALUES (?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, produto.getDescricao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
