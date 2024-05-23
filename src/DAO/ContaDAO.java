package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Conta;
public class ContaDAO {


    
     private Connection conn;

    public ContaDAO(Connection conn) {
        this.conn = conn;
    }

//    public void criarConta(Conta conta) throws SQLException {
//        String sql = "INSERT INTO usuarios (cpf, saldo) values (?, ?)";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.setString(1, conta.getCpf());
//        statement.setDouble(2, conta.getSaldo());
//        statement.execute();
//    }

    
    
    public void depositar(String cpf, double valor) throws SQLException {
        String sql = "update usuarios set saldo = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setString(2, cpf);
        statement.executeUpdate();
    }

    public double consultarSaldo(String cpf) throws SQLException {
        String sql = "select saldo from usuarios where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, cpf);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getDouble("saldo");
        } else {
            throw new SQLException("Conta não encontrada.");
        }
    }
    
          public double obterSaldo(String cpf) throws SQLException {
        String sql = "select saldo from usuarios where cpf = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("saldo");
                } else {
                    throw new SQLException("CPF não encontrado: " + cpf);
                }
            }
            
       
}
}
          public void atualizarSaldo(String cpf, double novoSaldo) throws SQLException {
        String sql = "update usuarios set saldo = ? where cpf = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, novoSaldo);
            stmt.setString(2, cpf);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("CPF não encontrado: " + cpf);
            }
        }
    }
         public void sacar(String cpf, double valor) throws SQLException {
        String sql = "update usuarios set saldo = saldo - ? where cpf = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setDouble(1, valor);
            statement.setString(2, cpf);
            statement.executeUpdate();
        }
    }
}

