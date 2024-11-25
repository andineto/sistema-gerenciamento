package DAO;

import Vendas.Produto;

import java.sql.*;

public class ProdutosDAO {

    public int adicionarProduto(Produto produto) {
        Connection conexao = ConexaoSQL.conectar();
        int idProduto = -1;
        try {

            PreparedStatement stmt;
            String sql;
            sql = "INSERT INTO Produtos (nome, preco, descricao) VALUES (?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, produto.getDescricao());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idProduto = rs.getInt(1);
            }
            System.out.println("Produto " + produto.getNome() + " foi adicionado ao banco");
            ConexaoSQL.FecharConexao(conexao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idProduto;
    }

    public Produto getProdutoById(int idProduto) {
        return new Produto("asd", 25.55,"arroz" );
    }
}

