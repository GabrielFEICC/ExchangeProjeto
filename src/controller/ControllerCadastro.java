
package controller;

import DAO.Conexao;
import DAO.LoginDAO;
import model.Login;
import view.JanelaCadastro;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class ControllerCadastro {
    private JanelaCadastro view;

    public ControllerCadastro(JanelaCadastro view) {
        this.view = view;
    }
    
    public void salvaCadastro(){
        String nome = view.getTxtNomeC().getText();
        String cpf = view.getTxtCpfC().getText();
        String senha = view.getTxtSenhaC().getText();
        Login login = new Login(nome, cpf, senha);
        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            System.out.println("conectou");
            LoginDAO dao = new LoginDAO(conn);
            dao.inserir(login);
            JOptionPane.showMessageDialog(view, "Usuario Cadastro!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(view, "usuario nao cadastrado!", "erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        
    }
}
