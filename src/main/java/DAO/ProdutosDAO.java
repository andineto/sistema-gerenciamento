package DAO;

import Vendas.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    
    public List<Produto> consultarProdutos() {
        List<Produto> vendas = new ArrayList<>();
        Connection conexao = ConexaoSQL.conectar();
        try {
            String sql = "SELECT id, nome,descricao, preco FROM Produtos ORDER BY id";
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                double preco = rs.getDouble("preco");
                vendas.add(new Produto(id, nome, descricao, preco));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendas;
    }
}

