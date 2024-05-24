
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
    
}
