package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoSQL {

    public static Connection conectar() {
        Connection conexao = null;
        try {
            String url = "jdbc:sqlite:controle_vendas.db";
            conexao = DriverManager.getConnection(url);
            System.out.println("Conexão com o SQLite foi estabelecida!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conexao;
    }
    public static void FecharConexao(Connection connect) throws SQLException {
        connect.close();
        System.out.println("Conexão com o SQLite foi fechada");
    }

    public static void main(String[] args) {
        Connection conexao = conectar();
        String sql = "DELETE FROM ItensVenda";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
