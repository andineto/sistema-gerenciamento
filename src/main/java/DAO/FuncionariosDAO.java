package DAO;

import Funcionarios.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionariosDAO {

    public int adicionarFuncionario(Funcionario func) {
        Connection conexao = ConexaoSQL.conectar();
        int idFunc = -1;
        try {
            String sql = "INSERT INTO Funcionarios (nome, cpf, salario_bruto, salario_liquido) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, func.getNome());
            stmt.setString(2, func.getCpf());
            stmt.setDouble(3, func.getSalario());
            stmt.setDouble(4, func.getSalarioLiquido());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idFunc = rs.getInt(1);
            }
            ConexaoSQL.FecharConexao(conexao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idFunc;
    }
    
    public List<Funcionario> consultarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        Connection conexao = ConexaoSQL.conectar();
        try {
            String sql = "SELECT * FROM Funcionarios";
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                Double salarioBruto = rs.getDouble("salario_bruto");
                Double salarioLiquido = rs.getDouble("salario_liquido");
                funcionarios.add(new Funcionario(id, nome, cpf, salarioBruto, salarioLiquido));
            }
        ConexaoSQL.FecharConexao(conexao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }

    public void remover(int id) {
        Connection conexao = ConexaoSQL.conectar();
        try {
            String sql = "DELETE FROM Funcionarios WHERE id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
