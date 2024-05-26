package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Conta;
public class ContaDAO {


    
     private Connection conn;

    public ContaDAO(Connection conn) throws SQLException {
        this.conn = new Conexao().getConnection();
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
         
//        public void atualizarSaldoCripto(String cpf, double novoSaldoBtc, double novoSaldoEth, double novoSaldoXrp) throws SQLException {
//        String sql = "UPDATE usuarios SET saldo_btc = ?, saldo_eth = ?, saldo_xrp = ? WHERE cpf = ?";
//        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setDouble(1, novoSaldoBtc);
//            stmt.setDouble(2, novoSaldoEth);
//            stmt.setDouble(3, novoSaldoXrp);
//            stmt.setString(4, cpf);
//            stmt.executeUpdate();
//        }
//        }
 
//         public void atualizarSaldoCripto(String cpf, String nome, double novoSaldo) throws SQLException {
//        String column = "saldo_" + nome;
//        String query = "UPDATE usuarios SET " + column + " = ? WHERE cpf = ?";
//        try (PreparedStatement statement = conn.prepareStatement(query)) {
//            statement.setDouble(1, novoSaldo);
//            statement.setString(2, cpf);
//            statement.executeUpdate();
//        }
//    }
         
         
        public void atualizaBtc(String cpf, String btc, double novoSaldoBtc) throws SQLException {
        String sql = "uptade usuarios set saldo_btc = ? where cpf = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, novoSaldoBtc);
            stmt.setString(2, cpf);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("CPF não encontrado: " + cpf);
            }
        }
   }
        public void atualizaEth(String cpf, String eth, double novoSaldoEth) throws SQLException {
        String sql = "uptade usuarios set saldo_eth = ? where cpf = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, novoSaldoEth);
            stmt.setString(2, cpf);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("CPF não encontrado: " + cpf);
            }
        }
    }
        public void atualizaXrp(String cpf, String xrp, double novoSaldoXrp) throws SQLException {
        String sql = "uptade usuarios set saldo_xrp = ? where cpf = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, novoSaldoXrp);
            stmt.setString(2, cpf);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("CPF não encontrado: " + cpf);
            }
        }
        }
        
        
        public double obterSaldoBtc(String cpf) throws SQLException {
        String sql = "SELECT saldo_btc FROM usuarios WHERE cpf = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("saldo_btc");
                }
            }
        }
        return 0.0;
    }

    public double obterSaldoEth(String cpf) throws SQLException {
        String sql = "SELECT saldo_eth FROM usuarios WHERE cpf = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("saldo_eth");
                }
            }
        }
        return 0.0;
    }

    public double obterSaldoXrp(String cpf) throws SQLException {
        String sql = "SELECT saldo_xrp FROM usuarios WHERE cpf = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("saldo_xrp");
                }
            }
        }
        return 0.0;
}
    }
    
