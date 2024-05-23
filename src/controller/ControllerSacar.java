package controller;

import DAO.Conexao;
import DAO.ContaDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.JanelaSacar;
import view.JanelaSaldo;

public class ControllerSacar {
    private JanelaSaldo viewSaldo;
    private JanelaSacar viewS;

    public ControllerSacar(JanelaSacar viewS) {
        this.viewSaldo = viewSaldo;
        this.viewS = viewS;
    }


    public void sacar(String cpf, double valor) {
        Conexao conexao = new Conexao();
        try (Connection conn = conexao.getConnection()) {
            ContaDAO dao = new ContaDAO(conn);
            double saldoAtual = dao.obterSaldo(cpf);
            if (saldoAtual >= valor) {
                double novoSaldo = saldoAtual - valor;
                dao.atualizarSaldo(cpf, novoSaldo);
                JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                mostrarSaldo(cpf);
            } else {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar saque!", "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void mostrarSaldo(String cpf) {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            ContaDAO dao = new ContaDAO(conn);
            double saldo = dao.consultarSaldo(cpf);
            if (viewSaldo != null) {
                viewSaldo.setSaldo(saldo);
                viewSaldo.setVisible(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar saldo!", "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
