
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
                new JanelaFuncoes(cpf).setVisible(true);
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
       
    }

        
}


