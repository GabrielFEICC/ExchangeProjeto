
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Moeda;

public class CriptoDAO {
    private Connection conn;
    
    public CriptoDAO(){
       try {
            this.conn = new Conexao().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public Moeda consultarCotacao(String nome) {
        String sql = "SELECT " + nome + " FROM cotacao";
        Moeda criptoMoeda = null;

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                double cotacaoAtual = rs.getDouble(nome);
                criptoMoeda = new Moeda(nome, cotacaoAtual);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return criptoMoeda;
    }
    
        public void atualizarCotacao(Moeda criptoMoeda) {
        String sql = "UPDATE cotacao SET " + criptoMoeda.getNome() + " = ?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setDouble(1, criptoMoeda.getCotacaoAtual());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Falha ao atualizar cotação da criptomoeda: " + e.getMessage());
        }
    }
//        public void atualizarSaldoCripto(String cpf, String nome, double quantidade) throws SQLException {
//        String column = "saldo_" + nome;
//        String query = "UPDATE usuarios SET " + column + " = " + column + " + ? WHERE cpf = ?";
//        try (PreparedStatement statement = conn.prepareStatement(query)) {
//            statement.setDouble(1, quantidade);
//            statement.setString(2, cpf);
//            statement.executeUpdate();
//        }
//    }
        

        public double consultarQuantidade(String cpf, String nome) throws SQLException {
        String column = "saldo_" + nome;
        String query = "SELECT " + column + " FROM usuarios WHERE cpf = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, cpf);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getDouble(column);
            } else {
                return 0;
            }
        }
    }
        
//        public void comprarCripto(String cpf, String nome, double quantidade) throws SQLException {
//        double quantidadeAtual = consultarQuantidade(cpf, nome);
//        String sql = "INSERT INTO usuarios (cpf, nome, quantidade) VALUES (?, ?, ?)";
//        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setString(1, cpf);
//            stmt.setString(2, nome);
//            stmt.setDouble(3, quantidadeAtual + quantidade);
//            stmt.executeUpdate();
//        }
//        
//        
//    }
        public void comprarBtc(String cpf, double valor) throws SQLException {
        String sql = "update usuarios set saldo_btc = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setString(2, cpf);
        statement.executeUpdate();
        
        
    }
        
        public void comprarEth(String cpf, double valor) throws SQLException {
        String sql = "update usuarios set saldo_eth = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setString(2, cpf);
        statement.executeUpdate();
        
        
    }
        
        public void comprarXrp(String cpf, double valor) throws SQLException {
        String sql = "update usuarios set saldo_xrp = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setString(2, cpf);
        statement.executeUpdate();
        
        
    }
    public void atualizarSaldoCripto(String cpf, String nome, double quantidade) throws SQLException {
    String column = "saldo_" + nome;
    String query = "UPDATE usuarios SET " + column + " = " + column + " + ? WHERE cpf = ?";
    try (PreparedStatement statement = conn.prepareStatement(query)) {
        statement.setDouble(1, quantidade);
        statement.setString(2, cpf);
        statement.executeUpdate();
    }
}
        public void comprarCripto(String cpf, String nome, double quantidade) throws SQLException {
        double quantidadeAtual = consultarQuantidade(cpf, nome);
        String sql = "UPDATE usuarios SET saldo_" + nome + " = ? WHERE cpf = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, quantidadeAtual + quantidade);
            stmt.setString(2, cpf);
            stmt.executeUpdate();
        }
    }
 }
