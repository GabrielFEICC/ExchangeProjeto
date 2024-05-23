package controller;

import DAO.Conexao;
import DAO.ContaDAO;
import view.JanelaDeposito;
//import view.JanelaSaldo;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.JanelaSaldo;
//import view.JanelaFuncoes;

public class ControllerConta {
    private JanelaDeposito view;
    private JanelaSaldo viewSaldo;

    public ControllerConta(JanelaDeposito view, JanelaSaldo viewSaldo) {
        this.view = view;
        this.viewSaldo = viewSaldo;
    }

public void depositar(String cpf, double valor) {
    Conexao conexao = new Conexao();
    try {
        Connection conn = conexao.getConnection();
        ContaDAO dao = new ContaDAO(conn);
        // Obter o saldo atual antes de fazer o depósito
        double saldoAtual = dao.obterSaldo(cpf);
        // Calcular o novo saldo após o depósito
        double novoSaldo = saldoAtual + valor;
        // Atualizar o saldo no banco de dados com o novo valor
        dao.atualizarSaldo(cpf, novoSaldo);
        // Mostrar mensagem de sucesso
        JOptionPane.showMessageDialog(view, "Depósito realizado com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        // Fechar a janela atual
        view.setVisible(false);
        // Atualizar a exibição do saldo
        mostrarSaldo(cpf);
    } catch (SQLException ex) {
        // Mostrar mensagem de erro
        JOptionPane.showMessageDialog(view, "Erro ao realizar depósito!", "Erro", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
}

    public void mostrarSaldo(String cpf) {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            ContaDAO dao = new ContaDAO(conn);
            double saldo = dao.consultarSaldo(cpf);
            viewSaldo.setSaldo(saldo);
            viewSaldo.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewSaldo, "Erro ao consultar saldo!", "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}