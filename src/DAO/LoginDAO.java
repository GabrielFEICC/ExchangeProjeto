
package DAO;
import java.sql.Connection;
import model.Login;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginDAO {
    private Connection conn;

    public LoginDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Login login) throws SQLException{
        String sql = "insert into logins(nome, cpf, senha) values ('" +login.getNome() + "', '" +login.getCpf()+"', '" +login.getSenha()+"')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
    public ResultSet consultar(Login login) throws SQLException{
        String sql = "select * from logins where cpf = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, login.getCpf());
        statement.setString(2, login.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }

}
