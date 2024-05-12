
package controller;

import DAO.Conexao;
import DAO.LoginDAO;
import model.Login;
import view.JanelaLogin;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import view.JanelaFuncoes;
import view.PrincipalFrame;


public class ControllerLogin {
     private JanelaLogin view;

    public ControllerLogin(JanelaLogin view) {
        this.view = view;
    }
     
    public void salvaLogin(){
        Login login = new Login(null,view.getTxtCpf().getText(),view.getTxtSenha().getText());
        Conexao conexao = new Conexao();
        
        try{
            Connection conn = conexao.getConnection();
            LoginDAO dao = new LoginDAO(conn);
            ResultSet res = dao.consultar(login);
            if(res.next()){
                JOptionPane.showMessageDialog(view, "Login Feito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");
                new JanelaFuncoes().setVisible(true);
//                JanelaFuncoes viewFuncoes = new JanelaFuncoes(new Login(nome, cpf, senha));
//                viewFuncoes.setVisible(true);
                view.setVisible(false);
            } else{
                JOptionPane.showMessageDialog(view, "Login não efetuado", "Erro", JOptionPane.ERROR_MESSAGE);
                new PrincipalFrame().setVisible(true);
                
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão", "Erro", JOptionPane.ERROR_MESSAGE);
                
        }
        
//        String nome = view.getTxtNome().getText();
//        String cpf = view.getTxtCpf().getText();
//        String senha = view.getTxtSenha().getText();
//        Login login = new Login(nome, cpf, senha);
//        Conexao conn = new Conexao();
//        try{
//           Connection connection = conn.getConnection();
//            System.out.println("conectou");
//           LoginDAO dao = new LoginDAO(connection);
//           dao.inserir(login);
//            JOptionPane.showMessageDialog(view, "Login feito!", "Logado!", JOptionPane.INFORMATION_MESSAGE);           
//        } catch(SQLException e){
//           JOptionPane.showMessageDialog(view, "falha no login", "Erro!", JOptionPane.ERROR_MESSAGE);
//           e.printStackTrace();
//        } 
       
//        Login login = new Login(null, view.getTxtCpf().getText(), view.getTxtSenha().getText());
//        
//        Conexao conexao = new Conexao();
//        try{
//            Connection conn = conexao.getConnection();
//            LoginDAO dao = new LoginDAO(conn);
//            ResultSet res = dao.inserir(login);
//            if(res.next()){
//                JOptionPane.showMessageDialog(view, "login feito!");
//            }  else{
//                JOptionPane.showMessageDialog(view, "login nao efetuado!");
//            }
//            
//        } catch(SQLException e){
//            JOptionPane.showMessageDialog(view, "erro de conexao!");
//        }
    }

        
}
